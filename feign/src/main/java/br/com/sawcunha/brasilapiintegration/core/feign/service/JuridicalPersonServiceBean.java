package br.com.sawcunha.brasilapiintegration.core.feign.service;

import br.com.sawcunha.brasilapiintegration.core.feign.api.CNPJAPI;
import br.com.sawcunha.brasilapiintegration.core.model.cnpj.JuridicalPerson;
import br.com.sawcunha.brasilapiintegration.core.specification.JuridicalPersonService;
import br.com.sawcunha.brasilapiintegration.core.util.TaxIdentiferUtil;
import lombok.NonNull;

import java.util.Objects;

public class JuridicalPersonServiceBean extends ServiceBean<CNPJAPI> implements JuridicalPersonService {

    private static JuridicalPersonServiceBean juridicalPersonServiceBean;

    public static JuridicalPersonServiceBean instance(@NonNull final String uri){
        if(Objects.isNull(juridicalPersonServiceBean))
            juridicalPersonServiceBean = new JuridicalPersonServiceBean(uri);

        return juridicalPersonServiceBean;
    }

    private JuridicalPersonServiceBean(@NonNull final String uri) {
        super(uri, CNPJAPI.class);
    }

    @Override
    public JuridicalPerson findCnpjByCnpjV1(@NonNull final String cnpj) {
        String cnpjValid = TaxIdentiferUtil.formatCNPJ(cnpj);
        return brasilAPI.findJuridicalPersonByCnpjV1(cnpjValid);
    }
}
