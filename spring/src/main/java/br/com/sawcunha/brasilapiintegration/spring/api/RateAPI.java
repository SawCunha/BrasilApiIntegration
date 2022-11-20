package br.com.sawcunha.brasilapiintegration.spring.api;

import br.com.sawcunha.brasilapiintegration.core.constant.BrasilAPI;
import br.com.sawcunha.brasilapiintegration.core.model.rate.Rate;
import br.com.sawcunha.brasilapiintegration.spring.configuration.BrasilAPIConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Set;

@FeignClient(value = "brasilapi-taxas", url = "${brasilapi.url}", configuration = BrasilAPIConfiguration.class)
public interface RateAPI {

    @RequestMapping(method = RequestMethod.GET, value = BrasilAPI.FIND_ALL_RATES_V1_URL)
    Set<Rate> findAllRatesV1();

    @RequestMapping(method = RequestMethod.GET, value = BrasilAPI.FIND_RATE_BY_ACRONYM_V1_URL)
    Rate findRateByAcronymV1(@PathVariable("acronym") final String acronym);

}
