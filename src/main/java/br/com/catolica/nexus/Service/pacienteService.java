package br.com.catolica.nexus.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.catolica.nexus.Model.Paciente;
import br.com.catolica.nexus.repository.PacienteRepository;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository repository;

    public Paciente criar(Paciente paciente) {
        return repository.save(paciente);
    }

    public List<Paciente> listarTodos() {
        return repository.findAll();
    }

    public Optional<Paciente> buscarPorId(String id) {
        return repository.findById(id);
    }

    public Optional<Paciente> atualizar(String id, Paciente pacienteAtualizado) {
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


