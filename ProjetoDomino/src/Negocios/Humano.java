package Negocios;

public class Humano extends Jogador {
	
	public Humano(String nome) {
		super(nome);
		
	}

	public Peca jogar(int id){
		return this.jogo.procurarId(id);
	}

	
}
