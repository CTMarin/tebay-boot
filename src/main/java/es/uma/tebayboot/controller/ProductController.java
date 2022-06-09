package es.uma.tebayboot.controller;

import es.uma.tebayboot.dto.Articulo;
import es.uma.tebayboot.dto.Subasta;
import es.uma.tebayboot.dto.Usuario;
import es.uma.tebayboot.service.ArticuloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("product")
public class ProductController {

    @Autowired
    protected ArticuloService articuloService;

    @GetMapping("/{id_product}")
    public String doInit(Model model, @PathVariable("id_product") Integer id_product){

        Articulo articulo = articuloService.findById(id_product);
        model.addAttribute("articulo",articulo);
        Usuario ganador = articuloService.findGanador(id_product);
        model.addAttribute("ganador",ganador);
        Subasta subasta = articuloService.findSubasta(id_product);
        model.addAttribute("subasta",subasta);

        return "product";
    }
}
