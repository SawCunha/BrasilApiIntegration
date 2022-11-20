package br.com.sawcunha.brasilapiintegration.spring.service;

import br.com.sawcunha.brasilapiintegration.core.model.rate.Rate;
import br.com.sawcunha.brasilapiintegration.core.specification.RateService;
import br.com.sawcunha.brasilapiintegration.spring.api.RateAPI;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Log4j
@RequiredArgsConstructor
public class RateServiceBean implements RateService {

    private final RateAPI rateAPI;

    @Override
    public Set<Rate> findAllRatesV1() {
        return rateAPI.findAllRatesV1();
    }

    @Override
    public Rate findRateByAcronymV1(@NonNull final String acronym) {
        return rateAPI.findRateByAcronymV1(acronym);
    }
}
