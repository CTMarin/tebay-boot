package es.uma.tebayboot.dao;

import es.uma.tebayboot.entity.SubastaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubastaRepository extends JpaRepository<SubastaEntity,Integer> {

    SubastaEntity findSubastaByIdSubasta(Integer id);

    @Query("select subasta from SubastaEntity subasta where subasta.vendedor.idUsuario = :user_id and subasta.articulo.titulo like concat('%',:title,'%') ")
    List<SubastaEntity> findByArticuloNameAndSeller(@Param("user_id") Integer user_id, @Param("title") String title);

    @Query("select subasta from SubastaEntity subasta join subasta.usuarioList usuario where usuario.idUsuario=:user_id")
    List<SubastaEntity> findByFavs(@Param("user_id") Integer user_id);
}
