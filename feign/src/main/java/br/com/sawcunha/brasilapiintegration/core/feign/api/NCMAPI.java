package br.com.sawcunha.brasilapiintegration.core.feign.api;

import br.com.sawcunha.brasilapiintegration.core.constant.BrasilAPI;
import br.com.sawcunha.brasilapiintegration.core.model.ncm.NCM;
import feign.Headers;
import feign.Param;
import feign.RequestLine;

import java.util.Set;

@Headers(BrasilAPI.USER_AGENT_FEIGN)
public interface NCMAPI {

    @RequestLine(BrasilAPI.FIND_ALL_NCM_V1_FEIGN)
    Set<NCM> findAllNCMV1();

    @RequestLine(BrasilAPI.FIND_ALL_NCM_BY_CODE_OR_DESCRIPTION_V1_FEIGN)
    Set<NCM> findAllNCMByCodeOrDescriptionV1(@Param("value") final String value);

    @RequestLine(BrasilAPI.FIND_NCM_BY_CODE_V1_FEIGN)
    NCM findNCMByCodeV1(@Param("code") final String code);

}
