package br.com.sawcunha.brasilapiintegration.spring.service;

import br.com.sawcunha.brasilapiintegration.core.model.cnpj.JuridicalPerson;
import br.com.sawcunha.brasilapiintegration.core.specification.JuridicalPersonService;
import br.com.sawcunha.brasilapiintegration.core.util.TaxIdentiferUtil;
import br.com.sawcunha.brasilapiintegration.spring.api.CNPJAPI;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Service;

@Service
@Log4j
@RequiredArgsConstructor
public class JuridicalPersonServiceBean implements JuridicalPersonService {

    private final CNPJAPI cnpjapi;

    @Override
    public JuridicalPerson findCnpjByCnpjV1(@NonNull final String cnpj) {
        String cnpjValid = TaxIdentiferUtil.formatCNPJ(cnpj);
        return cnpjapi.findJuridicalPersonByCnpjV1(cnpjValid);
    }
}
