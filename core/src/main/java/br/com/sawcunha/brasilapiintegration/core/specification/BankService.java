package br.com.sawcunha.brasilapiintegration.core.specification;

import br.com.sawcunha.brasilapiintegration.core.model.bank.Bank;

import java.util.List;

public interface BankService {

    List<Bank> findAllBanksV1();
    Bank findBankByCodeV1(final Integer code);

}
