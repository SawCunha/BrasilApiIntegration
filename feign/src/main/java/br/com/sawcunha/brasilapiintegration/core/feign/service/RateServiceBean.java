package br.com.sawcunha.brasilapiintegration.core.feign.service;

import br.com.sawcunha.brasilapiintegration.core.feign.api.RateAPI;
import br.com.sawcunha.brasilapiintegration.core.feign.configuration.FeingConfiguration;
import br.com.sawcunha.brasilapiintegration.core.feign.configuration.decoder.BrasilAPIErrorDecoder;
import br.com.sawcunha.brasilapiintegration.core.model.rate.Rate;
import br.com.sawcunha.brasilapiintegration.core.specification.RateService;
import lombok.NonNull;

import java.util.Objects;
import java.util.Set;

public class RateServiceBean implements RateService {

    private static RateServiceBean rateServiceBean;
    private final RateAPI rateAPI;

    public static RateServiceBean instance(@NonNull String uri){
        if(Objects.isNull(rateServiceBean))
            rateServiceBean = new RateServiceBean(uri);

        return rateServiceBean;
    }

    private RateServiceBean(@NonNull String uri) {
        this.rateAPI = FeingConfiguration.getInstance(RateAPI.class, uri, BrasilAPIErrorDecoder.getInstance());
    }

    @Override
    public Set<Rate> findAllRates() {
        return rateAPI.findAllRates();
    }

    @Override
    public Rate findRateByAcronym(@NonNull final String acronym) {
        return rateAPI.findRateByAcronym(acronym);
    }
}
