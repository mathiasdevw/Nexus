package br.com.catolica.nexus.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import br.com.catolica.nexus.Exception.RecursoNaoEncontrado;
import br.com.catolica.nexus.Exception.RegraDeNegocioException;
import br.com.catolica.nexus.Model.Clinica;
import br.com.catolica.nexus.repository.ClinicaRepository;
import java.util.Optional;



@Service

public class ClinicaService {
    @Autowired
    private ClinicaRepository repository;

    //Verifica se já existe uma clinica com o mesmo CNPJ antes de criar uma nova clinica com o exception
    public Clinica salvar(Clinica clinica) {
        Optional<Clinica> clinicaExistente = repository.findByCnpj(clinica.getCnpj());
        if (clinicaExistente.isPresent()) {
            throw new RegraDeNegocioException("Já existe uma clínica cadastrada com este CNPJ.");
        }
        return repository.save(clinica);
    }


    public Optional<Clinica> buscarPorId(String id) {
        return repository.findById(id);
    }
    
    public Page<Clinica> listarTodas(Pageable pageable) {
        return repository.findAll(pageable);
    }

    //Adicionado exception caso a clinica não seja encontrada
    public Clinica atualizar(String id, Clinica clinicaAtualizada) {
        Clinica clinica = repository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontrado ("Clínica não encontrada com o id: " + id));

        clinica.setNome(clinicaAtualizada.getNome());
        clinica.setEndereco(clinicaAtualizada.getEndereco());
        clinica.setTelefone(clinicaAtualizada.getTelefone());
        clinica.setDescricao(clinicaAtualizada.getDescricao());
        
        return repository.save(clinica);     
    }

    //Adicionado exception caso a clinica não seja encontrada
    public void excluir(String id) {
        if(!repository.existsById(id)){
            throw new RecursoNaoEncontrado("Clínica não encontrada com o id: " + id);
        }
        repository.deleteById(id);
    }


}