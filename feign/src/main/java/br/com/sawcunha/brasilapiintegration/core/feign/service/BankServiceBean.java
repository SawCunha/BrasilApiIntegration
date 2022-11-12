package br.com.sawcunha.brasilapiintegration.core.feign.service;

import br.com.sawcunha.brasilapiintegration.core.feign.api.BankAPI;
import br.com.sawcunha.brasilapiintegration.core.feign.configuration.FeingConfiguration;
import br.com.sawcunha.brasilapiintegration.core.feign.configuration.decoder.BrasilAPIErrorDecoder;
import br.com.sawcunha.brasilapiintegration.core.model.bank.Bank;
import br.com.sawcunha.brasilapiintegration.core.specification.BankService;
import lombok.NonNull;

import java.util.List;
import java.util.Objects;

public class BankServiceBean implements BankService {

    private static BankServiceBean bankServiceBean;

    private final BankAPI bankAPI;

    public static BankServiceBean instance(@NonNull String uri){
        if(Objects.isNull(bankServiceBean))
            bankServiceBean = new BankServiceBean(uri);

        return bankServiceBean;
    }

    private BankServiceBean(@NonNull String uri) {
        this.bankAPI = FeingConfiguration.getInstance(BankAPI.class, uri, BrasilAPIErrorDecoder.getInstance());
    }

    @Override
    public List<Bank> findAllBanksV1() {
        return bankAPI.findAll();
    }

    @Override
    public Bank findBanksV1ByCode(final Integer code) {
        return bankAPI.findByCode(code);
    }
}
