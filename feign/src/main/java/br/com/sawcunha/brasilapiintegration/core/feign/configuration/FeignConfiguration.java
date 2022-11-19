package br.com.sawcunha.brasilapiintegration.core.feign.configuration;

import feign.Client;
import feign.Feign;
import feign.codec.Decoder;
import feign.codec.Encoder;
import feign.codec.ErrorDecoder;
import feign.slf4j.Slf4jLogger;

class FeignConfiguration {

    <T> T getInstance(
            final Class<T> api,
            final String url,
            final Client client,
            final Encoder encoder,
            final Decoder decoder,
            final ErrorDecoder errorDecoder
    ){
        return Feign.builder()
                .client(client)
                .encoder(encoder)
                .decoder(decoder)
                .errorDecoder(errorDecoder)
                .logger(new Slf4jLogger(api))
                .target(api, url);
    }

}
