package br.com.sawcunha.brasilapiintegration.core.feign.configuration;

import feign.Client;
import feign.okhttp.OkHttpClient;

import java.util.Objects;

class ClientConfiguration {

    private static Client client;

    public ClientConfiguration() {
        ClientConfiguration.client = createOkHttpClient();
    }

    public ClientConfiguration(final Client client) {
        if(Objects.isNull(client))
            ClientConfiguration.client = createOkHttpClient();
        else
            ClientConfiguration.client = client;
    }

    protected Client client() {
        return client;
    }

    private OkHttpClient createOkHttpClient(){
        return new OkHttpClient();
    }

}
