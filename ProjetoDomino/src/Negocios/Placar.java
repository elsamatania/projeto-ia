package Negocios;

public class Placar {

	private int jogador1;
	private int jogador2;
	private int jogador3;
	private int jogador4;

	public Placar() {
		jogador1 = 0;
		jogador2 = 0;
		jogador3 = 0;
		jogador4 = 0;
	}

	
	public int getJogador1() {
		return jogador1;
	}

	public void setJogador1(int jogador1) {
		this.jogador1 = this.getJogador1() + jogador1;
	}

	public int getJogador2() {
		return jogador2;
	}

	public void setJogador2(int jogador2) {
		this.jogador2 = this.getJogador2() + jogador2;
	}

	public int getJogador3() {
		return jogador3;
	}

	public void setJogador3(int jogador3) {
		this.jogador3 = this.getJogador3() + jogador3;
	}

	public int getJogador4() {
		return jogador4;
	}

	public void setJogador4(int jogador4) {
		this.jogador4 = this.getJogador4() + jogador4;
	}

}
