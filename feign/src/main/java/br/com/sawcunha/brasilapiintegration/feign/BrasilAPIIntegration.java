package br.com.sawcunha.brasilapiintegration.feign;

import br.com.sawcunha.brasilapiintegration.feign.configuration.BrasilAPIIntegrationConfiguration;
import br.com.sawcunha.brasilapiintegration.feign.service.BankServiceBean;
import br.com.sawcunha.brasilapiintegration.feign.service.CepServiceBean;
import br.com.sawcunha.brasilapiintegration.feign.service.DirectDialDistanceServiceBean;
import br.com.sawcunha.brasilapiintegration.feign.service.FipeServiceBean;
import br.com.sawcunha.brasilapiintegration.feign.service.IBGEServiceBean;
import br.com.sawcunha.brasilapiintegration.feign.service.ISBNServiceBean;
import br.com.sawcunha.brasilapiintegration.feign.service.JuridicalPersonServiceBean;
import br.com.sawcunha.brasilapiintegration.feign.service.NCMServiceBean;
import br.com.sawcunha.brasilapiintegration.feign.service.NatinalHolidayServiceBean;
import br.com.sawcunha.brasilapiintegration.feign.service.RateServiceBean;
import br.com.sawcunha.brasilapiintegration.feign.service.RegistroBRServiceBean;
import br.com.sawcunha.brasilapiintegration.core.specification.BankService;
import br.com.sawcunha.brasilapiintegration.core.specification.CepService;
import br.com.sawcunha.brasilapiintegration.core.specification.DirectDialDistanceService;
import br.com.sawcunha.brasilapiintegration.core.specification.FipeService;
import br.com.sawcunha.brasilapiintegration.core.specification.IBGEService;
import br.com.sawcunha.brasilapiintegration.core.specification.ISBNService;
import br.com.sawcunha.brasilapiintegration.core.specification.JuridicalPersonService;
import br.com.sawcunha.brasilapiintegration.core.specification.NCMService;
import br.com.sawcunha.brasilapiintegration.core.specification.NatinalHolidayService;
import br.com.sawcunha.brasilapiintegration.core.specification.RateService;
import br.com.sawcunha.brasilapiintegration.core.specification.RegistroBRService;
import feign.Client;
import feign.Logger.Level;
import feign.Request.Options;
import feign.codec.Decoder;
import feign.codec.Encoder;
import feign.codec.ErrorDecoder;
import lombok.Getter;
import lombok.NonNull;
import lombok.extern.log4j.Log4j;
import org.apache.logging.log4j.core.util.Assert;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

@Log4j
public class BrasilAPIIntegration {
    private static BrasilAPIIntegrationConfiguration brasilAPIIntegrationConfiguration;
    private static BankService bankService;
    private static CepService cepService;
    private static DirectDialDistanceService directDialDistanceService;
    private static FipeService fipeService;
    private static IBGEService ibgeService;
    private static ISBNService isbnService;
    private static JuridicalPersonService juridicalPersonService;
    private static NatinalHolidayService natinalHolidayService;
    private static NCMService ncmService;
    private static RateService rateService;
    private static RegistroBRService registroBRService;

    private BrasilAPIIntegration(
        final BrasilAPIIntegrationConfiguration brasilAPIIntegrationConfiguration,
        final BankService bankService,
        final CepService cepService,
        final DirectDialDistanceService directDialDistanceService,
        final FipeService fipeService,
        final IBGEService ibgeService,
        final ISBNService isbnService,
        final JuridicalPersonService juridicalPersonService,
        final NatinalHolidayService natinalHolidayService,
        final NCMService ncmService,
        final RateService rateService,
        final RegistroBRService registroBRService
    ) {
        BrasilAPIIntegration.brasilAPIIntegrationConfiguration = brasilAPIIntegrationConfiguration;
        BrasilAPIIntegration.bankService = bankService;
        BrasilAPIIntegration.cepService = cepService;
        BrasilAPIIntegration.directDialDistanceService = directDialDistanceService;
        BrasilAPIIntegration.fipeService = fipeService;
        BrasilAPIIntegration.ibgeService = ibgeService;
        BrasilAPIIntegration.isbnService = isbnService;
        BrasilAPIIntegration.juridicalPersonService = juridicalPersonService;
        BrasilAPIIntegration.natinalHolidayService = natinalHolidayService;
        BrasilAPIIntegration.ncmService = ncmService;
        BrasilAPIIntegration.rateService = rateService;
        BrasilAPIIntegration.registroBRService = registroBRService;
    }

