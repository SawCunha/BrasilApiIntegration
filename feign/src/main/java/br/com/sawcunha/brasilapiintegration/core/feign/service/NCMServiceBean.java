package br.com.sawcunha.brasilapiintegration.core.feign.service;

import br.com.sawcunha.brasilapiintegration.core.feign.api.NCMAPI;
import br.com.sawcunha.brasilapiintegration.core.feign.specification.BrasilAPIFeign;
import br.com.sawcunha.brasilapiintegration.core.model.ncm.NCM;
import br.com.sawcunha.brasilapiintegration.core.specification.NCMService;
import lombok.NonNull;

import java.util.Set;

public class NCMServiceBean extends ServiceBean<NCMAPI> implements NCMService {

    public NCMServiceBean(@NonNull BrasilAPIFeign brasilAPIFeign, @NonNull String uri) {
        super(brasilAPIFeign, uri, NCMAPI.class);
    }

    @Override
    public Set<NCM> findAllNCMV1() {
        return brasilAPI.findAllNCMV1();
    }

    @Override
    public Set<NCM> findAllNCMByCodeOrDescriptionV1(@NonNull String value) {
        return brasilAPI.findAllNCMByCodeOrDescriptionV1(value);
    }

    @Override
    public NCM findNCMByCodeV1(@NonNull String code) {
        return brasilAPI.findNCMByCodeV1(code);
    }
}
