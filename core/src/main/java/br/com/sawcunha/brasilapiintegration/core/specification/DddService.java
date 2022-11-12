package br.com.sawcunha.brasilapiintegration.core.specification;

import br.com.sawcunha.brasilapiintegration.core.model.ddd.DirectDialDistance;
import lombok.NonNull;

public interface DddService {

    DirectDialDistance findDirectDialDistanceByCode(@NonNull final String code);

}
