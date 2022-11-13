package br.com.sawcunha.brasilapiintegration.core.feign.service;

import br.com.sawcunha.brasilapiintegration.core.enums.ProvidersISBN;
import br.com.sawcunha.brasilapiintegration.core.feign.api.ISBNAPI;
import br.com.sawcunha.brasilapiintegration.core.model.isbn.ISBN;
import br.com.sawcunha.brasilapiintegration.core.specification.ISBNService;
import lombok.NonNull;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class ISBNServiceBean extends ServiceBean<ISBNAPI> implements ISBNService {

    private static ISBNServiceBean isbnServiceBean;
    private static final String PROVIDERS_QUERY = "providers";

    public static ISBNServiceBean instance(@NonNull String uri){
        if(Objects.isNull(isbnServiceBean))
            isbnServiceBean = new ISBNServiceBean(uri);

        return isbnServiceBean;
    }

    public ISBNServiceBean(@NonNull String uri) {
        super(uri, ISBNAPI.class);
    }

    @Override
    public ISBN findISBNByCodeV1(@NonNull String code, ProvidersISBN... providersISBN) {
        Map<String, String> query = createQuery(providersISBN);
        return brasilAPI.findISBNByCodeV1(code, query);
    }

    private Map<String, String> createQuery(final ProvidersISBN... providersISBN){
        Map<String, String> query = new HashMap<>();

        if(Objects.nonNull(providersISBN) && providersISBN.length > 0){
            String values = Arrays.stream(providersISBN)
                    .map(ProvidersISBN::getProvider)
                    .collect(Collectors.joining(","));
            query.put(PROVIDERS_QUERY, values);
        }

        return query;
    }
}
