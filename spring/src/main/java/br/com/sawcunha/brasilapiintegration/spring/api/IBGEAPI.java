package br.com.sawcunha.brasilapiintegration.spring.api;

import br.com.sawcunha.brasilapiintegration.core.constant.BrasilAPI;
import br.com.sawcunha.brasilapiintegration.core.model.ibge.IBGE;
import br.com.sawcunha.brasilapiintegration.spring.configuration.BrasilAPIConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;
import java.util.Set;

@FeignClient(value = "brasilapi-ibge", url = "${brasilapi.url}", configuration = BrasilAPIConfiguration.class)
public interface IBGEAPI {

    @RequestMapping(method = RequestMethod.GET, value = BrasilAPI.FIND_ALL_COUNTIES_BY_UF_V1_URL)
    Set<IBGE> findAllCountiesByUFV1(@PathVariable("uf") final String uf, @RequestParam final Map<String, String> queries);

    @RequestMapping(method = RequestMethod.GET, value = BrasilAPI.FIND_ALL_STATE_BY_UF_V1_URL)
    Set<IBGE> findAllStateByUFV1();

    @RequestMapping(method = RequestMethod.GET, value = BrasilAPI.FIND_STATE_BY_CODE_V1_URL)
    IBGE findStateByCodeV1(@PathVariable("code") final String code);
}
