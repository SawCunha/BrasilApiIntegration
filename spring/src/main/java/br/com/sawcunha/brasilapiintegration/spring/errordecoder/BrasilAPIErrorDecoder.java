package br.com.sawcunha.brasilapiintegration.spring.errordecoder;

import br.com.sawcunha.brasilapiintegration.core.exception.BrasilApiIntegrationException;
import br.com.sawcunha.brasilapiintegration.core.model.error.BrasilAPIError;
import com.google.gson.Gson;
import feign.Response;
import feign.codec.ErrorDecoder;
import lombok.extern.log4j.Log4j;

import java.io.IOException;
import java.io.Reader;
import java.nio.charset.StandardCharsets;

@Log4j
public class BrasilAPIErrorDecoder implements ErrorDecoder {

    private final Gson gson;

    public BrasilAPIErrorDecoder() {
        this.gson = new Gson();
    }

    private BrasilApiIntegrationException createBrasilApiIntegrationException(Response response){

        int status = response.status();
        BrasilAPIError message;
        Reader reader = null;

        try {
            reader = response.body().asReader(StandardCharsets.UTF_8);
            message = gson.fromJson(reader, BrasilAPIError.class);
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

        return new BrasilApiIntegrationException(message, status);
    }

    @Override
    public Exception decode(String s, Response response) {
        log.debug("Decode Bank");
        return createBrasilApiIntegrationException(response);
    }
}
