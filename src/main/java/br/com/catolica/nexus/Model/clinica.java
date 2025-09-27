package br.com.catolica.nexus.Model;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.NotBlank;

@Document(collection = "clinicas")

public class Clinica{
    
    @Id
    private String cnpj;
    @NotBlank(message = "O nome não pode estar em branco")
    private String nome; 
    @NotBlank(message = "O endereço não pode estar em branco")
    private String endereco;
    @NotBlank(message = "O telefone não pode estar em branco")
    private String telefone;
    @NotBlank(message = "A descrição não pode estar em branco")
    private String descricao;

    public Clinica() {}

    public Clinica(String nome, String cnpj, String endereco, String telefone, String descricao) {
        this.nome = nome;
        this.cnpj = cnpj;
        this.endereco = endereco;
        this.telefone = telefone;
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCnpj() {
        return cnpj;
    }
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;   
    }
    public String getEndereco() {
        return endereco;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
        }
    public String getDescricao() {
        return descricao;
        }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }


}