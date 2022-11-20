package br.com.sawcunha.brasilapiintegration.spring.api;

import br.com.sawcunha.brasilapiintegration.core.constant.BrasilAPI;
import br.com.sawcunha.brasilapiintegration.core.model.isbn.ISBN;
import br.com.sawcunha.brasilapiintegration.spring.configuration.BrasilAPIConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@FeignClient(value = "brasilapi-isbn", url = "${brasilapi.url}", configuration = BrasilAPIConfiguration.class)
public interface ISBNAPI {

    @RequestMapping(method = RequestMethod.GET, value = BrasilAPI.FIND_ISBN_BY_CODE_V1_URL)
    ISBN findISBNByCodeV1(@PathVariable("code") final String code, @RequestParam final Map<String, String> queries);

}
