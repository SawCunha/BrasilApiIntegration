package br.com.sawcunha.brasilapiintegration.core.feign.configuration;

import feign.codec.Decoder;
import feign.gson.GsonDecoder;

class DecoderConfiguration {
    private static Decoder decoder;

    public DecoderConfiguration() {
        DecoderConfiguration.decoder = new GsonDecoder();
    }

    public DecoderConfiguration(final Decoder decoder) {
        DecoderConfiguration.decoder = decoder;
    }

    protected Decoder decoder() {
        return decoder;
    }

}
