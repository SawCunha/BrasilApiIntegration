package br.com.sawcunha.brasilapiintegration.core.specification;

import br.com.sawcunha.brasilapiintegration.core.model.cnpj.Cnpj;

public interface CnpjService {

    Cnpj findCnpjByCnpj(final String cnpj);

}
