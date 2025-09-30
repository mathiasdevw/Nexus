package br.com.catolica.nexus.Service;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.catolica.nexus.Exception.RecursoNaoEncontrado;
import br.com.catolica.nexus.Exception.RegraDeNegocioException;
import br.com.catolica.nexus.Model.Paciente;
import br.com.catolica.nexus.repository.PacienteRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository repository;

    //Verifica se já existe um paciente com o mesmo email antes de criar um novo paciente com o exception
    public Paciente criar(Paciente paciente) {
        Optional<Paciente> pacienteExistente = repository.findByEmail(paciente.getEmail());
        if (pacienteExistente.isPresent()) {
            throw new RegraDeNegocioException("Já existe um paciente cadastrado com este email.");
        }
        return repository.save(paciente);
    }

   
    public Page<Paciente> listarTodos(Pageable pageable) {
        return repository.findAll(pageable);
    }


    public Optional<Paciente> buscarPorId(String id) {
        return repository.findById(id);
    }


    //Adicionado exception caso o paciente não seja encontrado
    public Paciente atualizar(String id, Paciente pacienteAtualizado) {
        Paciente paciente = repository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontrado("Paciente não encontrado com o id: " + id));
        paciente.setNome(pacienteAtualizado.getNome());
        paciente.setEmail(pacienteAtualizado.getEmail());
        paciente.setTelefone(pacienteAtualizado.getTelefone());
        paciente.setSenha(pacienteAtualizado.getSenha());
        
        return repository.save(paciente);
    }
    
    //Adicionado exception caso o paciente não seja encontrado
    public void deletar(String id) {
        if(!repository.existsById(id)){
            throw new RecursoNaoEncontrado("Paciente não encontrado com o id: " + id);
        }
        repository.deleteById(id);
    }
}