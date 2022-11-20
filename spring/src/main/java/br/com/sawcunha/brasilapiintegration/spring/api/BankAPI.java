package br.com.sawcunha.brasilapiintegration.spring.api;

import br.com.sawcunha.brasilapiintegration.core.constant.BrasilAPI;
import br.com.sawcunha.brasilapiintegration.core.model.bank.Bank;
import br.com.sawcunha.brasilapiintegration.spring.configuration.BrasilAPIConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(value = "brasilapi-bank", url = "${brasilapi.url}", configuration = BrasilAPIConfiguration.class)
public interface BankAPI {

    @RequestMapping(method = RequestMethod.GET, value = BrasilAPI.ALL_BANK_V1_URL)
    List<Bank> findAllBanksV1();

    @RequestMapping(method = RequestMethod.GET, value = BrasilAPI.FIND_BANK_BY_CODE_V1_URL)
    Bank findBankByCodeV1(@PathVariable("code") final Integer code);
}
