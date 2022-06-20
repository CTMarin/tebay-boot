package es.uma.tebayboot.controller;

import es.uma.tebayboot.dto.Articulo;
import es.uma.tebayboot.dto.Categoria;
import es.uma.tebayboot.dto.Subasta;
import es.uma.tebayboot.dto.Usuario;
import es.uma.tebayboot.dto.form.FilterAuction;
import es.uma.tebayboot.dto.form.PublishAuction;
import es.uma.tebayboot.dto.form.SearchFilter;
import es.uma.tebayboot.service.ArticuloService;
import es.uma.tebayboot.service.CategoriaService;
import es.uma.tebayboot.service.SubastaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.Filter;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

/**
 * author: Carmen González Ortega 100%
 */
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
    public String doPublishedAuctions(Model model, HttpSession session, @ModelAttribute FilterAuction filters, @ModelAttribute SearchFilter searchbox) throws ParseException {
        Usuario usuario = (Usuario) session.getAttribute("user");
        if(!filters.isFilter()) {
            model.addAttribute("filters", new FilterAuction());
        } else {
            model.addAttribute("filters", filters);
        }

        List<Subasta> subastas;
        if(usuario != null) {
            List<Categoria> categorias = categoriaService.findAll();
            model.addAttribute("categorias",categorias);
            if (filters.isFilter()) {
                if(filters.getFinish_string() == null || Objects.equals(filters.getFinish_string(), "")) {
                    subastas = subastaService.findAllFilteredNoDate(usuario.getIdUsuario(), filters.getMin_init_value(), filters.getMax_init_value());
                } else {
                    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                    Date date = formatter.parse(filters.getFinish_string());
                    subastas = subastaService.findAllFiltered(usuario.getIdUsuario(), filters.getMin_init_value(), filters.getMax_init_value(), date);
                }
            } else {
                if(searchbox.getTitle() == null) {
                    subastas = this.subastaService.findByArticuloNameAndSeller(usuario.getIdUsuario(),"");
                } else {
                    subastas = this.subastaService.findByArticuloNameAndSeller(usuario.getIdUsuario(), searchbox.getTitle());
                }
            }
        } else {
            subastas = this.subastaService.findByArticuloNameAndSeller(usuario.getIdUsuario(),"");
        }
        model.addAttribute("subastas", subastas);
        model.addAttribute("searchbox", new SearchFilter());
        return "published_articles";
    }

    @GetMapping("won-auctions")
    public String doWonAuctions(Model model, HttpSession session){
        Usuario usuario = (Usuario) session.getAttribute("user");
        List<Articulo> articulos = articuloService.findByGanador_IdUsuario(usuario.getIdUsuario());
        model.addAttribute("articulos",articulos);

        return "won_auctions";
    }

    @GetMapping("fav-articles")
    public String doFavArticles(Model model, HttpSession session){
        Usuario usuario = (Usuario) session.getAttribute("user");
        List<Subasta> subastasFav = subastaService.findByFavs(usuario.getIdUsuario());
        model.addAttribute("subastasFav",subastasFav);

        return "fav_articles";
    }

    @GetMapping("publish-auction")
    public String getPublishAuctionPage(Model model) {
        PublishAuction subasta = new PublishAuction();
        List<Categoria> categorias = categoriaService.findAll();

        model.addAttribute("subasta", subasta);
        model.addAttribute("categoriaList", categorias);

        return "publish_auction";
    }

    @PostMapping("publish-auction")
    public String postPublishAuction(@ModelAttribute PublishAuction subasta, HttpSession session) {
        Usuario usuario = (Usuario) session.getAttribute("user");
        this.subastaService.publishAuction(subasta, usuario.getEmail());

        return "redirect:/";
    }

}
