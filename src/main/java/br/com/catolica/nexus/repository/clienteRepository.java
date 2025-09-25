package br.com.catolica.nexus.repository;



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


}