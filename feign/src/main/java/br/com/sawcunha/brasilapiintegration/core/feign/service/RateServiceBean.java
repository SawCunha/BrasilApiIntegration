package br.com.sawcunha.brasilapiintegration.core.feign.service;

import br.com.sawcunha.brasilapiintegration.core.feign.api.RateAPI;
import br.com.sawcunha.brasilapiintegration.core.model.rate.Rate;
import br.com.sawcunha.brasilapiintegration.core.specification.RateService;
import lombok.NonNull;

import java.util.Objects;
import java.util.Set;

public class RateServiceBean extends ServiceBean<RateAPI> implements RateService {

    private static RateServiceBean rateServiceBean;

    public static RateServiceBean instance(@NonNull String uri){
        if(Objects.isNull(rateServiceBean))
            rateServiceBean = new RateServiceBean(uri);

        return rateServiceBean;
    }

    private RateServiceBean(@NonNull String uri) {
        super(uri, RateAPI.class);
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
