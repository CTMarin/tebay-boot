package es.uma.tebayboot.dto.form;

import es.uma.tebayboot.dto.Categoria;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FilterAuction {
    boolean filter;
    List<Categoria> categoria_filter;
    Double min_init_value;
    Double max_init_value;
    String finish_string;
    Date finish_date;
}
