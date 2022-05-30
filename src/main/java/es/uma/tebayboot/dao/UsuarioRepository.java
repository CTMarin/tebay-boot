package es.uma.tebayboot.dao;

import es.uma.tebayboot.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Integer>
{
    public Usuario findUsuarioByIdUsuario(Integer id);
}
