package br.com.desafiojokenpo.repository;

import br.com.desafiojokenpo.entity.Jogador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JogadorRepository extends JpaRepository<Jogador, Long> {

}
