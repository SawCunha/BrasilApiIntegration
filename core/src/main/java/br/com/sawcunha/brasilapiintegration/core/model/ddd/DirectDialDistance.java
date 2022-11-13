package br.com.sawcunha.brasilapiintegration.core.model.ddd;

import br.com.sawcunha.brasilapiintegration.core.model.Base;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DirectDialDistance extends Base {

    private String state;
    private Set<String> cities;

}
