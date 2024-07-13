package com.example.demo.service;


import com.example.demo.exception.DataAlreadyExistsException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Cliente;
import com.example.demo.repository.ClienteRepository;
import com.example.demo.service.interfaces.ClienteService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;

    @Override
    public List<Cliente> getAllClientes() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente getClienteById(Long id) {
        return clienteRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Cliente no encontrado"));
    }

    @Override
    public Cliente createCliente(Cliente cliente) {
        if (cliente.getIdCliente() != null && clienteRepository.existsById(cliente.getIdCliente())) {
            throw new DataAlreadyExistsException("El cliente con ID " + cliente.getIdCliente() + " ya existe.");
        }
        return clienteRepository.save(cliente);
    }

    @Override
    public Cliente updateCliente(Long id, Cliente cliente) {
        Cliente ClienteFromDB = getClienteById(id);
        ClienteFromDB.setNombres(cliente.getNombres());
        ClienteFromDB.setApellidos(cliente.getApellidos());
        ClienteFromDB.setNroDocumento(cliente.getNroDocumento());
        ClienteFromDB.setEmail(cliente.getEmail());
        ClienteFromDB.setCreateAt(cliente.getCreateAt());
        return clienteRepository.save(ClienteFromDB);
    }

    @Override
    public void deleteCliente(Long id) {
        Cliente ClienteFromDB = getClienteById(id);
        clienteRepository.delete(ClienteFromDB);
    }
}
