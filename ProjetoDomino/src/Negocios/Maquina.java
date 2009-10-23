package Negocios;

import Negocios.Controle.Excessao.NaoTemPecaException;

public class Maquina extends Jogador{
	
	public Maquina(String nome) {
		super(nome);
		
	}

	public Jogada jogar(int ladoA,int ladoB)throws NaoTemPecaException{
		Jogada resp = this.jogo.procurar(ladoA, ladoB);
		jogo.excluirId(resp.getPeca().getId());
		return resp;
	}

}
