package com.agenda_virtual.controladores;

import com.agenda_virtual.modelos.Administrativo;
import com.agenda_virtual.servicios.AdministrativoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/administrativos")
public class AdministrativoControlador {

    @Autowired
    private AdministrativoServicio administrativoServicio;

    @GetMapping
    public String listarAdministrativos(Model model) {
        model.addAttribute("administrativos", administrativoServicio.obtenerTodos());
        return "administrativos/lista";
    }

    @GetMapping("/crear")
    public String mostrarFormularioCreacion(Model model) {
        model.addAttribute("administrativo", new Administrativo());
        return "administrativos/crear";
    }

    @PostMapping("/crear")
    public String crearAdministrativo(Administrativo administrativo) {
        administrativoServicio.guardar(administrativo);
        return "redirect:/administrativos";
    }

    @GetMapping("/{id}/editar")
    public String mostrarFormularioEdicion(@PathVariable Long id, Model model) {
        Administrativo administrativo = administrativoServicio.obtenerPorId(id);
        if (administrativo != null) {
            model.addAttribute("administrativo", administrativo);
            return "administrativos/editar";
        }
        return "redirect:/administrativos";
    }

    @PostMapping("/{id}/editar")
    public String editarAdministrativo(@PathVariable Long id, Administrativo administrativo) {
        administrativoServicio.actualizar(id, administrativo);
        return "redirect:/administrativos";
    }

    @GetMapping("/{id}/eliminar")
    public String eliminarAdministrativo(@PathVariable Long id) {
        administrativoServicio.eliminar(id);
        return "redirect:/administrativos";
    }
}