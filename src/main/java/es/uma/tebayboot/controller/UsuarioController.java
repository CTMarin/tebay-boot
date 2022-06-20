package es.uma.tebayboot.controller;

import es.uma.tebayboot.dto.Domicilio;
import es.uma.tebayboot.dto.Subasta;
import es.uma.tebayboot.dto.Usuario;
import es.uma.tebayboot.dto.form.KeyValueDTO;
import es.uma.tebayboot.dto.form.SubastaEdit;
import es.uma.tebayboot.dto.form.UsuarioEditar;
import es.uma.tebayboot.entity.UsuarioEntity;
import es.uma.tebayboot.service.DomicilioService;
import es.uma.tebayboot.service.SubastaService;
import es.uma.tebayboot.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
/*
    Álvaro J. Tapia Muñoz: 100%
 */
@Controller
@RequestMapping("admin")
public class UsuarioController
{
    private UsuarioService usuarioService;
    private DomicilioService domicilioService;
    private SubastaService subastaService;

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

    public SubastaService getSubastaService() {
        return subastaService;
    }

    @Autowired
    public void setSubastaService(SubastaService subastaService) {
        this.subastaService = subastaService;
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

        UsuarioEditar usuarioEditar = this.usuarioService.usuarioAEditar(usuario);

        List<KeyValueDTO<String>> sexos = Arrays.asList(
                new KeyValueDTO<>("Hombre", "hombre"),
                new KeyValueDTO<>("Mujer", "mujer"),
                new KeyValueDTO<>("Otro", "otro"));

        List<KeyValueDTO<String>> permisos = Arrays.asList(
                new KeyValueDTO<>("User","user"),
                new KeyValueDTO<>("Admin", "admin")
        );

        //Domicilio domicilio = this.domicilioService.buscarDomicilio(usuario.getDomicilio().getIdDomicilio()); //?¿?¿?
        model.addAttribute("usuarioEditar",usuarioEditar);
        model.addAttribute("sexos", sexos);
        model.addAttribute("permisos",permisos);
       // model.addAttribute("domicilio",domicilio); // ?¿?¿

        return "usuario";
    }

    @GetMapping("/{id}/borrar")
    public String doBorrar(@PathVariable("id") Integer IdUsuario)
    {
        this.usuarioService.borrarUsuario(IdUsuario);
        return "redirect:/admin/listaUsuarios";
    }

    @PostMapping("/guardar")
    public String doGuardar(@ModelAttribute("usuarioEditar") UsuarioEditar usuario)
    {
        this.usuarioService.guardarUsuario(usuario);
        return "redirect:/admin/listaUsuarios";
    }

    @GetMapping("/nuevo")
    public String doNuevo(Model model)
    {
        UsuarioEditar usuario = new UsuarioEditar();

        List<KeyValueDTO<String>> sexos = Arrays.asList(
                new KeyValueDTO<>("Hombre", "hombre"),
                new KeyValueDTO<>("Mujer", "mujer"),
                new KeyValueDTO<>("Otro", "otro"));

        List<KeyValueDTO<String>> permisos = Arrays.asList(
                new KeyValueDTO<>("User","user"),
                new KeyValueDTO<>("Admin", "admin")
        );

        model.addAttribute("usuarioEditar",usuario);
        model.addAttribute("sexos", sexos);
        model.addAttribute("permisos",permisos);
        //this.anyadirdomicilio??
        return "usuario";
    }

    @GetMapping("/listaSubastas")
    public String doListarSubastas(Model model)
    {
        return this.doFiltrarSubastas(model,null);
    }

    @PostMapping("/filtrarSubastas")
    public String doFiltrarSubastas(Model model, @RequestParam("filtro") String filtro)
    {
        List<Subasta> lista = this.subastaService.listarSubastas(filtro);
        model.addAttribute("subastas",lista);

        return "listaSubastas";
    }

    @GetMapping("/subasta/{id}/edit")
    public String doEditarSubasta(@PathVariable("id") Integer id, Model model)
    {
        Subasta subasta = this.subastaService.buscarSubasta(id);

        SubastaEdit subastaEdit = this.subastaService.subastaAEditar(subasta);

        model.addAttribute("subastaEdit",subastaEdit);

        return "subasta";
    }

    @GetMapping("/subasta/{id}/borrar")
    public String doBorrarSubasta(@PathVariable("id") Integer id)
    {
        this.subastaService.borrarSubasta(id);
        return "redirect:/admin/listaSubastas";
    }

    @PostMapping("/subasta/guardar")
    public String doGuardarSubasta(@ModelAttribute("subastaEdit") SubastaEdit subasta)
    {
        this.subastaService.guardarSubasta(subasta);
        return "redirect:/admin/listaSubastas";
    }

}
