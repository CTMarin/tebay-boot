package es.uma.tebayboot.controller;

import es.uma.tebayboot.dto.Articulo;
import es.uma.tebayboot.dto.Subasta;
import es.uma.tebayboot.dto.Usuario;
import es.uma.tebayboot.service.ArticuloService;
import es.uma.tebayboot.service.SubastaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("product")
public class ProductController {

    protected ArticuloService articuloService;

    protected SubastaService subastaService;

    public ArticuloService getArticuloService() {
        return articuloService;
    }

    @Autowired
    public void setArticuloService(ArticuloService articuloService) {
        this.articuloService = articuloService;
    }

    public SubastaService getSubastaService() {
        return subastaService;
    }

    @Autowired
    public void setSubastaService(SubastaService subastaService) {
        this.subastaService = subastaService;
    }

    @GetMapping("{id_product}")
    public String doInit(Model model, @PathVariable("id_product") Integer id_product){

        Articulo articulo = articuloService.findById(id_product);
        model.addAttribute("articulo",articulo);
        Usuario ganador = articuloService.findGanador(id_product);
        model.addAttribute("ganador",ganador);
        Subasta subasta = articuloService.findSubasta(id_product);
        model.addAttribute("subasta",subasta);

        return "product";
    }

    @GetMapping("/fav")
    public String removeFavArticle(@RequestParam("id") Integer id_subasta, @RequestParam("fav") boolean fav){

        if(fav) {
            subastaService.removeFav(id_subasta, null);
        }else{
            subastaService.addFav(id_subasta,null);
        }
        return "redirect:/marketplace";
    }


}
