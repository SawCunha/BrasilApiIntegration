package br.com.sawcunha.brasilapiintegration.spring.service;

import br.com.sawcunha.brasilapiintegration.core.model.ncm.NCM;
import br.com.sawcunha.brasilapiintegration.core.specification.NCMService;
import br.com.sawcunha.brasilapiintegration.spring.api.NCMAPI;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Log4j
@RequiredArgsConstructor
public class NCMServiceBean implements NCMService {

    private final NCMAPI ncmapi;

    @Override
    public Set<NCM> findAllNCMV1() {
        return ncmapi.findAllNCMV1();
    }

    @Override
    public Set<NCM> findAllNCMByCodeOrDescriptionV1(@NonNull String value) {
        return ncmapi.findAllNCMByCodeOrDescriptionV1(value);
    }

    @Override
    public NCM findNCMByCodeV1(@NonNull String code) {
        return ncmapi.findNCMByCodeV1(code);
    }
}
