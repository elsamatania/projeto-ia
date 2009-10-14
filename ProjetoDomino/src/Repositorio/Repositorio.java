package Repositorio;

/*
 * @author Fábio Rodrigues
 * Esta classe implementa um repositorio de pecas para o jogo onde sevirá de 
 * base as pecas do jogo e a dos jogadores.
 */

import java.util.ArrayList;

import Negocios.Peca;

public class Repositorio {
	
	private ArrayList<Peca> pecas;
	
	public Repositorio (){
		pecas = new ArrayList<Peca>();
	}
	
	
	public void incluir (Peca peca){
		this.pecas.add(peca);
	}
	
	
	public void excluir(int ind){
		pecas.remove(ind);
		
	}
	
	
	public Peca procurar(int ind){
		Peca resp = pecas.get(ind);
		return resp;
		
	}
	public Peca procurarId(int id){
		Peca resp = null;
		boolean achei=false;
		int tan = this.tamanho();
		for (int i=0;i<tan||(!achei);i++){
			if(this.procurar(i).getId()==id){
				resp = this.procurar(1);
				achei = true;
			}
			
		}
		
		return resp;
	}
	
	public int tamanho(){
		return pecas.size();
	}
	
	public int Tamanho(){
		return pecas.size();
	}
	
	public int procurar(int ladoA,int ladoB){
		boolean achei = false;
		int ind;
		int resp = -1;
		for(ind=0; (ind <= this.tamanho())&&(!achei);ind++){
			if(ladoA==this.pecas.get(ind).getLadoA()||ladoA==this.pecas.get(ind).getLadoB()||
					ladoB==this.pecas.get(ind).getLadoA()||ladoB==this.pecas.get(ind).getLadoB()){
				achei = true;
				resp = this.procurar(ind).getId();
			}
		}
		return resp;
	}
	

}
