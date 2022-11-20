package br.com.sawcunha.brasilapiintegration.core.feign.utils;

import br.com.sawcunha.brasilapiintegration.core.feign.BrasilAPIIntegration;
import feign.Logger.Level;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class BrasilAPIIntegrationUtil {

    private static final String URI_API = "https://brasilapi.com.br/api";

    private static BrasilAPIIntegration brasilAPIIntegration;

    public static BrasilAPIIntegration createBrasilAPIIntegration(){
        if(Objects.isNull(BrasilAPIIntegrationUtil.brasilAPIIntegration)){
            BrasilAPIIntegrationUtil.brasilAPIIntegration = BrasilAPIIntegration.builder(URI_API)
                    .configurationDefaultBuild()
                    .configureBrasilAPIService()
                        .enableBankService()
                        .enableCepService()
                        .enableDirectDialDistanceService()
                        .enableFipeService()
                        .enableIBGEService()
                        .enableISBNService()
                        .enableJuridicalPersonService()
                        .enableNatinalHolidayService()
                        .enableNCMService()
                        .enableRateService()
                        .enableRegistroBRService()
                        .buildServices()
                    .levelLogger(Level.NONE)
                    .configureOptionsRequest()
                        .connectTimeout(1L)
                        .connectTimeoutUnit(TimeUnit.MINUTES)
                        .readTimeout(30L)
                        .readTimeoutUnit(TimeUnit.SECONDS)
                        .followRedirects(true)
                    .buildOptionsRequest()
                    .build();
        }
        return brasilAPIIntegration;
    }

}
