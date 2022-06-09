/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.uma.tebayboot.entity;


import es.uma.tebayboot.dto.Categoria;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * author:
 *  - Carlos Marín Corbera 90%
 *  - Carmen González Ortega 10%
 */
@Entity
@Table(name = "categoria")
public class CategoriaEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_categoria")
    private Integer idCategoria;
    @Basic(optional = false)
    @Column(name = "titulo")
    private String titulo;
    @ManyToMany(mappedBy = "categoriaList")
    private List<ArticuloEntity> articuloList;
    @JoinTable(name = "categoria_usuario", joinColumns = {
            @JoinColumn(name = "categoria", referencedColumnName = "id_categoria")}, inverseJoinColumns = {
            @JoinColumn(name = "usuario", referencedColumnName = "id_usuario")})
    @ManyToMany
    private List<UsuarioEntity> usuarioList;

    public CategoriaEntity() {
    }

    public CategoriaEntity(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public CategoriaEntity(Integer idCategoria, String titulo) {
        this.idCategoria = idCategoria;
        this.titulo = titulo;
    }

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public List<ArticuloEntity> getArticuloList() {
        return articuloList;
    }

    public void setArticuloList(List<ArticuloEntity> articuloList) {
        this.articuloList = articuloList;
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
        hash += (idCategoria != null ? idCategoria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof CategoriaEntity)) {
            return false;
        }
        CategoriaEntity other = (CategoriaEntity) object;
        if ((this.idCategoria == null && other.idCategoria != null) || (this.idCategoria != null && !this.idCategoria.equals(other.idCategoria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.org.tebay.entity.Categoria[ idCategoria=" + idCategoria + " ]";
    }

    public Categoria toDTO(){
        Categoria dto = new Categoria();
        dto.setTitulo(this.titulo);
        return dto;
    }
}