    public static BrasilAPIIntegrationBuilder builder(@NonNull String uri){
        return new BrasilAPIIntegrationBuilder(uri);
    }

    public BankService getBankService() {
        log.info("#Get - BankService");
        Assert.requireNonEmpty(bankService, "BankService not enable.");
        return bankService;
    }

    public CepService getCepService() {
        log.info("#Get - BankService");
        Assert.requireNonEmpty(bankService, "BankService not enable.");
        return cepService;
    }

    public DirectDialDistanceService getDirectDialDistanceService() {
        log.info("#Get - DirectDialDistanceService");
        Assert.requireNonEmpty(directDialDistanceService, "DirectDialDistanceService not enable.");
        return directDialDistanceService;
    }

    public FipeService getFipeService() {
        log.info("#Get - FipeService");
        Assert.requireNonEmpty(fipeService, "FipeService not enable.");
        return fipeService;
    }

    public IBGEService getIbgeService() {
        log.info("#Get - IbgeService");
        Assert.requireNonEmpty(ibgeService, "IbgeService not enable.");
        return ibgeService;
    }

    public ISBNService getIsbnService() {
        log.info("#Get - IsbnService");
        Assert.requireNonEmpty(isbnService, "IsbnService not enable.");
        return isbnService;
    }

    public JuridicalPersonService getJuridicalPersonService() {
        log.info("#Get - JuridicalPersonService");
        Assert.requireNonEmpty(juridicalPersonService, "JuridicalPersonService not enable.");
        return juridicalPersonService;
    }

    public NatinalHolidayService getNatinalHolidayService() {
        log.info("#Get - NatinalHolidayService");
        Assert.requireNonEmpty(natinalHolidayService, "NatinalHolidayService not enable.");
        return natinalHolidayService;
    }

    public NCMService getNcmService() {
        log.info("#Get - NcmService");
        Assert.requireNonEmpty(ncmService, "NcmService not enable.");
        return ncmService;
    }

    public RateService getRateService() {
        log.info("#Get - RateService");
        Assert.requireNonEmpty(rateService, "RateService not enable.");
        return rateService;
    }

    public RegistroBRService getRegistroBRService() {
        log.info("#Get - RegistroBRService");
        Assert.requireNonEmpty(registroBRService, "RegistroBRService not enable.");
        return registroBRService;
    }

    public static class BrasilAPIIntegrationBuilder {

        private final String uri;
        private Client client;
        private Encoder encoder;
        private Decoder decoder;
        private ErrorDecoder errorDecoder;
        private Level levelLogger;
        private BrasilAPIIntegrationConfiguration brasilAPIIntegrationConfiguration;
        private BrasilAPIServiceBuilder brasilAPIServiceBuilder;
        private BrasilAPIOptionsRequestBuilder brasilAPIOptionsRequestBuilder;

        public BrasilAPIIntegrationBuilder(String uri) {
            this.uri = uri;
            this.brasilAPIOptionsRequestBuilder = new BrasilAPIOptionsRequestBuilder(this);
        }

        public BrasilAPIIntegrationBuilder client(final Client client){
            this.client = client;
            return this;
        }

        public BrasilAPIIntegrationBuilder encoder(final Encoder encoder){
            this.encoder = encoder;
            return this;
        }

        public BrasilAPIIntegrationBuilder decoder(final Decoder decoder){
            this.decoder = decoder;
            return this;
        }

        public BrasilAPIIntegrationBuilder errorDecoder(final ErrorDecoder errorDecoder){
            this.errorDecoder = errorDecoder;
            return this;
        }

        public BrasilAPIIntegrationBuilder levelLogger(final Level levelLogger){
            this.levelLogger = levelLogger;
            return this;
        }

