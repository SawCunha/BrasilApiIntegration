package br.com.sawcunha.brasilapiintegration.core.feign.configuration.decoder;

import br.com.sawcunha.brasilapiintegration.core.exception.BrasilApiIntegrationException;
import br.com.sawcunha.brasilapiintegration.core.feign.configuration.GsonConfiguration;
import br.com.sawcunha.brasilapiintegration.core.model.error.BrasilAPIError;
import feign.Response;
import feign.codec.ErrorDecoder;
import kotlin.text.Charsets;
import lombok.extern.log4j.Log4j2;

import java.io.IOException;
import java.io.Reader;
import java.util.Objects;

@Log4j2
public class BrasilAPIErrorDecoder implements ErrorDecoder {

    private static BrasilAPIErrorDecoder brasilAPIErrorDecoder;

    public static BrasilAPIErrorDecoder getInstance() {
        if(Objects.isNull(brasilAPIErrorDecoder)) brasilAPIErrorDecoder = new BrasilAPIErrorDecoder();
        return brasilAPIErrorDecoder;
    }

    private BrasilApiIntegrationException createBrasilApiIntegrationException(Response response){

        int status = response.status();
        BrasilAPIError message;
        Reader reader = null;

        try {
            reader = response.body().asReader(Charsets.UTF_8);
            message = GsonConfiguration.gsonInstance().fromJson(reader, BrasilAPIError.class);
        } catch (Exception e) {
            log.error("Error decode return API:", e);
            message = null;
        }finally {
            try {
                if (reader != null)
                    reader.close();
            } catch (IOException e) {
                log.error("Error close Reader:", e);
            }
        }

        return BrasilApiIntegrationException.builder()
                .brasilAPIError(message)
                .statusAPI(status)
                .build();
    }

    @Override
    public Exception decode(String s, Response response) {
        log.debug("Decode Bank");
        return createBrasilApiIntegrationException(response);
    }
}
