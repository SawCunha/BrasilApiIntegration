package br.com.sawcunha.brasilapiintegration.core.feign.api;

import br.com.sawcunha.brasilapiintegration.core.constant.BrasilAPI;
import br.com.sawcunha.brasilapiintegration.core.model.ddd.DirectDialDistance;
import feign.Headers;
import feign.Param;
import feign.RequestLine;

@Headers(BrasilAPI.USER_AGENT_FEIGN)
public interface DirectDialDistanceAPI {

    @RequestLine(BrasilAPI.FIND_DIRECT_DIAL_DISTANCE_BY_CODE_V1_FEIGN)
    DirectDialDistance findDirectDialDistanceByCodeV1(@Param("code") final String code);

}
