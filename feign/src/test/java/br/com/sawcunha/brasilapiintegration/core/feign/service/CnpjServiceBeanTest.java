package br.com.sawcunha.brasilapiintegration.core.feign.service;

import br.com.sawcunha.brasilapiintegration.core.exception.BrasilApiIntegrationException;
import br.com.sawcunha.brasilapiintegration.core.model.cnpj.Cnpj;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CnpjServiceBeanTest {

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

    @Test
    public void shouldGetCNPJWithInvalidCNPJErrorUsingAPIV1(){
        CnpjServiceBean cnpjServiceBean = new CnpjServiceBean();

        BrasilApiIntegrationException brasilApiIntegrationException = assertThrows(
                BrasilApiIntegrationException.class,
                () -> cnpjServiceBean.findCnpjByCnpj(CNPJ_INVALID)
        );

        assertEquals(STATUS_BAD_REQUEST, brasilApiIntegrationException.getStatusAPI());
        assertEquals(MESSAGE_ERROR_BAD_REQUEST, brasilApiIntegrationException.getBrasilAPIError().getMessage());
        assertEquals(TYPE_ERROR_BAD_REQUEST, brasilApiIntegrationException.getBrasilAPIError().getType());
        assertEquals(NAME_ERROR_BAD_REQUEST, brasilApiIntegrationException.getBrasilAPIError().getName());
        assertNull(brasilApiIntegrationException.getBrasilAPIError().getErrors());

    }

    @Test
    public void shouldGetCNPJWithNotFoundCNPJErrorUsingAPIV1(){
        CnpjServiceBean cnpjServiceBean = new CnpjServiceBean();

        BrasilApiIntegrationException brasilApiIntegrationException = assertThrows(
                BrasilApiIntegrationException.class,
                () -> cnpjServiceBean.findCnpjByCnpj(CNPJ_NOT_FOUND)
        );

        assertEquals(STATUS_NOT_FOUND, brasilApiIntegrationException.getStatusAPI());
        assertEquals(MESSAGE_ERROR_NOT_FOUND, brasilApiIntegrationException.getBrasilAPIError().getMessage());
        assertEquals(TYPE_ERROR_NOT_FOUND, brasilApiIntegrationException.getBrasilAPIError().getType());
        assertEquals(NAME_ERROR_NOT_FOUND, brasilApiIntegrationException.getBrasilAPIError().getName());
        assertNull(brasilApiIntegrationException.getBrasilAPIError().getErrors());

    }

    @Test
    public void shouldGetCNPJWithCNPJSuccessUsingAPIV1(){
        CnpjServiceBean cnpjServiceBean = new CnpjServiceBean();

        Cnpj cnpj = cnpjServiceBean.findCnpjByCnpj(CNPJ_VALID);

        assertEquals(CNPJ_VALID, cnpj.getCnpj());
        assertEquals(CNAE_FISCAL, cnpj.getCnae_fiscal());
        assertEquals(PORTE, cnpj.getPorte());
        assertEquals(CNAE_FISCAL_DESCRICAO, cnpj.getCnae_fiscal_descricao());
        assertEquals(NOME_FANTASIA, cnpj.getNome_fantasia());
        assertEquals(RAZAO_SOCIAL, cnpj.getRazao_social());

    }
}
