package Repositorio;

import java.util.ArrayList;

import Negocios.ImagemPeca;

public class RepositorioImagem {
	
private ArrayList<ImagemPeca> imagens;
	
	public RepositorioImagem (){
		imagens = new ArrayList<ImagemPeca>();
	}
	
	
	public void incluir (ImagemPeca imagem){
		this.imagens.add(imagem);
	}
	
	
	public void excluir(int ind){
		imagens.remove(ind);
		
	}
	
	
	public ImagemPeca procurar(int ind){
		ImagemPeca resp = imagens.get(ind);
		return resp;
		
	}
		
	public int tamanho(){
		return imagens.size();
	}
	

}
