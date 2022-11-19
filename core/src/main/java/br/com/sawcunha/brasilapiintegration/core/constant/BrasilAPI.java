package br.com.sawcunha.brasilapiintegration.core.constant;

import lombok.Getter;

@Getter
public final class BrasilAPI {

    public static final String USER_AGENT_FEIGN = "user-agent:  brasilapi-brasilapiintegration-java@1.0.0";

    //URLs Bank
    public static final String ALL_BANK_V1_FEIGN = "GET /banks/v1";
    public static final String ALL_BANK_V1_URL = "/banks/v1";
    public static final String FIND_BANK_BY_CODE_V1_FEIGN = "GET /banks/v1/{code}";
    public static final String FIND_BANK_BY_CODE_V1_URL = "/banks/v1/{code}";

    //URLs Cep
    public static final String FIND_CEP_BY_CEP_V1_FEIGN = "GET /cep/v1/{cep}";
    public static final String FIND_CEP_BY_CEP_V1_URL = "/cep/v1/{cep}";
    public static final String FIND_CEP_BY_CEP_V2_FEIGN = "GET /cep/v2/{cep}";
    public static final String FIND_CEP_BY_CEP_V2_URL = "/cep/v2/{cep}";

    //URLs CNPJ
    public static final String FIND_JURIDICAL_PERSON_BY_CNPJ_V1_FEIGN = "GET /cnpj/v1/{cnpj}";
    public static final String FIND_JURIDICAL_PERSON_BY_CNPJ_V1_URL = "/cnpj/v1/{cnpj}";

    //URLs DDD
    public static final String FIND_DIRECT_DIAL_DISTANCE_BY_CODE_V1_FEIGN = "GET /ddd/v1/{code}";
    public static final String FIND_DIRECT_DIAL_DISTANCE_BY_CODE_V1_URL = "/ddd/v1/{code}";

    //URLs Fipe
    public static final String FIND_ALL_FIPE_BY_VEHICLE_TYPE_V1_FEIGN = "GET /fipe/marcas/v1/{vehicleType}";
    public static final String FIND_ALL_FIPE_BY_VEHICLE_TYPE_V1_URL = "/fipe/marcas/v1/{vehicleType}";
    public static final String FIND_ALL_FIPE_PRICE_BY_VEHICLE_CODE_V1_FEIGN = "GET /fipe/preco/v1/{vehicleCode}";
    public static final String FIND_ALL_FIPE_PRICE_BY_VEHICLE_CODE_V1_URL = "/fipe/preco/v1/{vehicleCode}";
    public static final String FIND_ALL_FIPE_TABLE_V1_FEIGN = "GET /fipe/tabelas/v1";
    public static final String FIND_ALL_FIPE_TABLE_V1_URL = "/fipe/tabelas/v1";

    //URLs IBGE
    public static final String FIND_ALL_COUNTIES_BY_UF_V1_FEIGN = "GET /ibge/municipios/v1/{uf}";
    public static final String FIND_ALL_COUNTIES_BY_UF_V1_URL = "/ibge/municipios/v1/{uf}";
    public static final String FIND_ALL_STATE_BY_UF_V1_FEIGN = "GET /ibge/uf/v1";
    public static final String FIND_ALL_STATE_BY_UF_V1_URL = "/ibge/uf/v1";
    public static final String FIND_STATE_BY_CODE_V1_FEIGN = "GET /ibge/uf/v1/{code}";
    public static final String FIND_STATE_BY_CODE_V1_URL = "/ibge/uf/v1/{code}";

    //URLs ISBN
    public static final String FIND_ISBN_BY_CODE_V1_FEIGN = "GET /isbn/v1/{code}";
    public static final String FIND_ISBN_BY_CODE_V1_URL = "/isbn/v1/{code}";

    //URLs NationalHoliday
    public static final String FIND_ALL_NATIONAL_HOLIDAY_BY_YEAR_V1_FEIGN = "GET /feriados/v1/{year}";
    public static final String FIND_ALL_NATIONAL_HOLIDAY_BY_YEAR_V1_URL = "/feriados/v1/{year}";

    //URLs NCM
    public static final String FIND_ALL_NCM_V1_FEIGN = "GET /ncm/v1";
    public static final String FIND_ALL_NCM_V1_URL = "/ncm/v1";
    public static final String FIND_ALL_NCM_BY_CODE_OR_DESCRIPTION_V1_FEIGN = "GET /ncm/v1?search={value}";
    public static final String FIND_ALL_NCM_BY_CODE_OR_DESCRIPTION_V1_URL = "/ncm/v1?search={value}";
    public static final String FIND_NCM_BY_CODE_V1_FEIGN = "GET /ncm/v1/{code}";
    public static final String FIND_NCM_BY_CODE_V1_URL = "/ncm/v1/{code}";

    //URLs Rate
    public static final String FIND_ALL_RATES_V1_FEIGN = "GET /taxas/v1";
    public static final String FIND_ALL_RATES_V1_URL = "/taxas/v1";
    public static final String FIND_RATE_BY_ACRONYM_V1_FEIGN = "GET /taxas/v1/{acronym}";
    public static final String FIND_RATE_BY_ACRONYM_V1_URL = "/taxas/v1/{acronym}";

    //URLs RegistroBR
    public static final String FIND_REGISTRO_BR_BY_DOMAIN_V1_FEIGN = "GET /registrobr/v1/{domain}";
    public static final String FIND_REGISTRO_BR_BY_DOMAIN_V1_URL = "/registrobr/v1/{domain}";

}
