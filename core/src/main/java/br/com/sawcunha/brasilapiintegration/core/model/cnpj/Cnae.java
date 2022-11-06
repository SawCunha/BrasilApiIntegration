package br.com.sawcunha.brasilapiintegration.core.model.cnpj;

import br.com.sawcunha.brasilapiintegration.core.model.Base;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Cnae extends Base {
    private Long codigo;
    private String descricao;
}
