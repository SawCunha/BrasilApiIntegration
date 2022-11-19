package br.com.sawcunha.brasilapiintegration.core.feign.api;

import br.com.sawcunha.brasilapiintegration.core.constant.BrasilAPI;
import br.com.sawcunha.brasilapiintegration.core.model.cep.Cep;
import feign.Headers;
import feign.Param;
import feign.RequestLine;


@Headers(BrasilAPI.USER_AGENT_FEIGN)
public interface CepAPI {

    @RequestLine(BrasilAPI.FIND_CEP_BY_CEP_V1_FEIGN)
    Cep findByCepV1(@Param("cep") final String cep);

    @RequestLine(BrasilAPI.FIND_CEP_BY_CEP_V2_FEIGN)
    Cep findByCepV2(@Param("cep") final String cep);
}
