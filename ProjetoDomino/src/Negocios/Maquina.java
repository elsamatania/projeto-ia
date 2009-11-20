package Negocios;

import java.util.ArrayList;

import Negocios.Controle.Excessao.NaoTemPecaException;
import Repositorio.RepositorioJogadas;

public class Maquina extends Jogador{
	
	public Maquina(String nome) {
		super(nome);
		
	}

	public Jogada jogar(int ladoA,int ladoB,Dados dados)throws NaoTemPecaException{
		RepositorioJogadas possibilidades = jogo.jogadas(ladoA, ladoB);
		this.ordenar(possibilidades);
		//System.out.println(possibilidades.tamanho());
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
			if(possibilidades.procurarInd(0).equals(possibilidades.procurarInd(1))){//neste caso eu tenho uma peça para os dois lados ou faz doia A ou dois B evitar cruzada
				int lA = this.contarPecasTabuleiro(ladoA, dados);//conta quantas vezes o lado já saiu 
				int lB = this.contarPecasTabuleiro(ladoA, dados);//conta quantas vezes o lado já saiu
				/*se tivermos 5 pecas na mesa a que esta na mão é a sexta
				 * faltando apenas a carroça podendo levar uma cruzada
				 */
				if(((lA!=5) && (lB!=5))||((lA==5) && (lB==5))){//se as duas não tiver possibilidade de cruzada escolher aleatóriamante ou se os dois teverem possibilidade.
					resp= possibilidades.procurarInd(possibilidades.tamanho()*(int)Math.random());
				}
				else if(lA==5){
					possibilidades.excluirLado(ladoA);
					resp = possibilidades.procurarInd(1);
				}
				else{
					possibilidades.excluirLado(ladoB);
					resp = possibilidades.procurarInd(1);
				}
			}
			else{
				ArrayList carrocas = verificarCarrocas(possibilidades);
				boolean jogou = false;
				for(int i = 0; i< carrocas.size();i++){
					
				}
				
			}
		}
		else{
			ArrayList carrocas = verificarCarrocas(possibilidades);
		}
		resp = this.jogo.procurar(ladoA, ladoB);
		jogo.excluirId(resp.getPeca().getId());
		return resp;
	}
	
	
	//ordenar as possibilidades de jogar do maio para o menor
	public void ordenar(RepositorioJogadas jogadas){
		ArrayList<Jogada> ordem = new ArrayList<Jogada>();
		//ordena
		for(int i = 0; jogadas.tamanho() > 0;){
			Jogada maior = jogadas.procurarInd(i);
			for (int j = i+1 ; j < jogadas.tamanho() ; j++){
				if(maior.getPeca().getValor() < jogadas.procurarInd(j).getPeca().getValor()){
					maior = jogadas.procurarInd(j);
					
				}
			}
			ordem.add(maior);
			jogadas.excluir(maior);
		}
		for(int i = 0;i<ordem.size();i++){
			jogadas.incluir(ordem.get(i));
		}
		
	}
	
	
	//retorna um array das carroças possíveide jogar
	public ArrayList<Jogada> verificarCarrocas(RepositorioJogadas jogadas){
		ArrayList<Jogada> resp = new ArrayList<Jogada>();
		for(int i = 0; i<jogadas.tamanho();i++){
			if(jogadas.procurarInd(i).getPeca().isCarroca()){
				resp.add(jogadas.procurarInd(i));
			}
		}
		for(int i = 0 ; i<resp.size();i++){
			System.out.println(resp.get(i).getPeca().getValor());
		}
		return resp;
	}
	
	/*
	 * função retorna um array com o número de peças dos adverçarios
	 */
	private int[] nPecasAdver(Dados dados){//numero de peças adverçarias
		int [] resp  = {0,0,0};
		int eu = this.jogo.tamanho();
		if (eu==dados.getPecasJogador2()){
			resp[0] = dados.getPecasJogador1();
			resp[1] = dados.getPecasJogador3();
			resp[2] = dados.getPecasJogador4();
		}
		else if(eu == dados.getPecasJogador3()){
			resp[0] = dados.getPecasJogador1();
			resp[1] = dados.getPecasJogador2();
			resp[2] = dados.getPecasJogador4();
		}
		else{
			resp[0] = dados.getPecasJogador1();
			resp[1] = dados.getPecasJogador2();
			resp[2] = dados.getPecasJogador3();
		}
		return resp;
	}
	
	/*
	 * retorna a quantidade de peças na mesa com o lado passado como parametro
	 */
	private int contarPecasTabuleiro(int lado, Dados dados){
		int resp = 0;
		switch (lado){
			case 0:
				resp=dados.getBranco();
			break;
			case 1:
				resp=dados.getPio();
			break;
			case 2:
				resp=dados.getDuke();
			break;
			case 3:
				resp=dados.getTerno();
			break;
			case 4:
				resp=dados.getQuadra();
			break;
			case 5:
				resp=dados.getQuina();
			break;
			case 6:
				resp=dados.getSena();
			break;
		}
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
