package br.com.contadorgame;

import java.util.Map.Entry;

import br.com.contadorgame.Player;
import br.com.contadorgame.Match;
import br.com.contadorgame.Parser;
import br.com.contadorgame.Ranking;
import br.com.contadorgame.util.Utils;


public class Main {
	
	public static void main(String[] args) {
		// Informar o caminho do arquivo nessa variavel
		String arqLog = "/Users/jeanpires/Documents/workspaceAmil/ContadorGame/src/br/com/contadorgame/testes/app.log";
		Parser parser = new Parser(arqLog);
		parser.parse();
		
		for (Match match : parser.getMatchs()) {
			Ranking rank = new Ranking(match);
			rank.ignorarJogadorNoTotalAssassinatos(new Player("<WORLD>"));
			rank.calcular();
			System.out.println("Rank:" + rank.getMatch().getNome());
			System.out.println("Iní­cio:" + Utils.formatarData(rank.getMatch().getInicio())); 
			System.out.println("Fim:" + Utils.formatarData(rank.getMatch().getFim()));
			
			for (Entry<String, Player> jogador : rank.getMatch().getJogadores().entrySet()) {
				System.out.println("Jogador:" + jogador.getValue().getNome() + "\tMortes:" + jogador.getValue().getMortes() + "\tAssassinatos:" + jogador.getValue().getAssassinatos().size());
			}
			
			System.out.println("Total de assassinatos:" + rank.getTotalAssassinatos());
		}
	}

}