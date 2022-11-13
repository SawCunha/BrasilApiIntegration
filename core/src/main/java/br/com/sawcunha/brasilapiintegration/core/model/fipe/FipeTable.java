package br.com.sawcunha.brasilapiintegration.core.model.fipe;

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
public class FipeTable extends Base {

    @SerializedName("codigoFipe")
    private Integer code;
    @SerializedName("mes")
    private String month;

}

