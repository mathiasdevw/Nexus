package br.com.catolica.nexus.repository;

import br.com.catolica.nexus.Model.Funcionario;
import org.springframework.stereotype.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;


@Repository 
public interface FuncionarioRepository extends MongoRepository<Funcionario, String> {
    
}