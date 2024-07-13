package com.example.demo.service;

import com.example.demo.exception.DataAlreadyExistsException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Producto;
import com.example.demo.repository.ProductoRepository;
import com.example.demo.service.interfaces.ProductoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductoServiceImpl implements ProductoService {


    private final ProductoRepository productoRepository;

    @Override
    public List<Producto> getAllProductos() {
        return productoRepository.findAll();
    }

    @Override
    public Producto getProductoById(Integer id) {
        return productoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Producto not found"));
    }

    @Override
    public Producto createProducto(Producto producto) {
        if(producto.getIdProducto() != null && productoRepository.existsById(producto.getIdProducto())) {
            throw new DataAlreadyExistsException("Producto con ID " + producto.getIdProducto() + " ya existe");
        }
        return productoRepository.save(producto);
    }

    @Override
    public Producto updateProducto(Integer id, Producto producto) {
        Producto ProductoFromDB = getProductoById(id);
        ProductoFromDB.setDescripcion(producto.getDescripcion());
        ProductoFromDB.setCantidad(producto.getCantidad());
        ProductoFromDB.setEstado(producto.getEstado());
        return productoRepository.save(ProductoFromDB);
    }

    @Override
    public void deleteProducto(Integer id) {
        Producto ProductoFromDB = getProductoById(id);
        productoRepository.delete(ProductoFromDB);
    }
}
