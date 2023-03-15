package com.agenda_virtual.servicios;

import com.agenda_virtual.modelos.Pago;
import com.agenda_virtual.repositorios.PagoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
