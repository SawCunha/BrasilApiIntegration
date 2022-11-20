package br.com.sawcunha.brasilapiintegration.core.feign.service;

import br.com.sawcunha.brasilapiintegration.core.feign.api.CNPJAPI;
import br.com.sawcunha.brasilapiintegration.core.feign.specification.BrasilAPIFeign;
import br.com.sawcunha.brasilapiintegration.core.model.cnpj.JuridicalPerson;
import br.com.sawcunha.brasilapiintegration.core.specification.JuridicalPersonService;
import br.com.sawcunha.brasilapiintegration.core.util.TaxIdentiferUtil;
import lombok.NonNull;

public class JuridicalPersonServiceBean extends ServiceBean<CNPJAPI> implements JuridicalPersonService {

    public JuridicalPersonServiceBean(@NonNull BrasilAPIFeign brasilAPIFeign, @NonNull final String uri) {
        super(brasilAPIFeign, uri, CNPJAPI.class);
    }

    @Override
    public JuridicalPerson findCnpjByCnpjV1(@NonNull final String cnpj) {
        String cnpjValid = TaxIdentiferUtil.formatCNPJ(cnpj);
        return brasilAPI.findJuridicalPersonByCnpjV1(cnpjValid);
    }
}
