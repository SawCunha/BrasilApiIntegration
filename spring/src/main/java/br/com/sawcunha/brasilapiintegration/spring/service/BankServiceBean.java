package br.com.sawcunha.brasilapiintegration.spring.service;

import br.com.sawcunha.brasilapiintegration.core.model.bank.Bank;
import br.com.sawcunha.brasilapiintegration.core.specification.BankService;
import br.com.sawcunha.brasilapiintegration.spring.api.BankAPI;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j
@RequiredArgsConstructor
public class BankServiceBean implements BankService {

    private final BankAPI bankAPI;

    @Override
    public List<Bank> findAllBanksV1() {
        return bankAPI.findAllBanksV1();
    }

    @Override
    public Bank findBankByCodeV1(@NonNull final Integer code) {
        return bankAPI.findBankByCodeV1(code);
    }
}
