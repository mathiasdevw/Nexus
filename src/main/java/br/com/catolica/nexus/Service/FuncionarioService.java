package br.com.catolica.nexus.Service;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.catolica.nexus.Model.Funcionario;
import br.com.catolica.nexus.Model.Paciente;
import br.com.catolica.nexus.repository.FuncionarioRepository;
import org.springframework.stereotype.Service;


//Logica de negócios para as operações relacionadas aos funcionários

@Service
public class FuncionarioService {
    
    @Autowired
    private FuncionarioRepository repository;

    public Funcionario salvar(Funcionario funcionario) {
        return repository.save(funcionario);
    }

    public Optional<Funcionario> buscarPorId(String id) {
        return repository.findById(id);
    }

    //Lista funcionarios por paginas, facilitando o front-end
     public Page<Funcionario> listarTodos(Pageable pageable) {
        return repository.findAll(pageable);
    }


    //Metodo de atualizar que lança exceção caso o funcionario não seja encontrado (Julia)
     public Funcionario atualizar(String id, Funcionario funcionarioAtualizado) {
        Funcionario funcionario = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Funcionário não encontrado com o id: " + id));

        funcionario.setNome(funcionarioAtualizado.getNome());
        funcionario.setEmail(funcionarioAtualizado.getEmail());
        funcionario.setTelefone(funcionarioAtualizado.getTelefone());
        funcionario.setEspecialidade(funcionarioAtualizado.getEspecialidade());
        
        return repository.save(funcionario);
    }
    

// Novo metodo de exclusao atualizado no qual verifica se o funcionario existe antes de tentar excluir(J)
    public void excluir(String id) {
        if(!repository.existsById(id)){
            throw new RuntimeException("Funcionario não encontrado");
        }
        repository.deleteById(id);
        
    }
}
