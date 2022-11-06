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
public class Coordinates extends Base {

    private String longitude;
    private String latitude;

}
