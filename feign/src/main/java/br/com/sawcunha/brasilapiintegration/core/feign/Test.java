package br.com.sawcunha.brasilapiintegration.core.feign;

import br.com.sawcunha.brasilapiintegration.core.exception.BrasilApiIntegrationException;
import br.com.sawcunha.brasilapiintegration.core.feign.service.BankServiceBean;

public class Test {

    public static void main(String[] args) {
        BankServiceBean bankServiceBean = new BankServiceBean();
        BankServiceBean bankServiceBean1 = new BankServiceBean();
        BankServiceBean bankServiceBean2 = new BankServiceBean();
        System.out.println(bankServiceBean.findBanksV1ByCode(80));
        System.out.println(bankServiceBean1.findBanksV1ByCode(80));
        try {
            System.out.println(bankServiceBean2.findBanksV1ByCode(8222220));
        } catch (BrasilApiIntegrationException e){
            System.out.println(e.getStatusAPI());
            System.out.println(e.getDataAPI());
        }
    }

}
