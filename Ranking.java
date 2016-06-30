package br.com.contadorgame;

import java.util.HashSet;
import java.util.Map;


public class Ranking {

	private int totalAssassinatos = 0;
	private HashSet<Player> jogadoresIgnorados = new HashSet<Player>();
	private Match match;
	
	public Ranking(Match match) {
		this.match = match;
	}
	
	public void calcular() {
		for (Map.Entry<String, Player> jogador : match.getJogadores().entrySet()) {
			if (!jogadoresIgnorados.contains(jogador.getValue())) {
				totalAssassinatos += jogador.getValue().getAssassinatos().size();
			}
		}
	}

	public int getTotalAssassinatos() {
		return totalAssassinatos;
	}

	public void ignorarJogadorNoTotalAssassinatos(Player jogador) {
		jogadoresIgnorados.add(jogador);
		
	}

	public Match getMatch() {
		return match;
	}

}
