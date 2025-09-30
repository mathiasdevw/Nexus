package br.com.catolica.nexus.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import jakarta.validation.Valid;
import br.com.catolica.nexus.Model.Funcionario;
import br.com.catolica.nexus.Service.FuncionarioService;


@RequestMapping("/funcionarios")
@RestController
public class FuncionarioController {
    
    @Autowired
    private FuncionarioService service;


    @PostMapping
    public ResponseEntity<Funcionario> criar(@Valid @RequestBody Funcionario funcionario){
        Funcionario salvo = service.salvar(funcionario);
        return ResponseEntity.status(201).body(salvo);
    }

     @GetMapping
    public ResponseEntity<Page<Funcionario>> listar(Pageable pageable) {
        return ResponseEntity.ok(service.listarTodos(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Funcionario> buscarPorId(String id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Funcionario> atualizar(@PathVariable String id, @RequestBody Funcionario funcionario) {
        Funcionario atualizado = service.atualizar(id, funcionario);
        return ResponseEntity.ok(atualizado);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable String id) {
        service.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
