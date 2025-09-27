package  br.com.catolica.nexus.repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import br.com.catolica.nexus.Model.Clinica;


//Interface para as operações de acesso a dados das clínicas
@Repository
public interface ClinicaRepository extends MongoRepository<Clinica, String> {

}