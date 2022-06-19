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
public class KeyValueDTO<K> {
    String label;
    K value;
}
