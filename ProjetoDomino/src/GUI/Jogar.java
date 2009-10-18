package GUI;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

import Negocios.Humano;
import Negocios.Jogador;
import Negocios.Maquina;
import Negocios.Controle.ControleJogo;
import Negocios.Controle.CriarObjetos;

public class Jogar {

	private void executar() {

		JFrame frame = new JFrame();
		ControleJogo jogo = new ControleJogo();
		CriarObjetos obj = new CriarObjetos();
		
		jogo.receberPecas(obj.getPecas());
		jogo.definirJogadores(obj.getJog1(), obj.getJog2(), obj.getJog3(), obj.getJog4());
		jogo.definirTabuleiro(obj.getTab());
		jogo.distribuirPecas();
				
		GridLayout layout = new GridLayout(7, 0);
		GUIJogadorHumano jogador1 = new GUIJogadorHumano(jogo.getJogo().getJogador1());
		GUIJogador jogador2 = new GUIJogador();
		GUIJogador jogador3 = new GUIJogador(layout);
		GUIJogador jogador4 = new GUIJogador(layout);

		

		frame.getContentPane().add(BorderLayout.CENTER, jogo.getJogo().getTabuleiro());
		frame.getContentPane().add(BorderLayout.SOUTH, jogador1.getPainel());
		frame.getContentPane().add(BorderLayout.NORTH, jogador2.getPainel());
		frame.getContentPane().add(BorderLayout.WEST, jogador3.getPainel());
		frame.getContentPane().add(BorderLayout.EAST, jogador4.getPainel());

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Dominó");
		frame.setSize(1370, 740);
		frame.setVisible(true);

	}

	public static void main(String args[]) {

		Jogar jogo = new Jogar();
		jogo.executar();

	}
}
