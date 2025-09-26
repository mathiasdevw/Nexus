package br.com.catolica.nexus.Model;

public class Clinica{


    private String nome;
    private String cnpj;
    private String endereco;
    private String telefone;
    private String descricao;

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