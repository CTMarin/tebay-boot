package es.uma.tebayboot.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Categoria {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_categoria", nullable = false)
    private Integer idCategoria;
    @Basic
    @Column(name = "titulo", nullable = false, length = 50)
    private String titulo;
    @OneToMany(mappedBy = "categoria")
    private Collection<Articulo> articulos;
    @OneToMany(mappedBy = "categoria")
    private Collection<Usuario> usuarios;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Categoria categoria = (Categoria) o;
        return Objects.equals(idCategoria, categoria.idCategoria) && Objects.equals(titulo, categoria.titulo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCategoria, titulo);
    }

    public Collection<Articulo> getArticulos() {
        return articulos;
    }

    public void setArticulos(Collection<Articulo> articulos) {
        this.articulos = articulos;
    }

    public Collection<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Collection<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
}
