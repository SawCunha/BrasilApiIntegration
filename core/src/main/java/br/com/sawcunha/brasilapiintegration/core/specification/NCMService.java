package br.com.sawcunha.brasilapiintegration.core.specification;

import br.com.sawcunha.brasilapiintegration.core.model.ncm.NCM;
import lombok.NonNull;

import java.util.Set;

public interface NCMService {

    Set<NCM> findAllNCMV1();
    Set<NCM> findAllNCMByCodeOrDescriptionV1(@NonNull final String value);
    NCM findNCMByCodeV1(@NonNull final String code);

}
