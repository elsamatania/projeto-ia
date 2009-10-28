package GUI;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Negocios.Humano;
import Negocios.Jogador;
import Negocios.Maquina;
import Negocios.Controle.ControleJogo;
import Negocios.Controle.CriarObjetos;
import Negocios.Controle.Excessao.NaoTemPecaException;
import Negocios.Controle.Excessao.PecaInvalidaException;

public class Jogar {
	ControleJogo jogo = ControleJogo.getControleJogo();
	GUIJogadorHumano jogador1;
	GUIJogador jogador2;
	GUIJogador jogador3;
	GUIJogador jogador4;
	
	public static void main(String args[]) throws PecaInvalidaException {

		Jogar jogo = new Jogar();
		jogo.executar();

	}

	private void executar() throws PecaInvalidaException {

		this.montarGUI();
		this.partida1();
	}

	private void montarGUI() {
		JFrame frame = new JFrame();
		CriarObjetos obj = new CriarObjetos();

		jogo.receberPecas(obj.getPecas());
		jogo.definirJogadores(obj.getJog1(), obj.getJog2(), obj.getJog3(), obj
				.getJog4());
		jogo.definirTabuleiro(obj.getTab());
		jogo.distribuirPecas();

		GridLayout layout = new GridLayout(7, 0);

		jogador1 = new GUIJogadorHumano(jogo.getJogo().getJogador1());
		jogador2 = new GUIJogador(layout);
		jogador3 = new GUIJogador();
		jogador4 = new GUIJogador(layout);
		this.desabilitarBotoes();

		frame.getContentPane().add(BorderLayout.CENTER, jogo.getTabuleiro());
		frame.getContentPane().add(BorderLayout.SOUTH, jogador1.getPainel());
		frame.getContentPane().add(BorderLayout.NORTH, jogador3.getPainel());
		frame.getContentPane().add(BorderLayout.WEST, jogador4.getPainel());
		frame.getContentPane().add(BorderLayout.EAST, jogador2.getPainel());

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Dominó");
		frame.setSize(1370, 740);
		frame.setVisible(true);
	}

	public void partida1()  {
		boolean terminou = false;
		ArrayList<Jogador> ordem = jogo.definirOrdem();
		Humano humano;
		Maquina maq;
		int p2=0;
		int p3=0;
		int p4=0;
		int fecha=1;
		while(!terminou){
			for(int i=0;(i<ordem.size())&&(!terminou);i++){
				if(fecha<4){
					if(ordem.get(i) instanceof Humano){
						humano = (Humano) ordem.get(i);
						
							if(jogo.getJogo().getTabuleiro().getTanLadoA()==0){
								fecha=0;
								this.abilitarBotoes();
								while(!humano.isJogou()){
								
								}
								humano.setJogou(false);
								this.desabilitarBotoes();
							}
							else{
								try {
									humano.getJogo().procurar(jogo.getJogo().getLadoA(), jogo.getJogo().getLadoB());
									fecha=0;
									this.abilitarBotoes();
									while(!humano.isJogou()){
								
									}
									humano.setJogou(false);
									this.desabilitarBotoes();
									if(humano.getJogo().tamanho()==0){
										terminou=true;
										JOptionPane.showMessageDialog(null,"Parabens você venceu ! ! !","Atençao",JOptionPane.WARNING_MESSAGE);
									}
									} catch (NaoTemPecaException e) {
									JOptionPane.showMessageDialog(null,"Voce passou vez :(","Atençao",JOptionPane.WARNING_MESSAGE);
									fecha++;
								}
							}
							
						
					}
					else{
						maq = (Maquina) ordem.get(i);
						try {
							Thread.sleep(500);
							if(jogo.getJogo().getSaida().equals("inicio")&&jogo.getJogo().getTabuleiro().getTanLadoA()==0){
								boolean achou=false;
								for(int ind = 6;(ind > 0)&&(!achou);ind--){
									if(maq.getJogo().procurarCarroca(ind)!= null){
										achou=true;
										
										jogo.jogarPeca(maq.jogadaInicioJogo(ind));
										
									}
								}
								if(maq.equals(jogo.getJogo().getJogador2())){
									this.jogador2.getBotoes().get(p2).setVisible(false);
									p2++;
								}
								else if(maq.equals(jogo.getJogo().getJogador3())){
									this.jogador3.getBotoes().get(p3).setVisible(false);
									p3++;
								}
								else{
									this.jogador4.getBotoes().get(p4).setVisible(false);
									p4++;
								}
							}
							else{
								jogo.jogarPeca(maq.jogar(jogo.getJogo().getLadoA(), jogo.getJogo().getLadoB()));
								fecha=0;
								if(maq.equals(jogo.getJogo().getJogador2())){
									this.jogador2.getBotoes().get(p2).setVisible(false);
									p2++;
								}
								else if(maq.equals(jogo.getJogo().getJogador3())){
									this.jogador3.getBotoes().get(p3).setVisible(false);
									p3++;
								}
								else{
									this.jogador4.getBotoes().get(p4).setVisible(false);
									p4++;
								}
								
								if(maq.getJogo().tamanho()==0){
								terminou=true;
								JOptionPane.showMessageDialog(null,maq.getNome()+" venceu o jogo!!! ","Atençao",JOptionPane.WARNING_MESSAGE);
								}
								
							}
							
						} catch (PecaInvalidaException e) {
						} catch (NaoTemPecaException e) {
							JOptionPane.showMessageDialog(null,"O jogador: "+maq.getNome()+" passou a vez","Atençao",JOptionPane.WARNING_MESSAGE);
							fecha++;
						} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
						}
					}
				}
				else{
					JOptionPane.showMessageDialog(null,"O jogo Fechou","Atençao",JOptionPane.WARNING_MESSAGE);
					terminou=true;
				}
				
			}
		}
	}
	
	private void abilitarBotoes(){
		jogador1.botao1.setEnabled(true);
		jogador1.botao2.setEnabled(true);
		jogador1.botao3.setEnabled(true);
		jogador1.botao4.setEnabled(true);
		jogador1.botao5.setEnabled(true);
		jogador1.botao6.setEnabled(true);
	}
	
	private void desabilitarBotoes(){
		jogador1.botao1.setEnabled(false);
		jogador1.botao2.setEnabled(false);
		jogador1.botao3.setEnabled(false);
		jogador1.botao4.setEnabled(false);
		jogador1.botao5.setEnabled(false);
		jogador1.botao6.setEnabled(false);
	}
	
	
}
