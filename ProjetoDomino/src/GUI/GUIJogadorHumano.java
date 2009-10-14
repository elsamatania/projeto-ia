package GUI;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import Negocios.Jogador;

public class GUIJogadorHumano extends GUIJogador {
	
	private Jogador jog;
	
	public GUIJogadorHumano(Jogador jog){
		this.jog = jog;
		this.painel= new JPanel();
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
		
	}
	

}
