package br.com.sawcunha.brasilapiintegration.core.feign.service;

import br.com.sawcunha.brasilapiintegration.core.feign.api.CepAPI;
import br.com.sawcunha.brasilapiintegration.core.model.cep.Cep;
import br.com.sawcunha.brasilapiintegration.core.specification.CepService;
import br.com.sawcunha.brasilapiintegration.core.util.CepUtil;
import lombok.NonNull;

import java.util.Objects;

public class CepServiceBean extends ServiceBean<CepAPI> implements CepService {

    private static CepServiceBean cepServiceBean;

    public static CepServiceBean instance(@NonNull String uri){
        if(Objects.isNull(cepServiceBean))
            cepServiceBean = new CepServiceBean(uri);

        return cepServiceBean;
    }

    private CepServiceBean(@NonNull String uri) {
        super(uri, CepAPI.class);
    }

    @Override
    public Cep findCEPByCEPV1(final String cep) {
        String cepValid = CepUtil.formatCEP(cep);
        return brasilAPI.findByCepV1(cepValid);
    }

    @Override
    public Cep findCEPByCEPV2(final String cep) {
        String cepValid = CepUtil.formatCEP(cep);
        return brasilAPI.findByCepV2(cepValid);
    }
}