        public BrasilAPIIntegrationBuilder configurationBuild(){
            Options optionsRequest = new Options(
                    brasilAPIOptionsRequestBuilder.getConnectTimeout(), brasilAPIOptionsRequestBuilder.getConnectTimeoutUnit(),
                    brasilAPIOptionsRequestBuilder.getReadTimeout(), brasilAPIOptionsRequestBuilder.getReadTimeoutUnit(),
                    brasilAPIOptionsRequestBuilder.isFollowRedirects()
            );

            this.brasilAPIIntegrationConfiguration = BrasilAPIIntegrationConfiguration.builder()
                    .client(client)
                    .decoder(decoder)
                    .encoder(encoder)
                    .errorDecoder(errorDecoder)
                    .levelLogger(Objects.nonNull(this.levelLogger) ? this.levelLogger : Level.HEADERS)
                    .optionsRequest(optionsRequest)
                    .build();
            return this;
        }

        public BrasilAPIIntegrationBuilder configurationDefaultBuild(){
            this.brasilAPIIntegrationConfiguration = BrasilAPIIntegrationConfiguration.builder().buildDefault();
            return this;
        }

        public BrasilAPIServiceBuilder configureBrasilAPIService() {
            this.brasilAPIServiceBuilder = new BrasilAPIServiceBuilder(this);
            return brasilAPIServiceBuilder;
        }

        public BrasilAPIOptionsRequestBuilder configureOptionsRequest() {
            return brasilAPIOptionsRequestBuilder;
        }

        public BrasilAPIIntegration build(){
            if(Objects.isNull(brasilAPIIntegrationConfiguration)){
                configurationBuild();
            }

            return new BrasilAPIIntegration(
                    brasilAPIIntegrationConfiguration, brasilAPIServiceBuilder.getBankService(), brasilAPIServiceBuilder.getCepService(),
                    brasilAPIServiceBuilder.getDirectDialDistanceService(), brasilAPIServiceBuilder.getFipeService(), brasilAPIServiceBuilder.getIbgeService(),
                    brasilAPIServiceBuilder.getIsbnService(), brasilAPIServiceBuilder.getJuridicalPersonService(), brasilAPIServiceBuilder.getNatinalHolidayService(),
                    brasilAPIServiceBuilder.getNcmService(), brasilAPIServiceBuilder.getRateService(), brasilAPIServiceBuilder.getRegistroBRService()
            );
        }

        public BrasilAPIIntegrationConfiguration getBrasilAPIIntegrationConfiguration() {
            return brasilAPIIntegrationConfiguration;
        }
    }

    @Getter
    public static class BrasilAPIServiceBuilder {

        private final BrasilAPIIntegrationBuilder brasilAPIIntegrationBuilder;
        private BankService bankService;
        private CepService cepService;
        private DirectDialDistanceService directDialDistanceService;
        private FipeService fipeService;
        private IBGEService ibgeService;
        private ISBNService isbnService;
        private JuridicalPersonService juridicalPersonService;
        private NatinalHolidayService natinalHolidayService;
        private NCMService ncmService;
        private RateService rateService;
        private RegistroBRService registroBRService;

        private BrasilAPIServiceBuilder(final BrasilAPIIntegrationBuilder brasilAPIIntegrationBuilder) {
            this.brasilAPIIntegrationBuilder = brasilAPIIntegrationBuilder;
        }

        public BrasilAPIServiceBuilder enableBankService(){
            this.bankService = new BankServiceBean(brasilAPIIntegrationBuilder.getBrasilAPIIntegrationConfiguration(), brasilAPIIntegrationBuilder.uri);
            return this;
        }

        public BrasilAPIServiceBuilder enableCepService(){
            this.cepService = new CepServiceBean(brasilAPIIntegrationBuilder.getBrasilAPIIntegrationConfiguration(), brasilAPIIntegrationBuilder.uri);
            return this;
        }

        public BrasilAPIServiceBuilder enableDirectDialDistanceService(){
            this.directDialDistanceService = new DirectDialDistanceServiceBean(brasilAPIIntegrationBuilder.getBrasilAPIIntegrationConfiguration(), brasilAPIIntegrationBuilder.uri);
            return this;
        }

