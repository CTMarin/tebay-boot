/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.uma.tebayboot.entity;


import es.uma.tebayboot.dto.Domicilio;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.StringJoiner;

/**
 * author:
 *  - Carmen González Ortega 33%
 *  - Carlos Marín Corbera 33%
 *  - Álvaro Jesús Tapia Muñoz 33%
 */
@Entity
@Table(name = "domicilio")
public class DomicilioEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_domicilio")
    private Integer idDomicilio;
    @Basic(optional = false)
    @Column(name = "pais")
    private String pais;
    @Basic(optional = false)
    @Column(name = "ciudad")
    private String ciudad;
    @Basic(optional = false)
    @Column(name = "calle")
    private String calle;
    @Basic(optional = false)
    @Column(name = "numero")
    private int numero;
    @Basic(optional = false)
    @Column(name = "codigo_postal")
    private int codigoPostal;
    @Column(name = "bloque", nullable = true)
    private String bloque;
    @Column(name = "piso", nullable = true)
    private String piso;
    @Column(name = "puerta", nullable = true)
    private String puerta;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "domicilio")
    private List<UsuarioEntity> usuarioList;

    public DomicilioEntity() {
    }

    public DomicilioEntity(Integer idDomicilio) {
        this.idDomicilio = idDomicilio;
    }

    public DomicilioEntity(Integer idDomicilio, String pais, String ciudad, String calle, int numero, int codigoPostal) {
        this.idDomicilio = idDomicilio;
        this.pais = pais;
        this.ciudad = ciudad;
        this.calle = calle;
        this.numero = numero;
        this.codigoPostal = codigoPostal;
    }

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

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(int codigoPostal) {
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

    public List<UsuarioEntity> getUsuarioList() {
        return usuarioList;
    }

    public void setUsuarioList(List<UsuarioEntity> usuarioList) {
        this.usuarioList = usuarioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDomicilio != null ? idDomicilio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DomicilioEntity)) {
            return false;
        }
        DomicilioEntity other = (DomicilioEntity) object;
        if ((this.idDomicilio == null && other.idDomicilio != null) || (this.idDomicilio != null && !this.idDomicilio.equals(other.idDomicilio))) {
            return false;
        }
        return true;
    }

    public Domicilio toDTO()
    {
        Domicilio dto = new Domicilio();

        dto.setPais(this.pais);
        dto.setCiudad(this.ciudad);
        dto.setCalle(calle);
        dto.setNumero(numero);
        dto.setCodigoPostal(codigoPostal);

        return dto;
    }

    @Override
    public String toString() {
        //calle, numero, piso, bloque, puerta, ciudad, pais, codigo postal
        StringJoiner s = new StringJoiner(", ");
        s.add("Calle " + getCalle());
        s.add("Nº " + Integer.toString(getNumero()));

        if(getPiso()!= null && !getPiso().isEmpty())
        {
            s.add("piso " + getPiso());
        }

        if(getBloque()!= null && !getBloque().isEmpty())
        {
            s.add("bloque " + getBloque());
        }
        if(getPuerta()!= null && !getPuerta().isEmpty())
        {
            s.add("puerta " + getPuerta());
        }

        s.add(getCiudad());
        s.add(getPais());
        s.add(Integer.toString(getCodigoPostal()));

        return s.toString();
    }
}
