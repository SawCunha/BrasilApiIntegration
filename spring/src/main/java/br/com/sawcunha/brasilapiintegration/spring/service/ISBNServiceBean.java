package br.com.sawcunha.brasilapiintegration.spring.service;

import br.com.sawcunha.brasilapiintegration.core.enums.ProvidersISBN;
import br.com.sawcunha.brasilapiintegration.core.model.isbn.ISBN;
import br.com.sawcunha.brasilapiintegration.core.specification.ISBNService;
import br.com.sawcunha.brasilapiintegration.spring.api.ISBNAPI;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@Log4j
@RequiredArgsConstructor
public class ISBNServiceBean implements ISBNService {

    private static final String PROVIDERS_QUERY = "providers";

    private final ISBNAPI isbnapi;

    @Override
    public ISBN findISBNByCodeV1(@NonNull String code, ProvidersISBN... providersISBN) {
        Map<String, String> query = createQuery(providersISBN);
        return isbnapi.findISBNByCodeV1(code, query);
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
