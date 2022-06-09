package es.uma.tebayboot.service;

import es.uma.tebayboot.dao.ArticuloRepository;
import es.uma.tebayboot.dto.Articulo;
import es.uma.tebayboot.dto.Subasta;
import es.uma.tebayboot.dto.Usuario;
import es.uma.tebayboot.entity.ArticuloEntity;
import es.uma.tebayboot.entity.SubastaEntity;
import es.uma.tebayboot.entity.UsuarioEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ArticuloService {

    @Autowired
    protected ArticuloRepository articuloRepository;

    public List<Articulo> findByGanador_IdUsuario(Integer id_user){
        return entityListToDTO(articuloRepository.findByGanador_IdUsuario(id_user));
    }

    public Articulo findById(Integer id){
        ArticuloEntity articulo = articuloRepository.findById(id).orElse(null);
        return articulo==null?null:articulo.toDTO();
    }

    public Usuario findGanador(Integer id){
        UsuarioEntity usuario = articuloRepository.findGanador(id);
        return usuario==null?null:usuario.toDTO();
    }

    public Subasta findSubasta(Integer id){
        return articuloRepository.findSubasta(id).toDTO();
    }

    private List<Articulo> entityListToDTO(List<ArticuloEntity> articulos) {
        return articulos.stream().map(ArticuloEntity::toDTO).collect(Collectors.toList());
    }
}
