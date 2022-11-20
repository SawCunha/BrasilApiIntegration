package br.com.sawcunha.brasilapiintegration.feign.service;

import br.com.sawcunha.brasilapiintegration.core.enums.ProvidersIBGE;
import br.com.sawcunha.brasilapiintegration.feign.api.IBGEAPI;
import br.com.sawcunha.brasilapiintegration.feign.specification.BrasilAPIFeign;
import br.com.sawcunha.brasilapiintegration.core.model.ibge.IBGE;
import br.com.sawcunha.brasilapiintegration.core.specification.IBGEService;
import lombok.NonNull;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class IBGEServiceBean extends ServiceBean<IBGEAPI> implements IBGEService {
    private static final String PROVIDERS_QUERY = "providers";

    public IBGEServiceBean(@NonNull BrasilAPIFeign brasilAPIFeign, @NonNull String uri) {
        super(brasilAPIFeign, uri, IBGEAPI.class);
    }

    @Override
    public Set<IBGE> findAllMunicipalitiesByAcronymUFV1(@NonNull String acronymUF, ProvidersIBGE... providersIBGE) {
        Map<String, String> query = createQuery(providersIBGE);
        return brasilAPI.findAllCountiesByUFV1(acronymUF, query);
    }

    @Override
    public Set<IBGE> findAllIBGEV1() {
        return brasilAPI.findAllStateByUFV1();
    }

    @Override
    public IBGE findAllIBGEByAcronymUFOrCodeV1(@NonNull String code) {
        return brasilAPI.findStateByCodeV1(code);
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
