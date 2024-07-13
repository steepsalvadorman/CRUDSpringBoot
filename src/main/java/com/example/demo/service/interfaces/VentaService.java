package com.example.demo.service.interfaces;

import com.example.demo.model.Venta;

import java.util.List;

public interface VentaService {
    List<Venta> getAllVentas();
    Venta getVentaById(Long id);
    Venta createVenta(Venta venta);
    Venta updateVenta(Long id, Venta venta);
    void deleteVenta(Long id);
}

