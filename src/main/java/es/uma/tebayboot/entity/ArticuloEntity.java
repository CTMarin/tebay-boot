/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.uma.tebayboot.entity;


import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * author:
 *  - Carlos Marín Corbera 80%
 *  - Carmen González Ortega 20%
 */
@Entity
@Table(name = "articulo")
public class ArticuloEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_articulo")
    private Integer idArticulo;
    @Basic(optional = false)
    @Column(name = "titulo")
    private String titulo;
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @Column(name = "url_articulo")
    private String urlArticulo;
    @Basic(optional = false)
    @Column(name = "subasta")
    private int subasta1;
    @JoinTable(name = "articulo_categoria", joinColumns = {
            @JoinColumn(name = "id_articulo", referencedColumnName = "id_articulo")}, inverseJoinColumns = {
            @JoinColumn(name = "id_categoria", referencedColumnName = "id_categoria")})
    @ManyToMany
    private List<CategoriaEntity> categoriaList;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "articulo")
    private SubastaEntity subasta;
    @JoinColumn(name = "ganador", referencedColumnName = "id_usuario")
    @ManyToOne
    private UsuarioEntity ganador;

    public ArticuloEntity() {
    }

    public ArticuloEntity(Integer idArticulo) {
        this.idArticulo = idArticulo;
    }

    public ArticuloEntity(Integer idArticulo, String titulo, String urlArticulo, int subasta1) {
        this.idArticulo = idArticulo;
        this.titulo = titulo;
        this.urlArticulo = urlArticulo;
        this.subasta1 = subasta1;
    }

    public Integer getIdArticulo() {
        return idArticulo;
    }

    public void setIdArticulo(Integer idArticulo) {
        this.idArticulo = idArticulo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUrlArticulo() {
        return urlArticulo;
    }

    public void setUrlArticulo(String urlArticulo) {
        this.urlArticulo = urlArticulo;
    }

    public int getSubasta1() {
        return subasta1;
    }

    public void setSubasta1(int subasta1) {
        this.subasta1 = subasta1;
    }

    public List<CategoriaEntity> getCategoriaList() {
        return categoriaList;
    }

    public void setCategoriaList(List<CategoriaEntity> categoriaList) {
        this.categoriaList = categoriaList;
    }

    public SubastaEntity getSubasta() {
        return subasta;
    }

    public void setSubasta(SubastaEntity subasta) {
        this.subasta = subasta;
    }

    public UsuarioEntity getGanador() {
        return ganador;
    }

    public void setGanador(UsuarioEntity ganador) {
        this.ganador = ganador;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idArticulo != null ? idArticulo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ArticuloEntity)) {
            return false;
        }
        ArticuloEntity other = (ArticuloEntity) object;
        if ((this.idArticulo == null && other.idArticulo != null) || (this.idArticulo != null && !this.idArticulo.equals(other.idArticulo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.org.tebay.entity.Articulo[ idArticulo=" + idArticulo + " ]";
    }

}
