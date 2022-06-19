package es.uma.tebayboot.entity;

import es.uma.tebayboot.dto.Subasta;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
/*
    Álvaro J. Tapia Muñoz: 20%
 */
@Entity
@Table(name = "subasta")
public class SubastaEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_subasta")
    private Integer idSubasta;
    @Basic(optional = false)
    @Column(name = "valor_inicial")
    private double valorInicial;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "puja")
    private Double puja;
    @Basic(optional = false)
    @Column(name = "fecha_limite")
    @Temporal(TemporalType.DATE)
    private Date fechaLimite;
    @JoinTable(name = "subasta_favorito", joinColumns = {
            @JoinColumn(name = "subasta", referencedColumnName = "id_subasta")}, inverseJoinColumns = {
            @JoinColumn(name = "usuario", referencedColumnName = "id_usuario")})
    @ManyToMany
    private List<UsuarioEntity> usuarioList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "subasta")
    private List<PujaEntity> pujaList;
    @JoinColumn(name = "articulo", referencedColumnName = "id_articulo")
    @OneToOne(optional = false)
    private ArticuloEntity articulo;
    @JoinColumn(name = "vendedor", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false)
    private UsuarioEntity vendedor;

    public SubastaEntity() {
    }

    public SubastaEntity(Integer idSubasta) {
        this.idSubasta = idSubasta;
    }

    public SubastaEntity(Integer idSubasta, double valorInicial, Date fechaLimite) {
        this.idSubasta = idSubasta;
        this.valorInicial = valorInicial;
        this.fechaLimite = fechaLimite;
    }

    public Integer getIdSubasta() {
        return idSubasta;
    }

    public void setIdSubasta(Integer idSubasta) {
        this.idSubasta = idSubasta;
    }

    public double getValorInicial() {
        return valorInicial;
    }

    public void setValorInicial(double valorInicial) {
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

    public List<UsuarioEntity> getUsuarioList() {
        return usuarioList;
    }

    public void setUsuarioList(List<UsuarioEntity> usuarioList) {
        this.usuarioList = usuarioList;
    }

    public List<PujaEntity> getPujaList() {
        return pujaList;
    }

    public void setPujaList(List<PujaEntity> pujaList) {
        this.pujaList = pujaList;
    }

    public ArticuloEntity getArticulo() {
        return articulo;
    }

    public void setArticulo(ArticuloEntity articulo) {
        this.articulo = articulo;
    }

    public UsuarioEntity getVendedor() {
        return vendedor;
    }

    public void setVendedor(UsuarioEntity vendedor) {
        this.vendedor = vendedor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSubasta != null ? idSubasta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SubastaEntity)) {
            return false;
        }
        SubastaEntity other = (SubastaEntity) object;
        if ((this.idSubasta == null && other.idSubasta != null) || (this.idSubasta != null && !this.idSubasta.equals(other.idSubasta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.org.tebay.entity.Subasta[ idSubasta=" + idSubasta + " ]";
    }

    public Subasta toDTO() {
        Subasta dto = new Subasta();
        dto.setIdSubasta(this.idSubasta);
        dto.setArticulo(this.articulo.toDTO());
        dto.setFechaLimite(this.fechaLimite);
        dto.setPuja(this.puja);
        dto.setValorInicial(this.valorInicial);
        return dto;
    }
}
