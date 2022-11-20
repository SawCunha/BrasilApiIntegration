package br.com.sawcunha.brasilapiintegration.feign.service;

import br.com.sawcunha.brasilapiintegration.feign.api.BankAPI;
import br.com.sawcunha.brasilapiintegration.feign.specification.BrasilAPIFeign;
import br.com.sawcunha.brasilapiintegration.core.model.bank.Bank;
import br.com.sawcunha.brasilapiintegration.core.specification.BankService;
import lombok.NonNull;

import java.util.List;

public class BankServiceBean extends ServiceBean<BankAPI> implements BankService {

    public BankServiceBean(@NonNull BrasilAPIFeign brasilAPIFeign,  @NonNull String uri) {
        super(brasilAPIFeign, uri, BankAPI.class);
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
