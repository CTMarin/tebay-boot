package es.uma.tebayboot.dao;

import es.uma.tebayboot.entity.SubastaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubastaRepository extends JpaRepository<SubastaEntity,Integer> {

    public SubastaEntity findSubastaByIdSubasta(Integer id);
}
