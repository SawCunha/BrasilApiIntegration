package br.com.sawcunha.brasilapiintegration.core.feign.service;

import br.com.sawcunha.brasilapiintegration.core.exception.BrasilApiIntegrationException;
import br.com.sawcunha.brasilapiintegration.core.model.cep.Cep;
import br.com.sawcunha.brasilapiintegration.core.model.error.BrasilAPIError;
import br.com.sawcunha.brasilapiintegration.core.model.error.ServiceError;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CepServiceBeanTest {

    private static final String CEP_CORRECT = "36204634";
    private static final String CEP_INCORRECT = "5885478";
    private static final String CITY = "Barbacena";
    private static final String NEIGHBORHOOD = "Santo Antônio";
    private static final String STATE = "MG";
    private static final String STREET = "Rua São Francisco de Assis";

    private static final int STATUS_NOT_FOUND = 404;
    private static final String MESSAGE_ERROR = "Todos os serviços de CEP retornaram erro.";
    private static final String TYPE_ERROR = "service_error";
    private static final String NAME_ERROR = "CepPromiseError";


    @Test
    public void shouldGetCEPWithSuccessUsingAPIV1(){
        CepServiceBean cepServiceBean = new CepServiceBean();

        Cep cep = cepServiceBean.findCEPV1ByCEP(CEP_CORRECT);

        assertEquals(CEP_CORRECT, cep.getCep());
        assertNull(cep.getLocation());
        assertEquals(CITY, cep.getCity());
        assertEquals(NEIGHBORHOOD, cep.getNeighborhood());
        assertEquals(STATE, cep.getState());
        assertEquals(STREET, cep.getStreet());
    }

    @Test
    public void shouldGetCEPWithErrorUsingAPIV1(){
        CepServiceBean cepServiceBean = new CepServiceBean();

        BrasilApiIntegrationException brasilApiIntegrationException = assertThrows(
                BrasilApiIntegrationException.class,
                () -> cepServiceBean.findCEPV1ByCEP(CEP_INCORRECT)
        );

        validateException(brasilApiIntegrationException);

    }

    @Test
    public void shouldGetCEPSuccessfullyWithAPIV2(){
        CepServiceBean cepServiceBean = new CepServiceBean();

        Cep cep = cepServiceBean.findCEPV2ByCEP(CEP_CORRECT);

        assertEquals(CEP_CORRECT, cep.getCep());
        assertNotNull(cep.getLocation());
        assertEquals(CITY, cep.getCity());
        assertEquals(NEIGHBORHOOD, cep.getNeighborhood());
        assertEquals(STATE, cep.getState());
        assertEquals(STREET, cep.getStreet());
    }

    @Test
    public void shouldGetCEPWithErrorUsingAPIV2(){
        CepServiceBean cepServiceBean = new CepServiceBean();

        BrasilApiIntegrationException brasilApiIntegrationException = assertThrows(
                BrasilApiIntegrationException.class,
                () -> cepServiceBean.findCEPV2ByCEP(CEP_INCORRECT)
        );

        validateException(brasilApiIntegrationException);

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