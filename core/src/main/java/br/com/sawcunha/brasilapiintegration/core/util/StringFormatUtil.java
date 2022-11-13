package br.com.sawcunha.brasilapiintegration.core.util;

import lombok.NonNull;

public class StringFormatUtil {

    public static String removeAllWord(@NonNull final String value){
        return value.replaceAll("(\\D)", "");
    }

}
