package com.innovaultmy.app.controllers.RegistroControllers;

import com.innovaultmy.app.models.registros.VariosModel;
import com.innovaultmy.app.repositories.registros.variosRepositorios;
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
@RequestMapping("/nuevo")
public class VariosController {
    @Autowired
    private variosRepositorios VariosRepositorios;

    @GetMapping("/RegistrarObjetos")
    public ModelAndView Mostrarregistrar()
    {
        return new ModelAndView("AdminObjetos/VariosRegistro")
                .addObject("Miscelanea", new VariosModel());
    }
    @PostMapping("/RegistrarObjetos")
    public ModelAndView registrarObjeto(@Validated VariosModel Miscelanea, BindingResult bindingResult)
    {
        if(bindingResult.hasErrors())
        {
            return new ModelAndView("AdminObjetos/VariosRegistro")
                    .addObject("Miscelanea", new VariosModel());

        }
        VariosRepositorios.save(Miscelanea);
        return new ModelAndView("redirect:/nuevo/Index_Varios");
    }

    @GetMapping("/Index_Varios")
    public ModelAndView verPaginaDeInicio(@PageableDefault(sort="nombre",size = 20) Pageable pageable)
    {
        Page<VariosModel> Miscelaneas = VariosRepositorios.findAll(pageable);
        return new ModelAndView("AdminObjetos/Index_Varios")
                .addObject("Miscelanea",Miscelaneas);
    }

}
