package br.com.sawcunha.brasilapiintegration.spring.service;

import br.com.sawcunha.brasilapiintegration.core.model.registrobr.Registro;
import br.com.sawcunha.brasilapiintegration.core.specification.RegistroBRService;
import br.com.sawcunha.brasilapiintegration.spring.api.RegistroBRAPI;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Service;

@Service
@Log4j
@RequiredArgsConstructor
public class RegistroBRServiceBean implements RegistroBRService {

    private final RegistroBRAPI registroBRAPI;

    @Override
    public Registro findRegistroByDomainV1(@NonNull String domain) {
        return registroBRAPI.findRegistroByDomainV1(domain);
    }
}
