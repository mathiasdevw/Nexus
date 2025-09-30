package br.com.catolica.nexus.Model;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Document(collection = "funcionarios")
public class Funcionario{

    @Id 
    private String id;
    @NotBlank(message = "O nome não pode estar em branco")
    private String nome;
    @NotBlank(message = "A especialidade não pode estar em branco")
    @Size(min = 3, max = 50, message = "A especialidade deve ter entre 3 e 50 caracteres")
    private String especialidade;
    @NotBlank(message = "O email não pode estar em branco")
    private String email;
    @NotBlank(message = "O telefone não pode estar em branco")
    private String telefone;
    @NotBlank(message = "A senha não pode estar em branco")
    @Size(min = 6, message = "A senha deve ter no mínimo 6 caracteres")
    private String senha;

    public Funcionario() {}

    public Funcionario(String id, String nome, String especialidade, String email, String telefone, String senha) {
        this.id = id;
        this.nome = nome;
        this.especialidade = especialidade;
        this.email = email;
        this.telefone = telefone;
        this.senha = senha;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }   

    public String getSenha() {
        return senha;
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