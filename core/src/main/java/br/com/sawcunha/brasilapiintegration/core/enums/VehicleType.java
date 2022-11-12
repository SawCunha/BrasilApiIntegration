package br.com.sawcunha.brasilapiintegration.core.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum VehicleType {

    CAMINHOES("caminhoes"),
    CARROS("carros"),
    MOTOS("motos");

    private final String type;

}
