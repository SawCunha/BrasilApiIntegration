# BrasilAPI Integration

[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)
[![CI - BrasilAPI Integration](https://github.com/SawCunha/BrasilApiIntegration/actions/workflows/maven_pr.yml/badge.svg)](https://github.com/SawCunha/BrasilApiIntegration/actions/workflows/maven_pr.yml)
[![Dependency Review - BrasilAPI Integration](https://github.com/SawCunha/BrasilApiIntegration/actions/workflows/dependency-review.yml/badge.svg)](https://github.com/SawCunha/BrasilApiIntegration/actions/workflows/dependency-review.yml)

Projeto para facilitar e auxiliar na integração com as APIs disponibilizada no Projeto [BrasilAPI](https://github.com/BrasilAPI/BrasilAPI).

## Tecnologias utilizadas
- [Java](https://www.java.com/pt-BR/)
- [Open Feign](https://github.com/OpenFeign/feign)
- [Spring Boot](https://spring.io/projects/spring-boot)
- [Gson](https://github.com/google/gson)

## APIs implementadas do Brasil API
Atualmente o projeto implementando todas as APIs disponiveis para utilização.

[Documentação das APIs](https://brasilapi.com.br/docs)

## Como utilizar versão Feign

importe no pom
```java
<dependency>
    <groupId>br.com.sawcunha</groupId>
    <artifactId>BrasilApiIntegration-feign</artifactId>
    <version>1.0.0-SNAPSHOT</version>
</dependency>
```

Para criar uma instância com configuração default criar da seguinte forma:

Onde a URI_API seria a URL: https://brasilapi.com.br/api

Para ativar cada Endpoint e necessário informar o *enableBankService* de cada serviço que queira utilizar.

```java
BrasilAPIIntegration brasilAPIIntegration = BrasilAPIIntegration.builder(URI_API)
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
        .levelLogger(Level.FULL)
        .configureOptionsRequest()
            .connectTimeout(1L)
            .connectTimeoutUnit(TimeUnit.MINUTES)
            .readTimeout(30L)
            .readTimeoutUnit(TimeUnit.SECONDS)
            .followRedirects(true)
        .buildOptionsRequest()
        .build();
```

Caso não seja configurado *OptionsRequest* ele será criado com configuração default.
```java
this.connectTimeout = 10L;
this.connectTimeoutUnit = TimeUnit.SECONDS;
this.readTimeout = 60L;
this.readTimeoutUnit = TimeUnit.SECONDS;
this.followRedirects = true;
```

## Como utilizar versão Spring

importe no pom
```java
<dependency>
    <groupId>br.com.sawcunha</groupId>
    <artifactId>BrasilApiIntegration-spring</artifactId>
    <version>1.0.0-SNAPSHOT</version>
</dependency>
```

Sera necessário a criação de uma classe de configuração para ativação do Feign sem erros:
```java
@Configuration
@EnableFeignClients(basePackages={"br.com.sawcunha.brasilapiintegration.spring"})
@ComponentScan(basePackages={"br.com.sawcunha.brasilapiintegration.spring"})
public class BrasilAPIConfiguration {
}
```

No properties da aplicação adicionar as seguintes configurações:
```yml
brasilapi:
  url: https://brasilapi.com.br/api
```

Os properties do Feign pode ser configurado de acordo com seu gosto.

Para sobrescrever a saida do log do: **BrasilApiIntegration-spring**, basta sobrescrever no projeto o arquivo: **log4j.xml**

## Roadmap

O projeto seguira a ordem descrita para implementação de novos recursos

- [X] Integração utilizando [Open Feign](https://github.com/OpenFeign/feign)
- [X] Integração com [Spring Boot](https://spring.io/projects/spring-boot)
- [ ] Disponibilizar no [Maven Repository](https://mvnrepository.com/)
- [ ] Melhoria na cobertura de Testes unitarios e Integração
- [ ] Suporte a Java 11, 17 e posteriores.

## Autores

- [@SawCunha](https://github.com/SawCunha)

## Contribuintes

<a href="https://github.com/SawCunha/BrasilApiIntegration/graphs/contributors"><img src="https://contrib.rocks/image?repo=SawCunha/BrasilApiIntegration" /></a>


# Licença

MIT License

Copyright (c) 2022 BrasilApiIntegration

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.