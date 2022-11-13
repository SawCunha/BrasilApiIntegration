package br.com.sawcunha.brasilapiintegration.core.specification;

import br.com.sawcunha.brasilapiintegration.core.enums.VehicleType;
import br.com.sawcunha.brasilapiintegration.core.model.fipe.Fipe;
import br.com.sawcunha.brasilapiintegration.core.model.fipe.FipeTable;
import lombok.NonNull;

import java.util.Set;

public interface FipeService {

    Set<Fipe> findAllFipeByVehicleTypeV1(@NonNull final VehicleType vehicleType, final String referenceTableFipe);
    Set<Fipe> findAllFipePriceByVehicleCodeV1(@NonNull final String vehicleCode, final String referenceTableFipe);
    Set<FipeTable> findAllFipeTableV1();


}
