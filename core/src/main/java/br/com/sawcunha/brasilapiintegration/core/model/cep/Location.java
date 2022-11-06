package br.com.sawcunha.brasilapiintegration.core.model.cep;

import br.com.sawcunha.brasilapiintegration.core.model.Base;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Location extends Base {

    private String point;
    private Coordinates coordinates;

}
