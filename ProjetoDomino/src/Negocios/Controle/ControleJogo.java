package Negocios.Controle;

 

import Negocios.Jogador;
import Negocios.Jogo;
import Negocios.Peca;
import Repositorio.Repositorio;

public class ControleJogo {
	
	private Jogo jogo = new Jogo();
	
	public void receberPecas(Repositorio pecas){
		jogo.setPecas(pecas);
	}
	
	public void definirJogadores(Jogador jog1,Jogador jog2,Jogador jog3,Jogador jog4){
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
	
	public void jogada(Peca peca){
		
	}
	public Jogador partida(){
		Jogador vencedor = null;
		boolean terminou=false;
		for(;!terminou;){
			
		}
		return vencedor;
	}

}
