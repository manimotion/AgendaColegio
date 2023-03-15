package com.agenda_virtual.controladores;

import com.agenda_virtual.modelos.Alumno;
import com.agenda_virtual.modelos.Pago;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PagoControlador {

    // Simula una base de datos de pagos para propósitos de ejemplo
    private List<Pago> pagos;

    public PagoControlador() {
        // Inicializar la lista de pagos (en lugar de esto, se podría acceder a una base de datos real)
        pagos = new ArrayList<>();
    }

    // Método para registrar un pago
    public boolean registrarPago(Pago pago) {
        // En una aplicación real, aquí se insertaría el pago en la base de datos
        return pagos.add(pago);
    }

    // Método para actualizar un pago
    public boolean actualizarPago(Pago pagoActualizado) {
        // En una aplicación real, aquí se actualizaría el pago en la base de datos
        for (int i = 0; i < pagos.size(); i++) {
            if (pagos.get(i).getId() == pagoActualizado.getId()) {
                pagos.set(i, pagoActualizado);
                return true;
            }
        }
        return false;
    }

    // Método para obtener pagos de un alumno
    public List<Pago> obtenerPagosAlumno(Alumno alumno) {
        return pagos.stream()
                .filter(pago -> pago.getAlumno().equals(alumno))
                .collect(Collectors.toList());
    }
}
