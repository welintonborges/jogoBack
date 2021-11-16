package br.com.desafiojokenpo.entity;

import lombok.Builder;
import lombok.Data;
import lombok.Generated;

import javax.persistence.*;

@Entity
@Data
@Builder
@Table(name = "jogador" )
public class Jogador {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String resultado;

    private  Integer escolha;

}
