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
public class Qsa extends Base {
    private Integer identificador_de_socio;
    private String nome_socio;
    private String cnpj_cpf_do_socio;
    private Integer codigo_qualificacao_socio;
    private Double percentual_capital_social;
    private String data_entrada_sociedade;
    private String cpf_representante_legal;
    private String nome_representante_legal;
    private String codigo_qualificacao_representante_legal;
}
