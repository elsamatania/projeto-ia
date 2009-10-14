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
import Negocios.Controle.CriarPecas;

public class Jogar {

	private void executar() {

		Image tabuleiro = new ImageIcon("src/imagens/tabuleiro 1.jpg")
				.getImage();

		JFrame frame = new JFrame();
		ControleJogo jogo = new ControleJogo();
		CriarPecas pecas = new CriarPecas();
		jogo.receberPecas(pecas.getPecas());
		Jogador jog1 = new Humano("Fábio");
		Jogador jog2 = new Maquina("teste");
		Jogador jog3 = new Maquina("teste");
		Jogador jog4 = new Maquina("teste");
		jogo.definirJogadores(jog1, jog2, jog3, jog4);
		jogo.distribuirPecas();
		GridLayout layout = new GridLayout(7, 0);
		GUIJogadorHumano jogador1 = new GUIJogadorHumano(jog1);
		GUIJogador jogador2 = new GUIJogador();
		GUIJogador jogador3 = new GUIJogador(layout);
		GUIJogador jogador4 = new GUIJogador(layout);

		Tabuleiro tab = new Tabuleiro(tabuleiro, 1120, 500);

		frame.getContentPane().add(BorderLayout.CENTER, tab);
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
