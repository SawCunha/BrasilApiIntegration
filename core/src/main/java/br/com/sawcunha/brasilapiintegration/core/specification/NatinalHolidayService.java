package br.com.sawcunha.brasilapiintegration.core.specification;

import br.com.sawcunha.brasilapiintegration.core.model.nationalholiday.NationalHoliday;
import lombok.NonNull;

import java.util.Set;

public interface NatinalHolidayService {

    Set<NationalHoliday> findAllNationalHolidayByYearV1(@NonNull final Integer year);
}
