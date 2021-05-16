package br.unit.pa;

import java.math.BigInteger;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import br.unit.pa.domain.Cliente;
import br.unit.pa.domain.Produto;

@RestController
public class AcessoController {
	
	@GetMapping("")
	public String home() {
		try {
			String mensagem = "Exercício 5 - API REST + Swagger";
			System.out.println(mensagem);
			return mensagem;
		} catch (Exception e) {
			e.printStackTrace();
            return "Erro ao inicializar a aplicação!";
		}
	}
	
	@PostMapping("/v1/cliente")
    public ResponseEntity<Cliente> enviarCliente(@RequestBody Cliente cliente){
        try {
            System.out.println("O cliente cadastrado foi:" + cliente.toString());
            return ResponseEntity.ok(cliente);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    @PostMapping("/v1/produto")
    public ResponseEntity<Produto> enviarProduto(@RequestBody Produto produto){
        try {
            System.out.println("O Produto cadastrado foi:" + produto.toString());
            return ResponseEntity.ok(produto);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @GetMapping("/v1/cliente/{id}")
    public ResponseEntity<String> imprimirIdCliente(@PathVariable("id") long id){
        try {
        	String mensagem = "O id do cliente enviado foi: " + id;
            System.out.println(mensagem);
            return ResponseEntity.ok(mensagem);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body("Erro ao enviar o id: " + id);
        }
    }

    @GetMapping("/v1/produto/{id}")
    public ResponseEntity<String> imprimirIdProduto(@PathVariable("id") long id){
        try {
        	String mensagem = "O id do produto enviado foi: " + id;
            System.out.println(mensagem);
            return ResponseEntity.ok(mensagem);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body("Erro ao enviar o id: " + id);
        }
    }
    
    @GetMapping("/v1/validacao")
    public ResponseEntity<Object> validarDado(@RequestHeader("user") String user, @RequestHeader("password") BigInteger password){
        BigInteger senha = new BigInteger("123456");
        if (password.compareTo(senha) == 0) {
        	return ResponseEntity.accepted().body(user);
        } else {
        	return ResponseEntity.badRequest().body(false);
        }
    }
}
