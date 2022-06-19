package es.uma.tebayboot.controller;

import es.uma.tebayboot.dto.Subasta;
import es.uma.tebayboot.dto.Usuario;
import es.uma.tebayboot.service.SubastaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;
/**
 * author: Carmen González Ortega 100%
 */
@Controller
@RequestMapping("")
public class MarketplaceController {

    @Autowired
    protected SubastaService subastaService;

    @GetMapping("")
    public String doInit(Model model, HttpSession session) {

        Usuario usuario = (Usuario) session.getAttribute("user");
        if (usuario != null){
            List<Subasta> subastas = subastaService.findAll();
            model.addAttribute("subastas",subastas);
            List<Subasta> favoritos = subastaService.findByFavs(usuario.getIdUsuario());
            model.addAttribute("favoritos", favoritos);
        }
        return "marketplace";
    }
}
