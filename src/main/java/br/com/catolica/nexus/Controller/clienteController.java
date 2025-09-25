package br.com.catolica.nexus.Controller;

import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import br.com.catolica.nexus.Model.cliente;
import br.com.catolica.nexus.repository.clienteRepository;

@Repository
public class clienteController {

    @Autowired
    private clienteRepository clienteRepository;

    public List<cliente> getAllClientes() {
        return clienteRepository.findAll();
    }

    public cliente getClienteById(Long id) {
        return clienteRepository.findById(id).orElse(null);
    }

    public cliente createCliente(cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public cliente updateCliente(Long id, cliente clienteDetails) {
        cliente cliente = clienteRepository.findById(id).orElse(null);
        if (cliente != null) {
            cliente.setNome(clienteDetails.getNome());
            cliente.setCpf(clienteDetails.getCpf());
            cliente.setIdade(clienteDetails.getIdade());
            cliente.setEndereco(clienteDetails.getEndereco());
            return clienteRepository.save(cliente);
        }
        return null;
    }
    public void deleteCliente(Long id) {
        clienteRepository.deleteById(id);
    }

    public List<cliente> findByNome(String nome) {
        return clienteRepository.findByNome(nome);
    }


    
}