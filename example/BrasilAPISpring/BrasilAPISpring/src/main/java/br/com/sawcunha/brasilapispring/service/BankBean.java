package br.com.sawcunha.brasilapispring.service;

import br.com.sawcunha.brasilapiintegration.core.model.bank.Bank;
import br.com.sawcunha.brasilapiintegration.core.specification.BankService;
import br.com.sawcunha.brasilapispring.dto.BrasilAPIDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BankBean {

    private final BankService bankService;

    public BrasilAPIDTO<List<Bank>> findAllBanksV1() {
        List<Bank> banks = bankService.findAllBanksV1();
        return BrasilAPIDTO.<List<Bank>>builder()
                .data(banks)
                .build();
    }

    public BrasilAPIDTO<Bank> findBankByCodeV1(final Integer code) {
        Bank bank = bankService.findBankByCodeV1(code);
        return BrasilAPIDTO.<Bank>builder()
                .data(bank)
                .build();
    }
}
