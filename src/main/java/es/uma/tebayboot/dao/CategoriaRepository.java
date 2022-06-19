package es.uma.tebayboot.dao;

import es.uma.tebayboot.entity.CategoriaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * author: Carlos Marín Corbera 100%
 */
@Repository
public interface CategoriaRepository extends JpaRepository<CategoriaEntity,Integer> {
    public CategoriaEntity getCategoriaEntityByTitulo(String titulo);
}
