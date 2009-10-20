package Negocios;

public class Posicao {

	private int posicaoX;
	private int posicaoY;
	private int posicaoCarrocaX;
	private int posicaoCarrocaY;
	
	public Posicao(int px, int py, int pcx,int pcy){
		this.posicaoX = px;
		this.posicaoY = py;
		this.posicaoCarrocaX = pcx;
		this.posicaoCarrocaY = pcy;
	}

	public int getPosicaoX() {
		return posicaoX;
	}

	public void setPosicaoX(int posicaoX) {
		this.posicaoX = this.posicaoX + posicaoX;
	}

	public int getPosicaoY() {
		return posicaoY;
	}

	public void setPosicaoY(int posicaoY) {
		this.posicaoY = this.posicaoY + posicaoY;
	}

	public int getPosicaoCarrocaX() {
		return posicaoCarrocaX;
	}

	public void setPosicaoCarrocaX(int posicaoCarrocaX) {
		this.posicaoCarrocaX = this.posicaoCarrocaX + posicaoCarrocaX;
	}

	public int getPosicaoCarrocaY() {
		return posicaoCarrocaY;
	}

	public void setPosicaoCarrocaY(int posicaoCarrocaY) {
		this.posicaoCarrocaY = this.posicaoCarrocaY + posicaoCarrocaY;
	}

}
