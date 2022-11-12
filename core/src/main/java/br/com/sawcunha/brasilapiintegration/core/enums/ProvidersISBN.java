package br.com.sawcunha.brasilapiintegration.core.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ProvidersISBN {

    CBL("cbl"),
    MERCADO_EDITORIAL("mercado-editorial"),
    OPEN_LIBRARY("open-library"),
    GOOGLE_BOOKS("google-books");

    private final String provider;

}
