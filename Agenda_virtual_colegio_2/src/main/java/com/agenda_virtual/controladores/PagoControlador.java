package com.agenda_virtual.controladores;

import com.agenda_virtual.modelos.Pago;
import com.agenda_virtual.servicios.PagoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/pagos")
public class PagoControlador {

    @Autowired
    private PagoServicio pagoServicio;

    @GetMapping
    public String mostrarPagos(Model model) {
        model.addAttribute("pagos", pagoServicio.obtenerTodosPagos());
        return "pagos";
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioNuevoPago() {
        return "nuevoPago";
    }

    @PostMapping("/nuevo")
    public String guardarPago(Pago pago) {
        pagoServicio.guardarPago(pago);
        return "redirect:/pagos";
    }
}
