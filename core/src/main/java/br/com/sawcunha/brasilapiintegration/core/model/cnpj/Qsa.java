package br.com.sawcunha.brasilapiintegration.core.model.cnpj;

import br.com.sawcunha.brasilapiintegration.core.model.Base;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Qsa extends Base {
    @SerializedName("identificador_de_socio")
    private Integer memberIdentifier;
    @SerializedName("nome_socio")
    private String partnerName;
    @SerializedName("cnpj_cpf_do_socio")
    private String partnerTaxIdentifier;
    @SerializedName("codigo_qualificacao_socio")
    private Integer partnerQualificationCode;
    @SerializedName("percentual_capital_social")
    private Double shareCapitalPercentage;
    @SerializedName("data_entrada_sociedade")
    private String companyEntryDate;
    @SerializedName("cpf_representante_legal")
    private String taxIdentifierLegalRepresentative;
    @SerializedName("nome_representante_legal")
    private String legalRepresentativeName;
    @SerializedName("codigo_qualificacao_representante_legal")
    private String representativeLegalQualificationCode;
}
