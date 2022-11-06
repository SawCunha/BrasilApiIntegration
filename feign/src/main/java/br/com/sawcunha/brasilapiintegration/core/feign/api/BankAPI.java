package br.com.sawcunha.brasilapiintegration.core.feign.api;

import br.com.sawcunha.brasilapiintegration.core.model.bank.Bank;
import feign.Param;
import feign.RequestLine;

import java.util.List;

public interface BankAPI {

    @RequestLine("GET /banks/v1")
    List<Bank> findAll();

    @RequestLine("GET /banks/v1/{code}")
    Bank findByCode(@Param("code") final Integer code);
}
