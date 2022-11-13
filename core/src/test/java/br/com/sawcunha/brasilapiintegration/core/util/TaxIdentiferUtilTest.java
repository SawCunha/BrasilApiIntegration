package br.com.sawcunha.brasilapiintegration.core.util;

import br.com.sawcunha.brasilapiintegration.core.exception.BrasilApiIntegrationException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaxIdentiferUtilTest {

    private static final String CNPJ_VALID = "44.995.453/0001-70";
    private static final String CNPJ_INVALID = "44.995.0453/0001-70";
    private static final String CNPJ_RESULT = "44995453000170";
    private static final String ERROR_MESSAGE = "Invalid CNPJ";

    @Test
    void shouldReturnCNPJSuccessfullyFormatted(){
        String cnpjFormatted = TaxIdentiferUtil.formatCNPJ(CNPJ_VALID);

        assertEquals(CNPJ_RESULT, cnpjFormatted);
    }

    @Test
    void shouldReturnInvalidCeperror(){
        BrasilApiIntegrationException brasilApiIntegrationException = assertThrows(BrasilApiIntegrationException.class, () -> {
            TaxIdentiferUtil.formatCNPJ(CNPJ_INVALID);
        });

        assertNotNull(brasilApiIntegrationException.getMessage());
        assertEquals(ERROR_MESSAGE, brasilApiIntegrationException.getMessage());
    }

}