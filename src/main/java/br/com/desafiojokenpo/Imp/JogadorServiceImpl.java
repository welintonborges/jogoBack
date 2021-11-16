package br.com.desafiojokenpo.Imp;

import br.com.desafiojokenpo.dto.JogadorDTO;
import br.com.desafiojokenpo.entity.Jogador;
import br.com.desafiojokenpo.exeception.RegraNegocioException;
import br.com.desafiojokenpo.repository.JogadorRepository;
import br.com.desafiojokenpo.service.JogadorService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Random;
import java.util.Scanner;

@Service
public class JogadorServiceImpl implements JogadorService {

    private JogadorRepository jogadorRepository;


    public JogadorServiceImpl(JogadorRepository jogadorRepository){
        super();
        this.jogadorRepository = jogadorRepository;
    }


    @Override
    @Transactional
    public Jogador salvarJogador(Jogador jogador) {

        //1 - Papel, 2-Pedra, 3-Tesoura
        //Usu(1) Com(2) = -1, vendedor Usu.
        //Usu(1) Com(3) = -2, vendedor Comp.
        //Usu(2) Com(1) = 1, vendedor Comp.
        //Usu(2) Com(3) = -1, vendedor Usu.
        //Usu(3) Com(1) = 2, vendedor Usu.
        //Usu(3) Com(2) = 1, vendedor Comp.

        int leitor =  jogador.getEscolha();
        Random gerador =  new Random();
        JogadorDTO jogadorDTO;

        System.out.println("Vamos Jogar");
        new RegraNegocioException("Vamos Jogar");
        int numeroJogado = 0;
        int  numeroComputador = 0;
        int pontosUsu = 0;
        int pontosComp = 0;

        for (int i = 0; i < 10; i++) {
            numeroJogado = leitor;
            numeroComputador = gerador.nextInt(3) + 1;

            if(numeroJogado == numeroComputador){
                System.out.println("Empate");
            }
            else if ((numeroJogado - numeroComputador) == -1 ||
                    (numeroJogado - numeroComputador) == 2){
                System.out.println("Usuario e o vencedor da partida .");
                pontosUsu ++;
            }else {
                System.out.println("Computador e o vencedor da partida .");
                pontosComp++;
            }
        }

        if(pontosUsu > pontosComp){
            System.out.println("Usuario vendedor do jogo");
            new RegraNegocioException("Usuario vendedor do jogo");
            jogador.setResultado("Você ganhou !!!");
        }else  if(pontosUsu < pontosComp) {
            System.out.println("Computador vendedor do jogo");
            new RegraNegocioException("Computador vendedor do jogo");
            jogador.setResultado("Você perdeu !!!");
        }else{
            System.out.println("Jogo em patado");
            new RegraNegocioException("Jogo Empatado!!!");
            jogador.setResultado("Jogo Empatado!!!");
        }

        return jogadorRepository.save(jogador);
    }
}
