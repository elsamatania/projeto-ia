package Repositorio;

/*
 * @author Fábio Rodrigues
 * Esta classe implementa um repositorio de pecas para o jogo onde sevirá de 
 * base as pecas do jogo e a dos jogadores.
 */

import java.util.ArrayList;

import Negocios.Jogada;
import Negocios.Peca;
import Negocios.Controle.Excessao.NaoTemPecaException;

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
	
	public void excluirId(int id){
		boolean achei = false;
		int tan = this.tamanho();
		for (int i = 0; (i < tan && (!achei)); i++) {
			if (this.procurar(i).getId() == id) {
				this.excluir(i);
				achei = true;
			}

		}

	}

	public Peca procurar(int ind) {
		
		Peca resp = pecas.get(ind);
		return resp;

	}

	public Peca procurarId(int id) {
		Peca resp = null;
		boolean achei = false;
		int tan = this.tamanho();
		for (int i = 0; (i < tan && (!achei)); i++) {
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
	
	public Peca procurarCarroca(int lado){
		Peca resp = null;
		for(int i=0;i < this.tamanho();i++){
			if((this.pecas.get(i).isCarroca())&&(this.pecas.get(i).getLadoA()== lado)){
				resp=this.pecas.get(i);
			}
		}
		return resp;
	}

	public Jogada procurar(int ladoA,int ladoB)throws NaoTemPecaException{
		boolean achei = false;
		int ind;
		Jogada resp = null;
		for(ind=0; (ind < this.tamanho())&&(!achei);ind++){
			if(ladoA==this.pecas.get(ind).getLadoA()||ladoA==this.pecas.get(ind).getLadoB()){
				achei = true;
				resp = new Jogada("a",this.procurar(ind));
			}
			else if(!achei && ladoB==this.pecas.get(ind).getLadoA()||ladoB==this.pecas.get(ind).getLadoB()){
				achei = true;
				resp = new Jogada("b",this.procurar(ind));
			}
		}
		if(resp==null){
			throw new  NaoTemPecaException();
		}
		return resp;
	}
	
	public RepositorioJogadas jogadas(int ladoA,int ladoB){
		RepositorioJogadas resp = new RepositorioJogadas();
		for(int i=0;i<this.tamanho();i++){
			if(ladoA==this.pecas.get(i).getLadoA()||ladoA==this.pecas.get(i).getLadoB()){
				Jogada jogada = new Jogada("a",this.pecas.get(i));
				resp.incluir(jogada);
				
			}
			else if(ladoB==this.pecas.get(i).getLadoA()||ladoB==this.pecas.get(i).getLadoB()){
				Jogada jogada = new Jogada("b",this.pecas.get(i));
				resp.incluir(jogada);
			}
		}
		return resp;
	}
	
	public int contarPecas(int lado){
		int resp = 0;
		for(int i=0;i<this.tamanho();i++){
			if(this.procurar(i).getLadoA()==lado||this.procurar(i).getLadoB()==lado){
				resp++;
			}
		}
		return resp;
	}

}
