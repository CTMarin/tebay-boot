package es.uma.tebayboot.service;

import es.uma.tebayboot.dao.PujaRepository;
import es.uma.tebayboot.dao.SubastaRepository;
import es.uma.tebayboot.dao.UsuarioRepository;
import es.uma.tebayboot.entity.PujaEntity;
import es.uma.tebayboot.entity.SubastaEntity;
import es.uma.tebayboot.entity.UsuarioEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;
import java.util.List;
/**
 * author:
 *  - Carmen González Ortega 100%
 */
@Service
public class PujaService {

    @Autowired
    UsuarioRepository usuarioRepository;
    @Autowired
    SubastaRepository subastaRepository;
    @Autowired
    PujaRepository pujaRepository;


    public void create(double cantidad, Integer subasta_id, Integer usuario_id) {

        SubastaEntity subasta = subastaRepository.findById(subasta_id).orElse(new SubastaEntity());

        PujaEntity puja = new PujaEntity();
        puja.setValor(cantidad);
        puja.setFecha(Date.from(Instant.now()));
        puja.setUsuario(usuarioRepository.findById(usuario_id).orElse(new UsuarioEntity()));
        puja.setSubasta(subasta);
        pujaRepository.save(puja);

        List<PujaEntity> listaPujas = subasta.getPujaList();
        listaPujas.add(puja);
        subasta.setPujaList(listaPujas);
        subasta.setPuja(puja.getValor());
        subastaRepository.save(subasta);
    }
}
