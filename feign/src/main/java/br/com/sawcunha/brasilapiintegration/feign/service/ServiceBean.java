package br.com.sawcunha.brasilapiintegration.feign.service;

import br.com.sawcunha.brasilapiintegration.feign.specification.BrasilAPIFeign;
import lombok.NonNull;

public abstract class ServiceBean<A> {

    final A brasilAPI;

    ServiceBean(@NonNull BrasilAPIFeign brasilAPIFeign, @NonNull String uri, Class<A> apiClass) {
        this.brasilAPI = brasilAPIFeign.feignInstance(apiClass, uri);
    }
}
