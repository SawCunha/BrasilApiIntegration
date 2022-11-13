package br.com.sawcunha.brasilapiintegration.core.specification;

import br.com.sawcunha.brasilapiintegration.core.model.registrobr.Registro;
import lombok.NonNull;

public interface RegistroBRService {

    Registro findRegistroByDomainV1(@NonNull final String domain);

}
