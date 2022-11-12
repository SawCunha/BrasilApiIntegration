package br.com.sawcunha.brasilapiintegration.core.model.rate;

import br.com.sawcunha.brasilapiintegration.core.model.Base;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Rate extends Base {

    @SerializedName("nome")
    private String name;
    @SerializedName("valor")
    private BigDecimal value;

}
