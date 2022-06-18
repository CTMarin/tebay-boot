package es.uma.tebayboot.dto.form;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UsuarioEditar
{
    private String email;
    private String password;
    private String nombre;
    private String apellidos;
    private Integer edad;
    private String sexo;
    private String permiso;
    private Integer idUsuario;

    private String pais;
    private String ciudad;
    private Integer codigoPostal;
    private String calle;
    private Integer numero;
    private String bloque;
    private String piso;
    private String puerta;
}
