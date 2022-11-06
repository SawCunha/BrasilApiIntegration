package br.com.sawcunha.brasilapiintegration.core.feign.configuration;

import feign.Feign;
import feign.codec.ErrorDecoder;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.okhttp.OkHttpClient;
import feign.slf4j.Slf4jLogger;

public class FeingConfiguration {

    public static <T> T getInstance(final Class<T> api, final String url, final ErrorDecoder errorDecoder){
        return Feign.builder()
                .client(new OkHttpClient())
                .encoder(new GsonEncoder())
                .decoder(new GsonDecoder())
                .errorDecoder(errorDecoder)
                .logger(new Slf4jLogger(api))
                .target(api, url);
    }

}
