package es.uma.tebayboot.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Domicilio {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_domicilio", nullable = false)
    private Integer idDomicilio;
    @Basic
    @Column(name = "pais", nullable = false, length = 50)
    private String pais;
    @Basic
    @Column(name = "ciudad", nullable = false, length = 50)
    private String ciudad;
    @Basic
    @Column(name = "calle", nullable = false, length = 100)
    private String calle;
    @Basic
    @Column(name = "numero", nullable = false)
    private Integer numero;
    @Basic
    @Column(name = "codigo_postal", nullable = false)
    private Integer codigoPostal;
    @Basic
    @Column(name = "bloque", nullable = true, length = 50)
    private String bloque;
    @Basic
    @Column(name = "piso", nullable = true, length = 5)
    private String piso;
    @Basic
    @Column(name = "puerta", nullable = true, length = 10)
    private String puerta;
    @OneToMany(mappedBy = "domicilio")
    private Collection<Usuario> usuarios;

    public Integer getIdDomicilio() {
        return idDomicilio;
    }

    public void setIdDomicilio(Integer idDomicilio) {
        this.idDomicilio = idDomicilio;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Integer getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(Integer codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getBloque() {
        return bloque;
    }

    public void setBloque(String bloque) {
        this.bloque = bloque;
    }

    public String getPiso() {
        return piso;
    }

    public void setPiso(String piso) {
        this.piso = piso;
    }

    public String getPuerta() {
        return puerta;
    }

    public void setPuerta(String puerta) {
        this.puerta = puerta;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Domicilio domicilio = (Domicilio) o;
        return Objects.equals(idDomicilio, domicilio.idDomicilio) && Objects.equals(pais, domicilio.pais) && Objects.equals(ciudad, domicilio.ciudad) && Objects.equals(calle, domicilio.calle) && Objects.equals(numero, domicilio.numero) && Objects.equals(codigoPostal, domicilio.codigoPostal) && Objects.equals(bloque, domicilio.bloque) && Objects.equals(piso, domicilio.piso) && Objects.equals(puerta, domicilio.puerta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idDomicilio, pais, ciudad, calle, numero, codigoPostal, bloque, piso, puerta);
    }

    public Collection<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Collection<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
}
