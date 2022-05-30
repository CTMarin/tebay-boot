package es.uma.tebayboot.controller;

import es.uma.tebayboot.dao.UsuarioRepository;
import es.uma.tebayboot.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("usuario")
public class UsuarioController
{
    private UsuarioRepository usuarioRepository;

    public UsuarioRepository getUsuarioRepository()
    {
        return usuarioRepository;
    }

    @Autowired
    public void setUsuarioRepository(UsuarioRepository usuarioRepository)
    {
        this.usuarioRepository = usuarioRepository;
    }

    @GetMapping("/listaUsuarios")
    public String doListar(Model model)
    {
        List<Usuario> lista = this.usuarioRepository.findAll();
        model.addAttribute("usuarios",lista);

        return "ListaUsuarios";
    }
}
