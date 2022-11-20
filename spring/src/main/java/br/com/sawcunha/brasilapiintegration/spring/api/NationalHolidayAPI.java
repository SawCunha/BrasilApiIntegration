package br.com.sawcunha.brasilapiintegration.spring.api;

import br.com.sawcunha.brasilapiintegration.core.constant.BrasilAPI;
import br.com.sawcunha.brasilapiintegration.core.model.nationalholiday.NationalHoliday;
import br.com.sawcunha.brasilapiintegration.spring.configuration.BrasilAPIConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Set;

@FeignClient(value = "brasilapi-feriadonacional", url = "${brasilapi.url}", configuration = BrasilAPIConfiguration.class)
public interface NationalHolidayAPI {

    @RequestMapping(method = RequestMethod.GET, value = BrasilAPI.FIND_ALL_NATIONAL_HOLIDAY_BY_YEAR_V1_URL)
    Set<NationalHoliday> findAllNationalHolidayByYearV1(@PathVariable("year") final Integer year);

}
