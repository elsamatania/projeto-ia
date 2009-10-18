package Negocios;

import java.awt.Image;

import javax.swing.Icon;

public class Peca {

	private int id;
	private Image imagemVret1;
	private Image imagemVret2;
	private Image imagemHor1;
	private Image imagemHor2;
	private Icon icone;
	private int ladoA;
	private int ladoB;
	private boolean isCarroca;
	private int posicaoX;
	private int posicaoY;
	
	public Peca() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Peca(int id, Image imagemVret1, Image imagemVret2,
			Image imagemHor1, Image imagemHor2, Icon icone, int ladoA,
			int ladoB, boolean isCarroca) {
		super();
		this.id = id;
		this.imagemVret1 = imagemVret1;
		this.imagemVret2 = imagemVret2;
		this.imagemHor1 = imagemHor1;
		this.imagemHor2 = imagemHor2;
		this.icone = icone;
		this.ladoA = ladoA;
		this.ladoB = ladoB;
		this.isCarroca = isCarroca;
		this.posicaoX = 0;
		this.posicaoY = 0;
		}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	

	public Image getImagemVret1() {
		return imagemVret1;
	}

	public void setImagemVret1(Image imagemVret1) {
		this.imagemVret1 = imagemVret1;
	}

	public Image getImagemVret2() {
		return imagemVret2;
	}

	public void setImagemVret2(Image imagemVret2) {
		this.imagemVret2 = imagemVret2;
	}

	public Image getImagemHor1() {
		return imagemHor1;
	}

	public void setImagemHor1(Image imagemHor1) {
		this.imagemHor1 = imagemHor1;
	}

	public Image getImagemHor2() {
		return imagemHor2;
	}

	public void setImagemHor2(Image imagemHor2) {
		this.imagemHor2 = imagemHor2;
	}

	public Icon getIcone() {
		return icone;
	}

	public void setIcone(Icon icone) {
		this.icone = icone;
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

	public boolean isCarroca() {
		return isCarroca;
	}

	public void setCarroca(boolean isCarroca) {
		this.isCarroca = isCarroca;
	}

	public int getValor() {
		return this.ladoA + this.ladoB;
	}

	public void setPosicaoX(int posicaoX) {
		this.posicaoX = posicaoX;
	}

	public int getPosicaoX() {
		return posicaoX;
	}

	public void setPosicaoY(int posicaoY) {
		this.posicaoY = posicaoY;
	}

	public int getPosicaoY() {
		return posicaoY;
	}

	
}
