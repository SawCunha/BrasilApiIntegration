package br.com.sawcunha.brasilapiintegration.core.feign.api;

import br.com.sawcunha.brasilapiintegration.core.model.nationalholiday.NationalHoliday;
import feign.Param;
import feign.RequestLine;

public interface NationalHolidayAPI {

    @RequestLine("GET /feriados/v1/{year}")
    NationalHoliday findByYearV1(@Param("year") final Integer year);

}
