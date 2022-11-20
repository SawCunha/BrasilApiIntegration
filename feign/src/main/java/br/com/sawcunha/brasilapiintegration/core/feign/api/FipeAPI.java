package br.com.sawcunha.brasilapiintegration.core.feign.api;

import br.com.sawcunha.brasilapiintegration.core.constant.BrasilAPI;
import br.com.sawcunha.brasilapiintegration.core.model.fipe.Fipe;
import br.com.sawcunha.brasilapiintegration.core.model.fipe.FipeTable;
import feign.Headers;
import feign.Param;
import feign.QueryMap;
import feign.RequestLine;

import java.util.Map;
import java.util.Set;

@Headers(BrasilAPI.USER_AGENT_FEIGN)
public interface FipeAPI {

    @RequestLine(BrasilAPI.FIND_ALL_FIPE_BY_VEHICLE_TYPE_V1_FEIGN)
    Set<Fipe> findAllFipeByVehicleTypeV1(@Param("vehicleType") final String vehicleType, @QueryMap final Map<String, String> queries);

    @RequestLine(BrasilAPI.FIND_ALL_FIPE_PRICE_BY_VEHICLE_CODE_V1_FEIGN)
    Set<Fipe> findAllFipePriceByVehicleCodeV1(@Param("vehicleCode") final String vehicleCode, @QueryMap final Map<String, String> queries);

    @RequestLine(BrasilAPI.FIND_ALL_FIPE_TABLE_V1_FEIGN)
    Set<FipeTable> findAllFipeTableV1();
}
