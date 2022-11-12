package br.com.sawcunha.brasilapiintegration.core.feign.api;

import br.com.sawcunha.brasilapiintegration.core.model.fipe.Fipe;
import br.com.sawcunha.brasilapiintegration.core.model.fipe.FipeTable;
import feign.Param;
import feign.QueryMap;
import feign.RequestLine;

import java.util.Map;
import java.util.Set;

public interface FipeAPI {

    @RequestLine("GET /fipe/marcas/v1/{vehicleType}")
    Set<Fipe> findAllFipeByVehickeTypeV1(@Param("vehicleType") final String vehicleType, @QueryMap final Map<String, String> queries);

    @RequestLine("GET /fipe/preco/v1/{vehicleType}")
    Set<Fipe> findAllFipePriceByVehickeTypeV1(@Param("vehicleType") final String vehicleType, @QueryMap final Map<String, String> queries);

    @RequestLine("GET /fipe/tabelas/v1")
    Set<FipeTable> findAllFipeTableV1();
}
