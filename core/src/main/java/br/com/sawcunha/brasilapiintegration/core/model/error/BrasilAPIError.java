package br.com.sawcunha.brasilapiintegration.core.model.error;

import br.com.sawcunha.brasilapiintegration.core.model.Base;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BrasilAPIError extends Base {

    private String message;
    private String type;
    private String name;
    private List<ServiceError> errors;
}
