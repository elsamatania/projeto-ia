package Negocios.Controle;

import java.util.ArrayList;

import GUI.Tabuleiro;
import Negocios.Dados;
import Negocios.Humano;
import Negocios.ImagemPeca;
import Negocios.Jogada;
import Negocios.Jogador;
import Negocios.Jogo;
import Negocios.Maquina;
import Negocios.Peca;
import Negocios.Controle.Excessao.NaoTemPecaException;
import Negocios.Controle.Excessao.PecaInvalidaException;
import Repositorio.Repositorio;

public class ControleJogo {

	private Jogo jogo;
	private static ControleJogo controleJogo = new ControleJogo();
	Dados dados;
	

	private ControleJogo() {
		jogo = new Jogo();
		dados = new Dados();
	}

	public static ControleJogo getControleJogo() {
		if (controleJogo == null) {
			controleJogo = new ControleJogo();
		}
		return controleJogo;

	}

	public Peca jogadaJog1(int id) {
		return jogo.getJogador1().jogar(id);
	}

	public void receberPecas(Repositorio pecas) {
		jogo.setPecas(pecas);
	}

	public void definirTabuleiro(Tabuleiro tab) {
		jogo.setTabuleiro(tab);
	}

	public void definirJogadores(Humano jog1, Maquina jog2, Maquina jog3,
			Maquina jog4) {
		jogo.setJogador1(jog1);
		jogo.setJogador2(jog2);
		jogo.setJogador3(jog3);
		jogo.setJogador4(jog4);
	}
	public ArrayList<Jogador> definirOrdem() {
		ArrayList<Jogador> resp = new ArrayList<Jogador>();
		if(jogo.getSaida().equals("inicio")){
			definirOredemInicio(resp);
		}
		else{
			definirOrdemMeio(resp);
		}
		
		
		return resp;
	}

	private void definirOrdemMeio(ArrayList<Jogador> resp) {
		if(jogo.getSaida().equals("jogador1")){
			resp.add(jogo.getJogador1());
			resp.add(jogo.getJogador2());
			resp.add(jogo.getJogador3());
			resp.add(jogo.getJogador4());
		}
		else if(jogo.getSaida().equals("jogador2")){
			resp.add(jogo.getJogador2());
			resp.add(jogo.getJogador3());
			resp.add(jogo.getJogador4());
			resp.add(jogo.getJogador1());
		}
		else if(jogo.getSaida().equals("jogador3")){
			resp.add(jogo.getJogador3());
			resp.add(jogo.getJogador4());
			resp.add(jogo.getJogador1());
			resp.add(jogo.getJogador2());
		}
		if(jogo.getSaida().equals("jogador4")){
			resp.add(jogo.getJogador4());
			resp.add(jogo.getJogador1());
			resp.add(jogo.getJogador2());
			resp.add(jogo.getJogador3());
		}
	}

	private void definirOredemInicio(ArrayList<Jogador> resp) {
		boolean achou = false;
		for(int i = 6;(i>0)&&(!achou);i--){
			
				if(jogo.getJogador1().getJogo().procurarCarroca(i)!=null){
					achou = true;
					resp.add(jogo.getJogador1());
					resp.add(jogo.getJogador2());
					resp.add(jogo.getJogador3());
					resp.add(jogo.getJogador4());
				}
				else if((jogo.getJogador2().getJogo().procurarCarroca(i)!=null)){
					achou = true;
					resp.add(jogo.getJogador2());
					resp.add(jogo.getJogador3());
					resp.add(jogo.getJogador4());
					resp.add(jogo.getJogador1());
				}
				else if((jogo.getJogador3().getJogo().procurarCarroca(i)!=null)){
					achou = true;
					resp.add(jogo.getJogador3());
					resp.add(jogo.getJogador4());
					resp.add(jogo.getJogador1());
					resp.add(jogo.getJogador2());
				}
				else if(jogo.getJogador4().getJogo().procurarCarroca(i)!=null){
					achou = true;
					resp.add(jogo.getJogador4());
					resp.add(jogo.getJogador1());
					resp.add(jogo.getJogador2());
					resp.add(jogo.getJogador3());
				}
		}
	}
	

