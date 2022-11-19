package br.com.sawcunha.brasilapiintegration.core.feign.api;

import br.com.sawcunha.brasilapiintegration.core.constant.BrasilAPI;
import br.com.sawcunha.brasilapiintegration.core.model.isbn.ISBN;
import feign.Headers;
import feign.Param;
import feign.QueryMap;
import feign.RequestLine;

import java.util.Map;

@Headers(BrasilAPI.USER_AGENT_FEIGN)
public interface ISBNAPI {

    @RequestLine(BrasilAPI.FIND_ISBN_BY_CODE_V1_FEIGN)
    ISBN findISBNByCodeV1(@Param("code") final String code, @QueryMap final Map<String, String> queries);

}
