package br.com.sawcunha.brasilapiintegration.spring.api;

import br.com.sawcunha.brasilapiintegration.core.constant.BrasilAPI;
import br.com.sawcunha.brasilapiintegration.core.model.ddd.DirectDialDistance;
import br.com.sawcunha.brasilapiintegration.spring.configuration.BrasilAPIConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "brasilapi-ddd", url = "${brasilapi.url}", configuration = BrasilAPIConfiguration.class)
public interface DirectDialDistanceAPI {

    @RequestMapping(method = RequestMethod.GET, value = BrasilAPI.FIND_DIRECT_DIAL_DISTANCE_BY_CODE_V1_URL)
    DirectDialDistance findDirectDialDistanceByCodeV1(@PathVariable("code") final String code);

}
