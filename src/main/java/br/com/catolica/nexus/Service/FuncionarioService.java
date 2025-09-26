package br.com.catolica.nexus.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.catolica.nexus.Model.Funcionario;

import br.com.catolica.nexus.repository.FuncionarioRepository;

public class FuncionarioService {
    
    @Autowired
    private FuncionarioRepository repository;

    public Funcionario salvar(Funcionario funcionario) {
        return repository.save(funcionario);
    }

    public Optional<Funcionario> buscarPorId(String id) {
        return repository.findById(id);
    }

    public List<Funcionario> listarTodos() {
        return repository.findAll();
    }

    public Optional<Funcionario> atualizar(String id, Funcionario funcionarioAtualizado) {
        return repository.findById(id).map(funcionario -> {
            funcionario.setNome(funcionarioAtualizado.getNome());
            funcionario.setEmail(funcionarioAtualizado.getEmail());
            funcionario.setTelefone(funcionarioAtualizado.getTelefone());
            funcionario.setEspecialidade(funcionarioAtualizado.getEspecialidade());
            return repository.save(funcionario);
        });
    }

    public boolean deletar(String id) {
        return repository.findById(id).map(f -> {
            repository.deleteById(id);
            return true;
        }).orElse(false);
    }
}
