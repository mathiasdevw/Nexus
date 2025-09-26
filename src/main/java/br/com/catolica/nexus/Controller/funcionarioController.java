package br.com.catolica.nexus.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.catolica.nexus.Model.Funcionario;
import br.com.catolica.nexus.Service.FuncionarioService;

@RequestMapping("/funcionarios")
@RestController
public class FuncionarioController {
    
    @Autowired
    private FuncionarioService service;


    @PostMapping
    public ResponseEntity<Funcionario> criar(@RequestBody Funcionario funcionario){
        return ResponseEntity.ok(service.salvar(funcionario));
    }
}
