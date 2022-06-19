package es.uma.tebayboot.dto.form;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SubastaEdit {
    String titulo;
    String descripcion;
    String url_imagen;
    Double valor_inicial;
    Date fecha_limite;
    Integer idSubasta;
}

