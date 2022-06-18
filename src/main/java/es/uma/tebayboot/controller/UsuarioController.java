package es.uma.tebayboot.controller;

import es.uma.tebayboot.dto.Domicilio;
import es.uma.tebayboot.dto.Usuario;
import es.uma.tebayboot.entity.UsuarioEntity;
import es.uma.tebayboot.service.DomicilioService;
import es.uma.tebayboot.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("admin")
public class UsuarioController
{
    private UsuarioService usuarioService;
    private DomicilioService domicilioService;

    public UsuarioService getUsuarioService() {
        return usuarioService;
    }

    @Autowired
    public void setUsuarioService(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    public DomicilioService getDomicilioService() {
        return domicilioService;
    }

    @Autowired
    public void setDomicilioService(DomicilioService domicilioService) {
        this.domicilioService = domicilioService;
    }

    @GetMapping("/listaUsuarios")
    public String doListar(Model model)
    {
        return this.doFiltrar(model, null);
    }

    @PostMapping("/filtrar")
    public String doFiltrar(Model model, @RequestParam("filtro") String filtro)
    {
        List<Usuario> lista = this.usuarioService.listarClientes(filtro);
        model.addAttribute("usuarios", lista);

        return "ListaUsuarios";
    }

    @GetMapping("/{id}/edit")
    public String doEditar(@PathVariable("id") Integer IdUsuario, Model model)
    {
        Usuario usuario = this.usuarioService.buscarUsuario(IdUsuario);
        //Domicilio domicilio =
        model.addAttribute("usuario",usuario);

        return "usuario";
    }

    @GetMapping("/{id}/borrar")
    public String doBorrar(@PathVariable("id") Integer IdUsuario)
    {
        this.usuarioService.borrarUsuario(IdUsuario);
        return "redirect:/admin/listaUsuarios";
    }

    @PostMapping("/guardar")
    public String doGuardar(@ModelAttribute("usuario") Usuario usuario)
    {
        this.usuarioService.guardarUsuario(usuario);
        return "redirect:/admin/listaUsuarios";
    }

    @GetMapping("/nuevo")
    public String doNuevo(Model model)
    {
        Usuario usuario = new Usuario();

        model.addAttribute("usuario",usuario);
        //this.anyadirdomicilio??
        return "cliente";
    }

}
