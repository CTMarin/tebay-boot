package es.uma.tebayboot.service;

import es.uma.tebayboot.dao.ArticuloRepository;
import es.uma.tebayboot.dao.CategoriaRepository;
import es.uma.tebayboot.dto.Articulo;
import es.uma.tebayboot.dto.Subasta;
import es.uma.tebayboot.dto.Usuario;
import es.uma.tebayboot.entity.ArticuloEntity;
import es.uma.tebayboot.entity.CategoriaEntity;
import es.uma.tebayboot.entity.UsuarioEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
/*
    Álvaro J. Tapia Muñoz: 20%
 */
@Service
public class ArticuloService {

    @Autowired
    ArticuloRepository articuloRepository;
    @Autowired
    CategoriaRepository categoriaRepository;

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

    public ArticuloEntity create(String titulo, String descripcion, List<String> categories, String image_url) {
        List<CategoriaEntity> categoryList = new ArrayList<>();
        for(String category : categories) {
            categoryList.add(this.categoriaRepository.getCategoriaEntityByTitulo(category));
        }
        ArticuloEntity product = new ArticuloEntity();
        product.setTitulo(titulo);
        product.setDescripcion(descripcion);
        product.setCategoriaList(categoryList);
        product.setUrlArticulo(image_url);
        this.articuloRepository.save(product);

        return product;
    }

    public void updateSubasta(int product_id, int auction) {
        this.articuloRepository.updateSubasta(product_id, auction);
    }

    public ArticuloEntity formarArticulo(String titulo, String descripcion, String url,Integer idArticulo)
    {
        ArticuloEntity articulo = new ArticuloEntity();

        articulo.setUrlArticulo(url);
        articulo.setDescripcion(descripcion);
        articulo.setTitulo(titulo);
        articulo.setIdArticulo(idArticulo);


        articuloRepository.save(articulo);

        return articulo;
    }
}
