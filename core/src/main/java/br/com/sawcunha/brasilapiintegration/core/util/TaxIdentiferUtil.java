package br.com.sawcunha.brasilapiintegration.core.util;

import br.com.sawcunha.brasilapiintegration.core.exception.BrasilApiIntegrationException;
import lombok.NonNull;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaxIdentiferUtil {

    private static final String REGEX_CNPJ = "([0-9]{2}[0-9]{3}[0-9]{3}[0-9]{4}[0-9]{2})";
    private static final Pattern CNPJ_PATTERN = Pattern.compile(REGEX_CNPJ);

    public static String formatCNPJ(@NonNull final String cnpj){
        String cnpjDigit = StringFormatUtil.removeAllWord(cnpj);
        Matcher cnpjMatcher = CNPJ_PATTERN.matcher(cnpjDigit);

        if(!cnpjMatcher.matches()){
            throw new BrasilApiIntegrationException("Invalid CNPJ");
        }
        return cnpjDigit;
    }

}
