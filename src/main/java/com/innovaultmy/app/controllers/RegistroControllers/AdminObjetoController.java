package com.innovaultmy.app.controllers.RegistroControllers;

import com.innovaultmy.app.models.registros.InventarioFilamento;
import com.innovaultmy.app.repositories.registros.InventarioFilamentoRepositorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/admin")
public class AdminObjetoController {
    @Autowired
    private InventarioFilamentoRepositorie inventarioFilamentoRepositorie;
    @GetMapping("/RegistrarObjeto")
    public ModelAndView Mostrarregistrar()
    {
        return new ModelAndView("AdminObjetos/registrarFilamento")
                .addObject("filamento", new InventarioFilamento());
    }
    @PostMapping("/RegistrarObjeto")
    public ModelAndView registrarObjeto(@Validated InventarioFilamento filamento, BindingResult bindingResult)
    {
        if(bindingResult.hasErrors())
        {
            return new ModelAndView("AdminObjetos/registrarFilamento")
                    .addObject("filamento", new InventarioFilamento());

        }
        inventarioFilamentoRepositorie.save(filamento);
        return new ModelAndView("redirect:/admin/Indexfilamento");
    }
    @GetMapping("/Indexfilamento")
    public ModelAndView verPaginaDeInicio(@PageableDefault(sort="nombre",size = 20) Pageable pageable)
    {
        Page<InventarioFilamento> filamentos = inventarioFilamentoRepositorie.findAll(pageable);
        return new ModelAndView("AdminObjetos/index_Objetos")
                .addObject("filamento",filamentos);
    }


//
//    @PostMapping("/EditarObjeto")
//    public ModelAndView editarObjeto(@RequestParam("idObjeto") long id,
//                                     @RequestParam("nombreObjeto") String nombre,
//                                     @RequestParam("TipoFilamento") String tipoDeFilamento,
//                                     @RequestParam("CantidadFilamento") int cantidad,
//                                     @RequestParam("ColorFilamento") String color,
//                                     @RequestParam("notas") String notas) {
//
//        InventarioFilamento filamento = filamentoService.buscarPorId(id);
//        if (filamento != null) {
//            filamento.setNombre(nombre);
//            filamento.setTipoDeFilamento(tipoDeFilamento);
//            filamento.setCantidad(cantidad);
//            filamento.setColor(color);
//            filamento.setNotas(notas);
//            filamento.setFechaEdicion(new Date());
//
//            filamentoService.actualizarFilamento(filamento);
//        }
//        return new ModelAndView("redirect:/admin/Objetos");
//    }
//    @PostMapping("/EliminarObjeto")
//    public ModelAndView eliminarObjeto(@RequestParam("idObjeto") long id){
//        InventarioFilamento filamento = filamentoService.buscarPorId(id);
//        if (filamento != null) {
//            filamentoService.borrar(filamento);
//        }
//        return new ModelAndView("redirect:/admin/Objetos");
//    }
}
