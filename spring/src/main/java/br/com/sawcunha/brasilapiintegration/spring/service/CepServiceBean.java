package br.com.sawcunha.brasilapiintegration.spring.service;

import br.com.sawcunha.brasilapiintegration.core.model.cep.Cep;
import br.com.sawcunha.brasilapiintegration.core.specification.CepService;
import br.com.sawcunha.brasilapiintegration.core.util.CepUtil;
import br.com.sawcunha.brasilapiintegration.spring.api.CepAPI;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Service;

@Service
@Log4j
@RequiredArgsConstructor
public class CepServiceBean implements CepService {

    private final CepAPI cepAPI;

    @Override
    public Cep findCEPByCEPV1(final String cep) {
        String cepValid = CepUtil.formatCEP(cep);
        return cepAPI.findByCepV1(cepValid);
    }

    @Override
    public Cep findCEPByCEPV2(final String cep) {
        String cepValid = CepUtil.formatCEP(cep);
        return cepAPI.findByCepV2(cepValid);
    }
}
