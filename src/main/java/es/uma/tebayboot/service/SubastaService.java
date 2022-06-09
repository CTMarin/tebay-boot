package es.uma.tebayboot.service;

import es.uma.tebayboot.dao.SubastaRepository;
import es.uma.tebayboot.dto.Subasta;
import es.uma.tebayboot.entity.SubastaEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SubastaService {

    @Autowired
    protected SubastaRepository subastaRepository;

    public List<Subasta> findAll(){
        return entityListToDTO(subastaRepository.findAll());
    }

    public List<Subasta> findByArticuloNameAndSeller(Integer user_id, String title){
        return entityListToDTO(subastaRepository.findByArticuloNameAndSeller(user_id,title));
    }

    public List<Subasta> findByFavs(Integer user_id){
        return entityListToDTO(subastaRepository.findByFavs(user_id));
    }

    private List<Subasta> entityListToDTO(List<SubastaEntity> subastas) {
        return subastas.stream().map(SubastaEntity::toDTO).collect(Collectors.toList());
    }
}
