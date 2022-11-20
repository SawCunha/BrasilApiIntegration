package br.com.sawcunha.brasilapiintegration.feign.service;

import br.com.sawcunha.brasilapiintegration.feign.api.CepAPI;
import br.com.sawcunha.brasilapiintegration.feign.specification.BrasilAPIFeign;
import br.com.sawcunha.brasilapiintegration.core.model.cep.Cep;
import br.com.sawcunha.brasilapiintegration.core.specification.CepService;
import br.com.sawcunha.brasilapiintegration.core.util.CepUtil;
import lombok.NonNull;

public class CepServiceBean extends ServiceBean<CepAPI> implements CepService {

    public CepServiceBean(@NonNull BrasilAPIFeign brasilAPIFeign, @NonNull String uri) {
        super(brasilAPIFeign, uri, CepAPI.class);
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
