package Negocios;

public class Maquina extends Jogador{
	
	public Maquina(String nome) {
		super(nome);
		
	}

	public Peca jogar(int ladoA,int ladoB){
		int id = this.jogo.procurar(ladoA, ladoB);
		return this.jogo.procurarId(id);
	}

}
