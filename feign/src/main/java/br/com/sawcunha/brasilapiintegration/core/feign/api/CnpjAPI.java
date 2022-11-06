package br.com.sawcunha.brasilapiintegration.core.feign.api;

import br.com.sawcunha.brasilapiintegration.core.model.cnpj.Cnpj;
import feign.Param;
import feign.RequestLine;

public interface CnpjAPI {
    @RequestLine("GET /cnpj/v1/{cnpj}")
    Cnpj findByCnpjV1(@Param("cnpj") final String cnpj);
}
