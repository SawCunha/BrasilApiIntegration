package br.com.sawcunha.brasilapiintegration.core.feign.service;

import br.com.sawcunha.brasilapiintegration.core.exception.BrasilApiIntegrationException;
import br.com.sawcunha.brasilapiintegration.core.feign.utils.BrasilAPIIntegrationUtil;
import br.com.sawcunha.brasilapiintegration.core.model.cep.Cep;
import br.com.sawcunha.brasilapiintegration.core.model.error.BrasilAPIError;
import br.com.sawcunha.brasilapiintegration.core.model.error.ServiceError;
import br.com.sawcunha.brasilapiintegration.core.specification.CepService;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CepServiceBeanTest {

    private static final CepService cepServiceBean = BrasilAPIIntegrationUtil.createBrasilAPIIntegration().getCepService();

    private static final String CEP_CORRECT = "36204634";
    private static final String CEP_INVALID = "99904634";
    private static final String CEP_INCORRECT = "5885478";
    private static final String CITY = "Barbacena";
    private static final String NEIGHBORHOOD = "Santo Antônio";
    private static final String STATE = "MG";
    private static final String STREET = "Rua São Francisco de Assis";

    private static final int STATUS_NOT_FOUND = 404;
    private static final String MESSAGE_ERROR = "Todos os serviços de CEP retornaram erro.";
    private static final String TYPE_ERROR = "service_error";
    private static final String NAME_ERROR = "CepPromiseError";
    private static final String ERROR_MESSAGE = "Invalid CEP";


    @Test
    void shouldGetCEPWithSuccessUsingAPIV1(){

        Cep cep = cepServiceBean.findCEPByCEPV1(CEP_CORRECT);

        assertEquals(CEP_CORRECT, cep.getCep());
        assertNull(cep.getLocation());
        assertEquals(CITY, cep.getCity());
        assertEquals(NEIGHBORHOOD, cep.getNeighborhood());
        assertEquals(STATE, cep.getState());
        assertEquals(STREET, cep.getStreet());
    }

    @Test
    void shouldGetCEPWithErrorUsingAPIV1(){

        BrasilApiIntegrationException brasilApiIntegrationException = assertThrows(
                BrasilApiIntegrationException.class,
                () -> cepServiceBean.findCEPByCEPV1(CEP_INVALID)
        );

        validateException(brasilApiIntegrationException);

    }

    @Test
    void shouldGetCEPSuccessfullyWithAPIV2(){

        Cep cep = cepServiceBean.findCEPByCEPV2(CEP_CORRECT);

        assertEquals(CEP_CORRECT, cep.getCep());
        assertNotNull(cep.getLocation());
        assertEquals(CITY, cep.getCity());
        assertEquals(NEIGHBORHOOD, cep.getNeighborhood());
        assertEquals(STATE, cep.getState());
        assertEquals(STREET, cep.getStreet());
    }

    @Test
    void shouldGetCEPWithErrorUsingAPIV2(){

        BrasilApiIntegrationException brasilApiIntegrationException = assertThrows(
                BrasilApiIntegrationException.class,
                () -> cepServiceBean.findCEPByCEPV2(CEP_INVALID)
        );

        validateException(brasilApiIntegrationException);

    }

    @Test
    void shouldReturnInvalidCEPError(){

        BrasilApiIntegrationException brasilApiIntegrationException = assertThrows(
                BrasilApiIntegrationException.class,
                () -> cepServiceBean.findCEPByCEPV2(CEP_INCORRECT)
        );

        assertNotNull(brasilApiIntegrationException.getMessage());
        assertEquals(ERROR_MESSAGE, brasilApiIntegrationException.getMessage());
    }

    private void validateException(BrasilApiIntegrationException brasilApiIntegrationException){
        BrasilAPIError brasilAPIError = brasilApiIntegrationException.getBrasilAPIError();
        assertEquals(STATUS_NOT_FOUND, brasilApiIntegrationException.getStatusAPI());
        assertEquals(MESSAGE_ERROR, brasilAPIError.getMessage());
        assertEquals(TYPE_ERROR, brasilAPIError.getType());
        assertEquals(NAME_ERROR, brasilAPIError.getName());
        assertEquals(3, brasilAPIError.getErrors().size());
        List<ServiceError> servicesError = brasilAPIError.getErrors();

        assertAll("Services Error",
                () -> assertTrue(servicesError.stream().anyMatch(serviceError -> serviceError.getService().equals("correios"))),
                () -> assertTrue(servicesError.stream().anyMatch(serviceError -> serviceError.getService().equals("viacep"))),
                () -> assertTrue(servicesError.stream().anyMatch(serviceError -> serviceError.getService().equals("widenet")))
        );
    }
}