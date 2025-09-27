package br.com.catolica.nexus.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import br.com.catolica.nexus.Service.ClinicaService;
import br.com.catolica.nexus.Model.Clinica;
import org.springframework.http.ResponseEntity;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.RequestBody;

//Recebe as requisições HTTP relacionadas às clínicas

@RequestMapping("/clinicas")
@RestController
public class ClinicaController {
    @Autowired
    private ClinicaService service;

    @PostMapping
    public ResponseEntity<Clinica> criar(@Valid @RequestBody Clinica clinica){
        Clinica salvo = service.salvar(clinica);
        return ResponseEntity.status(201).body(salvo);
    }

    @GetMapping
    public ResponseEntity<Page<Clinica>> listar(Pageable pageable) {
        return ResponseEntity.ok(service.listarTodas(pageable));
    }   
    @GetMapping("/{id}")
    public ResponseEntity<Clinica> buscarPorId(String id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    
     @PutMapping("/{id}")
    public ResponseEntity<Clinica> atualizar(@PathVariable String id, @RequestBody Clinica clinica) {
        Clinica atualizado = service.atualizar(id, clinica);
        return ResponseEntity.ok(atualizado);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable String id) {
        service.excluir(id);
        return ResponseEntity.noContent().build();
    }

}