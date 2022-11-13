package br.com.sawcunha.brasilapiintegration.core.exception;

import br.com.sawcunha.brasilapiintegration.core.model.error.BrasilAPIError;
import lombok.Getter;

@Getter
public class BrasilApiIntegrationException extends RuntimeException {
    private final BrasilAPIError brasilAPIError;
    private final int statusAPI;
    private final String message;

    public BrasilApiIntegrationException(final BrasilAPIError brasilAPIError, final int statusAPI) {
        this.brasilAPIError = brasilAPIError;
        this.statusAPI = statusAPI;
        this.message = null;
    }

    public BrasilApiIntegrationException(final String message, final BrasilAPIError brasilAPIError, final int statusAPI) {
        super(message);
        this.brasilAPIError = brasilAPIError;
        this.statusAPI = statusAPI;
        this.message = message;
    }

    public BrasilApiIntegrationException(final String message) {
        super(message);
        this.brasilAPIError = null;
        this.statusAPI = 0;
        this.message = message;
    }
}
