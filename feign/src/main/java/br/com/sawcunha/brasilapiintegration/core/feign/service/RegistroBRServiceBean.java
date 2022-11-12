package br.com.sawcunha.brasilapiintegration.core.feign.service;

import br.com.sawcunha.brasilapiintegration.core.feign.api.RegistroBRAPI;
import br.com.sawcunha.brasilapiintegration.core.feign.configuration.FeingConfiguration;
import br.com.sawcunha.brasilapiintegration.core.feign.configuration.decoder.BrasilAPIErrorDecoder;
import br.com.sawcunha.brasilapiintegration.core.model.registrobr.Registro;
import br.com.sawcunha.brasilapiintegration.core.specification.RegistroBRService;
import lombok.NonNull;

import java.util.Objects;

public class RegistroBRServiceBean implements RegistroBRService {

    private static RegistroBRServiceBean registroBRServiceBean;
    private final RegistroBRAPI registroBRAPI;

    public static RegistroBRServiceBean instance(@NonNull String uri){
        if(Objects.isNull(registroBRServiceBean)){
            registroBRServiceBean = new RegistroBRServiceBean(uri);
        }
        return registroBRServiceBean;
    }

    private RegistroBRServiceBean(@NonNull String uri) {
        this.registroBRAPI = FeingConfiguration.getInstance(RegistroBRAPI.class, uri, BrasilAPIErrorDecoder.getInstance());
    }

    @Override
    public Registro findRegistroByDomain(@NonNull String domain) {
        return registroBRAPI.findRegistroByDomain(domain);
    }
}
