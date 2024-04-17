package com.innovaultmy.app.controllers.RegistroControllers;

import com.innovaultmy.app.models.registros.ImpresoraModel;
import com.innovaultmy.app.repositories.registros.impresoraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
@RequestMapping("/nuevo")
public class ImpresorasController
{
    @Autowired
    private impresoraRepository impresoraRep;
    @GetMapping("/nuevaImpresora")
    public ModelAndView mostrarRegistrarImpresora()
    {
        return new ModelAndView("AdminObjetos/ImpresorasRegistro")
                .addObject("impresora", new ImpresoraModel());
    }

    @PostMapping("/nuevaImpresora")
    public ModelAndView registrarImpresora(@Validated ImpresoraModel impresoraModel, BindingResult bindingResult)
    {
        if(bindingResult.hasErrors())
        {
            return new ModelAndView("AdminObjetos/ImpresorasRegistro")
                    .addObject("filamento", new ImpresoraModel());
        }
        impresoraRep.save(impresoraModel);
        return new ModelAndView("redirect:/nuevo/nuevaImpresora");
    }
}
