package es.uma.tebayboot.service;

import es.uma.tebayboot.dao.SubastaRepository;
import es.uma.tebayboot.dao.UsuarioRepository;
import es.uma.tebayboot.dto.Subasta;
import es.uma.tebayboot.dto.Usuario;
import es.uma.tebayboot.entity.SubastaEntity;
import es.uma.tebayboot.entity.UsuarioEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SubastaService {

    protected SubastaRepository subastaRepository;

    protected UsuarioRepository usuarioRepository;

    public SubastaRepository getSubastaRepository() {
        return subastaRepository;
    }

    @Autowired
    public void setSubastaRepository(SubastaRepository subastaRepository) {
        this.subastaRepository = subastaRepository;
    }

    public UsuarioRepository getUsuarioRepository() {
        return usuarioRepository;
    }

    @Autowired
    public void setUsuarioRepository(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

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

    public void removeFav(Integer subasta_id, Usuario usuario) {
        SubastaEntity subasta = this.subastaRepository.findById(subasta_id).orElse(null);

        List<UsuarioEntity> listaUsuarios = subasta.getUsuarioList();
        listaUsuarios.remove(usuarioRepository.findById(usuario.getIdUsuario()));
        subasta.setUsuarioList(listaUsuarios);

        subastaRepository.save(subasta);
    }

    public void addFav(Integer subasta_id, Usuario usuario) {
        SubastaEntity subasta = this.subastaRepository.findById(subasta_id).orElse(null);

        List<UsuarioEntity> listaUsuarios = subasta.getUsuarioList();
        UsuarioEntity usuarioEntity = usuarioRepository.findById(usuario.getIdUsuario()).orElse(null);
        if(usuarioEntity != null) listaUsuarios.add(usuarioEntity);
        subasta.setUsuarioList(listaUsuarios);

        subastaRepository.save(subasta);
    }
}
