/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.uma.tebayboot.entity;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author
 *  - Carlos Marín Corbera 90%
 *  - Carmen González Ortega 10%
 */
@Entity
@Table(name = "puja")
public class PujaEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_puja")
    private Integer idPuja;
    @Basic(optional = false)
    @Column(name = "valor")
    private double valor;
    @Basic(optional = false)
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @JoinColumn(name = "subasta", referencedColumnName = "id_subasta")
    @ManyToOne(optional = false)
    private SubastaEntity subasta;
    @JoinColumn(name = "usuario", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false)
    private UsuarioEntity usuario;

    public PujaEntity() {
    }

    public PujaEntity(Integer idPuja) {
        this.idPuja = idPuja;
    }

    public PujaEntity(Integer idPuja, double valor, Date fecha) {
        this.idPuja = idPuja;
        this.valor = valor;
        this.fecha = fecha;
    }

    public Integer getIdPuja() {
        return idPuja;
    }

    public void setIdPuja(Integer idPuja) {
        this.idPuja = idPuja;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public SubastaEntity getSubasta() {
        return subasta;
    }

    public void setSubasta(SubastaEntity subasta) {
        this.subasta = subasta;
    }

    public UsuarioEntity getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioEntity usuario) {
        this.usuario = usuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPuja != null ? idPuja.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PujaEntity)) {
            return false;
        }
        PujaEntity other = (PujaEntity) object;
        if ((this.idPuja == null && other.idPuja != null) || (this.idPuja != null && !this.idPuja.equals(other.idPuja))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tebay.entity.Puja[ idPuja=" + idPuja + " ]";
    }

}
