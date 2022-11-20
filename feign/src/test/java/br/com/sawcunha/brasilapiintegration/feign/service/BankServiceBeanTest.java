package br.com.sawcunha.brasilapiintegration.feign.service;

import br.com.sawcunha.brasilapiintegration.core.exception.BrasilApiIntegrationException;
import br.com.sawcunha.brasilapiintegration.feign.utils.BrasilAPIIntegrationUtil;
import br.com.sawcunha.brasilapiintegration.core.model.bank.Bank;
import br.com.sawcunha.brasilapiintegration.core.specification.BankService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class BankServiceBeanTest {

    private BankService bankServiceBean;

    private static final int CODE_INVALID = 33667852;
    private static final int CODE_C6 = 336;
    private static final String ISPB_C6 = "31872495";
    private static final String NAME_C6 = "BCO C6 S.A.";
    private static final String FULL_NAME_C6 = "Banco C6 S.A.";
    private static final String MESSAGE_ERROR =  "Código bancário não encontrado";
    private static final String TYPE_ERROR =  "BANK_CODE_NOT_FOUND";
    private static final int STATUS_NOT_FOUND = 404;

    @BeforeEach
    public void setUp() {
        org.apache.log4j.BasicConfigurator.configure();
        bankServiceBean = BrasilAPIIntegrationUtil.createBrasilAPIIntegration().getBankService();
    }

    @Test
    public void shouldGetAllBanksWithSuccessUsingAPIV1(){

        List<Bank> banks = bankServiceBean.findAllBanksV1();

        assertTrue(banks.size() > 1);
        assertAll("All Banks",
                () -> assertTrue(banks.stream().filter(bank -> Objects.nonNull(bank.getCode())).anyMatch(bank -> bank.getCode() == 104)),
                () -> assertTrue(banks.stream().filter(bank -> Objects.nonNull(bank.getCode())).anyMatch(bank -> bank.getCode() == 136)),
                () -> assertTrue(banks.stream().filter(bank -> Objects.nonNull(bank.getCode())).anyMatch(bank -> bank.getCode() == 336))
        );
    }

    @Test
    public void shouldGetBankByCodeWithSuccessUsingAPIV1(){

        Bank bank = bankServiceBean.findBankByCodeV1(CODE_C6);

        assertEquals(CODE_C6, bank.getCode());
        assertEquals(ISPB_C6, bank.getIspb());
        assertEquals(NAME_C6, bank.getName());
        assertEquals(FULL_NAME_C6, bank.getFullName());
    }

    @Test
    public void shouldGetBankByCodeWithErrorUsingAPIV1(){

        BrasilApiIntegrationException brasilApiIntegrationException = assertThrows(
                BrasilApiIntegrationException.class,
                () -> bankServiceBean.findBankByCodeV1(CODE_INVALID)
        );

        assertEquals(STATUS_NOT_FOUND, brasilApiIntegrationException.getStatusAPI());
        assertEquals(MESSAGE_ERROR, brasilApiIntegrationException.getBrasilAPIError().getMessage());
        assertEquals(TYPE_ERROR, brasilApiIntegrationException.getBrasilAPIError().getType());
        assertNull(brasilApiIntegrationException.getBrasilAPIError().getErrors());

    }
}