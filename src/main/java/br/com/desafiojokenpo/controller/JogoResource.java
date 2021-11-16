package br.com.desafiojokenpo.controller;


import br.com.desafiojokenpo.dto.JogadorDTO;
import br.com.desafiojokenpo.entity.Jogador;
import br.com.desafiojokenpo.exeception.RegraNegocioException;
import br.com.desafiojokenpo.service.JogadorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/jogo")
public class JogoResource {



    private JogadorService service;

    public JogoResource(JogadorService jogadorService){
        this.service = jogadorService;

    }

    @GetMapping("teste")
    public void ola(@RequestBody Jogador dto){
    service.salvarJogador(dto);
    }

    @PostMapping("/vamosJogar")
    public Object salvar(@RequestBody JogadorDTO dto){

        Jogador jogador =   Jogador.builder()
                .nome(dto.getNome())
                .resultado(dto.getResultado())
                .build();
        try {
         Jogador jogadorSalvo = service.salvarJogador(jogador);

            return new ResponseEntity(jogadorSalvo, HttpStatus.CREATED);

        }catch (RuntimeException e){
            return  new RegraNegocioException("Erro a salvar um jogador");
        }
    }
}
