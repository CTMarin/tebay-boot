package es.uma.tebayboot.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Usuario {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_usuario", nullable = false)
    private Integer idUsuario;
    @Basic
    @Column(name = "email", nullable = false, length = 100)
    private String email;
    @Basic
    @Column(name = "password", nullable = false, length = 100)
    private String password;
    @Basic
    @Column(name = "nombre", nullable = false, length = 25)
    private String nombre;
    @Basic
    @Column(name = "apellidos", nullable = false, length = 50)
    private String apellidos;
    @Basic
    @Column(name = "edad", nullable = false)
    private Integer edad;
    @Basic
    @Column(name = "sexo", nullable = false, length = 10)
    private String sexo;
    @Basic
    @Column(name = "permiso", nullable = false, length = 20)
    private String permiso;
    @OneToMany(mappedBy = "ganador")
    private Collection<Articulo> articulosGanados;
    @OneToMany(mappedBy = "usuario")
    private Collection<Categoria> categorias;
    @OneToMany(mappedBy = "usuario")
    private Collection<Puja> pujas;
    @OneToMany(mappedBy = "vendedor")
    private Collection<Subasta> subastasPublicadas;
    @OneToMany(mappedBy = "usuario")
    private Collection<Subasta> subastaFavoritas;
    @ManyToOne
    @JoinColumn(name = "domicilio", referencedColumnName = "id_domicilio", nullable = false)
    private Domicilio domicilio;

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

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(idUsuario, usuario.idUsuario) && Objects.equals(email, usuario.email) && Objects.equals(password, usuario.password) && Objects.equals(nombre, usuario.nombre) && Objects.equals(apellidos, usuario.apellidos) && Objects.equals(edad, usuario.edad) && Objects.equals(sexo, usuario.sexo) && Objects.equals(permiso, usuario.permiso);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUsuario, email, password, nombre, apellidos, edad, sexo, permiso);
    }

    public Collection<Articulo> getArticulosGanados() {
        return articulosGanados;
    }

    public void setArticulosGanados(Collection<Articulo> articulosGanados) {
        this.articulosGanados = articulosGanados;
    }

    public Collection<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(Collection<Categoria> categorias) {
        this.categorias = categorias;
    }

    public Collection<Puja> getPujas() {
        return pujas;
    }

    public void setPujas(Collection<Puja> pujas) {
        this.pujas = pujas;
    }

    public Collection<Subasta> getSubastasPublicadas() {
        return subastasPublicadas;
    }

    public void setSubastasPublicadas(Collection<Subasta> subastasPublicadas) {
        this.subastasPublicadas = subastasPublicadas;
    }

    public Collection<Subasta> getSubastaFavoritas() {
        return subastaFavoritas;
    }

    public void setSubastaFavoritas(Collection<Subasta> subastaFavoritas) {
        this.subastaFavoritas = subastaFavoritas;
    }

    public Domicilio getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(Domicilio domicilio) {
        this.domicilio = domicilio;
    }
}
