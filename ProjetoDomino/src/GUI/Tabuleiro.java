package GUI;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.JPanel;

import Repositorio.Repositorio;
import Repositorio.RepositorioImagem;

@SuppressWarnings("serial")
public class Tabuleiro extends JPanel{
	
	protected Image imagem;
	protected int alt;
	protected int larg;
	private RepositorioImagem imagens;
	
	public Tabuleiro(Image imagem,int larg,int alt){
		this.imagem = imagem;
		this.alt = alt;
		this.larg = larg;
		this.imagens = new RepositorioImagem();
	}
	
	public void paintComponent (Graphics g){
		Graphics2D g2 = (Graphics2D)g;
		g2.clearRect(0, 0,  this.getWidth(),this.getHeight());
		g2.drawImage(imagem,0,0,larg,alt,this);
		for(int i=0;i<imagens.tamanho();i++){
			g2.drawImage(imagens.procurar(i).getImagem(),imagens.procurar(i).getPosicaoX(),imagens.procurar(i).getPosicaoY(),this);
		}
	}

	public void setImagens(RepositorioImagem imagem) {
		this.imagens = imagem;
	}

	public RepositorioImagem getImagens() {
		return imagens;
	}
}
