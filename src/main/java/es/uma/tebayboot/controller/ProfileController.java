package es.uma.tebayboot.controller;

import es.uma.tebayboot.dto.Articulo;
import es.uma.tebayboot.dto.Categoria;
import es.uma.tebayboot.dto.Subasta;
import es.uma.tebayboot.service.ArticuloService;
import es.uma.tebayboot.service.CategoriaService;
import es.uma.tebayboot.service.SubastaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("profile")
public class ProfileController {

    CategoriaService categoriaService;
    SubastaService subastaService;
    ArticuloService articuloService;

    public CategoriaService getCategoriaService() {
        return categoriaService;
    }

    @Autowired
    public void setCategoriaService(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    public SubastaService getSubastaService() {
        return subastaService;
    }

    @Autowired
    public void setSubastaService(SubastaService subastaService) {
        this.subastaService = subastaService;
    }

    public ArticuloService getArticuloService() {
        return articuloService;
    }

    @Autowired
    public void setArticuloService(ArticuloService articuloService) {
        this.articuloService = articuloService;
    }

    @GetMapping("")
    public String doInit(){
        return "profile";
    }

    @GetMapping("published-articles")
    public String doPublishedAuctions(Model model){

        List<Categoria> categorias = categoriaService.findAll();
        model.addAttribute("categorias",categorias);
        List<Subasta> subastas = subastaService.findByArticuloNameAndSeller(1,"");
        model.addAttribute("subastas",subastas);

        return "published_articles";
    }

    @GetMapping("won-auctions")
    public String doWonAuctions(Model model){

        List<Articulo> articulos = articuloService.findByGanador_IdUsuario(1);
        model.addAttribute("articulos",articulos);

        return "won_auctions";
    }

    @GetMapping("fav-articles")
    public String doFavArticles(Model model){

        List<Subasta> subastasFav = subastaService.findByFavs(1);
        model.addAttribute("subastasFav",subastasFav);

        return "fav_articles";
    }
}
