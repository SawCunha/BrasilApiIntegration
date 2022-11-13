package br.com.sawcunha.brasilapiintegration.core.feign.api;

import br.com.sawcunha.brasilapiintegration.core.constant.BrasilAPI;
import br.com.sawcunha.brasilapiintegration.core.model.nationalholiday.NationalHoliday;
import feign.Param;
import feign.RequestLine;

import java.util.Set;

public interface NationalHolidayAPI {

    @RequestLine(BrasilAPI.FIND_ALL_NATIONAL_HOLIDAY_BY_YEAR_V1_FEIGN)
    Set<NationalHoliday> findAllNationalHolidayByYearV1(@Param("year") final Integer year);

}
