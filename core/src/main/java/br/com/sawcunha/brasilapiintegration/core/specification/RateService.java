package br.com.sawcunha.brasilapiintegration.core.specification;

import br.com.sawcunha.brasilapiintegration.core.model.rate.Rate;
import lombok.NonNull;

import java.util.Set;

public interface RateService {

    Set<Rate> findAllRatesV1();
    Rate findRateByAcronymV1(@NonNull final String acronym);

}
