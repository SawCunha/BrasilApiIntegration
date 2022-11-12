package br.com.sawcunha.brasilapiintegration.core.feign.api;

import br.com.sawcunha.brasilapiintegration.core.model.ddd.DirectDialDistance;
import feign.Param;
import feign.RequestLine;

public interface DDDAPI {

    @RequestLine("GET /ddd/v1/{code}")
    DirectDialDistance findByCodeV1(@Param("code") final String code);

}
