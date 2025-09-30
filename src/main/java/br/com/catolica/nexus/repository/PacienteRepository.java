package br.com.catolica.nexus.repository;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import br.com.catolica.nexus.Model.Paciente;


@Repository
public interface PacienteRepository extends MongoRepository<Paciente, String> {
    Optional<Paciente> findByEmail(String email);

}
