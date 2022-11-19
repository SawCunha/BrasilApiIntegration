package br.com.sawcunha.brasilapiintegration.core.feign.api;

import br.com.sawcunha.brasilapiintegration.core.constant.BrasilAPI;
import br.com.sawcunha.brasilapiintegration.core.model.cnpj.JuridicalPerson;
import feign.Headers;
import feign.Param;
import feign.RequestLine;

@Headers(BrasilAPI.USER_AGENT_FEIGN)
public interface CNPJAPI {
    @RequestLine(BrasilAPI.FIND_JURIDICAL_PERSON_BY_CNPJ_V1_FEIGN)
    JuridicalPerson findJuridicalPersonByCnpjV1(@Param("cnpj") final String cnpj);
}
