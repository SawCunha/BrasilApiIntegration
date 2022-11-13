package br.com.sawcunha.brasilapiintegration.core.model.ncm;

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
public class NCM extends Base {

    @SerializedName("codigo")
    private String code;
    @SerializedName("descricao")
    private String description;
    @SerializedName("data_inicio")
    private String startDate;
    @SerializedName("data_fim")
    private String endDate;
    @SerializedName("tipo_ato")
    private String actType;
    @SerializedName("numero_ato")
    private String actNumber;
    @SerializedName("ano_ato")
    private String actYear;

}
