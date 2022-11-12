package br.com.sawcunha.brasilapiintegration.core.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ProvidersIBGE {

    DADOS_ABERTOS_BR("dados-abertos-br"),
    GOV("gov"),
    WIKIPEDIA("wikipedia");

    private final String provider;

}
