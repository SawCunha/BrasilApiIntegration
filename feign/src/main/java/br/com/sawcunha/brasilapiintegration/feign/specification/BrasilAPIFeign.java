package br.com.sawcunha.brasilapiintegration.feign.specification;

public interface BrasilAPIFeign {
    <T> T feignInstance(final Class<T> api, final String url);
}
