package es.uma.tebayboot.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Subasta {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_subasta", nullable = false)
    private Integer idSubasta;
    @Basic
    @Column(name = "valor_inicial", nullable = false, precision = 0)
    private Double valorInicial;
    @Basic
    @Column(name = "puja", nullable = true, precision = 0)
    private Double puja;
    @Basic
    @Column(name = "fecha_limite", nullable = false)
    private Date fechaLimite;
    @OneToMany(mappedBy = "subasta")
    private Collection<Puja> pujas;
    @OneToOne
    @JoinColumn(name = "articulo", referencedColumnName = "id_articulo", nullable = false)
    private Articulo articulo;
    @ManyToOne
    @JoinColumn(name = "vendedor", referencedColumnName = "id_usuario", nullable = false)
    private Usuario vendedor;
    @OneToMany(mappedBy = "subasta")
    private Collection<Usuario> usuariosFavorito;

    public Integer getIdSubasta() {
        return idSubasta;
    }

    public void setIdSubasta(Integer idSubasta) {
        this.idSubasta = idSubasta;
    }

    public Double getValorInicial() {
        return valorInicial;
    }

    public void setValorInicial(Double valorInicial) {
        this.valorInicial = valorInicial;
    }

    public Double getPuja() {
        return puja;
    }

    public void setPuja(Double puja) {
        this.puja = puja;
    }

    public Date getFechaLimite() {
        return fechaLimite;
    }

    public void setFechaLimite(Date fechaLimite) {
        this.fechaLimite = fechaLimite;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subasta subasta = (Subasta) o;
        return Objects.equals(idSubasta, subasta.idSubasta) && Objects.equals(valorInicial, subasta.valorInicial) && Objects.equals(puja, subasta.puja) && Objects.equals(fechaLimite, subasta.fechaLimite);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idSubasta, valorInicial, puja, fechaLimite);
    }

    public Collection<Puja> getPujas() {
        return pujas;
    }

    public void setPujas(Collection<Puja> pujas) {
        this.pujas = pujas;
    }

    public Articulo getArticulo() {
        return articulo;
    }

    public void setArticulo(Articulo articulo) {
        this.articulo = articulo;
    }

    public Usuario getVendedor() {
        return vendedor;
    }

    public void setVendedor(Usuario vendedor) {
        this.vendedor = vendedor;
    }

    public Collection<Usuario> getUsuariosFavorito() {
        return usuariosFavorito;
    }

    public void setUsuariosFavorito(Collection<Usuario> usuariosFavorito) {
        this.usuariosFavorito = usuariosFavorito;
    }
}
