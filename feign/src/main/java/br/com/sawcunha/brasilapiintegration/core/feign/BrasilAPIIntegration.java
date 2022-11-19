package br.com.sawcunha.brasilapiintegration.core.feign;

import br.com.sawcunha.brasilapiintegration.core.feign.configuration.BrasilAPIIntegrationConfiguration;
import br.com.sawcunha.brasilapiintegration.core.feign.service.BankServiceBean;
import br.com.sawcunha.brasilapiintegration.core.feign.service.CepServiceBean;
import br.com.sawcunha.brasilapiintegration.core.feign.service.DirectDialDistanceServiceBean;
import br.com.sawcunha.brasilapiintegration.core.feign.service.FipeServiceBean;
import br.com.sawcunha.brasilapiintegration.core.feign.service.IBGEServiceBean;
import br.com.sawcunha.brasilapiintegration.core.feign.service.ISBNServiceBean;
import br.com.sawcunha.brasilapiintegration.core.feign.service.JuridicalPersonServiceBean;
import br.com.sawcunha.brasilapiintegration.core.feign.service.NCMServiceBean;
import br.com.sawcunha.brasilapiintegration.core.feign.service.NatinalHolidayServiceBean;
import br.com.sawcunha.brasilapiintegration.core.feign.service.RateServiceBean;
import br.com.sawcunha.brasilapiintegration.core.feign.service.RegistroBRServiceBean;
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
import feign.codec.Decoder;
import feign.codec.Encoder;
import feign.codec.ErrorDecoder;
import lombok.Getter;
import lombok.NonNull;
import lombok.extern.log4j.Log4j2;

import java.util.Objects;

@Log4j2
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
        return bankService;
    }

    public CepService getCepService() {
        return cepService;
    }

    public DirectDialDistanceService getDirectDialDistanceService() {
        return directDialDistanceService;
    }

    public FipeService getFipeService() {
        return fipeService;
    }

    public IBGEService getIbgeService() {
        return ibgeService;
    }

    public ISBNService getIsbnService() {
        return isbnService;
    }

    public JuridicalPersonService getJuridicalPersonService() {
        return juridicalPersonService;
    }

    public NatinalHolidayService getNatinalHolidayService() {
        return natinalHolidayService;
    }

    public NCMService getNcmService() {
        return ncmService;
    }

    public RateService getRateService() {
        return rateService;
    }

    public RegistroBRService getRegistroBRService() {
        return registroBRService;
    }

    public static class BrasilAPIIntegrationBuilder {

        private final String uri;
        private Client client;
        private Encoder encoder;
        private Decoder decoder;
        private ErrorDecoder errorDecoder;
        private BrasilAPIIntegrationConfiguration brasilAPIIntegrationConfiguration;
        private BrasilAPIServiceBuilder brasilAPIServiceBuilder;

        public BrasilAPIIntegrationBuilder(String uri) {
            this.uri = uri;
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

        public BrasilAPIIntegrationBuilder configurationBuild(){
            this.brasilAPIIntegrationConfiguration = BrasilAPIIntegrationConfiguration.builder()
                    .client(client)
                    .decoder(decoder)
                    .encoder(encoder)
                    .errorDecoder(errorDecoder)
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

}
