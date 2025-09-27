package br.com.catolica.nexus.Service;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.catolica.nexus.Model.Paciente;
import br.com.catolica.nexus.repository.PacienteRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository repository;

    public Paciente criar(Paciente paciente) {
        return repository.save(paciente);
    }

   
    public Page<Paciente> listarTodos(Pageable pageable) {
        return repository.findAll(pageable);
    }

     //Metodo de buscar que lança exceção caso o paciente não seja encontrado (Julia)

    public Optional<Paciente> buscarPorId(String id) {
        return repository.findById(id);
    }


     //Metodo de atualizar que lança exceção caso o paciente não seja encontrado (Julia)
    public Paciente atualizar(String id, Paciente pacienteAtualizado) {
        Paciente paciente = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Paciente não encontrado com o id: " + id));
        paciente.setNome(pacienteAtualizado.getNome());
        paciente.setEmail(pacienteAtualizado.getEmail());
        paciente.setTelefone(pacienteAtualizado.getTelefone());
        paciente.setSenha(pacienteAtualizado.getSenha());
        
        return repository.save(paciente);
    }
 
    public void deletar(String id) {
        if(!repository.existsById(id)){
            throw new RuntimeException("Paciente não encontrado com o id: " + id);
        }
        repository.deleteById(id);
    }
}