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
	private int pecasJogador1;
	private int pecasJogador2;
	private int pecasJogador3;
	private int pecasJogador4;
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
		this.pecasJogador1 = 6;
		this.pecasJogador2 = 6;
		this.pecasJogador3 = 6;
		this.pecasJogador4 = 6;
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

	public int getPecasJogador1() {
		return pecasJogador1;
	}

	public void setPecasJogador1(int pecasJogador1) {
		this.pecasJogador1 = pecasJogador1;
	}

	public int getPecasJogador2() {
		return pecasJogador2;
	}

	public void setPecasJogador2(int pecasJogador2) {
		this.pecasJogador2 = pecasJogador2;
	}

	public int getPecasJogador3() {
		return pecasJogador3;
	}

	public void setPecasJogador3(int pecasJogador3) {
		this.pecasJogador3 = pecasJogador3;
	}

	public int getPecasJogador4() {
		return pecasJogador4;
	}

	public void setPecasJogador4(int pecasJogador4) {
		this.pecasJogador4 = pecasJogador4;
	}

	
}
