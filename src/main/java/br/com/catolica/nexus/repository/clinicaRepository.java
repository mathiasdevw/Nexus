package  br.com.catolica.nexus.repository;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import br.com.catolica.nexus.Model.Clinica;


@Repository
public interface ClinicaRepository extends MongoRepository<Clinica, String> {
    Optional<Clinica> findByCnpj(String cnpj);

}