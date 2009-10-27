package GUI;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;


import Negocios.Controle.ControleJogo;
import Negocios.Controle.CriarObjetos;
import Negocios.Controle.Excessao.PecaInvalidaException;

public class Jogar {

	private void executar() throws PecaInvalidaException {

		JFrame frame = new JFrame();
		ControleJogo jogo = ControleJogo.getControleJogo();
		CriarObjetos obj = new CriarObjetos();

		jogo.receberPecas(obj.getPecas());
		jogo.definirJogadores(obj.getJog1(), obj.getJog2(), obj.getJog3(), obj
				.getJog4());
		jogo.definirTabuleiro(obj.getTab());
		jogo.distribuirPecas();

		GridLayout layout = new GridLayout(7, 0);

		GUIJogadorHumano jogador1 = new GUIJogadorHumano(jogo.getJogo()
				.getJogador1());
		GUIJogador jogador2 = new GUIJogador();
		GUIJogador jogador3 = new GUIJogador(layout);
		GUIJogador jogador4 = new GUIJogador(layout);

		frame.getContentPane().add(BorderLayout.CENTER, jogo.getTabuleiro());
		frame.getContentPane().add(BorderLayout.SOUTH, jogador1.getPainel());
		frame.getContentPane().add(BorderLayout.NORTH, jogador2.getPainel());
		frame.getContentPane().add(BorderLayout.WEST, jogador3.getPainel());
		frame.getContentPane().add(BorderLayout.EAST, jogador4.getPainel());

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Dominó");
		frame.setSize(1370, 740);
		frame.setVisible(true);

		jogo.partida1();
	}

	public static void main(String args[]) throws PecaInvalidaException {

		Jogar jogo = new Jogar();
		jogo.executar();

	}
}
