package com.innovaultmy.app.controllers;

import com.innovaultmy.app.models.InventarioFilamento;
import com.innovaultmy.app.service.InventarioFilamentoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;


@Controller
@RequestMapping("/admin")
public class AdminObjetoController {
    private final InventarioFilamentoService filamentoService;

    public AdminObjetoController(InventarioFilamentoService filamentoService) {
        this.filamentoService = filamentoService;
    }
    @GetMapping("/Objetos")
    public ModelAndView objeto(Model model) {
        List<InventarioFilamento> filamentos = filamentoService.listaFilamentos();
        model.addAttribute("filamentos", filamentos);
        return new ModelAndView("AdminObjetos/index_Objetos");
    }

    @PostMapping("/RegistrarObjeto")
    public ModelAndView registrarObjeto(@RequestParam("nombreObjeto") String nombre,
                                        @RequestParam("TipoFilamento") String tipoDeFilamento,
                                        @RequestParam("CantidadFilamento") int cantidad,
                                        @RequestParam("ColorFilamento") String color,
                                        @RequestParam("notas") String notas) {

        filamentoService.registrarNuevoFilamento(nombre, tipoDeFilamento, cantidad, color, notas);
        return new ModelAndView("redirect:/admin/Objetos");
    }
    @PostMapping("/EditarObjeto")
    public ModelAndView editarObjeto(@RequestParam("idObjeto") long id,
                                     @RequestParam("nombreObjeto") String nombre,
                                     @RequestParam("TipoFilamento") String tipoDeFilamento,
                                     @RequestParam("CantidadFilamento") int cantidad,
                                     @RequestParam("ColorFilamento") String color,
                                     @RequestParam("notas") String notas) {

        InventarioFilamento filamento = filamentoService.buscarPorId(id);
        if (filamento != null) {
            filamento.setNombre(nombre);
            filamento.setTipoDeFilamento(tipoDeFilamento);
            filamento.setCantidad(cantidad);
            filamento.setColor(color);
            filamento.setNotas(notas);
            filamento.setFechaEdicion(new Date());

            filamentoService.actualizarFilamento(filamento);
        }
        return new ModelAndView("redirect:/admin/Objetos");
    }
    @PostMapping("/EliminarObjeto")
    public ModelAndView eliminarObjeto(@RequestParam("idObjeto") long id){
        InventarioFilamento filamento = filamentoService.buscarPorId(id);
        if (filamento != null) {
            filamentoService.borrar(filamento);
        }
        return new ModelAndView("redirect:/admin/Objetos");
    }
}
