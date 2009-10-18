package Negocios;

public class Humano extends Jogador {
	
	public Humano(String nome) {
		super(nome);
		
	}

	public Peca jogar(int id){
		Peca resp = this.jogo.procurarId(id);
		return resp;
	}

	
}
