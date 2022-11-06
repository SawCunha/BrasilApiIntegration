package br.com.sawcunha.brasilapiintegration.core.feign.configuration;

import com.google.gson.Gson;

import java.util.Objects;

public class GsonConfiguration {

    private static Gson gson;

    public static Gson gsonInstance(){
        if(Objects.isNull(gson)) gson = new Gson();
        return gson;
    }

}
