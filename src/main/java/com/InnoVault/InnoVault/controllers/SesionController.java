package com.InnoVault.InnoVault.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/sesion")
public class SesionController
{
    @GetMapping("/Registro")
    public ModelAndView verPaginaDeRegistro()
    {
        return new ModelAndView("paginas/Registro");
    }
    @GetMapping("/Login")
    public ModelAndView verPaginaDeLogin()
    {
        return new ModelAndView("paginas/Login");
    }
    @GetMapping("/Rest")
    public ModelAndView cambiar_contr() {
        return new ModelAndView("paginas/Rest");
    }
    @GetMapping("/verify_code")
    public ModelAndView verify_code(){
        return new ModelAndView("paginas/verify_code");
    }
}
