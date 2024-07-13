package com.example.demo.controller;


import com.example.demo.model.Venta;
import com.example.demo.service.VentaServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/venta")
@AllArgsConstructor
public class VentaController {

    public final VentaServiceImpl ventaServiceImpl;

    @GetMapping
    public List<Venta> listar() {
        return ventaServiceImpl.getAllVentas();
    }

    @GetMapping("/{id}")
    public Venta getVentaById(@PathVariable Long id) {
        return ventaServiceImpl.getVentaById(id);
    }

    @PostMapping
    public Venta createVenta(@RequestBody Venta venta) {
        return ventaServiceImpl.createVenta(venta);
    }

    @PutMapping("/{id}")
    public Venta updateVenta(@PathVariable Long id,@RequestBody Venta venta) {
        return ventaServiceImpl.updateVenta(id, venta);
    }

    @DeleteMapping("/{id}")
    public void deleteVenta(@PathVariable Long id) {
        ventaServiceImpl.deleteVenta(id);
    }
}
