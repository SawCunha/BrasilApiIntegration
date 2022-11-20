package br.com.sawcunha.brasilapiintegration.core.feign.service;

import br.com.sawcunha.brasilapiintegration.core.feign.api.NationalHolidayAPI;
import br.com.sawcunha.brasilapiintegration.core.feign.specification.BrasilAPIFeign;
import br.com.sawcunha.brasilapiintegration.core.model.nationalholiday.NationalHoliday;
import br.com.sawcunha.brasilapiintegration.core.specification.NatinalHolidayService;
import lombok.NonNull;

import java.util.Set;

public class NatinalHolidayServiceBean extends ServiceBean<NationalHolidayAPI> implements NatinalHolidayService {

    public NatinalHolidayServiceBean(@NonNull BrasilAPIFeign brasilAPIFeign, @NonNull String uri) {
        super(brasilAPIFeign, uri, NationalHolidayAPI.class);
    }

    @Override
    public Set<NationalHoliday> findAllNationalHolidayByYearV1(@NonNull Integer year) {
        return brasilAPI.findAllNationalHolidayByYearV1(year);
    }
}
