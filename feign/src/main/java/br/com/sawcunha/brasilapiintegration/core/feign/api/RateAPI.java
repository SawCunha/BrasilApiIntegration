package br.com.sawcunha.brasilapiintegration.core.feign.api;

import br.com.sawcunha.brasilapiintegration.core.model.rate.Rate;
import feign.Param;
import feign.RequestLine;

import java.util.Set;

public interface RateAPI {

    @RequestLine("GET /taxas/v1")
    Set<Rate> findAllRates();

    @RequestLine("GET /taxas/v1/{acronym}")
    Rate findRateByAcronym(@Param("acronym") final String acronym);

}
