package br.com.sawcunha.brasilapiintegration.core.specification;

import br.com.sawcunha.brasilapiintegration.core.model.ddd.DirectDialDistance;
import lombok.NonNull;

public interface DirectDialDistanceService {

    DirectDialDistance findDirectDialDistanceByCodeV1(@NonNull final String code);

}
