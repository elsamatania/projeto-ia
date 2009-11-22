package Negocios;

import java.util.ArrayList;

import Negocios.Controle.Excessao.NaoTemPecaException;
import Repositorio.RepositorioJogadas;

public class Maquina extends Jogador{
	
	public Maquina(String nome) {
		super(nome);
		
	}

	/*
	 * Nesta parte esta toda inteligencia da máquina ele recebe os lados possiveis um objeto com os dados
	 * de historico do jogo, quantidade de peças ja jogada e toque dos jogadores 
	 */
	
	public Jogada jogar(int ladoA,int ladoB,Dados dados)throws NaoTemPecaException{
		RepositorioJogadas possibilidades = jogo.jogadas(ladoA, ladoB);
		System.out.printf("Possibilidades: "+possibilidades.tamanho()+" - ");
		this.ordenar(possibilidades);
		Jogada resp = null;
		if(possibilidades.tamanho()==0){//quer dizer que não tem peça para jogar
			throw new  NaoTemPecaException();
		}
		else if(possibilidades.tamanho()==1){//como só existe uma possibilidade de jogar. Jogar!!
			resp = possibilidades.procurarInd(0);
			System.out.println("Só tem uma possibilidade");
		}
		else if((possibilidades.tamanho()==2)&&(ladoA==ladoB)){//se temos 2 possibilidade e os lados são iguais então é a mesma peça e o lado não faz diferença
			resp = possibilidades.procurarInd(0);
			System.out.println("Mesma peça");
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
					System.out.println("Escolha aleatrotia uma peça duas possibilidades");
				}
				else if(lA==5){//caso só haja possibilidade de cruzada no lado A ele excluir a jogada do lado A e joga a qua ficou no lado B
					possibilidades.excluirLado("a");
					resp = possibilidades.procurarInd(0);
					System.out.println("Evitar cruzada lado A");
				}
				else{//caso só haja no lado B ele excluir a jogada do lado B e joga a qua ficou no lado A
					possibilidades.excluirLado("b");
					resp = possibilidades.procurarInd(0);
					System.out.println("Evitar cruzada lado B");
				}
			}
			else{
				ArrayList<Jogada> carrocas = verificarCarrocas(possibilidades);
				boolean jogou = false;
				for(int i = 0; (i< carrocas.size())&&(!jogou);i++){//descobrir se existe alguma carroça com perigo de fuzilamento
					//caso tenha 5 peças ja no tab. e nenhuma na mão pode ser fusilada então jogar logo.
					if((jogo.contarPecas(carrocas.get(i).getPeca().getLadoA())==0)&&(this.contarPecasTabuleiro(carrocas.get(i).getPeca().getLadoA(), dados)==5)){
						resp = carrocas.get(i);
						jogou = true;
						System.out.println("Evitar fuzilamento duas pecas dif");
					}
				}
				if(!jogou){//caso não haja carroça a ser fusilada e a jogada nã tenha sido feita
					int ladoATab = this.contarPecasTabuleiro(ladoA, dados); 
					int ladoBTab = this.contarPecasTabuleiro(ladoB, dados);
					int ladoAMao = jogo.contarPecas(ladoA);
					int ladoBMao = jogo.contarPecas(ladoB);
					int totalA = ladoATab + ladoAMao;
					int totalB = ladoBTab + ladoBMao;
					//inicio if chicote
					if(totalA==7){//encontrou um chicote no tabuleiro vai tentar manter e se puder levantar do outro lado(if chicote lado A)
						//caso tenha um chicote com 2 na mão e dua peças fazer dois lados iguais para fzer a cruzada
						//ou caso tenha mais de duas, fazer dois lados iguais provocar um toque geral, matar uma cabeça na rodada e ficar com outro lado chicoteado.
						System.out.printf(" - Encontrou chicote duas pecas!!! - ");
						if((ladoAMao==2)&&(possibilidades.acharJogada("b", ladoA)!=null)&&(jogo.tamanho()==2)||(ladoAMao>2)&&(possibilidades.acharJogada("b", ladoA)!=null)){
							resp=possibilidades.acharJogada("b", ladoA);
							System.out.println("Levatar chicote duas peças");
						}
						else if(possibilidades.existeLado("b")){
							possibilidades.excluirLado("a");//exclui todas jogadas do lado onde ele tem o chicote para guarda-lo
							carrocas = verificarCarrocas(possibilidades);//da prioridade a jogar uma carroça do lado oposto ao chicote
							if(carrocas.size()>0){
								resp = carrocas.get(0);
								System.out.println("Evitar comer chicote prio carroça A duas pecas dif");
							}
							else{
								//encontra a peca que le tem em maior quantidade e joga.
								int contaMaior = 0;
								int maior = 0;
								for(int i = 0; i < possibilidades.tamanho();i++){
									int atual = ladoB == possibilidades.procurarInd(i).getPeca().getLadoA()?possibilidades.procurarInd(i).getPeca().getLadoB():possibilidades.procurarInd(i).getPeca().getLadoA();
									int contar = jogo.contarPecas(atual);
									if(contar > contaMaior){
										maior = atual;
									}
								}
								resp = possibilidades.acharJogada("b", maior);
								System.out.println("Evitar comer chitote duas pecas dif");
							}
						}
						else{//se só tever como jogar do lado a 
							carrocas = verificarCarrocas(possibilidades);//da prioridade a jogar uma carroça do lado do chicote e mante-lo
							if(carrocas.size()>0){
								resp = carrocas.get(0);
								System.out.println("comer chicote usando carroça A duas pecas dif");
							}
							else{
								//encontra a peca que le tem em maior quantidade e joga.
								int contaMaior = 0;
								int maior = 0;
								for(int i = 0; i < possibilidades.tamanho();i++){
									int atual = ladoB == possibilidades.procurarInd(i).getPeca().getLadoA()?possibilidades.procurarInd(i).getPeca().getLadoB():possibilidades.procurarInd(i).getPeca().getLadoA();
									int contar = jogo.contarPecas(atual);
									if(contar > contaMaior){
										maior = atual;
									}
								}
								resp = possibilidades.acharJogada("b", maior);
								System.out.println("Não pode evitar comer chicote A duas pecas dif");
							}
						}
					}//(fim if chicote lado A)
					//if chicote lado B
					else if(totalB==7){
						//caso tenha um chicote com 2 na mão e dua peças fazer dois lados iguais para fzer a cruzada
						//ou caso tenha mais de duas, fazer dois lados iguais provocar um toque geral, matar uma cabeça na rodada e ficar com outro lado chicoteado.
						System.out.printf(" - Encontrou chicote duas pecas!!! - ");
						if((ladoAMao==2)&&(possibilidades.acharJogada("a", ladoB)!=null)&&(jogo.tamanho()==2)||(ladoAMao>2)&&(possibilidades.acharJogada("a", ladoB)!=null)){
							resp=possibilidades.acharJogada("a", ladoB);
						}
						else if(possibilidades.existeLado("a")){
							possibilidades.excluirLado("b");//exclui todas jogadas do lado onde ele tem o chicote para guarda-lo
							carrocas = verificarCarrocas(possibilidades);//da prioridade a jogar uma carroça do lado oposto ao chicote
							if(carrocas.size()>0){
								resp = carrocas.get(0);
								System.out.println("Evitar chicote B prior carroça duas pecas dif");
							}
							else{
								//encontra a peca que le tem em maior quantidade e joga.
								int contaMaior = 0;
								int maior = 0;
								for(int i = 0; i < possibilidades.tamanho();i++){
									int atual = ladoA == possibilidades.procurarInd(i).getPeca().getLadoA()?possibilidades.procurarInd(i).getPeca().getLadoB():possibilidades.procurarInd(i).getPeca().getLadoA();
									int contar = jogo.contarPecas(atual);
									if(contar > contaMaior){
										maior = atual;
									}
								}
								resp = possibilidades.acharJogada("b", maior);
								System.out.println("Evitar chicote lado B duas pecas dif");
							}
						}
						else{//se só tever como jogar do lado b 
							carrocas = verificarCarrocas(possibilidades);//da prioridade a jogar uma carroça do lado do chicote e mante-lo
							if(carrocas.size()>0){
								resp = carrocas.get(0);
								System.out.println("Evitar chicote com carroça B duas pecas dif");
							}
							else{
								//encontra a peca que le tem em maior quantidade e joga.
								int contaMaior = 0;
								int maior = 0;
								int atual;
								for(int i = 0; i < possibilidades.tamanho();i++){
									atual = ladoB == possibilidades.procurarInd(i).getPeca().getLadoA()?possibilidades.procurarInd(i).getPeca().getLadoB():possibilidades.procurarInd(i).getPeca().getLadoA();
									int contar = jogo.contarPecas(atual);
									if(contar > contaMaior){
										maior = atual;
									}
								}
								resp = possibilidades.acharJogada("b", maior);
								System.out.println("Não pode evitar chicote B duas pecas dif");
							}
						}
					//Fim elseif chicote lado b	
					}//fim if chicote
					else{//não encontrou chicote usando Lado A ou B (procurar pecas para levantar chicote ou de maior quantidade na mao para jogar)
						//**********************implementar
						int contaMao = 0;
						int contaMesa = 0;
						int contaMaiorMao = 0;
						int pecaAtual = 0;
						Jogada chicote = null;
						Jogada melhorJogada = null;
						boolean achouChicote = false;
						for(int i = 0 ;(i<possibilidades.tamanho())&&(!achouChicote);i++ ){
							if(possibilidades.procurarInd(i).getLado().equals("a")){
								pecaAtual = ladoA==possibilidades.procurarInd(i).getPeca().getLadoA()?possibilidades.procurarInd(i).getPeca().getLadoB():possibilidades.procurarInd(i).getPeca().getLadoA();
							}
							else{
								pecaAtual = ladoB==possibilidades.procurarInd(i).getPeca().getLadoB()?possibilidades.procurarInd(i).getPeca().getLadoA():possibilidades.procurarInd(i).getPeca().getLadoB();
							}
							contaMao = this.jogo.contarPecas(pecaAtual);
							contaMesa = this.contarPecasTabuleiro(pecaAtual, dados); 
							if(contaMesa + contaMao == 7){
								chicote = possibilidades.procurarInd(i);
								achouChicote=true;
								System.out.printf(" - Encontrou chicote duas pecas!!! - ");
							}
							
						}
						if(chicote!=null){
							resp = chicote;
							System.out.println("Chicote sem lado  duas pecas dif");
						}
						else{
							if((ladoATab>ladoBTab)&&(possibilidades.existeLado("b"))){//manter o lado com mais peças ja na mesa 
								possibilidades.excluirLado("a");
								System.out.print(" - Manter A - ");
							}
							if((ladoATab<ladoBTab)&&(possibilidades.existeLado("a"))){//manter o lado com mais peças ja na mesa
								possibilidades.excluirLado("b");
								System.out.printf(" - Manter B - ");
							}
							for(int i = 0 ;(i<possibilidades.tamanho());i++ ){
								if(possibilidades.procurarInd(i).getLado().equals("a")){
									pecaAtual = ladoA==possibilidades.procurarInd(i).getPeca().getLadoA()?possibilidades.procurarInd(i).getPeca().getLadoB():possibilidades.procurarInd(i).getPeca().getLadoA();
								}
								else{
									pecaAtual = ladoB==possibilidades.procurarInd(i).getPeca().getLadoB()?possibilidades.procurarInd(i).getPeca().getLadoA():possibilidades.procurarInd(i).getPeca().getLadoB();
								}
								contaMao = this.jogo.contarPecas(pecaAtual);
								contaMesa = this.contarPecasTabuleiro(pecaAtual, dados); 
								if(contaMao > contaMaiorMao){
									melhorJogada = possibilidades.procurarInd(i);
								}
							}
							resp = melhorJogada;
							System.out.println("melhor jogada");
							resp = melhorJogada;
							System.out.println("Melhor jogada sem lado  duas pecas dif");
						}//fim else melhor jogada sem chicote usando lado A ou B
					}//fim else não encontrou chicote Lado A ou B
				}//Fim if não jogou
			}//fim duas jogadas com peças diferentes
		}//fim duas jogadas 
		else{//mais de 2 jogadas será identica a 2 jogadas com peças diferentes
			ArrayList<Jogada> carrocas = verificarCarrocas(possibilidades);
			boolean jogou = false;
			for(int i = 0; (i< carrocas.size())&&(!jogou);i++){//descobrir se existe alguma carroça com perigo de fuzilamento
				//caso tenha 5 peças ja no tab. e nenhuma na mão pode ser fusilada então jogar logo.
				if((jogo.contarPecas(carrocas.get(i).getPeca().getLadoA())==0)&&(this.contarPecasTabuleiro(carrocas.get(i).getPeca().getLadoA(), dados)==5)){
					resp = carrocas.get(i);
					jogou = true;
					System.out.println(" - Evitar Fuzilamento - ");
				}
			}
			if(!jogou){//caso não haja carroça a ser fusilada e a jogada nã tenha sido feita
				int ladoATab = this.contarPecasTabuleiro(ladoA, dados); 
				int ladoBTab = this.contarPecasTabuleiro(ladoB, dados);
				int ladoAMao = jogo.contarPecas(ladoA);
				int ladoBMao = jogo.contarPecas(ladoB);
				int totalA = ladoATab + ladoAMao;
				int totalB = ladoBTab + ladoBMao;
				//inicio if chicote
				if(totalA==7){//encontrou um chicote no tabuleiro vai tentar manter e se puder levantar do outro lado(if chicote lado A)
					//caso tenha um chicote com 2 na mão e dua peças fazer dois lados iguais para fzer a cruzada
					//ou caso tenha mais de duas, fazer dois lados iguais provocar um toque geral, matar uma cabeça na rodada e ficar com outro lado chicoteado.
					System.out.printf(" - Encontrou chicote !!! - ");
					if((ladoAMao==2)&&(possibilidades.acharJogada("b", ladoA)!=null)&&(jogo.tamanho()==2)||(ladoAMao>2)&&(possibilidades.acharJogada("b", ladoA)!=null)){
						resp=possibilidades.acharJogada("b", ladoA);
						System.out.println("chicote com lados A ou B");
					}
					else if(possibilidades.existeLado("b")){
						possibilidades.excluirLado("a");//exclui todas jogadas do lado onde ele tem o chicote para guarda-lo
						carrocas = verificarCarrocas(possibilidades);//da prioridade a jogar uma carroça do lado oposto ao chicote
						System.out.println(" - Manter A - ");
						if(carrocas.size()>0){
							resp = carrocas.get(0);
							System.out.println("manter chicote com carroça A");
						}
						else{
							//encontra a peca que le tem em maior quantidade e joga.
							int contaMaior = 0;
							int maior = 0;
							for(int i = 0; i < possibilidades.tamanho();i++){
								int atual = ladoB == possibilidades.procurarInd(i).getPeca().getLadoA()?possibilidades.procurarInd(i).getPeca().getLadoB():possibilidades.procurarInd(i).getPeca().getLadoA();
								int contar = jogo.contarPecas(atual);
								if(contar > contaMaior){
									maior = atual;
								}
							}
							resp = possibilidades.acharJogada("b", maior);
							System.out.println("não pode manter chicote com carroça A");
						}
					}
					else{//se só tever como jogar do lado a 
						carrocas = verificarCarrocas(possibilidades);//da prioridade a jogar uma carroça do lado do chicote e mante-lo
						if(carrocas.size()>0){
							resp = carrocas.get(0);
							System.out.println("manter chicote com carroça B");
						}
						else{
							//encontra a peca que le tem em maior quantidade e joga.
							int contaMaior = 0;
							int maior = 0;
							for(int i = 0; i < possibilidades.tamanho();i++){
								int atual = ladoB == possibilidades.procurarInd(i).getPeca().getLadoA()?possibilidades.procurarInd(i).getPeca().getLadoB():possibilidades.procurarInd(i).getPeca().getLadoA();
								int contar = jogo.contarPecas(atual);
								if(contar > contaMaior){
									maior = atual;
								}
							}
							resp = possibilidades.acharJogada("b", maior);
							System.out.println("não pode manter chicote com carroça B");
						}
					}
				}//(fim if chicote lado A)
				//if chicote lado B
				else if(totalB==7){
					//caso tenha um chicote com 2 na mão e dua peças fazer dois lados iguais para fzer a cruzada
					//ou caso tenha mais de duas, fazer dois lados iguais provocar um toque geral, matar uma cabeça na rodada e ficar com outro lado chicoteado.
					System.out.printf(" - Encontrou chicote !!! - ");
					if((ladoAMao==2)&&(possibilidades.acharJogada("a", ladoB)!=null)&&(jogo.tamanho()==2)||(ladoAMao>2)&&(possibilidades.acharJogada("a", ladoB)!=null)){
						resp=possibilidades.acharJogada("a", ladoB);
					}
					else if(possibilidades.existeLado("a")){
						possibilidades.excluirLado("b");//exclui todas jogadas do lado onde ele tem o chicote para guarda-lo
						carrocas = verificarCarrocas(possibilidades);//da prioridade a jogar uma carroça do lado oposto ao chicote
						System.out.println(" - Manter B - ");
						if(carrocas.size()>0){
							resp = carrocas.get(0);
							System.out.println("carrocas 2 pecas A");
						}
						else{
							//encontra a peca que le tem em maior quantidade e joga.
							int contaMaior = 0;
							int maior = 0;
							for(int i = 0; i < possibilidades.tamanho();i++){
								int atual = ladoA == possibilidades.procurarInd(i).getPeca().getLadoA()?possibilidades.procurarInd(i).getPeca().getLadoB():possibilidades.procurarInd(i).getPeca().getLadoA();
								int contar = jogo.contarPecas(atual);
								if(contar > contaMaior){
									maior = atual;
								}
							}
							resp = possibilidades.acharJogada("b", maior);
							System.out.println("melhor jogada duas pecas A");
						}
					}
					else{//se só tever como jogar do lado a 
						carrocas = verificarCarrocas(possibilidades);//da prioridade a jogar uma carroça do lado do chicote e mante-lo
						if(carrocas.size()>0){
							resp = carrocas.get(0);
							System.out.println("carrocas duas pecas B");
						}
						else{
							//encontra a peca que le tem em maior quantidade e joga.
							int contaMaior = 0;
							int maior = 0;
							int atual;
							for(int i = 0; i < possibilidades.tamanho();i++){
								atual = ladoB == possibilidades.procurarInd(i).getPeca().getLadoA()?possibilidades.procurarInd(i).getPeca().getLadoB():possibilidades.procurarInd(i).getPeca().getLadoA();
								int contar = jogo.contarPecas(atual);
								if(contar > contaMaior){
									maior = atual;
								}
							}
							resp = possibilidades.acharJogada("b", maior);
							System.out.println("melhor jogada duas pecas B");
						}
					}
				//Fim elseif chicote lado b	
				}//fim if chicote
				else{//não encontrou chicote usando Lado A ou B (procurar pecas para levantar chicote ou de maior quantidade na mao para jogar)
					int contaMao = 0;
					int contaMesa = 0;
					int contaMaiorMao = 0;
					int pecaAtual = 0;
					Jogada chicote = null;
					Jogada melhorJogada = null;
					boolean achouChicote = false;
					for(int i = 0 ;(i<possibilidades.tamanho())&&(!achouChicote);i++ ){
						if(possibilidades.procurarInd(i).getLado().equals("a")){
							pecaAtual = ladoA==possibilidades.procurarInd(i).getPeca().getLadoA()?possibilidades.procurarInd(i).getPeca().getLadoB():possibilidades.procurarInd(i).getPeca().getLadoA();
						}
						else{
							pecaAtual = ladoB==possibilidades.procurarInd(i).getPeca().getLadoB()?possibilidades.procurarInd(i).getPeca().getLadoA():possibilidades.procurarInd(i).getPeca().getLadoB();
						}
						contaMao = this.jogo.contarPecas(pecaAtual);
						contaMesa = this.contarPecasTabuleiro(pecaAtual, dados); 
						if(contaMesa + contaMao == 7){
							chicote = possibilidades.procurarInd(i);
							achouChicote=true;
						}
					}
					if(chicote!=null){
						resp = chicote;
						System.out.println(" - Encontrou!!! - ");
					}
					else{
						if((ladoATab>ladoBTab)&&(possibilidades.existeLado("b"))){
							possibilidades.excluirLado("a");
							System.out.print(" - Manter A - ");
						}
						if((ladoATab<ladoBTab)&&(possibilidades.existeLado("a"))){
							possibilidades.excluirLado("b");
							System.out.printf(" - Manter B - ");
						}
						for(int i = 0 ;(i<possibilidades.tamanho());i++ ){
							if(possibilidades.procurarInd(i).getLado().equals("a")){//pega o lado oposto a jogada e para contar com a que tem na mão
								pecaAtual = ladoA==possibilidades.procurarInd(i).getPeca().getLadoA()?possibilidades.procurarInd(i).getPeca().getLadoB():possibilidades.procurarInd(i).getPeca().getLadoA();
							}
							else{
								pecaAtual = ladoB==possibilidades.procurarInd(i).getPeca().getLadoB()?possibilidades.procurarInd(i).getPeca().getLadoA():possibilidades.procurarInd(i).getPeca().getLadoB();
							}
							contaMao = this.jogo.contarPecas(pecaAtual);
							contaMesa = this.contarPecasTabuleiro(pecaAtual, dados); 
							if(contaMao > contaMaiorMao){
								melhorJogada = possibilidades.procurarInd(i);
							}
						}
						resp = melhorJogada;
						System.out.println("melhor jogada");
					}//fim else melhor jogada sem chicote usando lado A ou B
				}//fim else não encontrou chicote Lado A ou B
			}//Fim if não jogou
		}//fim duas jogadas com peças diferentes
		//resp = this.jogo.procurar(ladoA, ladoB);
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
