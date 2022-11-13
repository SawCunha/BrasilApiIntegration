package br.com.sawcunha.brasilapiintegration.core.util;

import br.com.sawcunha.brasilapiintegration.core.exception.BrasilApiIntegrationException;
import lombok.NonNull;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CepUtil {

    private static final String ERROR_MESSAGE = "Invalid CEP";

    private static final String REGEX_CEP = "^([\\d]{2})([\\d]{3})([\\d]{3})";
    private static final Pattern CEP_PATTERN = Pattern.compile(REGEX_CEP);

    public static String formatCEP(@NonNull final String cep){
        String cepDigit = StringFormatUtil.removeAllWord(cep);
        Matcher cepMatcher = CEP_PATTERN.matcher(cepDigit);

        if(!cepMatcher.matches()){
            throw new BrasilApiIntegrationException(ERROR_MESSAGE);
        }
        return cepDigit;
    }
}
