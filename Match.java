package br.com.contadorgame;

import java.util.Date;
import java.util.TreeMap;

public class Match {
	
	private String nome = "";
	private Date inicio = null;
	private Date Fim = null;
	private TreeMap<String, Player> jogadores = new TreeMap<String, Player>();
	
	public Match(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public Date getInicio() {
		return inicio;
	}

	public void setInicio(Date inicio) {
		this.inicio = inicio;
	}

	public Date getFim() {
		return Fim;
	}

	public void setFim(Date fim) {
		Fim = fim;
	}

	public TreeMap<String, Player> getJogadores() {
		return jogadores;
	}

	public void addJogador(String nome, Player jogador) {
		this.jogadores.put(nome, jogador);
	}

}
