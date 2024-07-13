package com.example.demo.controller;


import com.example.demo.model.Producto;
import com.example.demo.service.ProductoServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@AllArgsConstructor
@RequestMapping("/producto")
public class ProductoController {

    private final ProductoServiceImpl productoServiceImpl;


    @GetMapping
    public List<Producto> getAllProductos() {
        return productoServiceImpl.getAllProductos();
    }

    @GetMapping("/{id}")
    public Producto getProductoById(@PathVariable Integer id) {
        return productoServiceImpl.getProductoById(id);
    }

    @PostMapping
    public Producto createProducto(@RequestBody Producto producto) {
        return productoServiceImpl.createProducto(producto);
    }

    @PutMapping("/{id}")
    public Producto updateProducto(@PathVariable Integer id, @RequestBody Producto producto) {
        return productoServiceImpl.updateProducto(id, producto);
    }

    @DeleteMapping("/{id}")
    public void deleteProducto(@PathVariable Integer id) {
        productoServiceImpl.deleteProducto(id);
    }
}
