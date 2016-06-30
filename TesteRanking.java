package br.com.contadorgame.testes;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import br.com.contadorgame.Player;
import br.com.contadorgame.Match;
import br.com.contadorgame.Parser;
import br.com.contadorgame.Ranking;

public class TesteRanking{

	Parser parser;
	
	@Before
	public void setupParser() {
		String arqLog = "/Users/jeanpires/Documents/workspaceAmil/ContadorGame/src/br/com/contadorgame/testes/app.log";
		parser = new Parser(arqLog);
		parser.parse();
		assertNotNull(parser);
	}
	
	@Test
	public void isCarregaLinhasCorretamente() {
		assertNotNull(parser.getLinhas());
		assertTrue(parser.getLinhas().size() == 4);
		assertNotNull(parser.getScanner());
		assertNotNull(parser.getScanner());
		assertNotNull(parser.getMatchs());
		assertTrue(parser.getMatchs().size() == 1);
	}
	
	@Test
	public void isExistemDoisAssassinatos() {
		for (Match match : parser.getMatchs()) {
			Ranking rank = new Ranking(match);
			rank.calcular();
			assertTrue(rank.getTotalAssassinatos() == 2);	
		}
	}
	
	@Test
	public void ignorarMorteJogador() {
		for (Match match : parser.getMatchs()) {
			Ranking rank = new Ranking(match);
			rank.ignorarJogadorNoTotalAssassinatos(new Player("<WORLD>"));
			rank.calcular();
			assertTrue(rank.getTotalAssassinatos() == 1);
		}
	}
	
	@Test
	public void calcularMortes() {
		for (Match match : parser.getMatchs()) {
			Ranking rank = new Ranking(match);
			rank.calcular();
			assertTrue(rank.getTotalAssassinatos() == 2);
		}
	}
	
}