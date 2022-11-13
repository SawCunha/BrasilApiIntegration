package br.com.sawcunha.brasilapiintegration.core.feign.service;

import br.com.sawcunha.brasilapiintegration.core.feign.api.DirectDialDistanceAPI;
import br.com.sawcunha.brasilapiintegration.core.model.ddd.DirectDialDistance;
import br.com.sawcunha.brasilapiintegration.core.specification.DirectDialDistanceService;
import lombok.NonNull;

import java.util.Objects;

public class DirectDialDistanceServiceBean extends ServiceBean<DirectDialDistanceAPI> implements DirectDialDistanceService {

    private static DirectDialDistanceServiceBean directDialDistanceServiceBean;

    public static DirectDialDistanceServiceBean instance(@NonNull String uri){
        if(Objects.isNull(directDialDistanceServiceBean))
            directDialDistanceServiceBean = new DirectDialDistanceServiceBean(uri);

        return directDialDistanceServiceBean;
    }

    public DirectDialDistanceServiceBean(@NonNull String uri) {
        super(uri, DirectDialDistanceAPI.class);
    }

    @Override
    public DirectDialDistance findDirectDialDistanceByCodeV1(@NonNull String code) {
        return brasilAPI.findDirectDialDistanceByCodeV1(code);
    }
}
