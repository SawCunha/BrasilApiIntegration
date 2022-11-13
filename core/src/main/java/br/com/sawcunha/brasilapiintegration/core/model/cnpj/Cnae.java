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
public class Cnae extends Base {
    @SerializedName("codigo")
    private Long code;
    @SerializedName("descricao")
    private String description;
}
