package br.com.sawcunha.brasilapiintegration.core.feign.api;

import br.com.sawcunha.brasilapiintegration.core.model.cep.Cep;
import feign.Param;
import feign.RequestLine;

public interface CepAPI {

    @RequestLine("GET /cep/v1/{cep}")
    Cep findByCepV1(@Param("cep") final String cep);

    @RequestLine("GET /cep/v2/{cep}")
    Cep findByCepV2(@Param("cep") final String cep);
}
