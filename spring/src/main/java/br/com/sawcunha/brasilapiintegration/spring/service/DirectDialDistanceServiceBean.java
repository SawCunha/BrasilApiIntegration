package br.com.sawcunha.brasilapiintegration.spring.service;

import br.com.sawcunha.brasilapiintegration.core.model.ddd.DirectDialDistance;
import br.com.sawcunha.brasilapiintegration.core.specification.DirectDialDistanceService;
import br.com.sawcunha.brasilapiintegration.spring.api.DirectDialDistanceAPI;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Service;

@Service
@Log4j
@RequiredArgsConstructor
public class DirectDialDistanceServiceBean implements DirectDialDistanceService {

    private final DirectDialDistanceAPI directDialDistanceAPI;

    @Override
    public DirectDialDistance findDirectDialDistanceByCodeV1(@NonNull String code) {
        return directDialDistanceAPI.findDirectDialDistanceByCodeV1(code);
    }
}
