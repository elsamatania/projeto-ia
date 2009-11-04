package Negocios;

import Negocios.Controle.Excessao.NaoTemPecaException;
import Repositorio.RepositorioJogadas;

public class Maquina extends Jogador{
	
	public Maquina(String nome) {
		super(nome);
		
	}

	public Jogada jogar(int ladoA,int ladoB,Dados dados)throws NaoTemPecaException{
		/*RepositorioJogadas possibilidades = jogo.jogadas(ladoA, ladoB);
		Jogada resp = null;
		if(possibilidades.tamanho()==0){//quer dizer que não tem peça para jogar
			throw new  NaoTemPecaException();
		}
		else if(possibilidades.tamanho()==1){//como só existe uma possibilidade de jogar. Jogar!!
			resp = possibilidades.procurarInd(0);
		}
		else if((possibilidades.tamanho()==2)&&(ladoA==ladoB)){//se temos 2 possibilidade e os lados são iguais então é a mesma peça e o lado não faz diferença
			resp = possibilidades.procurarInd(0);
		}
		else if(possibilidades.tamanho()==2){
			if(possibilidades.procurarInd(0).equals(possibilidades.procurarInd(1))){
				
			}
		}*/
		Jogada resp = this.jogo.procurar(ladoA, ladoB);
		jogo.excluirId(resp.getPeca().getId());
		return resp;
	}
	
	public Jogada jogadaInicioJogo(int lado){
		Jogada resp = null;
		Peca peca = jogo.procurarCarroca(lado);
		if (peca != null){
			resp = new Jogada("a",peca);
			jogo.excluirId(resp.getPeca().getId());
			
		}
		return resp;
		
	}

}
