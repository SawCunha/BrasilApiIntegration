package br.com.sawcunha.brasilapiintegration.core.feign.service;

import br.com.sawcunha.brasilapiintegration.core.feign.api.CepAPI;
import br.com.sawcunha.brasilapiintegration.core.feign.configuration.FeingConfiguration;
import br.com.sawcunha.brasilapiintegration.core.feign.configuration.decoder.BrasilAPIErrorDecoder;
import br.com.sawcunha.brasilapiintegration.core.model.cep.Cep;
import br.com.sawcunha.brasilapiintegration.core.specification.CepService;

import java.util.Objects;

public class CepServiceBean implements CepService {

    private static CepAPI cepAPI;
    private static final String URI = "https://brasilapi.com.br/api";

    private static CepAPI instance(){
        if(Objects.isNull(cepAPI))
            cepAPI = FeingConfiguration.getInstance(CepAPI.class, URI, BrasilAPIErrorDecoder.getInstance());

        return cepAPI;
    }

    @Override
    public Cep findCEPV1ByCEP(final String cep) {
        return instance().findByCepV1(cep);
    }

    @Override
    public Cep findCEPV2ByCEP(final String cep) {
        return instance().findByCepV2(cep);
    }
}
