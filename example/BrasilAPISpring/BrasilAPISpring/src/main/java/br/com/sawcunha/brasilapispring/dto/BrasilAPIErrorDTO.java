package br.com.sawcunha.brasilapispring.dto;

import br.com.sawcunha.brasilapiintegration.core.model.error.BrasilAPIError;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BrasilAPIErrorDTO<E> {

    private final E dataError;
    private final int statusAPI;
    private final String message;

}
