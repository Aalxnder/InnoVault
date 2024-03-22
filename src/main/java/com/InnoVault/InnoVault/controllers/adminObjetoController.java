package com.InnoVault.InnoVault.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin")
public class adminObjetoController
{
//    Get mapping
    @GetMapping("RegistrarObjeto")
    public ModelAndView registrarObjeto()
    {
        return new ModelAndView("/AdminObjetos/registrar");
    }

    @GetMapping("ActualizarObjeto")
    public ModelAndView actualizarObjeto()
    {
        return new ModelAndView("/AdminObjetos/actualizar");
    }
    @GetMapping("IndexObjeto")
    public ModelAndView indexObjeto()
    {
        return new ModelAndView("AdminObjetos/index_Objetos");
    }
}
