package br.com.sawcunha.brasilapiintegration.core.feign.api;

import br.com.sawcunha.brasilapiintegration.core.model.registrobr.Registro;
import feign.Param;
import feign.RequestLine;

public interface RegistroBRAPI {

    @RequestLine("/registrobr/v1/{domain}")
    Registro findRegistroByDomain(@Param("domain") final String domain);

}
