package br.com.sawcunha.brasilapiintegration.core.specification;

import br.com.sawcunha.brasilapiintegration.core.model.cnpj.JuridicalPerson;

public interface JuridicalPersonService {

    JuridicalPerson findCnpjByCnpjV1(final String cnpj);

}
