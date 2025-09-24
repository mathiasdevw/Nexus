package br.com.catolica.nexus.Controller;
public class clienteController {

    private String nome;
    private String cpf;
    private int idade;
    private String endereco;

    public clienteController(String nome, String cpf, int idade, String endereco) {
        this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;
        this.endereco = endereco;
    }
    
}