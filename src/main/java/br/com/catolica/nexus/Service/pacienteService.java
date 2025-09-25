package br.com.catolica.nexus.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.catolica.nexus.Model.paciente;
import br.com.catolica.nexus.repository.pacienteRepository;

@Service
public class pacienteService {

    @Autowired
    private pacienteRepository repository;

    public paciente criar(paciente paciente) {
        return repository.save(paciente);
    }

    public List<paciente> listarTodos() {
        return repository.findAll();
    }

    public Optional<paciente> buscarPorId(String id) {
        return repository.findById(id);
    }

    public Optional<paciente> atualizar(String id, paciente pacienteAtualizado) {
        return repository.findById(id).map(paciente -> {
            paciente.setNome(pacienteAtualizado.getNome());
            paciente.setEmail(pacienteAtualizado.getEmail());
            paciente.setTelefone(pacienteAtualizado.getTelefone());
            paciente.setSenha(pacienteAtualizado.getSenha());
            return repository.save(paciente);
        });
    }

    public boolean deletar(String id) {
        return repository.findById(id).map(p -> {
            repository.deleteById(id);
            return true;
        }).orElse(false);
    }
}


