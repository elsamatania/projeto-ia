package Negocios.Controle;

import java.awt.Image;

import GUI.Tabuleiro;
import Negocios.Humano;
import Negocios.ImagemPeca;
import Negocios.Jogo;
import Negocios.Maquina;
import Negocios.Peca;
import Repositorio.Repositorio;

public class ControleJogo {

	private Jogo jogo;
	private static ControleJogo controleJogo = new ControleJogo();

	private ControleJogo() {
		jogo = new Jogo();

	}

	public static ControleJogo getControleJogo() {
		if (controleJogo == null) {
			controleJogo = new ControleJogo();
		}
		return controleJogo;

	}

	public Peca jogadaJog1(int id) {
		return jogo.getJogador1().jogar(id);
	}

	public Peca jogadaJog2(int ladoA, int ladoB) {
		return jogo.getJogador2().jogar(ladoA, ladoB);
	}

	public Peca jogadaJog3(int ladoA, int ladoB) {
		return jogo.getJogador3().jogar(ladoA, ladoB);
	}

	public Peca jogadaJog4(int ladoA, int ladoB) {
		return jogo.getJogador4().jogar(ladoA, ladoB);
	}

	public void receberPecas(Repositorio pecas) {
		jogo.setPecas(pecas);
	}

	public void definirTabuleiro(Tabuleiro tab) {
		jogo.setTabuleiro(tab);
	}

	public void definirJogadores(Humano jog1, Maquina jog2, Maquina jog3,
			Maquina jog4) {
		jogo.setJogador1(jog1);
		jogo.setJogador2(jog2);
		jogo.setJogador3(jog3);
		jogo.setJogador4(jog4);
	}

	public Repositorio escolherPecas() {
		Peca peca;
		int posicao;
		Repositorio resp = new Repositorio();
		for (int i = 0; i < 7; i++) {
			posicao = (int) (jogo.getPecas().tamanho() * Math.random());
			peca = jogo.getPecas().procurar(posicao);
			jogo.getPecas().excluir(posicao);
			resp.incluir(peca);
		}
		return resp;
	}

	public void distribuirPecas() {
		jogo.getJogador1().setJogo(this.escolherPecas());
		jogo.getJogador2().setJogo(this.escolherPecas());
		jogo.getJogador3().setJogo(this.escolherPecas());
		jogo.getJogador4().setJogo(this.escolherPecas());
	}

	private ImagemPeca posicionarPeca(Peca peca) {
		ImagemPeca resp = null;
		int tan = jogo.getTabuleiro().getImagens().tamanho();
		if (peca.isCarroca()) {
			if (tan < 6){
				resp = new ImagemPeca(peca.getImagemVret1(),this.jogo.getPosicaoA().getPosicaoCarrocaX(),this.jogo.getPosicaoA().getPosicaoCarrocaY());
				if(tan==5){
					this.jogo.getPosicaoA().setPosicaoY(60);
					this.jogo.getPosicaoA().setPosicaoCarrocaY(80);
				}
				else{
					this.jogo.getPosicaoA().setPosicaoCarrocaX(40);
					this.jogo.getPosicaoA().setPosicaoX(40);
				}
			}
			else if(tan < 8){
				resp = new ImagemPeca(peca.getImagemHor1(),this.jogo.getPosicaoA().getPosicaoCarrocaX(),this.jogo.getPosicaoA().getPosicaoCarrocaY());
				this.jogo.getPosicaoA().setPosicaoCarrocaY(41);
				this.jogo.getPosicaoA().setPosicaoY(40);
			}
			else{
				resp = new ImagemPeca(peca.getImagemVret1(),this.jogo.getPosicaoA().getPosicaoCarrocaX(),this.jogo.getPosicaoA().getPosicaoCarrocaY());
				this.jogo.getPosicaoA().setPosicaoCarrocaX(-41);
				this.jogo.getPosicaoA().setPosicaoX(-40);
			}
		}
		else {
			if (tan < 6){
				resp = new ImagemPeca(peca.getImagemHor1(),this.jogo.getPosicaoA().getPosicaoX(),this.jogo.getPosicaoA().getPosicaoY());
					if(tan == 5){
						this.jogo.getPosicaoA().setPosicaoCarrocaY(65);
						this.jogo.getPosicaoA().setPosicaoX(41);
						this.jogo.getPosicaoA().setPosicaoY(41);
						
					}
					else{
						this.jogo.getPosicaoA().setPosicaoX(82);
						this.jogo.getPosicaoA().setPosicaoCarrocaX(82);
						
					}
			}
			else if(tan < 8){
				resp = new ImagemPeca(peca.getImagemVret1(),this.jogo.getPosicaoA().getPosicaoX(),this.jogo.getPosicaoA().getPosicaoY());
				if(tan == 7){
					this.jogo.getPosicaoA().setPosicaoX(-80);
					//this.jogo.getPosicaoA().setPosicaoCarrocaX(-41);
					this.jogo.getPosicaoA().setPosicaoY(41);
				}
				else{
					this.jogo.getPosicaoA().setPosicaoY(82);
					this.jogo.getPosicaoA().setPosicaoCarrocaY(82);
				}
			}
			else{
				resp = new ImagemPeca(peca.getImagemHor1(),this.jogo.getPosicaoA().getPosicaoX(),this.jogo.getPosicaoA().getPosicaoY());
				this.jogo.getPosicaoA().setPosicaoX(-82);
				this.jogo.getPosicaoA().setPosicaoCarrocaX(-80);
			}
				
		}
		return resp;
	}

	public void jogarTabuleito(Peca peca) {
		ImagemPeca imagem = this.posicionarPeca(peca);
		jogo.getTabuleiro().getImagens().incluir(imagem);
		jogo.getTabuleiro().repaint();
		//System.out.println(String.valueOf(jogo.getTabuleiro().getPecas()
			//	.tamanho()));

	}

	public Tabuleiro getTabuleiro() {
		return jogo.getTabuleiro();
	}

	public Humano getJogador1() {
		return jogo.getJogador1();
	}

}
