package Repositorio;

import java.util.ArrayList;

import Negocios.Jogada;

public class RepositorioJogadas {
	private ArrayList<Jogada> jogadas;

	public RepositorioJogadas() {
		jogadas = new ArrayList<Jogada>();
	}

	public void incluir(Jogada jogada) {
		if (this.procurar(jogada)>-1){
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
	

}
