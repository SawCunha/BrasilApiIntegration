package br.com.sawcunha.brasilapiintegration.spring.api;

import br.com.sawcunha.brasilapiintegration.core.constant.BrasilAPI;
import br.com.sawcunha.brasilapiintegration.core.model.fipe.Fipe;
import br.com.sawcunha.brasilapiintegration.core.model.fipe.FipeTable;
import br.com.sawcunha.brasilapiintegration.spring.configuration.BrasilAPIConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;
import java.util.Set;

@FeignClient(value = "brasilapi-fipe", url = "${brasilapi.url}", configuration = BrasilAPIConfiguration.class)
public interface FipeAPI {

    @RequestMapping(method = RequestMethod.GET, value = BrasilAPI.FIND_ALL_FIPE_BY_VEHICLE_TYPE_V1_URL)
    Set<Fipe> findAllFipeByVehicleTypeV1(@PathVariable("vehicleType") final String vehicleType, @RequestParam final Map<String, String> queries);

    @RequestMapping(method = RequestMethod.GET, value = BrasilAPI.FIND_ALL_FIPE_PRICE_BY_VEHICLE_CODE_V1_URL)
    Set<Fipe> findAllFipePriceByVehicleCodeV1(@PathVariable("vehicleCode") final String vehicleCode, @RequestParam final Map<String, String> queries);

    @RequestMapping(method = RequestMethod.GET, value = BrasilAPI.FIND_ALL_FIPE_TABLE_V1_URL)
    Set<FipeTable> findAllFipeTableV1();
}
