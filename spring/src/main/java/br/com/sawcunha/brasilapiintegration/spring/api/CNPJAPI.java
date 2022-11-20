package br.com.sawcunha.brasilapiintegration.spring.api;

import br.com.sawcunha.brasilapiintegration.core.constant.BrasilAPI;
import br.com.sawcunha.brasilapiintegration.core.model.cnpj.JuridicalPerson;
import br.com.sawcunha.brasilapiintegration.spring.configuration.BrasilAPIConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "brasilapi-cnpj", url = "${brasilapi.url}", configuration = BrasilAPIConfiguration.class)
public interface CNPJAPI {

    @RequestMapping(method = RequestMethod.GET, value = BrasilAPI.FIND_JURIDICAL_PERSON_BY_CNPJ_V1_URL)
    JuridicalPerson findJuridicalPersonByCnpjV1(@PathVariable("cnpj") final String cnpj);
}
