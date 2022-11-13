package br.com.sawcunha.brasilapiintegration.core.feign.service;

import br.com.sawcunha.brasilapiintegration.core.feign.api.RegistroBRAPI;
import br.com.sawcunha.brasilapiintegration.core.model.registrobr.Registro;
import br.com.sawcunha.brasilapiintegration.core.specification.RegistroBRService;
import lombok.NonNull;

import java.util.Objects;

public class RegistroBRServiceBean extends ServiceBean<RegistroBRAPI> implements RegistroBRService {

    private static RegistroBRServiceBean registroBRServiceBean;

    public static RegistroBRServiceBean instance(@NonNull String uri){
        if(Objects.isNull(registroBRServiceBean)){
            registroBRServiceBean = new RegistroBRServiceBean(uri);
        }
        return registroBRServiceBean;
    }

    private RegistroBRServiceBean(@NonNull String uri) {
        super(uri, RegistroBRAPI.class);
    }

    @Override
    public Registro findRegistroByDomainV1(@NonNull String domain) {
        return brasilAPI.findRegistroByDomainV1(domain);
    }
}
