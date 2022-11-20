package br.com.sawcunha.brasilapiintegration.spring.api;

import br.com.sawcunha.brasilapiintegration.core.constant.BrasilAPI;
import br.com.sawcunha.brasilapiintegration.core.model.cep.Cep;
import br.com.sawcunha.brasilapiintegration.spring.configuration.BrasilAPIConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@FeignClient(value = "brasilapi-cep", url = "${brasilapi.url}", configuration = BrasilAPIConfiguration.class)
public interface CepAPI {

    @RequestMapping(method = RequestMethod.GET, value = BrasilAPI.FIND_CEP_BY_CEP_V1_URL)
    Cep findByCepV1(@PathVariable("cep") final String cep);

    @RequestMapping(method = RequestMethod.GET, value = BrasilAPI.FIND_CEP_BY_CEP_V2_URL)
    Cep findByCepV2(@PathVariable("cep") final String cep);
}
