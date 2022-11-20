package br.com.sawcunha.brasilapiintegration.feign.service;

import br.com.sawcunha.brasilapiintegration.feign.api.RateAPI;
import br.com.sawcunha.brasilapiintegration.feign.specification.BrasilAPIFeign;
import br.com.sawcunha.brasilapiintegration.core.model.rate.Rate;
import br.com.sawcunha.brasilapiintegration.core.specification.RateService;
import lombok.NonNull;

import java.util.Set;

public class RateServiceBean extends ServiceBean<RateAPI> implements RateService {

    public RateServiceBean(@NonNull BrasilAPIFeign brasilAPIFeign, @NonNull String uri) {
        super(brasilAPIFeign, uri, RateAPI.class);
    }

    @Override
    public Set<Rate> findAllRatesV1() {
        return brasilAPI.findAllRatesV1();
    }

    @Override
    public Rate findRateByAcronymV1(@NonNull final String acronym) {
        return brasilAPI.findRateByAcronymV1(acronym);
    }
}