	public Repositorio escolherPecas() {
		Peca peca;
		int posicao;
		Repositorio resp = new Repositorio();
		for (int i = 0; i < 6; i++) {
			posicao = (int) (jogo.getPecas().tamanho() * Math.random());
			peca = jogo.getPecas().procurar(posicao);
			jogo.getPecas().excluir(posicao);
			resp.incluir(peca);
		}
		return resp;
	}

	public void distribuirPecas() {
		jogo.getJogador1().setJogo(this.escolherPecas());
		jogo.getJogador2().setJogo(this.escolherPecas());
		jogo.getJogador3().setJogo(this.escolherPecas());
		jogo.getJogador4().setJogo(this.escolherPecas());
	}

	private ImagemPeca posicionarPecaLadoA(Peca peca) {
		ImagemPeca resp = null;
		int tan = this.jogo.getTabuleiro().getTanLadoA();
		if (peca.isCarroca()) {
			if (tan < 6){
				resp = new ImagemPeca(peca.getImagemVret1(),this.jogo.getPosicaoA().getPosicaoCarrocaX(),this.jogo.getPosicaoA().getPosicaoCarrocaY());
				if(tan==5){
					this.jogo.getPosicaoA().setPosicaoY(60);
					this.jogo.getPosicaoA().setPosicaoCarrocaY(80);
				}
				else{
					this.jogo.getPosicaoA().setPosicaoCarrocaX(40);
					this.jogo.getPosicaoA().setPosicaoX(40);
				}
			}
			else if(tan < 8){
				resp = new ImagemPeca(peca.getImagemHor1(),this.jogo.getPosicaoA().getPosicaoCarrocaX(),this.jogo.getPosicaoA().getPosicaoCarrocaY());
				if(tan == 7){
					this.jogo.getPosicaoA().setPosicaoCarrocaX(-40);
					this.jogo.getPosicaoA().setPosicaoX(-122);
					//this.jogo.getPosicaoA().setPosicaoY(40);
				}
				else{
					this.jogo.getPosicaoA().setPosicaoCarrocaY(41);
					this.jogo.getPosicaoA().setPosicaoY(40);
				}
			}
			else{
				resp = new ImagemPeca(peca.getImagemVret1(),this.jogo.getPosicaoA().getPosicaoCarrocaX(),this.jogo.getPosicaoA().getPosicaoCarrocaY());
				this.jogo.getPosicaoA().setPosicaoCarrocaX(-41);
				this.jogo.getPosicaoA().setPosicaoX(-40);
			}
		}
		else {
			if (tan < 6){
				if(jogo.getTabuleiro().getTanLadoA()==0){
					resp = new ImagemPeca(peca.getImagemHor2(),this.jogo.getPosicaoA().getPosicaoX(),this.jogo.getPosicaoA().getPosicaoY());
				}
				else if(peca.getLadoA()==jogo.getLadoA()){
					resp = new ImagemPeca(peca.getImagemHor1(),this.jogo.getPosicaoA().getPosicaoX(),this.jogo.getPosicaoA().getPosicaoY());
				}
				else{
					resp = new ImagemPeca(peca.getImagemHor2(),this.jogo.getPosicaoA().getPosicaoX(),this.jogo.getPosicaoA().getPosicaoY());
				}
					if(tan == 5){
						this.jogo.getPosicaoA().setPosicaoCarrocaY(65);
						this.jogo.getPosicaoA().setPosicaoX(41);
						this.jogo.getPosicaoA().setPosicaoY(41);
						
					}
					else{
						this.jogo.getPosicaoA().setPosicaoX(82);
						this.jogo.getPosicaoA().setPosicaoCarrocaX(82);
						
					}
			}
			else if(tan < 8){
				if(peca.getLadoA()==jogo.getLadoA()){
					resp = new ImagemPeca(peca.getImagemVret1(),this.jogo.getPosicaoA().getPosicaoX(),this.jogo.getPosicaoA().getPosicaoY());
				}
				else{
					resp = new ImagemPeca(peca.getImagemVret2(),this.jogo.getPosicaoA().getPosicaoX(),this.jogo.getPosicaoA().getPosicaoY());
				}
				if(tan == 7){
					this.jogo.getPosicaoA().setPosicaoX(-80);
					//this.jogo.getPosicaoA().setPosicaoCarrocaX(-41);
					this.jogo.getPosicaoA().setPosicaoY(41);
				}
				else{
					this.jogo.getPosicaoA().setPosicaoY(82);
					this.jogo.getPosicaoA().setPosicaoCarrocaY(82);
				}
			}
			else{
				if(peca.getLadoA()==jogo.getLadoA()){
					resp = new ImagemPeca(peca.getImagemHor2(),this.jogo.getPosicaoA().getPosicaoX(),this.jogo.getPosicaoA().getPosicaoY());
				}
				else{
					resp = new ImagemPeca(peca.getImagemHor1(),this.jogo.getPosicaoA().getPosicaoX(),this.jogo.getPosicaoA().getPosicaoY());
				}
				this.jogo.getPosicaoA().setPosicaoX(-82);
				this.jogo.getPosicaoA().setPosicaoCarrocaX(-81);
			}
				
		}
		return resp;
	}
	
