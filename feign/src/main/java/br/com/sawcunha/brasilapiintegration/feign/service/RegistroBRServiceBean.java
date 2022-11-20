package br.com.sawcunha.brasilapiintegration.feign.service;

import br.com.sawcunha.brasilapiintegration.feign.api.RegistroBRAPI;
import br.com.sawcunha.brasilapiintegration.feign.specification.BrasilAPIFeign;
import br.com.sawcunha.brasilapiintegration.core.model.registrobr.Registro;
import br.com.sawcunha.brasilapiintegration.core.specification.RegistroBRService;
import lombok.NonNull;

public class RegistroBRServiceBean extends ServiceBean<RegistroBRAPI> implements RegistroBRService {

    public RegistroBRServiceBean(@NonNull BrasilAPIFeign brasilAPIFeign, @NonNull String uri) {
        super(brasilAPIFeign, uri, RegistroBRAPI.class);
    }

    @Override
    public Registro findRegistroByDomainV1(@NonNull String domain) {
        return brasilAPI.findRegistroByDomainV1(domain);
    }
}