        public BrasilAPIServiceBuilder enableFipeService(){
            this.fipeService = new FipeServiceBean(brasilAPIIntegrationBuilder.getBrasilAPIIntegrationConfiguration(), brasilAPIIntegrationBuilder.uri);
            return this;
        }

        public BrasilAPIServiceBuilder enableIBGEService(){
            this.ibgeService = new IBGEServiceBean(brasilAPIIntegrationBuilder.getBrasilAPIIntegrationConfiguration(), brasilAPIIntegrationBuilder.uri);
            return this;
        }

        public BrasilAPIServiceBuilder enableISBNService(){
            this.isbnService = new ISBNServiceBean(brasilAPIIntegrationBuilder.getBrasilAPIIntegrationConfiguration(), brasilAPIIntegrationBuilder.uri);
            return this;
        }

        public BrasilAPIServiceBuilder enableJuridicalPersonService(){
            this.juridicalPersonService = new JuridicalPersonServiceBean(brasilAPIIntegrationBuilder.getBrasilAPIIntegrationConfiguration(), brasilAPIIntegrationBuilder.uri);
            return this;
        }

        public BrasilAPIServiceBuilder enableNatinalHolidayService(){
            this.natinalHolidayService = new NatinalHolidayServiceBean(brasilAPIIntegrationBuilder.getBrasilAPIIntegrationConfiguration(), brasilAPIIntegrationBuilder.uri);
            return this;
        }

        public BrasilAPIServiceBuilder enableNCMService(){
            this.ncmService = new NCMServiceBean(brasilAPIIntegrationBuilder.getBrasilAPIIntegrationConfiguration(), brasilAPIIntegrationBuilder.uri);
            return this;
        }

        public BrasilAPIServiceBuilder enableRateService(){
            this.rateService = new RateServiceBean(brasilAPIIntegrationBuilder.getBrasilAPIIntegrationConfiguration(), brasilAPIIntegrationBuilder.uri);
            return this;
        }

        public BrasilAPIServiceBuilder enableRegistroBRService(){
            this.registroBRService = new RegistroBRServiceBean(brasilAPIIntegrationBuilder.getBrasilAPIIntegrationConfiguration(), brasilAPIIntegrationBuilder.uri);
            return this;
        }

        public BrasilAPIIntegrationBuilder buildServices(){
            return brasilAPIIntegrationBuilder;
        }

    }

    @Getter
    public static class BrasilAPIOptionsRequestBuilder {

        private final BrasilAPIIntegrationBuilder brasilAPIIntegrationBuilder;
        private long connectTimeout;
        private TimeUnit connectTimeoutUnit;
        private long readTimeout;
        private TimeUnit readTimeoutUnit;
        private boolean followRedirects;

        private BrasilAPIOptionsRequestBuilder(final BrasilAPIIntegrationBuilder brasilAPIIntegrationBuilder) {
            this.brasilAPIIntegrationBuilder = brasilAPIIntegrationBuilder;
            this.connectTimeout = 10L;
            this.connectTimeoutUnit = TimeUnit.SECONDS;
            this.readTimeout = 60L;
            this.readTimeoutUnit = TimeUnit.SECONDS;
            this.followRedirects = true;
        }

        public BrasilAPIOptionsRequestBuilder connectTimeout(final long connectTimeout) {
            this.connectTimeout = connectTimeout;
            return this;
        }

        public BrasilAPIOptionsRequestBuilder connectTimeoutUnit(@NonNull final TimeUnit connectTimeoutUnit) {
            this.connectTimeoutUnit = connectTimeoutUnit;
            return this;
        }

        public BrasilAPIOptionsRequestBuilder readTimeout(final long readTimeout) {
            this.readTimeout = readTimeout;
            return this;
        }

        public BrasilAPIOptionsRequestBuilder readTimeoutUnit(@NonNull final TimeUnit readTimeoutUnit) {
            this.readTimeoutUnit = readTimeoutUnit;
            return this;
        }

        public BrasilAPIOptionsRequestBuilder followRedirects(final boolean followRedirects) {
            this.followRedirects = followRedirects;
            return this;
        }

        public BrasilAPIIntegrationBuilder buildOptionsRequest(){
            return brasilAPIIntegrationBuilder;
        }

    }

}
