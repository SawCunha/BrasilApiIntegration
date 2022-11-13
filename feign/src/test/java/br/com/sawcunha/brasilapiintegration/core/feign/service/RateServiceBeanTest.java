package br.com.sawcunha.brasilapiintegration.core.feign.service;

import br.com.sawcunha.brasilapiintegration.core.exception.BrasilApiIntegrationException;
import br.com.sawcunha.brasilapiintegration.core.model.rate.Rate;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import static br.com.sawcunha.brasilapiintegration.core.feign.utils.Util.URI_API;
import static org.junit.jupiter.api.Assertions.*;

class RateServiceBeanTest {

    private final RateServiceBean rateServiceBean = RateServiceBean.instance(URI_API);

    private static final List<String> RATES = Arrays.asList("CDI", "Selic", "IPCA");
    private static final String RATE_INVALID = "RATE";
    private static final String MESSAGE_ERROR =  "Taxa ou Índice não encontrada.";
    private static final String TYPE_ERROR =  "not_found";
    private static final int STATUS_NOT_FOUND = 404;

    @Test
    public void shouldFindAllRateSuccess(){
        Set<Rate> rates = rateServiceBean.findAllRatesV1();

        assertTrue(rates.stream().allMatch(rate -> RATES.contains(rate.getName())));
    }

    @Test
    public void shouldFindRateByAcronymWithAcronymCDI(){
        Rate rate = rateServiceBean.findRateByAcronymV1(RATES.get(0));

        assertEquals(RATES.get(0), rate.getName());
    }

    @Test
    public void shouldFindRateByAcronymWithAcronymNull(){
        NullPointerException nullPointerException = assertThrows(NullPointerException.class, () -> rateServiceBean.findRateByAcronymV1(null));

        assertEquals("acronym is marked non-null but is null", nullPointerException.getMessage());
    }

    @Test
    public void shouldFindRateByAcronymWithAcronymInvalid(){
        BrasilApiIntegrationException brasilApiIntegrationException = assertThrows(BrasilApiIntegrationException.class, () -> rateServiceBean.findRateByAcronymV1(RATE_INVALID));

        assertEquals(STATUS_NOT_FOUND, brasilApiIntegrationException.getStatusAPI());
        assertEquals(MESSAGE_ERROR, brasilApiIntegrationException.getBrasilAPIError().getMessage());
        assertEquals(TYPE_ERROR, brasilApiIntegrationException.getBrasilAPIError().getType());
    }

}