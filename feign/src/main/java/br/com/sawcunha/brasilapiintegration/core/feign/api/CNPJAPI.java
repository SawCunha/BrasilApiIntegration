package br.com.sawcunha.brasilapiintegration.core.feign.api;

import br.com.sawcunha.brasilapiintegration.core.constant.BrasilAPI;
import br.com.sawcunha.brasilapiintegration.core.model.cnpj.JuridicalPerson;
import feign.Param;
import feign.RequestLine;

public interface CNPJAPI {
    @RequestLine(BrasilAPI.FIND_JURIDICAL_PERSON_BY_CNPJ_V1_FEIGN)
    JuridicalPerson findJuridicalPersonByCnpjV1(@Param("cnpj") final String cnpj);
}
