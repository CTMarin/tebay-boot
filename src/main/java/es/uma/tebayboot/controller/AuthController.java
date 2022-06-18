package es.uma.tebayboot.controller;

import es.uma.tebayboot.dto.Usuario;
import es.uma.tebayboot.dto.form.KeyValueDTO;
import es.uma.tebayboot.dto.form.UsuarioLogin;
import es.uma.tebayboot.dto.form.UsuarioRegister;
import es.uma.tebayboot.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class AuthController {
    UsuarioService usuarioService;

    public UsuarioService getUsuarioService() {
        return usuarioService;
    }

    @Autowired
    public void setUsuarioService(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/login")
    public String login(Model model) {
        UsuarioLogin user = new UsuarioLogin();
        model.addAttribute("user", user);

        return "login";
    }

    @GetMapping("/register")
    public String register(Model model) {
        UsuarioRegister user = new UsuarioRegister();
        List<KeyValueDTO<String>> sexos = Arrays.asList(
                new KeyValueDTO<>("Hombre", "hombre"),
                new KeyValueDTO<>("Mujer", "mujer"),
                new KeyValueDTO<>("Otro", "otro"));

        model.addAttribute("user", user);
        model.addAttribute("sexos", sexos);

        return "register";
    }

    @PostMapping("/register")
    public String registerPost(@ModelAttribute UsuarioRegister user) {
        this.usuarioService.register(user);

        return "redirect:/login/";
    }

    @PostMapping("/auth")
    public String authenticate(Model model, HttpSession session,
                               @ModelAttribute UsuarioLogin user) {
        String goTo = "redirect:/marketplace/";

        Usuario usuario = this.usuarioService.checkUser(user.getEmail(), user.getPassword());
        session.setAttribute("user", usuario);
        if (usuario == null) {
            model.addAttribute("error", "Usuario o contraseña incorrectos");
            goTo = "login";
        }
        else if(usuario.getPermiso().equals("admin"))
        {
            goTo = "redirect:/admin/listaUsuarios";
        }

        return goTo;
    }
}

/*
            domicile = new Domicilio();
            domicile.setPais(country);
            domicile.setCiudad(city);
            domicile.setCodigoPostal(cp);
            domicile.setCalle(street);
            domicile.setNumero(number);
            domicile.setBloque(block);
            domicile.setPiso(floor);
            domicile.setPuerta(door);

            domicilioFacade.create(domicile);

            user = new Usuario();
            user.setEmail(email);
            user.setPassword(passwd);
            user.setNombre(name);
            user.setApellidos(second_name);
            user.setEdad(age);
            user.setSexo(gender);
            user.setPermiso("user");
            user.setDomicilio(domicile);

            usuarioFacade.create(user);

            response.sendRedirect(request.getContextPath() + "/login");
 */
