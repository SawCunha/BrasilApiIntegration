package br.com.sawcunha.brasilapiintegration.spring.service;

import br.com.sawcunha.brasilapiintegration.core.enums.ProvidersIBGE;
import br.com.sawcunha.brasilapiintegration.core.model.ibge.IBGE;
import br.com.sawcunha.brasilapiintegration.core.specification.IBGEService;
import br.com.sawcunha.brasilapiintegration.spring.api.IBGEAPI;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Log4j
@RequiredArgsConstructor
public class IBGEServiceBean implements IBGEService {
    private static final String PROVIDERS_QUERY = "providers";

    private final IBGEAPI ibgeapi;

    @Override
    public Set<IBGE> findAllMunicipalitiesByAcronymUFV1(@NonNull String acronymUF, ProvidersIBGE... providersIBGE) {
        Map<String, String> query = createQuery(providersIBGE);
        return ibgeapi.findAllCountiesByUFV1(acronymUF, query);
    }

    @Override
    public Set<IBGE> findAllIBGEV1() {
        return ibgeapi.findAllStateByUFV1();
    }

    @Override
    public IBGE findAllIBGEByAcronymUFOrCodeV1(@NonNull String code) {
        return ibgeapi.findStateByCodeV1(code);
    }

    private Map<String, String> createQuery(final ProvidersIBGE... providersIBGE){
        Map<String, String> query = new HashMap<>();

        if(Objects.nonNull(providersIBGE) && providersIBGE.length > 0){
            String values = Arrays.stream(providersIBGE)
                    .map(ProvidersIBGE::getProvider)
                    .collect(Collectors.joining(","));
            query.put(PROVIDERS_QUERY, values);
        }

        return query;
    }
}
