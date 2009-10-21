package Repositorio;

/*
 * @author F�bio Rodrigues
 * Esta classe implementa um repositorio de pecas para o jogo onde sevir� de 
 * base as pecas do jogo e a dos jogadores.
 */

import java.util.ArrayList;

import Negocios.Jogada;
import Negocios.Peca;

public class Repositorio {

	private ArrayList<Peca> pecas;

	public Repositorio() {
		pecas = new ArrayList<Peca>();
	}

	public void incluir(Peca peca) {
		this.pecas.add(peca);
	}

	public void excluir(int ind) {
		pecas.remove(ind);

	}

	public Peca procurar(int ind) {
		Peca resp = pecas.get(ind);
		return resp;

	}

	public Peca procurarId(int id) {
		Peca resp = null;
		boolean achei = false;
		int tan = this.tamanho();
		for (int i = 0; (i < tan || (!achei)); i++) {
			if (this.procurar(i).getId() == id) {
				resp = this.procurar(i);
				achei = true;
			}

		}

		return resp;
	}

	public int tamanho() {
		return pecas.size();
	}

	public Jogada procurar(int ladoA,int ladoB){
		boolean achei = false;
		int ind;
		Jogada resp = null;
		for(ind=0; (ind <= this.tamanho())&&(!achei);ind++){
			if(ladoA==this.pecas.get(ind).getLadoA()||ladoA==this.pecas.get(ind).getLadoB()){
				achei = true;
				resp = new Jogada("a",this.procurar(ind));
			}
			else if(!achei && ladoB==this.pecas.get(ind).getLadoA()||ladoB==this.pecas.get(ind).getLadoB()){
				achei = true;
				resp = new Jogada("b",this.procurar(ind));
			}
		}
		return resp;
	}

}
