package com.innovaultmy.app.controllers.RegistroControllers;

import com.innovaultmy.app.models.Usuario;
import com.innovaultmy.app.repositories.registros.UsuariosR;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin")
public class UserControllers {

    @Autowired
    private UsuariosR userRepository;

    @GetMapping("/RegistrarUsuario")
    public ModelAndView mostrarRegistrar() {
        return new ModelAndView("paginas/Registro")
                .addObject("usuario", new Usuario());
    }

    @PostMapping("/RegistrarUsuario")
    public ModelAndView registrarUsuario(@Validated Usuario usuario, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ModelAndView("paginas/Registro")
                    .addObject("usuario", new Usuario());
        }
        userRepository.save(usuario);
        return new ModelAndView("redirect:/admin/IndexUsuario");
    }

    @GetMapping("/IndexUsuario")
    public ModelAndView verPaginaDeInicio(Pageable pageable) {
        Page<Usuario> usuarios = userRepository.findAll(pageable);
        return new ModelAndView("paginas/Registro")
                .addObject("usuarios", usuarios);
    }
}



