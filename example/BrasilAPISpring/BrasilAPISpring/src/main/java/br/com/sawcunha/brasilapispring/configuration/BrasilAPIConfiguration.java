package br.com.sawcunha.brasilapispring.configuration;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(basePackages={"br.com.sawcunha.brasilapiintegration.spring"})
@ComponentScan(basePackages={"br.com.sawcunha.brasilapiintegration.spring"})
public class BrasilAPIConfiguration {
}
