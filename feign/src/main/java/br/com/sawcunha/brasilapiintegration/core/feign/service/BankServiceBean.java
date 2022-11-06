package br.com.sawcunha.brasilapiintegration.core.feign.service;

import br.com.sawcunha.brasilapiintegration.core.feign.api.BankAPI;
import br.com.sawcunha.brasilapiintegration.core.feign.configuration.FeingConfiguration;
import br.com.sawcunha.brasilapiintegration.core.feign.configuration.decoder.BankDecoder;
import br.com.sawcunha.brasilapiintegration.core.model.bank.Bank;
import br.com.sawcunha.brasilapiintegration.core.specification.BankService;

import java.util.List;
import java.util.Objects;

public class BankServiceBean implements BankService {

    private static BankAPI bankAPI;
    private static final String URI = "https://brasilapi.com.br/api";

    private static BankAPI instance(){
        if(Objects.isNull(bankAPI))
            bankAPI = FeingConfiguration.getInstance(BankAPI.class, URI, BankDecoder.getInstance());

        return bankAPI;
    }

    @Override
    public List<Bank> findAllBanksV1() {
        return instance().findAll();
    }

    @Override
    public Bank findBanksV1ByCode(final Integer code) {
        return instance().findByCode(code);
    }
}