	private ImagemPeca posicionarPecaLadoB(Peca peca) {
		ImagemPeca resp = null;
		int tan = this.jogo.getTabuleiro().getTanLadoB();
		if (peca.isCarroca()) {
			if (tan < 6){
				resp = new ImagemPeca(peca.getImagemVret1(),this.jogo.getPosicaoB().getPosicaoCarrocaX(),this.jogo.getPosicaoB().getPosicaoCarrocaY());
				if(tan==5){
					this.jogo.getPosicaoB().setPosicaoY(-106);
					this.jogo.getPosicaoB().setPosicaoX(42);
					this.jogo.getPosicaoB().setPosicaoCarrocaY(-40);
				}
				else{
					this.jogo.getPosicaoB().setPosicaoCarrocaX(-40);
					this.jogo.getPosicaoB().setPosicaoX(-40);
					
				}
			}
			else if(tan < 8){
				resp = new ImagemPeca(peca.getImagemHor1(),this.jogo.getPosicaoB().getPosicaoCarrocaX(),this.jogo.getPosicaoB().getPosicaoCarrocaY());
				if(tan == 7){
					this.jogo.getPosicaoB().setPosicaoCarrocaX(80);
					this.jogo.getPosicaoB().setPosicaoX(83);
					this.jogo.getPosicaoB().setPosicaoY(42);
				}
				else{
					this.jogo.getPosicaoB().setPosicaoCarrocaY(-41);
					this.jogo.getPosicaoB().setPosicaoY(-40);
				}
			}
			else{
				resp = new ImagemPeca(peca.getImagemVret1(),this.jogo.getPosicaoB().getPosicaoCarrocaX(),this.jogo.getPosicaoB().getPosicaoCarrocaY());
				this.jogo.getPosicaoB().setPosicaoCarrocaX(41);
				this.jogo.getPosicaoB().setPosicaoX(41);
			}
		}
		else {
			if (tan < 6){
				if(peca.getLadoA()==jogo.getLadoB()){
					resp = new ImagemPeca(peca.getImagemHor2(),this.jogo.getPosicaoB().getPosicaoX(),this.jogo.getPosicaoB().getPosicaoY());
				}
				else{
					resp = new ImagemPeca(peca.getImagemHor1(),this.jogo.getPosicaoB().getPosicaoX(),this.jogo.getPosicaoB().getPosicaoY());
				}
					if(tan == 5){
						this.jogo.getPosicaoB().setPosicaoCarrocaX(-42);
						this.jogo.getPosicaoB().setPosicaoCarrocaY(-15);
						//this.jogo.getPosicaoB().setPosicaoX(-41);
						this.jogo.getPosicaoB().setPosicaoY(-80);
						
					}
					else{
						this.jogo.getPosicaoB().setPosicaoX(-82);
						this.jogo.getPosicaoB().setPosicaoCarrocaX(-82);
											
					}
			}
			else if(tan < 8){
				if(peca.getLadoA()==jogo.getLadoB()){
					resp = new ImagemPeca(peca.getImagemVret2(),this.jogo.getPosicaoB().getPosicaoX(),this.jogo.getPosicaoB().getPosicaoY());
				}
				else{
					resp = new ImagemPeca(peca.getImagemVret1(),this.jogo.getPosicaoB().getPosicaoX(),this.jogo.getPosicaoB().getPosicaoY());
				}
				if(tan == 7){
					this.jogo.getPosicaoB().setPosicaoX(40);
					this.jogo.getPosicaoB().setPosicaoCarrocaX(41);
					this.jogo.getPosicaoB().setPosicaoCarrocaY(-40);
				}
				else{
					this.jogo.getPosicaoB().setPosicaoY(-82);
					this.jogo.getPosicaoB().setPosicaoCarrocaY(-82);
				}
			}
			else{
				if(peca.getLadoA()==jogo.getLadoB()){
					resp = new ImagemPeca(peca.getImagemHor1(),this.jogo.getPosicaoB().getPosicaoX(),this.jogo.getPosicaoB().getPosicaoY());
				}
				else{
					resp = new ImagemPeca(peca.getImagemHor2(),this.jogo.getPosicaoB().getPosicaoX(),this.jogo.getPosicaoB().getPosicaoY());
				}
				this.jogo.getPosicaoB().setPosicaoX(80);
				this.jogo.getPosicaoB().setPosicaoCarrocaX(80);
			}
				
		}
		return resp;
	}

