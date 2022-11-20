package br.com.sawcunha.brasilapiintegration.feign.configuration;

import feign.codec.Encoder;
import feign.gson.GsonEncoder;

class EncoderConfiguration {
    private static Encoder encoder;

    public EncoderConfiguration() {
        EncoderConfiguration.encoder = new GsonEncoder();
    }

    public EncoderConfiguration(final Encoder encoder) {
        EncoderConfiguration.encoder = encoder;
    }

    protected Encoder encoder() {
        return encoder;
    }

}
