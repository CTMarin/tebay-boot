package es.uma.tebayboot.dao;

import es.uma.tebayboot.dto.Usuario;
import es.uma.tebayboot.entity.ArticuloEntity;
import es.uma.tebayboot.entity.SubastaEntity;
import es.uma.tebayboot.entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ArticuloRepository extends JpaRepository<ArticuloEntity,Integer> {

    List<ArticuloEntity> findByGanador_IdUsuario(Integer id_user);

    @Query("select a.ganador from ArticuloEntity a where a.idArticulo=:id_product")
    UsuarioEntity findGanador(@Param("id_product") Integer id_product);

    @Query("select a.subasta from ArticuloEntity a where a.idArticulo=:id_product")
    SubastaEntity findSubasta(@Param("id_product") Integer id_product);

    @Transactional
    @Modifying
    @Query("update ArticuloEntity product set product.subasta1 = :id_subasta where product.idArticulo = :id_product")
    public void updateSubasta(@Param("id_product") int id_product, @Param("id_subasta") int id_subasta);
}
