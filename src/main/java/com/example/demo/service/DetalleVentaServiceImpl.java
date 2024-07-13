package com.example.demo.service;

import com.example.demo.exception.DataAlreadyExistsException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.DetalleVenta;
import com.example.demo.repository.DetalleVentaRepository;
import com.example.demo.service.interfaces.DetalleVentaService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DetalleVentaServiceImpl implements DetalleVentaService {

    private final DetalleVentaRepository detalleVentaRepository;

    @Override
    public List<DetalleVenta> getAllDetalleVentas() {
        return detalleVentaRepository.findAll();
    }

    @Override
    public DetalleVenta getDetalleVentaById(Long id) {
        return detalleVentaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("DetalleVenta not found"));
    }

    @Override
    public DetalleVenta createDetalleVenta(DetalleVenta detalleVenta) {
        if(detalleVenta.getIdDetalle() != null && detalleVentaRepository.existsById(detalleVenta.getIdDetalle())) {
            throw new DataAlreadyExistsException("DetalleVenta con ID " + detalleVenta.getIdDetalle() + " ya existe");
        }
        return detalleVentaRepository.save(detalleVenta);
    }

    @Override
    public DetalleVenta updateDetalleVenta(Long id, DetalleVenta detalleVenta) {
        DetalleVenta DetalleVentaFromDB = getDetalleVentaById(id);
        DetalleVentaFromDB.setCantidad(detalleVenta.getCantidad());
        DetalleVentaFromDB.setPrecio(detalleVenta.getPrecio());
        DetalleVentaFromDB.setSubTotal(detalleVenta.getSubTotal());
        DetalleVentaFromDB.setVenta(detalleVenta.getVenta());
        DetalleVentaFromDB.setProducto(detalleVenta.getProducto());
        return detalleVentaRepository.save(DetalleVentaFromDB);
    }

    @Override
    public void deleteDetalleVenta(Long id) {
        DetalleVenta DetalleVentaFromDB = getDetalleVentaById(id);
        detalleVentaRepository.delete(DetalleVentaFromDB);
    }
}

