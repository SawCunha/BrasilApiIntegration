package br.com.sawcunha.brasilapiintegration.core.model.ibge;

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
public class IBGE extends Base {

    @SerializedName("codigo_ibge")
    private String codeIBGE;
    @SerializedName("nome")
    private String name;
    @SerializedName("id")
    private Integer id;
    @SerializedName("sigla")
    private String acronym;
    @SerializedName("regiao")
    private Region region;

}
