package es.uma.tebayboot.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Articulo {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_articulo", nullable = false)
    private Integer idArticulo;
    @Basic
    @Column(name = "titulo", nullable = false, length = 50)
    private String titulo;
    @Basic
    @Column(name = "descripcion", nullable = true, length = 500)
    private String descripcion;
    @Basic
    @Column(name = "url_articulo", nullable = false, length = 200)
    private String urlArticulo;
    @ManyToOne
    @JoinColumn(name = "ganador", referencedColumnName = "id_usuario")
    private Usuario ganador;
    @OneToMany(mappedBy = "articulo")
    private Collection<Categoria> categorias;
    @OneToOne(mappedBy = "articulo")
    private Subasta subasta;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Articulo articulo = (Articulo) o;
        return Objects.equals(idArticulo, articulo.idArticulo) && Objects.equals(titulo, articulo.titulo) && Objects.equals(descripcion, articulo.descripcion) && Objects.equals(urlArticulo, articulo.urlArticulo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idArticulo, titulo, descripcion, urlArticulo);
    }

    public Usuario getGanador() {
        return ganador;
    }

    public void setGanador(Usuario ganador) {
        this.ganador = ganador;
    }

    public Collection<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(Collection<Categoria> categorias) {
        this.categorias = categorias;
    }

    public Subasta getSubasta() {
        return subasta;
    }

    public void setSubasta(Subasta subasta) {
        this.subasta = subasta;
    }
}
