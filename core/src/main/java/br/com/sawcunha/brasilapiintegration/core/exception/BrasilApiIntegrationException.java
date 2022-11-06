package br.com.sawcunha.brasilapiintegration.core.exception;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Builder
@Getter
@RequiredArgsConstructor
public class BrasilApiIntegrationException extends RuntimeException {
    private final Object dataAPI;
    private final int statusAPI;
    private final Class dataClass;
}
