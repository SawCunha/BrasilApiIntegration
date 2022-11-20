package br.com.sawcunha.brasilapispring.configuration;

import br.com.sawcunha.brasilapiintegration.core.exception.BrasilApiIntegrationException;
import br.com.sawcunha.brasilapiintegration.core.model.error.BrasilAPIError;
import br.com.sawcunha.brasilapispring.dto.BrasilAPIDTO;
import br.com.sawcunha.brasilapispring.dto.BrasilAPIErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionsHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(BrasilApiIntegrationException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    protected BrasilAPIErrorDTO<BrasilAPIError> handleSecurity(BrasilApiIntegrationException exception){
        return BrasilAPIErrorDTO.<BrasilAPIError>builder()
                .dataError(exception.getBrasilAPIError())
                .message(exception.getMessage())
                .statusAPI(exception.getStatusAPI())
                .build();
    }

}
