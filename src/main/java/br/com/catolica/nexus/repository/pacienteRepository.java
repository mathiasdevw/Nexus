package br.com.catolica.nexus.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.catolica.nexus.Model.Paciente;

@Repository
public interface PacienteRepository extends MongoRepository<Paciente, String> {

}
