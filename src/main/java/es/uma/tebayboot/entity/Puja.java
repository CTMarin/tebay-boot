package es.uma.tebayboot.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
public class Puja {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_puja", nullable = false)
    private Integer idPuja;
    @Basic
    @Column(name = "valor", nullable = false, precision = 0)
    private Double valor;
    @Basic
    @Column(name = "fecha", nullable = false)
    private Date fecha;
    @ManyToOne
    @JoinColumn(name = "usuario", referencedColumnName = "id_usuario", nullable = false)
    private Usuario usuario;
    @ManyToOne
    @JoinColumn(name = "subasta", referencedColumnName = "id_subasta", nullable = false)
    private Subasta subasta;

    public Integer getIdPuja() {
        return idPuja;
    }

    public void setIdPuja(Integer idPuja) {
        this.idPuja = idPuja;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Puja puja = (Puja) o;
        return Objects.equals(idPuja, puja.idPuja) && Objects.equals(valor, puja.valor) && Objects.equals(fecha, puja.fecha);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPuja, valor, fecha);
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Subasta getSubasta() {
        return subasta;
    }

    public void setSubasta(Subasta subasta) {
        this.subasta = subasta;
    }
}
