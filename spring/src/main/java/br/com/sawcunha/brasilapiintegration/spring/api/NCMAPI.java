package br.com.sawcunha.brasilapiintegration.spring.api;

import br.com.sawcunha.brasilapiintegration.core.constant.BrasilAPI;
import br.com.sawcunha.brasilapiintegration.core.model.ncm.NCM;
import br.com.sawcunha.brasilapiintegration.spring.configuration.BrasilAPIConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Set;

@FeignClient(value = "brasilapi-ncm", url = "${brasilapi.url}", configuration = BrasilAPIConfiguration.class)
public interface NCMAPI {

    @RequestMapping(method = RequestMethod.GET, value = BrasilAPI.FIND_ALL_NCM_V1_URL)
    Set<NCM> findAllNCMV1();

    @RequestMapping(method = RequestMethod.GET, value = BrasilAPI.FIND_ALL_NCM_BY_CODE_OR_DESCRIPTION_V1_URL)
    Set<NCM> findAllNCMByCodeOrDescriptionV1(@PathVariable("value") final String value);

    @RequestMapping(method = RequestMethod.GET, value = BrasilAPI.FIND_NCM_BY_CODE_V1_URL)
    NCM findNCMByCodeV1(@PathVariable("code") final String code);

}
