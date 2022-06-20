package es.uma.tebayboot.service;

import es.uma.tebayboot.dao.DomicilioRepository;
import es.uma.tebayboot.dao.UsuarioRepository;
import es.uma.tebayboot.dto.Usuario;
import es.uma.tebayboot.dto.form.UsuarioEditar;
import es.uma.tebayboot.dto.form.UsuarioRegister;
import es.uma.tebayboot.entity.DomicilioEntity;
import es.uma.tebayboot.entity.UsuarioEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
/**
 * author:
 *  - Carlos Marín Corbera 50%
 *  - Álvaro Jesús Tapia Muñoz 50%
 */
@Service
public class UsuarioService {
    UsuarioRepository usuarioRepository;
    DomicilioRepository domicilioRepository;
    DomicilioService domicilioService;


    public DomicilioRepository getDomicilioRepository() {
        return domicilioRepository;
    }

    @Autowired
    public void setDomicilioRepository(DomicilioRepository domicilioRepository) {
        this.domicilioRepository = domicilioRepository;
    }

    public UsuarioRepository getUsuarioRepository() {
        return usuarioRepository;
    }

    @Autowired
    public void setUsuarioRepository(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public DomicilioService getDomicilioService() {
        return domicilioService;
    }

    @Autowired
    public void setDomicilioService(DomicilioService domicilioService) {
        this.domicilioService = domicilioService;
    }



    public Usuario findById(Integer id) {
        UsuarioEntity result = this.usuarioRepository.findById(id).orElse(null);
        return result != null ? result.toDTO() : null;
    }

    public Usuario checkUser(String email, String password) {
        UsuarioEntity result = this.usuarioRepository.checkUser(email, password);
        return result != null ? result.toDTO() : null;
    }

    public void register(UsuarioRegister user) {
        DomicilioEntity domicile = new DomicilioEntity();
        domicile.setPais(user.getPais());
        domicile.setCiudad(user.getCiudad());
        domicile.setCodigoPostal(user.getCodigo_postal());
        domicile.setCalle(user.getCalle());
        domicile.setNumero(user.getNumero());
        domicile.setBloque(user.getBloque());
        domicile.setPiso(user.getPiso());
        domicile.setPuerta(user.getPuerta());

        this.domicilioRepository.save(domicile);

        UsuarioEntity usuario = new UsuarioEntity();
        usuario.setEmail(user.getEmail());
        usuario.setPassword(user.getPassword());
        usuario.setNombre(user.getNombre());
        usuario.setApellidos(user.getApellidos());
        usuario.setEdad(user.getEdad());
        usuario.setSexo(user.getSexo());
        usuario.setPermiso("user");
        usuario.setDomicilio(domicile);

        this.usuarioRepository.save(usuario);
    }

    protected List<Usuario> listEntityADTO(List<UsuarioEntity> lista) {
        if(lista != null) {
            List<Usuario> listaDTO = new ArrayList<>();
            for(UsuarioEntity usuario : lista) {
                listaDTO.add(usuario.toDTO());
            }
            return listaDTO;
        }
        else {
            return null;
        }
    }

    public List<Usuario> listarClientes(String filtroNombre) {
        List<UsuarioEntity> lista;
        if((filtroNombre != null && filtroNombre.length() > 0)) {
            lista = this.usuarioRepository.findByBusquedaNombre(filtroNombre);
        }
        else {
            lista = this.usuarioRepository.findAll();
        }
        return this.listEntityADTO(lista);
    }

    public Usuario buscarUsuario(Integer id)
    {
        //UsuarioEntity usuario = this.usuarioRepository.findByIdUsuario(id);
        UsuarioEntity usuario = this.usuarioRepository.findById(id).orElse(null);

        if(usuario != null)
        {
            return usuario.toDTO();
        }
        else
        {
            return null;
        }
    }

    public void borrarUsuario(Integer id)
    {
        UsuarioEntity usuario = this.usuarioRepository.findById(id).orElse(null);
        this.usuarioRepository.delete(usuario);
        this.domicilioService.borrarDomicilio(usuario.getDomicilio().getIdDomicilio());
    }

    public void guardarUsuario(UsuarioEditar dto)
    {
        UsuarioEntity usuario;

        usuario = new UsuarioEntity();

        usuario.setEmail(dto.getEmail());
        usuario.setPassword(dto.getPassword());
        usuario.setNombre(dto.getNombre());
        usuario.setApellidos(dto.getApellidos());
        usuario.setEdad(dto.getEdad());
        usuario.setSexo(dto.getSexo());
        usuario.setPermiso(dto.getPermiso());
        usuario.setIdUsuario(dto.getIdUsuario());

        DomicilioEntity domicilio = domicilioService.formarDomicilio(dto.getPais(),dto.getCiudad(),dto.getCalle(),dto.getNumero(),dto.getCodigoPostal(),dto.getBloque(),dto.getPiso(),dto.getPuerta(),dto.getIdDomicilio());

        usuario.setDomicilio(domicilio);
        this.domicilioRepository.save(domicilio);
        this.usuarioRepository.save(usuario);


    }

    public UsuarioEditar usuarioAEditar(Usuario usuario)
    {
        UsuarioEditar usuarioADevolver = new UsuarioEditar();

        usuarioADevolver.setEmail(usuario.getEmail());
        usuarioADevolver.setPassword(usuario.getPassword());
        usuarioADevolver.setNombre(usuario.getNombre());
        usuarioADevolver.setApellidos(usuario.getApellidos());
        usuarioADevolver.setEdad(usuario.getEdad());
        usuarioADevolver.setSexo(usuario.getSexo());
        usuarioADevolver.setPermiso(usuario.getPermiso());
        usuarioADevolver.setPais(usuario.getDomicilio().getPais());
        usuarioADevolver.setCiudad(usuario.getDomicilio().getCiudad());
        usuarioADevolver.setCodigoPostal(usuario.getDomicilio().getCodigoPostal());
        usuarioADevolver.setCalle(usuario.getDomicilio().getCalle());
        usuarioADevolver.setNumero(usuario.getDomicilio().getNumero());
        usuarioADevolver.setBloque(usuario.getDomicilio().getBloque());
        usuarioADevolver.setPiso(usuario.getDomicilio().getPiso());
        usuarioADevolver.setPuerta(usuario.getDomicilio().getPuerta());
        usuarioADevolver.setIdUsuario(usuario.getIdUsuario());

        return usuarioADevolver;
    }
}
