package es.uma.tebayboot.dto.form;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.List;
/**
 * author: Carlos Marín Corbera 100%
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PublishAuction {
    String titulo;
    String descripcion;
    String url_imagen;
    List<String> categorias;
    Double valor_inicial;
    Date fecha_limite;
}
