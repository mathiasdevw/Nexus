package br.com.catolica.nexus.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import br.com.catolica.nexus.Model.Clinica;
import br.com.catolica.nexus.Model.Paciente;
import br.com.catolica.nexus.repository.ClinicaRepository;

import java.util.List;
import java.util.Optional;

//Logica de negócios para as operações relacionadas às clínicas

@Service

public class ClinicaService {
    @Autowired
    private ClinicaRepository repository;

    public Clinica salvar(Clinica clinica) {
        return repository.save(clinica);
    }

    public Optional<Clinica> buscarPorId(String id) {
        return repository.findById(id);
    }
    
    //Lista clinicas por paginas, facilitando o front-end 
    public Page<Clinica> listarTodas(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public Clinica atualizar(String id, Clinica clinicaAtualizada) {
        Clinica clinica = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Clínica não encontrada com o id: " + id));

        clinica.setNome(clinicaAtualizada.getNome());
        clinica.setEndereco(clinicaAtualizada.getEndereco());
        clinica.setTelefone(clinicaAtualizada.getTelefone());
        clinica.setDescricao(clinicaAtualizada.getDescricao());
        
        return repository.save(clinica);
    }

    public void excluir(String id) {
        if(!repository.existsById(id)){
            throw new RuntimeException("Clínica não encontrada com o id: " + id);
        }
        repository.deleteById(id);
    }


}