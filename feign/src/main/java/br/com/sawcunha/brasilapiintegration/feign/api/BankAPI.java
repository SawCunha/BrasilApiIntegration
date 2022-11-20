package br.com.sawcunha.brasilapiintegration.feign.api;

import br.com.sawcunha.brasilapiintegration.core.constant.BrasilAPI;
import br.com.sawcunha.brasilapiintegration.core.model.bank.Bank;
import feign.Headers;
import feign.Param;
import feign.RequestLine;

import java.util.List;

@Headers(BrasilAPI.USER_AGENT_FEIGN)
public interface BankAPI {

    @RequestLine(BrasilAPI.ALL_BANK_V1_FEIGN)
    List<Bank> findAllBanksV1();

    @RequestLine(BrasilAPI.FIND_BANK_BY_CODE_V1_FEIGN)
    Bank findBankByCodeV1(@Param("code") final Integer code);
}
