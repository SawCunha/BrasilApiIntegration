package br.com.sawcunha.brasilapiintegration.core.model.nationalholiday;

import br.com.sawcunha.brasilapiintegration.core.model.Base;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NationalHoliday extends Base {

    private LocalDate date;
    private String name;
    private String type;

}
