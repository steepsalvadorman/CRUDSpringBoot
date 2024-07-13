package com.example.demo.service.interfaces;

import com.example.demo.model.DetalleVenta;

import java.util.List;

public interface DetalleVentaService {
    List<DetalleVenta> getAllDetalleVentas();
    DetalleVenta getDetalleVentaById(Long id);
    DetalleVenta createDetalleVenta(DetalleVenta detalleVenta);
    DetalleVenta updateDetalleVenta(Long id, DetalleVenta detalleVenta);
    void deleteDetalleVenta(Long id);
}