package Repositorio;

import java.util.ArrayList;

import Negocios.Jogada;

public class RepositorioJogadas {
	private ArrayList<Jogada> jogadas;

	public RepositorioJogadas() {
		jogadas = new ArrayList<Jogada>();
	}

	public void incluir(Jogada jogada) {
		
		if (this.procurar(jogada)== -1){
			
			this.jogadas.add(jogada);
		}
		
	}

	public void excluir(Jogada jogada) {
		int ind = this.procurar(jogada);
		if (ind>-1){
			jogadas.remove(ind);
		}

	}
	public Jogada procurarInd(int ind){
		Jogada resp = null;
		if(ind < this.tamanho()){
			resp = jogadas.get(ind);
		}
		return resp;
	}
	public int procurar(Jogada jogada) {
		boolean achei = false;
		int resp = -1;
		int tan = this.tamanho();
		for (int i = 0; (i < tan && (!achei)); i++) {
			if (this.jogadas.get(i).equals(jogada)) {
				achei = true;
				resp=i;
				
			}

		}

		return resp;
	}

	public int tamanho() {
		return jogadas.size();
	}
	
	public boolean existeLado(String lado){
		boolean resp = false;
		for(int i = 0;(i<this.tamanho())&&(!resp);i++){
			if(lado.equals(this.procurarInd(i).getLado())){
				resp=true;
			}
		}
		return resp;
	}
	
	public Jogada acharJogada(String lado,int peca){
		Jogada resp = null;
		for(int i = 0; i< this.tamanho();i++){
			if(procurarInd(i).getLado().equals(lado)){
				if((this.procurarInd(i).getPeca().getLadoA()==peca)||(this.procurarInd(i).getPeca().getLadoB()==peca)){
					resp = this.procurarInd(i);
				}
			}
		}
		return resp;
	}
	
	public void excluirLado(String lado){
		boolean achei = false;
		int tan = this.tamanho();
		for (int i = 0; (i < tan && (!achei)); i++) {
			if (this.jogadas.get(i).getLado().equals(lado)) {
				achei = true;
				this.excluir(this.jogadas.get(i));				
			}

		}
	}

}
