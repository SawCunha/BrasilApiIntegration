package br.com.sawcunha.brasilapiintegration.core.specification;

import br.com.sawcunha.brasilapiintegration.core.enums.ProvidersIBGE;
import br.com.sawcunha.brasilapiintegration.core.model.ibge.IBGE;
import lombok.NonNull;

import java.util.Set;

public interface IBGEService {

    Set<IBGE> findAllMunicipalitiesByAcronymUFV1(@NonNull final String acronymUF, final ProvidersIBGE... providersIBGE);
    Set<IBGE> findAllIBGEV1();
    IBGE findAllIBGEByAcronymUFOrCodeV1(@NonNull final String code);

}
