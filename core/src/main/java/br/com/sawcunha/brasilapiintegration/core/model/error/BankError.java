package br.com.sawcunha.brasilapiintegration.core.model.error;

import br.com.sawcunha.brasilapiintegration.core.model.Base;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BankError extends Base {

    private String message;
    private String type;

}
