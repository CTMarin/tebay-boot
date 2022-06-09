package es.uma.tebayboot.service;

import es.uma.tebayboot.dao.CategoriaRepository;
import es.uma.tebayboot.dto.Categoria;
import es.uma.tebayboot.dto.Subasta;
import es.uma.tebayboot.entity.CategoriaEntity;
import es.uma.tebayboot.entity.SubastaEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoriaService {

    @Autowired
    protected CategoriaRepository categoriaRepository;

    public List<Categoria> findAll(){
        return entityListToDTO(categoriaRepository.findAll());
    }

    private List<Categoria> entityListToDTO(List<CategoriaEntity> categorias) {
        return categorias.stream().map(CategoriaEntity::toDTO).collect(Collectors.toList());
    }
}
