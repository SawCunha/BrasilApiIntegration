package br.com.sawcunha.brasilapispring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@AutoConfigurationPackage
public class BrasilAPISpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(BrasilAPISpringApplication.class, args);
    }

}

