package br.com.sawcunha.brasilapiintegration.core.feign.service;

import br.com.sawcunha.brasilapiintegration.core.feign.api.CnpjAPI;
import br.com.sawcunha.brasilapiintegration.core.feign.configuration.FeingConfiguration;
import br.com.sawcunha.brasilapiintegration.core.feign.configuration.decoder.BrasilAPIErrorDecoder;
import br.com.sawcunha.brasilapiintegration.core.model.cnpj.Cnpj;
import br.com.sawcunha.brasilapiintegration.core.specification.CnpjService;

import java.util.Objects;

public class CnpjServiceBean implements CnpjService {

    private static CnpjAPI cnpjAPI;
    private static final String URI = "https://brasilapi.com.br/api";

    private static CnpjAPI instance(){
        if(Objects.isNull(cnpjAPI))
            cnpjAPI = FeingConfiguration.getInstance(CnpjAPI.class, URI, BrasilAPIErrorDecoder.getInstance());

        return cnpjAPI;
    }


    @Override
    public Cnpj findCnpjByCnpj(final String cnpj) {
        return instance().findByCnpjV1(cnpj);
    }
}
