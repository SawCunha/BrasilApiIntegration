package br.com.sawcunha.brasilapiintegration.core.model.cnpj;

import br.com.sawcunha.brasilapiintegration.core.model.Base;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Cnpj extends Base {
    private String cnpj;
    private Integer identificador_matriz_filial;
    private String descricao_matriz_filial;
    private String razao_social;
    private String nome_fantasia;
    private Integer situacao_cadastral;
    private String descricao_situacao_cadastral;
    private String data_situacao_cadastral;
    private Integer motivo_situacao_cadastral;
    private String nome_cidade_exterior;
    private Long codigo_natureza_juridica;
    private String data_inicio_atividade;
    private Long cnae_fiscal;
    private Long cnae_fiscal_descricao;
    private String descricao_tipo_logradouro;
    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
    private Long cep;
    private String uf;
    private Long codigo_municipio;
    private String municipio;
    private String ddd_telefone_1;
    private String ddd_telefone_2;
    private String ddd_fax;
    private Integer qualificacao_do_responsavel;
    private Long capital_social;
    private Integer porte;
    private String descricao_porte;
    private Boolean opcao_pelo_simples;
    private String data_opcao_pelo_simples;
    private String data_exclusao_do_simples;
    private Boolean opcao_pelo_mei;
    private String situacao_especial;
    private String data_situacao_especial;
    private Set<Cnae> cnaes_secundarios;
    private Set<Qsa> qsa;
}