	public void jogarTabuleiro(Jogada jogada) {
		ImagemPeca imagem;
		dados.setNPecas();
		if(jogada.getLado().equals("a")){
			imagem = this.posicionarPecaLadoA(jogada.getPeca());
			jogo.getTabuleiro().setTanLadoA(1);
		}
		else{
			imagem = this.posicionarPecaLadoB(jogada.getPeca());
			jogo.getTabuleiro().setTanLadoB(1);
			
		}
		jogo.getTabuleiro().getImagens().incluir(imagem);
		jogo.getTabuleiro().repaint();
		if(jogada.getPeca().isCarroca()){
			switch(jogada.getPeca().getLadoA()){
			case 0:
				dados.setBranco();
			break;
			case 1:
				dados.setPio();
			break;
			case 2:
				dados.setDuke();
			break;
			case 3:
				dados.setTerno();
			break;
			case 4:
				dados.setQuadra();
			break;
			case 5:
				dados.setQuina();
			break;
			case 6:
				dados.setSena();
			break;
			}
		}
		else{
			switch(jogada.getPeca().getLadoA()){
			case 0:
				dados.setBranco();
			break;
			case 1:
				dados.setPio();
			break;
			case 2:
				dados.setDuke();
			break;
			case 3:
				dados.setTerno();
			break;
			case 4:
				dados.setQuadra();
			break;
			case 5:
				dados.setQuina();
			break;
			case 6:
				dados.setSena();
			break;
			}
			switch(jogada.getPeca().getLadoB()){
			case 0:
				dados.setBranco();
			break;
			case 1:
				dados.setPio();
			break;
			case 2:
				dados.setDuke();
			break;
			case 3:
				dados.setTerno();
			break;
			case 4:
				dados.setQuadra();
			break;
			case 5:
				dados.setQuina();
			break;
			case 6:
				dados.setSena();
			break;
			}
		}
	}
	
	public void jogarPeca(Jogada jogada)throws PecaInvalidaException{
		if (jogo.getTabuleiro().getTanLadoA()==0&&jogo.getTabuleiro().getTanLadoB()==0){
			jogada.setLado("a");
			jogarTabuleiro(jogada);
			jogo.setLadoA(jogada.getPeca().getLadoA());
			jogo.setLadoB(jogada.getPeca().getLadoB());
		}
		else{
			if(jogada.getLado().equals("a")){
				if(jogo.getLadoA()==jogada.getPeca().getLadoA()){
					jogarTabuleiro(jogada);
					jogo.setLadoA(jogada.getPeca().getLadoB());
				}
				else if(jogo.getLadoA()==jogada.getPeca().getLadoB()){
					jogarTabuleiro(jogada);
					jogo.setLadoA(jogada.getPeca().getLadoA());
				}
				else{
					throw new  PecaInvalidaException();
				}
			}
			else {
				if(jogo.getLadoB()==jogada.getPeca().getLadoB()){
					jogarTabuleiro(jogada);
					jogo.setLadoB(jogada.getPeca().getLadoA());
				}
				else if(jogo.getLadoB()==jogada.getPeca().getLadoA()){
					jogarTabuleiro(jogada);
					jogo.setLadoB(jogada.getPeca().getLadoB());
				}
				else{
					throw new  PecaInvalidaException();
				}
			}
		}
	}
	
	
	public Tabuleiro getTabuleiro() {
		return jogo.getTabuleiro();
	}

	public Jogo getJogo() {
		return this.jogo;
	}
	
	public Dados getDados(){
		return dados;
	}
	
	
}
