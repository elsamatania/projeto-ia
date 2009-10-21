package Negocios;

public class Maquina extends Jogador{
	
	public Maquina(String nome) {
		super(nome);
		
	}

	public Jogada jogar(int ladoA,int ladoB){
		Jogada resp = this.jogo.procurar(ladoA, ladoB);
		return resp;
	}

}
