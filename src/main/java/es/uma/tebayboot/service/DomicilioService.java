package es.uma.tebayboot.service;

import es.uma.tebayboot.dao.DomicilioRepository;
import es.uma.tebayboot.dto.Domicilio;
import es.uma.tebayboot.dto.Usuario;
import es.uma.tebayboot.dto.form.UsuarioRegister;
import es.uma.tebayboot.entity.DomicilioEntity;
import es.uma.tebayboot.entity.UsuarioEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/*
    Álvaro J. Tapia Muñoz: 80%
 */
@Service
public class DomicilioService {
    DomicilioRepository domicilioRepository;

    public DomicilioRepository getDomicilioRepository() {
        return domicilioRepository;
    }

    @Autowired
    public void setDomicilioRepository(DomicilioRepository domicilioRepository) {
        this.domicilioRepository = domicilioRepository;
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
    }

    public Domicilio buscarDomicilio(Integer id)
    {
        DomicilioEntity domicilio = this.domicilioRepository.findDomicilioEntityByIdDomicilio(id);

        return domicilio.toDTO();


    }


    public void borrarDomicilio(Integer id)
    {
        DomicilioEntity domicilio = this.domicilioRepository.findById(id).orElse(null);
        this.domicilioRepository.delete(domicilio);
    }

    public DomicilioEntity formarDomicilio(String pais, String ciudad, String calle, Integer numero, Integer codigo_postal, String bloque, String piso, String puerta, Integer id)
    {
        DomicilioEntity domicilio = new DomicilioEntity();
        domicilio.setPais(pais);
        domicilio.setCiudad(ciudad);
        domicilio.setCalle(calle);
        domicilio.setNumero(numero);
        domicilio.setCodigoPostal(codigo_postal);
        domicilio.setBloque(bloque);
        domicilio.setPiso(piso);
        domicilio.setPuerta(puerta);
        domicilio.setIdDomicilio(id);

        domicilioRepository.save(domicilio);

        return domicilio;
    }
}
