package br.com.sawcunha.brasilapiintegration.spring.service;

import br.com.sawcunha.brasilapiintegration.core.enums.VehicleType;
import br.com.sawcunha.brasilapiintegration.core.model.fipe.Fipe;
import br.com.sawcunha.brasilapiintegration.core.model.fipe.FipeTable;
import br.com.sawcunha.brasilapiintegration.core.specification.FipeService;
import br.com.sawcunha.brasilapiintegration.spring.api.FipeAPI;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

@Service
@Log4j
@RequiredArgsConstructor
public class FipeServiceBean implements FipeService {

    private static final String REFERENCE_TABLE_QUERY = "tabela_referencia";

    private final FipeAPI fipeAPI;

    @Override
    public Set<Fipe> findAllFipeByVehicleTypeV1(@NonNull VehicleType vehicleType, String referenceTableFipe) {
        Map<String, String> query = createQuery(referenceTableFipe);
        return fipeAPI.findAllFipeByVehicleTypeV1(vehicleType.getType(), query);
    }

    @Override
    public Set<Fipe> findAllFipePriceByVehicleCodeV1(@NonNull String vehicleCode, String referenceTableFipe) {
        Map<String, String> query = createQuery(referenceTableFipe);
        return fipeAPI.findAllFipePriceByVehicleCodeV1(vehicleCode, query);
    }

    @Override
    public Set<FipeTable> findAllFipeTableV1() {
        return fipeAPI.findAllFipeTableV1();
    }

    private Map<String, String> createQuery(final String referenceTableFipe){
        Map<String, String> query = new HashMap<>();

        if(Objects.nonNull(referenceTableFipe)) query.put(REFERENCE_TABLE_QUERY ,referenceTableFipe);

        return query;
    }
}
