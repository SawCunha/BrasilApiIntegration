package br.com.sawcunha.brasilapiintegration.feign.api;

import br.com.sawcunha.brasilapiintegration.core.constant.BrasilAPI;
import br.com.sawcunha.brasilapiintegration.core.model.ibge.IBGE;
import feign.Headers;
import feign.Param;
import feign.QueryMap;
import feign.RequestLine;

import java.util.Map;
import java.util.Set;

@Headers(BrasilAPI.USER_AGENT_FEIGN)
public interface IBGEAPI {

    @RequestLine(BrasilAPI.FIND_ALL_COUNTIES_BY_UF_V1_FEIGN)
    Set<IBGE> findAllCountiesByUFV1(@Param("uf") final String uf, @QueryMap final Map<String, String> queries);

    @RequestLine(BrasilAPI.FIND_ALL_STATE_BY_UF_V1_FEIGN)
    Set<IBGE> findAllStateByUFV1();

    @RequestLine(BrasilAPI.FIND_STATE_BY_CODE_V1_FEIGN)
    IBGE findStateByCodeV1(@Param("code") final String code);
}
