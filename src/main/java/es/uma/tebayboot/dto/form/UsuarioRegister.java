package es.uma.tebayboot.dto.form;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * author: Carlos Marín Corbera 100%
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UsuarioRegister {
    String email;
    String password;
    String rep_password;
    String nombre;
    String apellidos;
    int edad;
    String sexo;
    String pais;
    String ciudad;
    int codigo_postal;
    String calle;
    int numero;
    String bloque;
    String piso;
    String puerta;
}
