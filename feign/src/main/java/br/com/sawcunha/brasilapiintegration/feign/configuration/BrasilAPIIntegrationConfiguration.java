package br.com.sawcunha.brasilapiintegration.feign.configuration;

import br.com.sawcunha.brasilapiintegration.feign.specification.BrasilAPIFeign;
import feign.Client;
import feign.Logger.Level;
import feign.Request.Options;
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
    private static Level levelLogger;
    private static Options optionsRequest;

    public BrasilAPIIntegrationConfiguration() {
        BrasilAPIIntegrationConfiguration.feignConfiguration = new FeignConfiguration();
        BrasilAPIIntegrationConfiguration.clientConfiguration = new ClientConfiguration();
        BrasilAPIIntegrationConfiguration.encoderConfiguration = new EncoderConfiguration();
        BrasilAPIIntegrationConfiguration.decoderConfiguration = new DecoderConfiguration();
        BrasilAPIIntegrationConfiguration.errorDecoderConfiguration = new ErrorDecoderConfiguration();
        BrasilAPIIntegrationConfiguration.levelLogger = Level.BASIC;
        BrasilAPIIntegrationConfiguration.optionsRequest = createOptionRequest();
    }

    public BrasilAPIIntegrationConfiguration(
        @NonNull final ClientConfiguration clientConfiguration,
        @NonNull final EncoderConfiguration encoderConfiguration,
        @NonNull final DecoderConfiguration decoderConfiguration,
        @NonNull final ErrorDecoderConfiguration errorDecoderConfiguration,
        @NonNull final Level levelLogger,
        @NonNull final Options optionsRequest
    ) {
        BrasilAPIIntegrationConfiguration.feignConfiguration = new FeignConfiguration();
        BrasilAPIIntegrationConfiguration.clientConfiguration = clientConfiguration;
        BrasilAPIIntegrationConfiguration.errorDecoderConfiguration = errorDecoderConfiguration;
        BrasilAPIIntegrationConfiguration.encoderConfiguration = encoderConfiguration;
        BrasilAPIIntegrationConfiguration.decoderConfiguration = decoderConfiguration;
        BrasilAPIIntegrationConfiguration.levelLogger = levelLogger;
        BrasilAPIIntegrationConfiguration.optionsRequest = optionsRequest;
    }


    @Override
    public <T> T feignInstance(@NonNull final Class<T> api, @NonNull final String url){
        return feignConfiguration.getInstance(
                api,
                url,
                clientConfiguration.client(),
                encoderConfiguration.encoder(),
                decoderConfiguration.decoder(),
                errorDecoderConfiguration.errorDecoder(),
                levelLogger,
                optionsRequest
        );
    }

    private Options createOptionRequest() {
        return new Options();
    }

    public static BrasilAPIIntegrationConfigurationBuilder builder() {
        return new BrasilAPIIntegrationConfigurationBuilder();
    }

    public static class BrasilAPIIntegrationConfigurationBuilder {
        private ClientConfiguration clientConfiguration;
        private EncoderConfiguration encoderConfiguration;
        private DecoderConfiguration decoderConfiguration;
        private ErrorDecoderConfiguration errorDecoderConfiguration;
        private Level levelLogger;
        private Options optionsRequest;

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

        public BrasilAPIIntegrationConfigurationBuilder levelLogger(@NonNull final Level levelLogger){
            this.levelLogger = levelLogger;
            return this;
        }

        public BrasilAPIIntegrationConfigurationBuilder optionsRequest(@NonNull final Options optionsRequest){
            this.optionsRequest = optionsRequest;
            return this;
        }

        public BrasilAPIIntegrationConfiguration build() {
            return new BrasilAPIIntegrationConfiguration(
                    clientConfiguration,
                    encoderConfiguration,
                    decoderConfiguration,
                    errorDecoderConfiguration,
                    levelLogger,
                    optionsRequest
            );
        }

        public BrasilAPIIntegrationConfiguration buildDefault() {
            return new BrasilAPIIntegrationConfiguration();
        }

    }
}
