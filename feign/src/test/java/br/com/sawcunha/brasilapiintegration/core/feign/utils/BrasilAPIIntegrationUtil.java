package br.com.sawcunha.brasilapiintegration.core.feign.utils;

import br.com.sawcunha.brasilapiintegration.core.feign.BrasilAPIIntegration;

import java.util.Objects;

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
                    .build();
        }


        return brasilAPIIntegration;
    }

}
