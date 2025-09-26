package br.com.catolica.nexus.Model;

import org.springframework.data.annotation.Id;

public class Funcionario {

    @Id 
    private String id;
    private String nome;
    private String especialidade;
    private String email;
    private String telefone;


    public Funcionario(String id, String nome, String especialidade, String email, String telefone) {
        this.id = id;
        this.nome = nome;
        this.especialidade = especialidade;
        this.email = email;
        this.telefone = telefone;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getEspecialidade() {
        return especialidade;
    }
    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    } 

}