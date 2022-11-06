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
public class Cep extends Base {
    private String cep;
    private String state;
    private String city;
    private String neighborhood;
    private String street;
    private String service;
    private Location location;
}
