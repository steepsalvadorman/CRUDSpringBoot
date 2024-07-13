package com.example.demo.controller;

import com.example.demo.model.Cliente;
import com.example.demo.service.ClienteServiceImpl;
import com.example.demo.service.interfaces.ClienteService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteServiceImpl clienteServiceImpl;



    @GetMapping
    public List<Cliente> getAllClientes() {
        return clienteServiceImpl.getAllClientes();
    }

    @GetMapping("/{id}")
    public Cliente getClienteById(@PathVariable Long id) {
        return clienteServiceImpl.getClienteById(id);
    }

    @PostMapping
    public Cliente createCliente(@RequestBody Cliente cliente) {
        return clienteServiceImpl.createCliente(cliente);
    }

    @PutMapping("/{id}")
    public Cliente updateCliente(@PathVariable Long id, @RequestBody Cliente cliente) {
        return clienteServiceImpl.updateCliente(id, cliente);
    }

    @DeleteMapping("/{id}")
    public void deleteCliente(@PathVariable Long id) {
        clienteServiceImpl.deleteCliente(id);
    }
}
