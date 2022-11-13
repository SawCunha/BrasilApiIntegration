package br.com.sawcunha.brasilapiintegration.core.feign.service;

import br.com.sawcunha.brasilapiintegration.core.feign.api.NationalHolidayAPI;
import br.com.sawcunha.brasilapiintegration.core.model.nationalholiday.NationalHoliday;
import br.com.sawcunha.brasilapiintegration.core.specification.NatinalHolidayService;
import lombok.NonNull;

import java.util.Objects;
import java.util.Set;

public class NatinalHolidayServiceBean extends ServiceBean<NationalHolidayAPI> implements NatinalHolidayService {

    private static NatinalHolidayServiceBean natinalHolidayServiceBean;

    public static NatinalHolidayServiceBean instance(@NonNull String uri){
        if(Objects.isNull(natinalHolidayServiceBean))
            natinalHolidayServiceBean = new NatinalHolidayServiceBean(uri);

        return natinalHolidayServiceBean;
    }

    public NatinalHolidayServiceBean(@NonNull String uri) {
        super(uri, NationalHolidayAPI.class);
    }

    @Override
    public Set<NationalHoliday> findAllNationalHolidayByYearV1(@NonNull Integer year) {
        return brasilAPI.findAllNationalHolidayByYearV1(year);
    }
}
