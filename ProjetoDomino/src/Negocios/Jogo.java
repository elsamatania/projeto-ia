package Negocios;


import GUI.Tabuleiro;
import Repositorio.Repositorio;

public class Jogo {

	private Humano jogador1;
	private Maquina jogador2;
	private Maquina jogador3;
	private Maquina jogador4;
	private Repositorio pecas;
	private int ladoA;
	private int ladoB;
	private Posicao posicaoA;
	private Posicao posicaoB;
	private Placar placar;
	private Tabuleiro tabuleiro;
	private String saida;

	public Jogo(Humano jog1, Maquina jog2, Maquina jog3, Maquina jog4,
			Repositorio pecas, Tabuleiro tabuleiro) {
		this.jogador1 = jog1;
		this.jogador2 = jog2;
		this.jogador3 = jog3;
		this.jogador4 = jog4;
		this.pecas = pecas;
		this.ladoA = 0;
		this.ladoB = 0;
		this.placar = new Placar();
		this.posicaoA = new Posicao(519, 250, 540, 209);
		this.posicaoB = new Posicao(519, 250, 540, 209);
		this.tabuleiro = tabuleiro;
		

	}

	public Jogo() {
		this.placar = new Placar();
		this.posicaoA = new Posicao(540, 233, 540, 209);
		this.posicaoB = new Posicao(458, 233, 500, 209);
		this.saida="inicio";
	}

	public Humano getJogador1() {
		return jogador1;
	}

	public void setJogador1(Humano jogador1) {
		this.jogador1 = jogador1;
	}

	public Maquina getJogador2() {
		return jogador2;
	}

	public void setJogador2(Maquina jogador2) {
		this.jogador2 = jogador2;
	}

	public Maquina getJogador3() {
		return jogador3;
	}

	public void setJogador3(Maquina jogador3) {
		this.jogador3 = jogador3;
	}

	public Maquina getJogador4() {
		return jogador4;
	}

	public void setJogador4(Maquina jogador4) {
		this.jogador4 = jogador4;
	}

	public Repositorio getPecas() {
		return pecas;
	}

	public void setPecas(Repositorio pecas) {
		this.pecas = pecas;
	}

	public int getLadoA() {
		return ladoA;
	}

	public void setLadoA(int ladoA) {
		this.ladoA = ladoA;
	}

	public int getLadoB() {
		return ladoB;
	}

	public void setLadoB(int ladoB) {
		this.ladoB = ladoB;
	}

	public Posicao getPosicaoA() {
		return posicaoA;
	}

	public void setPosicaoA(Posicao posicaoA) {
		this.posicaoA = posicaoA;
	}

	public Posicao getPosicaoB() {
		return posicaoB;
	}

	public void setPosicaoB(Posicao posicaoB) {
		this.posicaoB = posicaoB;
	}

	public Placar getPlacar() {
		return placar;
	}

	public void setPlacar(Placar placar) {
		this.placar = placar;
	}

	public void setTabuleiro(Tabuleiro tabuleiro) {
		this.tabuleiro = tabuleiro;
	}

	public Tabuleiro getTabuleiro() {
		return tabuleiro;
	}

	public void setSaida(String saida) {
		this.saida = saida;
	}

	public String getSaida() {
		return saida;
	}

	

}
