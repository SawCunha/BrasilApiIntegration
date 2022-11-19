package br.com.sawcunha.brasilapiintegration.core.feign.specification;

public interface BrasilAPIFeign {
    <T> T feignInstance(final Class<T> api, final String url);
}
