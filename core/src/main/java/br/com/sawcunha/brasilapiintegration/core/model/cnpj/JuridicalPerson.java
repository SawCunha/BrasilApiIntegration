package br.com.sawcunha.brasilapiintegration.core.model.cnpj;

import br.com.sawcunha.brasilapiintegration.core.model.Base;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class JuridicalPerson extends Base {
    @SerializedName("cnpj")
    private String taxIdentifier;
    @SerializedName("razao_social")
    private String corporateName;
    @SerializedName("nome_fantasia")
    private String fantasyName;
    @SerializedName("identificador_matriz_filial")
    private Integer subsidiaryIdentifier;
    @SerializedName("descricao_matriz_filial")
    private String subsidiaryDescription;
    @SerializedName("situacao_cadastral")
    private Integer cadastralSituation;
    @SerializedName("descricao_situacao_cadastral")
    private String descriptionCadastralSituation;
    @SerializedName("data_situacao_cadastral")
    private String dateCadastralStatus;
    @SerializedName("motivo_situacao_cadastral")
    private Integer reasonCadastralSituation;
    @SerializedName("nome_cidade_exterior")
    private String outerCityName;
    @SerializedName("codigo_natureza_juridica")
    private Long codeJuridicalNature;
    @SerializedName("natureza_juridica")
    private String juridicaNature;
    @SerializedName("data_inicio_atividade")
    private String activityStartDate;
    @SerializedName("cnae_fiscal")
    private Long cnaeFiscal;
    @SerializedName("cnae_fiscal_descricao")
    private String descriptionCnaeFiscal;
    @SerializedName("descricao_tipo_logradouro")
    private String descriptionTypeStreet;
    @SerializedName("logradouro")
    private String publicPlace;
    @SerializedName("numero")
    private String addressNumber;
    @SerializedName("complemento")
    private String addressAddOn;
    @SerializedName("bairro")
    private String addressNeighborhood;
    @SerializedName("descricao_tipo_de_logradouro")
    private String descriptionTypeOfStreet;
    @SerializedName("cep")
    private Long zipCode;
    @SerializedName("uf")
    private String ufAddress;
    @SerializedName("codigo_municipio_ibge")
    private Long ibgeMunicipalityCode;
    @SerializedName("codigo_pais")
    private Long countryCode;
    @SerializedName("pais")
    private String country;
    private String email;
    @SerializedName("codigo_municipio")
    private Long municipalityCode;
    @SerializedName("municipio")
    private String municipality;
    @SerializedName("ddd_telefone_1")
    private String dddPhoneOne;
    @SerializedName("ddd_telefone_2")
    private String dddPhoneTwo;
    @SerializedName("ddd_fax")
    private String dddFax;
    @SerializedName("qualificacao_do_responsavel")
    private Integer qualificationOfResponsible;
    @SerializedName("capital_social")
    private Long jointStock;
    @SerializedName("porte")
    private String porte;
    @SerializedName("descricao_porte")
    private String descriptionPorte;
    @SerializedName("codigo_porte")
    private Long porteCode;
    @SerializedName("opcao_pelo_simples")
    private Boolean optionForSimple;
    @SerializedName("data_opcao_pelo_simples")
    private String dateOptionBySimple;
    @SerializedName("data_exclusao_do_simples")
    private String simpleExclusionDate;
    @SerializedName("opcao_pelo_mei")
    private Boolean optionForMei;
    @SerializedName("situacao_especial")
    private String specialSituation;
    @SerializedName("data_situacao_especial")
    private String dateSpecialSituation;
    @SerializedName("data_opcao_pelo_mei")
    private String dateOptionByMei;
    @SerializedName("data_exclusao_do_mei")
    private String dateExclusionOfMei;
    @SerializedName("nome_cidade_no_exterior")
    private String overseasCityName;
    @SerializedName("ente_federativo_responsavel")
    private String responsibleFederativeEnte;
    @SerializedName("descricao_motivo_situacao_cadastral")
    private String descriptionReasonCadastralSituation;
    @SerializedName("descricao_identificador_matriz_filial")
    private String descriptionSubsidiaryMatrixIdentifier;
    @SerializedName("cnaes_secundarios")
    private Set<Cnae> secondaryCnaes;
    private Set<Qsa> qsa;
}
