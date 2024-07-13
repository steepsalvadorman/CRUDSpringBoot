package com.example.demo.controller;

import com.example.demo.model.DetalleVenta;
import com.example.demo.service.DetalleVentaServiceImpl;
import com.example.demo.service.interfaces.DetalleVentaService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/detalle-venta")
public class DetalleVentaController {

    private final DetalleVentaServiceImpl detalleVentaServiceImpl;

    @GetMapping
    public List<DetalleVenta> listar() {
        return detalleVentaServiceImpl.getAllDetalleVentas();
    }

    @GetMapping("/{id}")
    public DetalleVenta getDetalleVenta(@PathVariable Long id) {
        return detalleVentaServiceImpl.getDetalleVentaById(id);
    }

    @PostMapping
    public DetalleVenta createDetalleVenta(@RequestBody DetalleVenta detalleVenta) {
        return detalleVentaServiceImpl.createDetalleVenta(detalleVenta);
    }

    @PutMapping("/{id}")
    public DetalleVenta updateDetalleVenta(@PathVariable Long id, @RequestBody DetalleVenta detalleVenta){
        return detalleVentaServiceImpl.updateDetalleVenta(id, detalleVenta);
    }

    @DeleteMapping("/{id}")
    public void deleteDetalleVenta(@PathVariable Long id) {
        detalleVentaServiceImpl.deleteDetalleVenta(id);
    }
}
