package Negocios.Controle;

 

import GUI.Tabuleiro;
import Negocios.Humano;
import Negocios.Jogador;
import Negocios.Jogo;
import Negocios.Maquina;
import Negocios.Peca;
import Repositorio.Repositorio;

public class ControleJogo {
	
	private Jogo jogo = new Jogo();
	
	public void receberPecas(Repositorio pecas){
		jogo.setPecas(pecas);
	}
	
	public void definirTabuleiro(Tabuleiro tab){
		jogo.setTabuleiro(tab);
	}
	
	public void definirJogadores(Humano jog1,Maquina jog2,Maquina jog3,Maquina jog4){
		jogo.setJogador1(jog1);
		jogo.setJogador2(jog2);
		jogo.setJogador3(jog3);
		jogo.setJogador4(jog4);
	}
	
	public Repositorio escolherPecas(){
		Peca peca;
		int posicao;
		Repositorio resp = new Repositorio();
		for (int i=0;i<7;i++){
			posicao = (int)(jogo.getPecas().tamanho()* Math.random());
			peca = jogo.getPecas().procurar(posicao);
			jogo.getPecas().excluir(posicao);
			resp.incluir(peca);
		}
		return resp;
	}
	
	public void distribuirPecas(){
		jogo.getJogador1().setJogo(this.escolherPecas());
		jogo.getJogador2().setJogo(this.escolherPecas());
		jogo.getJogador3().setJogo(this.escolherPecas());
		jogo.getJogador4().setJogo(this.escolherPecas());
	}
	
	private void posicionarPeca(Peca peca){
		if (peca.isCarroca()){
			peca.setPosicaoX(this.jogo.getPosicaoA().getPosicaoCarrocaX());
			peca.setPosicaoY(this.jogo.getPosicaoA().getPosicaoCarrocaY());
			this.jogo.getPosicaoA().setPosicaoCarrocaX(jogo.getPosicaoA().getPosicaoCarrocaX()+41);
		}
		else{
			peca.setPosicaoX(this.jogo.getPosicaoA().getPosicaoX());
			peca.setPosicaoY(this.jogo.getPosicaoA().getPosicaoY());
			this.jogo.getPosicaoA().setPosicaoCarrocaX(jogo.getPosicaoA().getPosicaoCarrocaX()+83);
		}
		
	}
	
	public void jogarTabuleito(Peca peca){
		this.posicionarPeca(peca);
		jogo.getTabuleiro().getPecas().incluir(peca);
		
	}
	public Jogo getJogo() {
		return jogo;
	}

	public void setJogo(Jogo jogo) {
		this.jogo = jogo;
	}

}
