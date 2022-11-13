package br.com.sawcunha.brasilapiintegration.core.model.isbn;

import br.com.sawcunha.brasilapiintegration.core.model.Base;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Dimension extends Base {

    private Double width;
    private Double height;
    private String unit;

}
