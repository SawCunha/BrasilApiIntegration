package br.com.sawcunha.brasilapiintegration.core.feign.service;

import br.com.sawcunha.brasilapiintegration.core.feign.api.CepAPI;
import br.com.sawcunha.brasilapiintegration.core.feign.configuration.FeingConfiguration;
import br.com.sawcunha.brasilapiintegration.core.feign.configuration.decoder.BrasilAPIErrorDecoder;
import br.com.sawcunha.brasilapiintegration.core.model.cep.Cep;
import br.com.sawcunha.brasilapiintegration.core.specification.CepService;
import lombok.NonNull;

import java.util.Objects;

public class CepServiceBean implements CepService {

    private static CepServiceBean cepServiceBean;

    private final CepAPI cepAPI;

    public static CepServiceBean instance(@NonNull String uri){
        if(Objects.isNull(cepServiceBean))
            cepServiceBean = new CepServiceBean(uri);

        return cepServiceBean;
    }

    private CepServiceBean(@NonNull String uri) {
        this.cepAPI = FeingConfiguration.getInstance(CepAPI.class, uri, BrasilAPIErrorDecoder.getInstance());
    }

    @Override
    public Cep findCEPV1ByCEP(final String cep) {
        return cepAPI.findByCepV1(cep);
    }

    @Override
    public Cep findCEPV2ByCEP(final String cep) {
        return cepAPI.findByCepV2(cep);
    }
}
