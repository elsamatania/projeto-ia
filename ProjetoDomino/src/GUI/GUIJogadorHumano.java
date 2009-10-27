package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Negocios.Humano;
import Negocios.Jogada;
import Negocios.Controle.ControleJogo;
import Negocios.Controle.Excessao.PecaInvalidaException;

public class GUIJogadorHumano extends GUIJogador {

	private Humano jog;

	public Humano getJog() {
		return jog;
	}

	public void setJog(Humano jog) {
		this.jog = jog;
	}

	public GUIJogadorHumano(Humano jog) {
		this.painel = new JPanel();
		this.botao1 = new JButton(jog.getJogo().procurar(0).getIcone());
		this.botao2 = new JButton(jog.getJogo().procurar(1).getIcone());
		this.botao3 = new JButton(jog.getJogo().procurar(2).getIcone());
		this.botao4 = new JButton(jog.getJogo().procurar(3).getIcone());
		this.botao5 = new JButton(jog.getJogo().procurar(4).getIcone());
		this.botao6 = new JButton(jog.getJogo().procurar(5).getIcone());

		painel.add(botao1);
		painel.add(botao2);
		painel.add(botao3);
		painel.add(botao4);
		painel.add(botao5);
		painel.add(botao6);
	

		botao1.addActionListener(new Acao1(jog.getJogo().procurar(0).getId(),botao1));
		botao2.addActionListener(new Acao1(jog.getJogo().procurar(1).getId(),botao2));
		botao3.addActionListener(new Acao1(jog.getJogo().procurar(2).getId(),botao3));
		botao4.addActionListener(new Acao1(jog.getJogo().procurar(3).getId(),botao4));
		botao5.addActionListener(new Acao1(jog.getJogo().procurar(4).getId(),botao5));
		botao6.addActionListener(new Acao1(jog.getJogo().procurar(5).getId(),botao6));

	}

	public class Acao1 implements ActionListener {
		private int peca;
		private String lado;
		private JButton botao;

		public Acao1(int peca,JButton botao) {
			this.peca = peca;
			this.botao = botao;
		}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			ControleJogo jog = ControleJogo.getControleJogo();
			String[] botoes = {"<= Lado","Lado =>"};  
			int i = JOptionPane.showOptionDialog(null,"Informe o lado","Lado da Jogada",JOptionPane.NO_OPTION,JOptionPane.QUESTION_MESSAGE,  
			                 null,botoes,null);
			if(i==0){
				lado="b";
			}
			else{
				lado="a";
			}
			Jogada jogada = new Jogada(lado,jog.jogadaJog1(peca));
			//jog.jogarTabuleiro(jogada);
			try {
				jog.jogarPeca(jogada);
				jog.getJogo().getJogador1().setJogou(true);
				botao.setVisible(false);
			} catch (PecaInvalidaException e) {
				JOptionPane.showMessageDialog(null, "Jogada Invalida","Atenção",JOptionPane.INFORMATION_MESSAGE);
			}
		}

	}

}
