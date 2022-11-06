package br.com.sawcunha.brasilapiintegration.core.exception;

import br.com.sawcunha.brasilapiintegration.core.model.error.BrasilAPIError;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Builder
@Getter
@RequiredArgsConstructor
public class BrasilApiIntegrationException extends RuntimeException {
    private final BrasilAPIError brasilAPIError;
    private final int statusAPI;
}
