package es.uma.tebayboot.dao;

import es.uma.tebayboot.entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
/*
    Álvaro J. Tapia Muñoz: 50%
 */
@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Integer> {
    @Query("select user from UsuarioEntity user where user.email = :email and user.password = :password")
    public UsuarioEntity checkUser(@Param("email") String email, @Param("password") String passwd);

    public UsuarioEntity getUsuarioEntityByEmail(String email);

    @Query("SELECT u from UsuarioEntity u where u.nombre LIKE CONCAT('%',:nombre,'%')")
    public List<UsuarioEntity> findByBusquedaNombre(@Param("nombre") String nombre);

    public UsuarioEntity findByIdUsuario(Integer id);
}
