package br.com.catolica.nexus.Service;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import br.com.catolica.nexus.Exception.RecursoNaoEncontrado;
import br.com.catolica.nexus.Exception.RegraDeNegocioException;
import br.com.catolica.nexus.Model.Funcionario;
import br.com.catolica.nexus.repository.FuncionarioRepository;
import org.springframework.stereotype.Service;

@Service
public class FuncionarioService {
    
    @Autowired
    private FuncionarioRepository repository;

    //Verifica se já existe um funcionario com o mesmo email antes de criar um novo funcionario com o exception
    public Funcionario salvar(Funcionario funcionario) {
        Optional<Funcionario> funcionarioExistente = repository.findByEmail(funcionario.getEmail());
        if (funcionarioExistente.isPresent()) {
            throw new RegraDeNegocioException("Já existe um funcionário cadastrado com este email.");
        }
        return repository.save(funcionario);
    }

    public Optional<Funcionario> buscarPorId(String id) {
        return repository.findById(id);
    }

     public Page<Funcionario> listarTodos(Pageable pageable) {
        return repository.findAll(pageable);
    }

    //Adicionado exception caso o funcionario não seja encontrado 
     public Funcionario atualizar(String id, Funcionario funcionarioAtualizado) {
        Funcionario funcionario = repository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontrado ("Funcionário não encontrado com o id: " + id));

        funcionario.setNome(funcionarioAtualizado.getNome());
        funcionario.setEmail(funcionarioAtualizado.getEmail());
        funcionario.setTelefone(funcionarioAtualizado.getTelefone());
        funcionario.setEspecialidade(funcionarioAtualizado.getEspecialidade());
        
        return repository.save(funcionario);
    }
    

    //Adicionado exception caso o funcionario não seja encontrado
    public void excluir(String id) {
        if(!repository.existsById(id)){
            throw new RecursoNaoEncontrado("Funcionario não encontrado");
        }
        repository.deleteById(id);
        
    }
}
