package br.com.sawcunha.brasilapiintegration.core.feign.api;

import br.com.sawcunha.brasilapiintegration.core.model.cnpj.JuridicalPerson;
import feign.Param;
import feign.RequestLine;

public interface CNPJAPI {
    @RequestLine("GET /cnpj/v1/{cnpj}")
    JuridicalPerson findByCnpjV1(@Param("cnpj") final String cnpj);
}
