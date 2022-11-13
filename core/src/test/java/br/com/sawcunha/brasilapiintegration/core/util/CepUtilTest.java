package br.com.sawcunha.brasilapiintegration.core.util;

import br.com.sawcunha.brasilapiintegration.core.exception.BrasilApiIntegrationException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CepUtilTest {

    private static final String CEP_VALID = "36200-555";
    private static final String CEP_INVALID = "346200-555";
    private static final String CEP_RESULT = "36200555";
    private static final String ERROR_MESSAGE = "Invalid CEP";

    @Test
    void shouldReturnCEPSuccessfullyFormatted(){
        String cepFormatted = CepUtil.formatCEP(CEP_VALID);

        assertEquals(CEP_RESULT, cepFormatted);
    }

    @Test
    void shouldReturnInvalidCEPError(){
        BrasilApiIntegrationException brasilApiIntegrationException = assertThrows(BrasilApiIntegrationException.class, () -> {
            CepUtil.formatCEP(CEP_INVALID);
        });

        assertNotNull(brasilApiIntegrationException.getMessage());
        assertEquals(ERROR_MESSAGE, brasilApiIntegrationException.getMessage());
    }

}