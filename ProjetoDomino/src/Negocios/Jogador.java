package Negocios;

import Repositorio.Repositorio;

public  class Jogador {
	
	protected String nome;
	protected Repositorio jogo;
	
	
	public Jogador(String nome) {
		super();
		this.nome = nome;
		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Repositorio getJogo() {
		return jogo;
	}

	public void setJogo(Repositorio jogo) {
		this.jogo = jogo;
	}
	

}
