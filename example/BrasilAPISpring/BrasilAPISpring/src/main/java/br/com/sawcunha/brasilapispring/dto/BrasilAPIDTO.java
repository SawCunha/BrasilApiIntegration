package br.com.sawcunha.brasilapispring.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BrasilAPIDTO<D> {

    private D data;

}
