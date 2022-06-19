package es.uma.tebayboot.dao;

import es.uma.tebayboot.entity.PujaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 * author:
 *  - Carmen González Ortega 100%
 */
@Repository
public interface PujaRepository extends JpaRepository<PujaEntity,Integer> {
}
