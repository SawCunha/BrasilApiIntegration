package br.com.sawcunha.brasilapiintegration.spring.configuration;

import br.com.sawcunha.brasilapiintegration.core.constant.BrasilAPI;
import br.com.sawcunha.brasilapiintegration.spring.errordecoder.BrasilAPIErrorDecoder;
import feign.RequestInterceptor;
import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Bean;

public class BrasilAPIConfiguration {

    @Bean
    public RequestInterceptor requestInterceptor() {
        return requestTemplate -> {
            requestTemplate.header("user-agent", BrasilAPI.USER_AGENT);
        };
    }

    @Bean
    public ErrorDecoder errorDecoder() {
        return new BrasilAPIErrorDecoder();
    }
}
