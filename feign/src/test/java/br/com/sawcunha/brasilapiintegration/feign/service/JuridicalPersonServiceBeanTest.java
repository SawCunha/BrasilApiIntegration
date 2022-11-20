package br.com.sawcunha.brasilapiintegration.feign.service;

import br.com.sawcunha.brasilapiintegration.core.exception.BrasilApiIntegrationException;
import br.com.sawcunha.brasilapiintegration.feign.utils.BrasilAPIIntegrationUtil;
import br.com.sawcunha.brasilapiintegration.core.model.cnpj.JuridicalPerson;
import br.com.sawcunha.brasilapiintegration.core.specification.JuridicalPersonService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JuridicalPersonServiceBeanTest {


    private JuridicalPersonService cnpjServiceBean;

    private static final String CNPJ_INVALID = "445855";
    private static final String CNPJ_NOT_FOUND = "66032678000164";
    private static final String CNPJ_VALID = "13156947000138";

    private static final int STATUS_NOT_FOUND = 404;
    private static final int STATUS_BAD_REQUEST = 400;

    private static final String MESSAGE_ERROR_BAD_REQUEST = "CNPJ 445855 inválido.";
    private static final String TYPE_ERROR_BAD_REQUEST = "bad_request";
    private static final String NAME_ERROR_BAD_REQUEST = "BadRequestError";

    private static final String MESSAGE_ERROR_NOT_FOUND = "CNPJ 66.032.678/0001-64 não encontrado.";
    private static final String TYPE_ERROR_NOT_FOUND = "not_found";
    private static final String NAME_ERROR_NOT_FOUND = "NotFoundError";

    private static final Long CNAE_FISCAL = 4781400L;
    private static final String PORTE = "MICRO EMPRESA";
    private static final String CNAE_FISCAL_DESCRICAO = "Comércio varejista de artigos do vestuário e acessórios";
    private static final String NOME_FANTASIA = "VEST CHIC MODAS";
    private static final String RAZAO_SOCIAL = "IRENE MACHADO DA ROCHA DE SOUZA";
    private static final String ERROR_MESSAGE = "Invalid CNPJ";

    @BeforeEach
    public void setUp() {
        org.apache.log4j.BasicConfigurator.configure();
        cnpjServiceBean = BrasilAPIIntegrationUtil.createBrasilAPIIntegration().getJuridicalPersonService();
    }

    @Test
    public void shouldGetCNPJWithInvalidCNPJError(){

        BrasilApiIntegrationException brasilApiIntegrationException = assertThrows(
                BrasilApiIntegrationException.class,
                () -> cnpjServiceBean.findCnpjByCnpjV1(CNPJ_INVALID)
        );


        assertNotNull(brasilApiIntegrationException.getMessage());
        assertEquals(ERROR_MESSAGE, brasilApiIntegrationException.getMessage());

    }

    @Test
    public void shouldGetCNPJWithNotFoundCNPJErrorUsingAPIV1(){

        BrasilApiIntegrationException brasilApiIntegrationException = assertThrows(
                BrasilApiIntegrationException.class,
                () -> cnpjServiceBean.findCnpjByCnpjV1(CNPJ_NOT_FOUND)
        );

        assertEquals(STATUS_NOT_FOUND, brasilApiIntegrationException.getStatusAPI());
        assertEquals(MESSAGE_ERROR_NOT_FOUND, brasilApiIntegrationException.getBrasilAPIError().getMessage());
        assertEquals(TYPE_ERROR_NOT_FOUND, brasilApiIntegrationException.getBrasilAPIError().getType());
        assertEquals(NAME_ERROR_NOT_FOUND, brasilApiIntegrationException.getBrasilAPIError().getName());
        assertNull(brasilApiIntegrationException.getBrasilAPIError().getErrors());

    }

    @Test
    public void shouldGetCNPJWithCNPJSuccessUsingAPIV1(){

        JuridicalPerson juridicalPerson = cnpjServiceBean.findCnpjByCnpjV1(CNPJ_VALID);

        assertEquals(CNPJ_VALID, juridicalPerson.getTaxIdentifier());
        assertEquals(CNAE_FISCAL, juridicalPerson.getCnaeFiscal());
        assertEquals(PORTE, juridicalPerson.getPorte());
        assertEquals(CNAE_FISCAL_DESCRICAO, juridicalPerson.getDescriptionCnaeFiscal());
        assertEquals(NOME_FANTASIA, juridicalPerson.getFantasyName());
        assertEquals(RAZAO_SOCIAL, juridicalPerson.getCorporateName());

    }
}
