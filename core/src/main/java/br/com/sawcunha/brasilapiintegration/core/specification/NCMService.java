package br.com.sawcunha.brasilapiintegration.core.specification;

import br.com.sawcunha.brasilapiintegration.core.model.ncm.NCM;
import lombok.NonNull;

import java.util.Set;

public interface NCMService {

    Set<NCM> findAllNCM();
    Set<NCM> findAllNCMByCodeOrDescription(@NonNull final String value);
    NCM findNCMByCode(@NonNull final String code);

}
