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
 *  - Carlos Marín Corbera 50%
 *  - Carmen González Ortega 20%
 *  - Álvaro Jesús Tapia Muñoz 30%
 */
@Entity
@Table(name = "usuario")
public class UsuarioEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_usuario")
    private Integer idUsuario;
    @Basic(optional = false)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "apellidos")
    private String apellidos;
    @Basic(optional = false)
    @Column(name = "edad")
    private int edad;
    @Basic(optional = false)
    @Column(name = "sexo")
    private String sexo;
    @Basic(optional = false)
    @Column(name = "permiso")
    private String permiso;
    @ManyToMany(mappedBy = "usuarioList")
    private List<SubastaEntity> subastaList;
    @ManyToMany(mappedBy = "usuarioList")
    private List<CategoriaEntity> categoriaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuario")
    private List<PujaEntity> pujaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vendedor")
    private List<SubastaEntity> subastaList1;
    @JoinColumn(name = "domicilio", referencedColumnName = "id_domicilio")
    @ManyToOne(optional = false)
    private DomicilioEntity domicilio;
    @Basic(optional = false)
    @Column(name = "password")
    private String password;
    @OneToMany(mappedBy = "ganador")
    private List<ArticuloEntity> articuloList;

    public UsuarioEntity() {
    }

    public UsuarioEntity(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public UsuarioEntity(Integer idUsuario, String email, String nombre, String apellidos, int edad, String sexo, String permiso, String password) {
        this.idUsuario = idUsuario;
        this.email = email;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
        this.sexo = sexo;
        this.permiso = permiso;
        this.password = password;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getPermiso() {
        return permiso;
    }

    public void setPermiso(String permiso) {
        this.permiso = permiso;
    }

    public List<SubastaEntity> getSubastaList() {
        return subastaList;
    }

    public void setSubastaList(List<SubastaEntity> subastaList) {
        this.subastaList = subastaList;
    }

    public List<CategoriaEntity> getCategoriaList() {
        return categoriaList;
    }

    public void setCategoriaList(List<CategoriaEntity> categoriaList) {
        this.categoriaList = categoriaList;
    }

    public List<PujaEntity> getPujaList() {
        return pujaList;
    }

    public void setPujaList(List<PujaEntity> pujaList) {
        this.pujaList = pujaList;
    }

    public List<SubastaEntity> getSubastaList1() {
        return subastaList1;
    }

    public void setSubastaList1(List<SubastaEntity> subastaList1) {
        this.subastaList1 = subastaList1;
    }

    public DomicilioEntity getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(DomicilioEntity domicilio) {
        this.domicilio = domicilio;
    }

    public List<ArticuloEntity> getArticuloList() {
        return articuloList;
    }

    public void setArticuloList(List<ArticuloEntity> articuloList) {
        this.articuloList = articuloList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUsuario != null ? idUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsuarioEntity)) {
            return false;
        }
        UsuarioEntity other = (UsuarioEntity) object;
        if ((this.idUsuario == null && other.idUsuario != null) || (this.idUsuario != null && !this.idUsuario.equals(other.idUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.org.tebay.entity.Usuario[ idUsuario=" + idUsuario + " ]";
    }



}
