package br.com.sawcunha.brasilapiintegration.core.specification;

import br.com.sawcunha.brasilapiintegration.core.model.rate.Rate;
import lombok.NonNull;

import java.util.Set;

public interface RateService {

    Set<Rate> findAllRates();
    Rate findRateByAcronym(@NonNull final String acronym);

}
