package br.com.sawcunha.brasilapiintegration.core.specification;

import br.com.sawcunha.brasilapiintegration.core.enums.ProvidersISBN;
import br.com.sawcunha.brasilapiintegration.core.model.isbn.ISBN;
import lombok.NonNull;

public interface ISBNService {

    ISBN findISBNByCodeV1(@NonNull final String code, ProvidersISBN... providersISBN);


}
