package br.com.sawcunha.brasilapiintegration.core.feign.service;

import br.com.sawcunha.brasilapiintegration.core.feign.api.DirectDialDistanceAPI;
import br.com.sawcunha.brasilapiintegration.core.feign.specification.BrasilAPIFeign;
import br.com.sawcunha.brasilapiintegration.core.model.ddd.DirectDialDistance;
import br.com.sawcunha.brasilapiintegration.core.specification.DirectDialDistanceService;
import lombok.NonNull;

public class DirectDialDistanceServiceBean extends ServiceBean<DirectDialDistanceAPI> implements DirectDialDistanceService {

    public DirectDialDistanceServiceBean(@NonNull BrasilAPIFeign brasilAPIFeign, @NonNull String uri) {
        super(brasilAPIFeign, uri, DirectDialDistanceAPI.class);
    }

    @Override
    public DirectDialDistance findDirectDialDistanceByCodeV1(@NonNull String code) {
        return brasilAPI.findDirectDialDistanceByCodeV1(code);
    }
}
