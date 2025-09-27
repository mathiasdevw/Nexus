package br.com.catolica.nexus.repository;

import br.com.catolica.nexus.Model.Funcionario;
import org.springframework.stereotype.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

//Interface para as operações de acesso a dados dos funcionários
@Repository 
public interface FuncionarioRepository extends MongoRepository<Funcionario, String> {
    
}