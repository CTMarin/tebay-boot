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

    protected SubastaRepository subastaRepository;

    public SubastaRepository getSubastaRepository(){
        return subastaRepository;
    }

    @Autowired
    public void setSubastaRepository(SubastaRepository subastaRepository){
        this.subastaRepository = subastaRepository;
    }

    public List<Subasta> findAll(){
        return entityListToDTO(subastaRepository.findAll());
    }

    private List<Subasta> entityListToDTO(List<SubastaEntity> subastas) {
        return subastas.stream().map(SubastaEntity::toDTO).collect(Collectors.toList());
    }
}
