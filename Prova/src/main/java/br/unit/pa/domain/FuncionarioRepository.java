package br.unit.pa.domain;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long>{
	
    Optional<Funcionario> findByNomeContainingIgnoreCase(String nome);
    
}
