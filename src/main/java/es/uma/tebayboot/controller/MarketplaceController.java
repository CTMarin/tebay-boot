package es.uma.tebayboot.controller;

import es.uma.tebayboot.dto.Subasta;
import es.uma.tebayboot.service.SubastaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("marketplace")
public class MarketplaceController {

    @Autowired
    protected SubastaService subastaService;

    @GetMapping("")
    public String doInit(Model model) {
        List<Subasta> subastas = subastaService.findAll();
        model.addAttribute("subastas",subastas);
        return "marketplace";
    }
}
