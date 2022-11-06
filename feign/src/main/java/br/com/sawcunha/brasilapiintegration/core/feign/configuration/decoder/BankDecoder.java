package br.com.sawcunha.brasilapiintegration.core.feign.configuration.decoder;

import br.com.sawcunha.brasilapiintegration.core.exception.BrasilApiIntegrationException;
import br.com.sawcunha.brasilapiintegration.core.feign.configuration.GsonConfiguration;
import br.com.sawcunha.brasilapiintegration.core.model.error.BankError;
import feign.Response;
import feign.codec.ErrorDecoder;
import kotlin.text.Charsets;
import lombok.extern.log4j.Log4j2;

import java.io.IOException;
import java.io.Reader;
import java.util.Objects;

@Log4j2
public class BankDecoder implements ErrorDecoder {

    private static BankDecoder bankDecoder;

    public static BankDecoder getInstance() {
        if(Objects.isNull(bankDecoder)) bankDecoder = new BankDecoder();
        return bankDecoder;
    }

    private BrasilApiIntegrationException createBrasilApiIntegrationException(Response response){

        int status = response.status();
        Object message;
        Reader reader = null;
        Class messageClass;

        try {
            reader = response.body().asReader(Charsets.UTF_8);
            message = GsonConfiguration.gsonInstance().fromJson(reader, BankError.class);
            messageClass = BankError.class;
        } catch (Exception e) {
            log.error("Error decode return API:", e);
            message = e.getMessage();
            messageClass = String.class;
        }finally {
            try {
                if (reader != null)
                    reader.close();
            } catch (IOException e) {
                log.error("Error close Reader:", e);
            }
        }

        return BrasilApiIntegrationException.builder()
                .dataAPI(message)
                .statusAPI(status)
                .dataClass(messageClass)
                .build();
    }

    @Override
    public Exception decode(String s, Response response) {
        log.debug("Decode Bank");
        return createBrasilApiIntegrationException(response);
    }
}
