package br.com.sawcunha.brasilapiintegration.core.feign.api;

import br.com.sawcunha.brasilapiintegration.core.constant.BrasilAPI;
import br.com.sawcunha.brasilapiintegration.core.model.rate.Rate;
import feign.Headers;
import feign.Param;
import feign.RequestLine;

import java.util.Set;

@Headers(BrasilAPI.USER_AGENT_FEIGN)
public interface RateAPI {

    @RequestLine(BrasilAPI.FIND_ALL_RATES_V1_FEIGN)
    Set<Rate> findAllRatesV1();

    @RequestLine(BrasilAPI.FIND_RATE_BY_ACRONYM_V1_FEIGN)
    Rate findRateByAcronymV1(@Param("acronym") final String acronym);

}
