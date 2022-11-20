package br.com.sawcunha.brasilapispring.controller;

import br.com.sawcunha.brasilapiintegration.core.model.bank.Bank;
import br.com.sawcunha.brasilapispring.dto.BrasilAPIDTO;
import br.com.sawcunha.brasilapispring.service.BankBean;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/bank", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class BankController {

    private final BankBean bankService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public BrasilAPIDTO<List<Bank>> allBanks() {
        return bankService.findAllBanksV1();
    }

    @GetMapping("/{code}")
    public BrasilAPIDTO<Bank> findBankByID(@PathVariable("code") Integer code) {
        return bankService.findBankByCodeV1(code);
    }

}
