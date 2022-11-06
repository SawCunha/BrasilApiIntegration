package br.com.sawcunha.brasilapiintegration.core.specification;

import br.com.sawcunha.brasilapiintegration.core.model.cep.Cep;

public interface CepService {

    Cep findCEPV1ByCEP(final String cep);
    Cep findCEPV2ByCEP(final String cep);

}
