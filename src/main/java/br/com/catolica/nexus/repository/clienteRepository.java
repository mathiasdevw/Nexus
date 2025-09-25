package br.com.catolica.nexus.repository;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import br.com.catolica.nexus.Model.cliente;



public class clienteRepository{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<cliente> findByNome(String nome) {
        String sql = "SELECT * FROM clientes WHERE nome = ?";
        return jdbcTemplate.query(sql, new Object[]{nome}, (rs, rowNum) ->
                new cliente(
                        rs.getString("nome"),
                        rs.getString("cpf"),
                        rs.getInt("idade"),
                        rs.getString("endereco")
                )
        );
    }

    public List<cliente> findAll() {
        String sql = "SELECT * FROM clientes";
        return jdbcTemplate.query(sql, (rs, rowNum) ->
                new cliente(
                        rs.getString("nome"),
                        rs.getString("cpf"),
                        rs.getInt("idade"),
                        rs.getString("endereco")
                )
        );
    }

        public cliente save(cliente cliente) {
                String sql = "INSERT INTO clientes (nome, cpf, idade, endereco) VALUES (?, ?, ?, ?)";
                jdbcTemplate.update(sql, cliente.getNome(), cliente.getCpf(), cliente.getIdade(), cliente.getEndereco());
                return cliente;
        }

        public java.util.Optional<cliente> findById(Long id) {
                String sql = "SELECT * FROM clientes WHERE id = ?";
                cliente cliente = jdbcTemplate.queryForObject(sql, new Object[]{id}, (rs, rowNum) ->
                        new cliente(
                                rs.getString("nome"),
                                rs.getString("cpf"),
                                rs.getInt("idade"),
                                rs.getString("endereco")
                        )
                );
                return java.util.Optional.ofNullable(cliente);
        }

        public void deleteById(Long id) {
                String sql = "DELETE FROM clientes WHERE id = ?";
                jdbcTemplate.update(sql, id);
        }

        
}