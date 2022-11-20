package br.com.sawcunha.brasilapiintegration.feign.service;

import br.com.sawcunha.brasilapiintegration.core.enums.VehicleType;
import br.com.sawcunha.brasilapiintegration.core.exception.BrasilApiIntegrationException;
import br.com.sawcunha.brasilapiintegration.feign.utils.BrasilAPIIntegrationUtil;
import br.com.sawcunha.brasilapiintegration.core.model.fipe.Fipe;
import br.com.sawcunha.brasilapiintegration.core.model.fipe.FipeTable;
import br.com.sawcunha.brasilapiintegration.core.specification.FipeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class FipeServiceBeanTest {

    private static FipeService fipeServiceBean;

    private static final String VEHICLE_CODE_FIPE_VALID = "0730270";
    private static final String VEHICLE_CODE_FIPE_INVALID = "073027000";
    private static final String REFERENCE_TABLE_APRIL_2022 = "284";
    private static final String REFERENCE_TABLE_INVALID = "invalid";
    private static final String MESSAGE_ERROR =  "Tabela de referência inválida";
    private static final String TYPE_ERROR =  "bad_request";
    private static final int STATUS_BAD_REQUEST = 400;
    private static final String MESSAGE_ERROR_FIPE_PRICE =  "Código fipe inválido";
    private static final String TYPE_ERROR_FIPE_PRICE =  "bad_request";
    private static final String MODEL = "ARRIZO 5 RTS 1.5 Turbo Flex Aut.";
    private static final String BRAND = "Caoa Chery";
    private static final String FUEL = "Gasolina";

    @BeforeEach
    public void setUp() {
        org.apache.log4j.BasicConfigurator.configure();
        fipeServiceBean = BrasilAPIIntegrationUtil.createBrasilAPIIntegration().getFipeService();
    }

    @Test
    void shouldReturnFipeListOfMarksWithVehicleTypeCarrosReferenceTableFipeIsNull(){
        Set<Fipe> fipes = fipeServiceBean.findAllFipeByVehicleTypeV1(VehicleType.CARROS, null);

        assertNotNull(fipes);
        assertFalse(fipes.isEmpty());
    }

    @Test
    void shouldReturnFipeListOfMarksWithVehicleTypeCarrosReferenceTableFipeIsApril2022(){
        Set<Fipe> fipes = fipeServiceBean.findAllFipeByVehicleTypeV1(VehicleType.CARROS, REFERENCE_TABLE_APRIL_2022);

        assertNotNull(fipes);
        assertFalse(fipes.isEmpty());
    }

    @Test
    void shouldReturnErrorWithInvalidReferenceTable(){
        BrasilApiIntegrationException brasilApiIntegrationException = assertThrows(
                BrasilApiIntegrationException.class,
                () -> fipeServiceBean.findAllFipeByVehicleTypeV1(VehicleType.CARROS, REFERENCE_TABLE_INVALID)
        );

        assertNotNull(brasilApiIntegrationException);
        assertEquals(STATUS_BAD_REQUEST, brasilApiIntegrationException.getStatusAPI());
        assertEquals(MESSAGE_ERROR, brasilApiIntegrationException.getBrasilAPIError().getMessage());
        assertEquals(TYPE_ERROR, brasilApiIntegrationException.getBrasilAPIError().getType());
    }

    @Test
    void shouldReturnFipeListPriceWithVehicleCodeReferenceTableFipeIsNull(){
        Set<Fipe> fipes = fipeServiceBean.findAllFipePriceByVehicleCodeV1(VEHICLE_CODE_FIPE_VALID, null);

        assertNotNull(fipes);
        assertFalse(fipes.isEmpty());
        Fipe fipe = fipes.toArray(new Fipe[0])[0];
        assertEquals(MODEL, fipe.getModel());
        assertEquals(BRAND, fipe.getBrand());
        assertEquals(FUEL, fipe.getFuel());
    }

    @Test
    void shouldReturnErrorWithInvalidVehicleCode(){
        BrasilApiIntegrationException brasilApiIntegrationException = assertThrows(
                BrasilApiIntegrationException.class,
                () -> fipeServiceBean.findAllFipePriceByVehicleCodeV1(VEHICLE_CODE_FIPE_INVALID, null)
        );

        assertNotNull(brasilApiIntegrationException);
        assertEquals(STATUS_BAD_REQUEST, brasilApiIntegrationException.getStatusAPI());
        assertEquals(MESSAGE_ERROR_FIPE_PRICE, brasilApiIntegrationException.getBrasilAPIError().getMessage());
        assertEquals(TYPE_ERROR_FIPE_PRICE, brasilApiIntegrationException.getBrasilAPIError().getType());
    }

    @Test
    void shouldSuccessfullyReturnFipeTable(){
        Set<FipeTable> fipeTable = fipeServiceBean.findAllFipeTableV1();

        assertNotNull(fipeTable);
        assertFalse(fipeTable.isEmpty());
    }

}