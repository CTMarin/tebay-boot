package es.uma.tebayboot.dao;

import es.uma.tebayboot.entity.DomicilioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 * author:
 *  - Carlos Marín Corbera 100%
 */
@Repository
public interface DomicilioRepository extends JpaRepository<DomicilioEntity, Integer> {
}
