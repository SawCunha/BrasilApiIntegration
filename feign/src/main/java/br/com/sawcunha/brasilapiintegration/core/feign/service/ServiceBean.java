package br.com.sawcunha.brasilapiintegration.core.feign.service;

import br.com.sawcunha.brasilapiintegration.core.feign.configuration.FeingConfiguration;
import br.com.sawcunha.brasilapiintegration.core.feign.configuration.decoder.BrasilAPIErrorDecoder;
import lombok.NonNull;

public abstract class ServiceBean<A> {

    final A brasilAPI;

    ServiceBean(@NonNull String uri, Class<A> apiClass) {
        this.brasilAPI = FeingConfiguration.getInstance( apiClass, uri, BrasilAPIErrorDecoder.getInstance());
    }
}
