package br.com.sawcunha.brasilapiintegration.core.model.registrobr;

import br.com.sawcunha.brasilapiintegration.core.model.Base;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Registro extends Base {

    @SerializedName("status_code")
    private Integer statusCode;
    private String status;
    private String fqdn;
    private String fqdnace;
    private Boolean exempt;
    @SerializedName("publication-status")
    private String publicationStatus;
    @SerializedName("expires-at")
    private String expiresAT;

    private Set<String> hosts;
    private Set<String> suggestions;
}
