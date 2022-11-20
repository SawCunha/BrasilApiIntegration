package br.com.sawcunha.brasilapiintegration.core.feign.service;

import br.com.sawcunha.brasilapiintegration.core.enums.VehicleType;
import br.com.sawcunha.brasilapiintegration.core.feign.api.FipeAPI;
import br.com.sawcunha.brasilapiintegration.core.feign.specification.BrasilAPIFeign;
import br.com.sawcunha.brasilapiintegration.core.model.fipe.Fipe;
import br.com.sawcunha.brasilapiintegration.core.model.fipe.FipeTable;
import br.com.sawcunha.brasilapiintegration.core.specification.FipeService;
import lombok.NonNull;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class FipeServiceBean extends ServiceBean<FipeAPI> implements FipeService {

    private static final String REFERENCE_TABLE_QUERY = "tabela_referencia";

    public FipeServiceBean(@NonNull BrasilAPIFeign brasilAPIFeign, @NonNull String uri) {
        super(brasilAPIFeign, uri, FipeAPI.class);
    }

    @Override
    public Set<Fipe> findAllFipeByVehicleTypeV1(@NonNull VehicleType vehicleType, String referenceTableFipe) {
        Map<String, String> query = createQuery(referenceTableFipe);
        return brasilAPI.findAllFipeByVehicleTypeV1(vehicleType.getType(), query);
    }

    @Override
    public Set<Fipe> findAllFipePriceByVehicleCodeV1(@NonNull String vehicleCode, String referenceTableFipe) {
        Map<String, String> query = createQuery(referenceTableFipe);
        return brasilAPI.findAllFipePriceByVehicleCodeV1(vehicleCode, query);
    }

    @Override
    public Set<FipeTable> findAllFipeTableV1() {
        return brasilAPI.findAllFipeTableV1();
    }

    private Map<String, String> createQuery(final String referenceTableFipe){
        Map<String, String> query = new HashMap<>();

        if(Objects.nonNull(referenceTableFipe)) query.put(REFERENCE_TABLE_QUERY ,referenceTableFipe);

        return query;
    }
}
