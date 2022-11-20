package br.com.sawcunha.brasilapiintegration.core.feign.configuration;

import br.com.sawcunha.brasilapiintegration.core.feign.decoder.BrasilAPIErrorDecoder;
import feign.codec.ErrorDecoder;

class ErrorDecoderConfiguration {

    private static ErrorDecoder errorDecoder;

    public ErrorDecoderConfiguration() {
        ErrorDecoderConfiguration.errorDecoder = new BrasilAPIErrorDecoder();
    }

    public ErrorDecoderConfiguration(final ErrorDecoder errorDecoder) {
        ErrorDecoderConfiguration.errorDecoder = errorDecoder;
    }

    protected ErrorDecoder errorDecoder() {
        return errorDecoder;
    }
}
