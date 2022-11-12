package br.com.sawcunha.brasilapiintegration.core.feign.service;

import br.com.sawcunha.brasilapiintegration.core.feign.api.CNPJAPI;
import br.com.sawcunha.brasilapiintegration.core.feign.configuration.FeingConfiguration;
import br.com.sawcunha.brasilapiintegration.core.feign.configuration.decoder.BrasilAPIErrorDecoder;
import br.com.sawcunha.brasilapiintegration.core.model.cnpj.JuridicalPerson;
import br.com.sawcunha.brasilapiintegration.core.specification.JuridicalPersonService;
import lombok.NonNull;

import java.util.Objects;

public class JuridicalPersonServiceBean implements JuridicalPersonService {

    private static JuridicalPersonServiceBean juridicalPersonServiceBean;

    private final CNPJAPI CNPJAPI;

    public static JuridicalPersonServiceBean instance(@NonNull final String uri){
        if(Objects.isNull(juridicalPersonServiceBean))
            juridicalPersonServiceBean = new JuridicalPersonServiceBean(uri);

        return juridicalPersonServiceBean;
    }

    private JuridicalPersonServiceBean(@NonNull final String uri) {
        this.CNPJAPI = FeingConfiguration.getInstance(CNPJAPI.class, uri, BrasilAPIErrorDecoder.getInstance());
    }

    @Override
    public JuridicalPerson findCnpjByCnpj(final String cnpj) {
        return CNPJAPI.findByCnpjV1(cnpj);
    }
}
