package br.com.catolica.nexus.Model;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.NotBlank;

@Document(collection = "pacientes")

public class Paciente {

    @Id
    private String id;
    @NotBlank(message = "O nome não pode estar em branco")
    private String nome;
    @NotBlank(message = "O email não pode estar em branco")
    private String email;
    @NotBlank(message = "A senha não pode estar em branco")
    private String senha;
    @NotBlank(message = "O telefone não pode estar em branco")  
    private String telefone;


    public Paciente() {}

    public Paciente(String id, String nome, String email, String senha, String telefone) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
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
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
        }
    public String getSenha() {
        return senha;
        }
    public void setSenha(String senha) {
        this.senha = senha;
    }
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
        }

}        