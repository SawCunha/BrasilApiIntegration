package br.com.sawcunha.brasilapiintegration.core.feign.configuration;

import br.com.sawcunha.brasilapiintegration.core.feign.specification.BrasilAPIFeign;
import feign.Client;
import feign.codec.Decoder;
import feign.codec.Encoder;
import feign.codec.ErrorDecoder;
import lombok.NonNull;

public class BrasilAPIIntegrationConfiguration implements BrasilAPIFeign {

    private static FeignConfiguration feignConfiguration;
    private static ClientConfiguration clientConfiguration;
    private static EncoderConfiguration encoderConfiguration;
    private static DecoderConfiguration decoderConfiguration;
    private static ErrorDecoderConfiguration errorDecoderConfiguration;

    public BrasilAPIIntegrationConfiguration() {
        BrasilAPIIntegrationConfiguration.feignConfiguration = new FeignConfiguration();
        BrasilAPIIntegrationConfiguration.clientConfiguration = new ClientConfiguration();
        BrasilAPIIntegrationConfiguration.encoderConfiguration = new EncoderConfiguration();
        BrasilAPIIntegrationConfiguration.decoderConfiguration = new DecoderConfiguration();
        BrasilAPIIntegrationConfiguration.errorDecoderConfiguration = new ErrorDecoderConfiguration();
    }

    public BrasilAPIIntegrationConfiguration(
        @NonNull final ClientConfiguration clientConfiguration,
        @NonNull final EncoderConfiguration encoderConfiguration,
        @NonNull final DecoderConfiguration decoderConfiguration,
        @NonNull final ErrorDecoderConfiguration errorDecoderConfiguration
    ) {
        BrasilAPIIntegrationConfiguration.feignConfiguration = new FeignConfiguration();
        BrasilAPIIntegrationConfiguration.clientConfiguration = clientConfiguration;
        BrasilAPIIntegrationConfiguration.errorDecoderConfiguration = errorDecoderConfiguration;
        BrasilAPIIntegrationConfiguration.encoderConfiguration = encoderConfiguration;
        BrasilAPIIntegrationConfiguration.decoderConfiguration = decoderConfiguration;
    }


    @Override
    public <T> T feignInstance(@NonNull final Class<T> api, @NonNull final String url){
        return feignConfiguration.getInstance(
                api,
                url,
                clientConfiguration.client(),
                encoderConfiguration.encoder(),
                decoderConfiguration.decoder(),
                errorDecoderConfiguration.errorDecoder()
        );
    }

    public static BrasilAPIIntegrationConfigurationBuilder builder() {
        return new BrasilAPIIntegrationConfigurationBuilder();
    }

    public static class BrasilAPIIntegrationConfigurationBuilder {
        private ClientConfiguration clientConfiguration;
        private EncoderConfiguration encoderConfiguration;
        private DecoderConfiguration decoderConfiguration;
        private ErrorDecoderConfiguration errorDecoderConfiguration;

        public BrasilAPIIntegrationConfigurationBuilder client(@NonNull final Client client){
            this.clientConfiguration = new ClientConfiguration(client);
            return this;
        }

        public BrasilAPIIntegrationConfigurationBuilder encoder(@NonNull final Encoder encoder){
            this.encoderConfiguration = new EncoderConfiguration(encoder);
            return this;
        }

        public BrasilAPIIntegrationConfigurationBuilder decoder(@NonNull final Decoder decoder){
            this.decoderConfiguration = new DecoderConfiguration(decoder);
            return this;
        }

        public BrasilAPIIntegrationConfigurationBuilder errorDecoder(@NonNull final ErrorDecoder errorDecoder){
            this.errorDecoderConfiguration = new ErrorDecoderConfiguration(errorDecoder);
            return this;
        }

        public BrasilAPIIntegrationConfiguration build() {
            return new BrasilAPIIntegrationConfiguration(clientConfiguration, encoderConfiguration, decoderConfiguration, errorDecoderConfiguration);
        }

        public BrasilAPIIntegrationConfiguration buildDefault() {
            return new BrasilAPIIntegrationConfiguration();
        }

    }
}
