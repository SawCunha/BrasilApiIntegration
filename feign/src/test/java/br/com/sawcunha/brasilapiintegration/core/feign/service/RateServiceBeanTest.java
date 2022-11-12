package br.com.sawcunha.brasilapiintegration.core.feign.service;

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

    @Test
    public void shouldFindAllRateSuccess(){
        Set<Rate> rates = rateServiceBean.findAllRates();

        assertTrue(rates.stream().allMatch(rate -> RATES.contains(rate.getName())));
    }

    @Test
    public void shouldFindRateByAcronymWithAcronymCDI(){
        Rate rate = rateServiceBean.findRateByAcronym(RATES.get(0));

        assertEquals(RATES.get(0), rate.getName());
    }

    @Test
    public void shouldFindRateByAcronymWithAcronymNull(){
        NullPointerException nullPointerException = assertThrows(NullPointerException.class, () -> rateServiceBean.findRateByAcronym(null));

        assertEquals("acronym is marked non-null but is null", nullPointerException.getMessage());
    }

}