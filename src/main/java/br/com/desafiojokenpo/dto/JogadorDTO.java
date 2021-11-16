package br.com.desafiojokenpo.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class JogadorDTO {

    private String nome;
    private String resultado;
    private Integer escolha;
}
