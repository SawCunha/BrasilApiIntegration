package br.com.sawcunha.brasilapiintegration.core.feign.service;

import br.com.sawcunha.brasilapiintegration.core.feign.api.BankAPI;
import br.com.sawcunha.brasilapiintegration.core.model.bank.Bank;
import br.com.sawcunha.brasilapiintegration.core.specification.BankService;
import lombok.NonNull;

import java.util.List;
import java.util.Objects;

public class BankServiceBean extends ServiceBean<BankAPI> implements BankService {

    private static BankServiceBean bankServiceBean;

    public static BankServiceBean instance(@NonNull String uri){
        if(Objects.isNull(bankServiceBean))
            bankServiceBean = new BankServiceBean(uri);

        return bankServiceBean;
    }

    private BankServiceBean(@NonNull String uri) {
        super(uri, BankAPI.class);
    }

    @Override
    public List<Bank> findAllBanksV1() {
        return brasilAPI.findAllBanksV1();
    }

    @Override
    public Bank findBankByCodeV1(final Integer code) {
        return brasilAPI.findBankByCodeV1(code);
    }
}
