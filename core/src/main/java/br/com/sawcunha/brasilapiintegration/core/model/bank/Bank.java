package br.com.sawcunha.brasilapiintegration.core.model.bank;

import br.com.sawcunha.brasilapiintegration.core.model.Base;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Bank extends Base {
    private String ispb;
    private String name;
    private Integer code;
    private String fullName;
}
