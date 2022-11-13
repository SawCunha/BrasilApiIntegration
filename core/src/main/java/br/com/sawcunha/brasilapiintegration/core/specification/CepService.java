package br.com.sawcunha.brasilapiintegration.core.specification;

import br.com.sawcunha.brasilapiintegration.core.model.cep.Cep;

public interface CepService {

    Cep findCEPByCEPV1(final String cep);
    Cep findCEPByCEPV2(final String cep);

}
