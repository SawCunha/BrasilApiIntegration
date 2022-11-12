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
public class Region extends Base {

    private Integer id;
    @SerializedName("regiao")
    private String acronym;
    @SerializedName("nome")
    private String name;

}
