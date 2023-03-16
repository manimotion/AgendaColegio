package com.agenda_virtual.servicios;

import com.agenda_virtual.modelos.Pago;
import com.agenda_virtual.repositorios.PagoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PagoServicio {

    @Autowired
    private PagoRepositorio pagoRepositorio;

    public List<Pago> obtenerTodosPagos() {
        return pagoRepositorio.findAll();
    }

    public Pago guardarPago(Pago pago) {
        return pagoRepositorio.save(pago);
    }

    public Optional<Pago> obtenerPagoPorId(Long id) {
        return pagoRepositorio.findById(id);
    }

    public void eliminarPago(Long id) {
        pagoRepositorio.deleteById(id);
    }
}
