package br.com.catolica.nexus.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.catolica.nexus.Model.paciente;

@Repository
public interface pacienteRepository extends MongoRepository<paciente, String> {

}
