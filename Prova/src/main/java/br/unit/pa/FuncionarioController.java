package br.unit.pa;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.unit.pa.domain.Funcionario;
import br.unit.pa.domain.FuncionarioRepository;

@RestController
public class FuncionarioController {
	
	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	@GetMapping("/")
	public ResponseEntity<String> home() {
		String mensagem = "[2a Unidade] Prova";
		HttpStatus httpStatus = HttpStatus.ACCEPTED;
		System.out.println(mensagem);
		return ResponseEntity.status(httpStatus).body(mensagem);
	}
	
	@PostMapping("/funcionario")
	public ResponseEntity<Object> cadastroFuncionario(@RequestBody Funcionario funcionario) {
		try {
			Date data = new Date();
			funcionario.setData(data);
			funcionarioRepository.save(funcionario);
			return ResponseEntity.ok(funcionario);
		} catch (Exception e) {
			e.printStackTrace();
			HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
			return ResponseEntity.status(httpStatus).body(null);
		}
	}
	
	@GetMapping("/funcionarios")
	public ResponseEntity<List<Funcionario>> obterFuncionarios() {
		try {
			List<Funcionario> funcionarios = funcionarioRepository.findAll();
			if (funcionarios != null) {
				return ResponseEntity.ok(funcionarios);
			} else {
				return ResponseEntity.badRequest().body(null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(500).body(null);
		}
	}
	
	@GetMapping("/funcionarios/{nome}")
	public ResponseEntity<Object> obterFuncionario(@PathVariable("nome") String nome) {
		try {
			Optional<Funcionario> funcionario = funcionarioRepository.findByNomeContainingIgnoreCase(nome);
			if (funcionario.isPresent()) {
				return ResponseEntity.ok(funcionario.get());
			} else {
				return ResponseEntity.badRequest().body(null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(500).body(null);
		}
	}
	
	@PutMapping("/funcionario/{matricula}/{opcao}/{dadoAtualizado}")
	public ResponseEntity<Object> atualizar(@PathVariable ("matricula") Long matricula, @PathVariable ("opcao") int opcao, @PathVariable ("dadoAtualizado") String dadoAtualizado) {
		try {
			Optional<Funcionario> funcionario = funcionarioRepository.findById(matricula);
			if (funcionario.isPresent()) {
				Funcionario atualizacao = funcionario.get();
				switch (opcao) {
				case 1:
					atualizacao.setNome(dadoAtualizado);
					break;
				case 2:
					atualizacao.setEmail(dadoAtualizado);
					break;
				}
				funcionarioRepository.save(atualizacao);
				return ResponseEntity.ok(funcionario.get());
			} else {
				return ResponseEntity.badRequest().body(null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(500).body(null);
		}
	}
	
	@DeleteMapping("/remocao_funcionario/{matricula}")
	public ResponseEntity<Boolean> deletar(@PathVariable ("matricula") Long matricula) {
		try {
			Optional<Funcionario> funcionario = funcionarioRepository.findById(matricula);
			if (funcionario.isPresent()) {
				funcionarioRepository.deleteById(matricula);
				return ResponseEntity.ok(true);
			} else {
				return ResponseEntity.badRequest().body(null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(500).body(null);
		}
	}
}
