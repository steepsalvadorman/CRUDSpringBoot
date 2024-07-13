package com.example.demo.service;


import com.example.demo.exception.DataAlreadyExistsException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Venta;
import com.example.demo.repository.VentaRepository;
import com.example.demo.service.interfaces.VentaService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class VentaServiceImpl implements VentaService {

    private final VentaRepository ventaRepository;

    @Override
    public List<Venta> getAllVentas() {
        return ventaRepository.findAll();
    }

    @Override
    public Venta getVentaById(Long id) {
        return ventaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Venta not found"));
    }

    @Override
    public Venta createVenta(Venta venta) {
        if(venta.getIdVenta() != null && ventaRepository.existsById(venta.getIdVenta())) {
            throw new DataAlreadyExistsException("Venta con ID " + venta.getIdVenta() + " ya existe");
        }
        return ventaRepository.save(venta);
    }

    @Override
    public Venta updateVenta(Long id, Venta venta) {
        Venta VentaFromDB = getVentaById(id);
        VentaFromDB.setFecha(venta.getFecha());
        VentaFromDB.setSerie(venta.getSerie());
        VentaFromDB.setNumero(venta.getNumero());
        VentaFromDB.setTotal(venta.getTotal());
        VentaFromDB.setCliente(venta.getCliente());
        return ventaRepository.save(VentaFromDB);
    }

    @Override
    public void deleteVenta(Long id) {
        Venta existingVenta = getVentaById(id);
        ventaRepository.delete(existingVenta);
    }
}