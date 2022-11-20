package br.com.sawcunha.brasilapiintegration.core.feign.api;

import br.com.sawcunha.brasilapiintegration.core.constant.BrasilAPI;
import br.com.sawcunha.brasilapiintegration.core.model.registrobr.Registro;
import feign.Headers;
import feign.Param;
import feign.RequestLine;

@Headers(BrasilAPI.USER_AGENT_FEIGN)
public interface RegistroBRAPI {

    @RequestLine(BrasilAPI.FIND_REGISTRO_BR_BY_DOMAIN_V1_FEIGN)
    Registro findRegistroByDomainV1(@Param("domain") final String domain);

}
