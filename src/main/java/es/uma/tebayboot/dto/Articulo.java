package es.uma.tebayboot.dto;

import java.util.List;

public class Articulo {

    private Integer idArticulo;
    private String titulo;
    private List<Categoria> categoriaList;
    private Usuario ganador;
    private String descripcion;
    private String urlArticulo;

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

    public List<Categoria> getCategoriaList() {
        return categoriaList;
    }

    public void setCategoriaList(List<Categoria> categoriaList) {
        this.categoriaList = categoriaList;
    }

    public Usuario getGanador() {
        return ganador;
    }

    public void setGanador(Usuario ganador) {
        this.ganador = ganador;
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
}
