package es.uma.tebayboot.service;

import es.uma.tebayboot.dao.ArticuloRepository;
import es.uma.tebayboot.dao.SubastaRepository;
import es.uma.tebayboot.dao.UsuarioRepository;
import es.uma.tebayboot.dto.Subasta;
import es.uma.tebayboot.dto.form.PublishAuction;
import es.uma.tebayboot.dto.form.SubastaEdit;
import es.uma.tebayboot.entity.ArticuloEntity;
import es.uma.tebayboot.dto.Usuario;
import es.uma.tebayboot.entity.PujaEntity;
import es.uma.tebayboot.entity.SubastaEntity;
import es.uma.tebayboot.entity.UsuarioEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
/**
 * author:
 *  - Carmen González Ortega 33%
 *  - Carlos Marín Corbera 33%
 *  - Álvaro J. Tapia Muñoz 33%
 */
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

    public List<Subasta> findAllFiltered(Integer user_id, Double min_valor, Double max_valor, Date fecha_limite) {
        return entityListToDTO(this.subastaRepository.findAllFiltered(user_id, min_valor, max_valor, fecha_limite));
    }

    public List<Subasta> findAllFilteredNoDate(Integer user_id, Double min_valor, Double max_valor) {
        return entityListToDTO(this.subastaRepository.findAllFilteredNoDate(user_id, min_valor, max_valor));
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

    public Subasta buscarSubasta(Integer id)
    {
        SubastaEntity subasta = this.subastaRepository.findById(id).orElse(null);

        if(subasta != null)
        {
            return subasta.toDTO();
        }
        else
        {
            return null;
        }
    }

    public SubastaEdit subastaAEditar(Subasta subasta)
    {
        SubastaEdit subastaADevolver = new SubastaEdit();

        subastaADevolver.setTitulo(subasta.getArticulo().getTitulo());
        subastaADevolver.setDescripcion(subasta.getArticulo().getDescripcion());
        subastaADevolver.setUrl_imagen(subasta.getArticulo().getUrlArticulo());
        subastaADevolver.setFecha_limite((java.sql.Date) subasta.getFechaLimite());
        subastaADevolver.setValor_inicial(subasta.getValorInicial());
        subastaADevolver.setIdSubasta(subasta.getIdSubasta());

        return subastaADevolver;
    }

    public void borrarSubasta(Integer id)
    {
        SubastaEntity subasta = this.subastaRepository.findById(id).orElse(null);
        //this.subastaRepository.delete(subasta);
        this.articuloRepository.delete(subasta.getArticulo());
    }

    public void guardarSubasta(SubastaEdit dto)
    {

        SubastaEntity subasta = this.subastaRepository.findById(dto.getIdSubasta()).orElse(null);

        subasta.getArticulo().setTitulo(dto.getTitulo());
        subasta.getArticulo().setDescripcion(dto.getDescripcion());
        subasta.getArticulo().setUrlArticulo(dto.getUrl_imagen());
        subasta.setValorInicial(dto.getValor_inicial());
        subasta.setFechaLimite(dto.getFecha_limite());

        this.subastaRepository.save(subasta);


    }

}
