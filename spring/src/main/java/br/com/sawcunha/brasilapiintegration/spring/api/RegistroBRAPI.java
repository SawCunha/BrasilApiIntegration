package br.com.sawcunha.brasilapiintegration.spring.api;

import br.com.sawcunha.brasilapiintegration.core.constant.BrasilAPI;
import br.com.sawcunha.brasilapiintegration.core.model.registrobr.Registro;
import br.com.sawcunha.brasilapiintegration.spring.configuration.BrasilAPIConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "brasilapi-registrobr", url = "${brasilapi.url}", configuration = BrasilAPIConfiguration.class)
public interface RegistroBRAPI {

    @RequestMapping(method = RequestMethod.GET, value = BrasilAPI.FIND_REGISTRO_BR_BY_DOMAIN_V1_URL)
    Registro findRegistroByDomainV1(@PathVariable("domain") final String domain);

}
