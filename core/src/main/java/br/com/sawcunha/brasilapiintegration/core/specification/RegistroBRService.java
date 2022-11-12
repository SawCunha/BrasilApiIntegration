package br.com.sawcunha.brasilapiintegration.core.specification;

import br.com.sawcunha.brasilapiintegration.core.model.registrobr.Registro;
import lombok.NonNull;

public interface RegistroBRService {

    Registro findRegistroByDomain(@NonNull final String domain);

}
