package Negocios;

import java.awt.Image;

public class ImagemPeca {
	
	private Image imagem;
	private int posicaoX;
	private int posicaoY;
	
	public ImagemPeca(Image imagem, int pX, int pY){
		this.imagem = imagem;
		this.posicaoX = pX;
		this.posicaoY = pY;
	}
	public Image getImagem() {
		return imagem;
	}
	public void setImagem(Image imagem) {
		this.imagem = imagem;
	}
	public int getPosicaoX() {
		return posicaoX;
	}
	public void setPosicaoX(int posicaoX) {
		this.posicaoX = posicaoX;
	}
	public int getPosicaoY() {
		return posicaoY;
	}
	public void setPosicaoY(int posicaoY) {
		this.posicaoY = posicaoY;
	}
		
}
