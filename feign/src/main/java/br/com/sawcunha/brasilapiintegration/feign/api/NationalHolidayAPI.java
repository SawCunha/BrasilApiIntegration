package br.com.sawcunha.brasilapiintegration.feign.api;

import br.com.sawcunha.brasilapiintegration.core.constant.BrasilAPI;
import br.com.sawcunha.brasilapiintegration.core.model.nationalholiday.NationalHoliday;
import feign.Headers;
import feign.Param;
import feign.RequestLine;

import java.util.Set;

@Headers(BrasilAPI.USER_AGENT_FEIGN)
public interface NationalHolidayAPI {

    @RequestLine(BrasilAPI.FIND_ALL_NATIONAL_HOLIDAY_BY_YEAR_V1_FEIGN)
    Set<NationalHoliday> findAllNationalHolidayByYearV1(@Param("year") final Integer year);

}
