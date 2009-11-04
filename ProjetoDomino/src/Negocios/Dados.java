package Negocios;


import Repositorio.RepositorioToques;

public class Dados {
	private int branco;
	private int pio;
	private int duke;
	private int terno;
	private int quadra;
	private int quina;
	private int sena;
	private RepositorioToques jogador1;
	private RepositorioToques jogador2;
	private RepositorioToques jogador3;
	private RepositorioToques jogador4;
	private int nPecas;
	
	public Dados(){
		this.branco = 0;
		this.pio = 0;
		this.duke = 0;
		this.terno = 0;
		this.quadra = 0;
		this.quina = 0;
		this.sena = 0;
		this.jogador1 = new RepositorioToques();
		this.jogador2 = new RepositorioToques();
		this.jogador3 = new RepositorioToques();
		this.jogador4 = new RepositorioToques();
		this.nPecas = 0;
	}
	
	public int getBranco() {
		return branco;
	}

	public void setBranco() {
		++this.branco ;
	}

	public int getPio() {
		return pio;
	}

	public void setPio() {
		++this.pio;
	}

	public int getDuke() {
		return duke;
	}

	public void setDuke() {
		++this.duke;
	}

	public int getTerno() {
		return terno;
	}

	public void setTerno() {
		++this.terno;
	}

	public int getQuadra() {
		return quadra;
	}

	public void setQuadra() {
		++this.quadra;
	}

	public int getQuina() {
		return quina;
	}

	public void setQuina() {
		++this.quina;
	}

	public int getSena() {
		return sena;
	}

	public void setSena() {
		++this.sena;
	}

	public RepositorioToques getJogador1() {
		return jogador1;
	}

	public void setJogador1(RepositorioToques jogador1) {
		this.jogador1 = jogador1;
	}

	public RepositorioToques getJogador2() {
		return jogador2;
	}

	public void setJogador2(RepositorioToques jogador2) {
		this.jogador2 = jogador2;
	}

	public RepositorioToques getJogador3() {
		return jogador3;
	}

	public void setJogador3(RepositorioToques jogador3) {
		this.jogador3 = jogador3;
	}

	public RepositorioToques getJogador4() {
		return jogador4;
	}

	public void setJogador4(RepositorioToques jogador4) {
		this.jogador4 = jogador4;
	}

	public int getNPecas() {
		return nPecas;
	}

	public void setNPecas() {
		++this.nPecas;
	}

	
}
