package GUI;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.JPanel;

import Repositorio.Repositorio;

@SuppressWarnings("serial")
public class Tabuleiro extends JPanel{
	
	protected Image imagem;
	protected int alt;
	protected int larg;
	private Repositorio pecas;
	
	public Tabuleiro(Image imagem,int larg,int alt){
		this.imagem = imagem;
		this.alt = alt;
		this.larg = larg;
		this.pecas = new Repositorio();
	}
	
	public void paintComponent (Graphics g){
		
		Graphics2D g2 = (Graphics2D)g;
		g2.drawImage(imagem,0,0,larg,alt,this);
	}

	public void setPecas(Repositorio pecas) {
		this.pecas = pecas;
	}

	public Repositorio getPecas() {
		return pecas;
	}
}
