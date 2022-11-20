package br.com.sawcunha.brasilapiintegration.spring.service;

import br.com.sawcunha.brasilapiintegration.core.model.nationalholiday.NationalHoliday;
import br.com.sawcunha.brasilapiintegration.core.specification.NatinalHolidayService;
import br.com.sawcunha.brasilapiintegration.spring.api.NationalHolidayAPI;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Log4j
@RequiredArgsConstructor
public class NatinalHolidayServiceBean implements NatinalHolidayService {

    private final NationalHolidayAPI nationalHolidayAPI;

    @Override
    public Set<NationalHoliday> findAllNationalHolidayByYearV1(@NonNull Integer year) {
        return nationalHolidayAPI.findAllNationalHolidayByYearV1(year);
    }
}
