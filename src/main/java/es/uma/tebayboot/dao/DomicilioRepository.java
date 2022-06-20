package es.uma.tebayboot.dao;

import es.uma.tebayboot.entity.DomicilioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 * author:
 *  - Carlos Marín Corbera 50%
 *  - Álvaro J. Tapia Muñoz: 50%
 */
@Repository
public interface DomicilioRepository extends JpaRepository<DomicilioEntity, Integer>
{
    public DomicilioEntity findDomicilioEntityByIdDomicilio(Integer id);
}
