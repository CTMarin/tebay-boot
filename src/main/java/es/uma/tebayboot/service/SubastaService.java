package es.uma.tebayboot.service;

import es.uma.tebayboot.dao.ArticuloRepository;
import es.uma.tebayboot.dao.SubastaRepository;
import es.uma.tebayboot.dao.UsuarioRepository;
import es.uma.tebayboot.dto.Subasta;
import es.uma.tebayboot.dto.form.PublishAuction;
import es.uma.tebayboot.entity.ArticuloEntity;
import es.uma.tebayboot.dto.Usuario;
import es.uma.tebayboot.entity.PujaEntity;
import es.uma.tebayboot.entity.SubastaEntity;
import es.uma.tebayboot.entity.UsuarioEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SubastaService {

    @Autowired
    SubastaRepository subastaRepository;
    @Autowired
    ArticuloRepository articuloRepository;
    @Autowired
    UsuarioRepository usuarioRepository;
    @Autowired
    ArticuloService articuloService;
    @Autowired
    PujaService pujaService;

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
        UsuarioEntity usuarioEntity = usuarioRepository.findById(usuario.getIdUsuario()).orElse(null);
        if(usuarioEntity != null) listaUsuarios.remove(usuarioEntity);

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

    public SubastaEntity create(PublishAuction dto, ArticuloEntity articulo, String email) {
        SubastaEntity subasta = new SubastaEntity();
        subasta.setValorInicial(dto.getValor_inicial());
        subasta.setFechaLimite(dto.getFecha_limite());
        subasta.setVendedor(this.usuarioRepository.getUsuarioEntityByEmail(email));
        subasta.setArticulo(articulo);
        this.subastaRepository.save(subasta);

        return subasta;
    }

    public void publishAuction(PublishAuction dto, String email) {
        ArticuloEntity articulo = this.articuloService.create(
                dto.getTitulo(),
                dto.getDescripcion(),
                dto.getCategorias(),
                dto.getUrl_imagen());
        SubastaEntity subasta = this.create(dto, articulo, email);
        articuloService.updateSubasta(articulo.getIdArticulo(), subasta.getIdSubasta());
    }

    public void pujar(double nuevaPuja, Integer id_subasta, Usuario usuario) {

        SubastaEntity subasta = subastaRepository.findById(id_subasta).orElse(null);
        if((subasta.getPuja()==null && nuevaPuja>=subasta.getValorInicial()) ||
                subasta.getPuja()!=null && nuevaPuja>subasta.getPuja()) {

            pujaService.create(nuevaPuja,id_subasta,usuario.getIdUsuario());
        }
    }

    public List<Subasta> listarSubastas(String filtroNombre)
    {
        List<SubastaEntity> lista;

        if(filtroNombre != null && filtroNombre.length() > 0)
        {
            lista = this.subastaRepository.findByNombre(filtroNombre);
        }
        else
        {
            lista = this.subastaRepository.findAll();
        }

        return this.entityListToDTO(lista);
    }

}
