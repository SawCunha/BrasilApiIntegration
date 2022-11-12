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
public class Fipe extends Base {

    @SerializedName("codigoFipe")
    private String code;
    @SerializedName("nome")
    private String name;
    @SerializedName("valor")
    private String value;
    @SerializedName("marca")
    private String brand;
    @SerializedName("modelo")
    private String model;
    @SerializedName("anoModelo")
    private Integer modelYear;
    @SerializedName("combustivel")
    private String fuel;
    @SerializedName("siglaCombustivel")
    private String acronymFuel;
    @SerializedName("mesReferencia")
    private String monthReference;
    @SerializedName("tipoVeiculo")
    private Integer vehicleType;
    @SerializedName("dataConsulta")
    private String consultationDate;
}
