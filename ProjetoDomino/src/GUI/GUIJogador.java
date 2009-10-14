package GUI;

import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;


public class GUIJogador {
	
	protected JPanel painel;
	protected JButton botao1;
	protected JButton botao2;
	protected JButton botao3;
	protected JButton botao4;
	protected JButton botao5;
	protected JButton botao6;
	
	
	public GUIJogador(){
		this.painel= new JPanel();
		this.botao1 = new JButton(new ImageIcon("src/imagens/peca 1.jpg"));
		this.botao2 = new JButton(new ImageIcon("src/imagens/peca 1.jpg"));
		this.botao3 = new JButton(new ImageIcon("src/imagens/peca 1.jpg"));
		this.botao4 = new JButton(new ImageIcon("src/imagens/peca 1.jpg"));
		this.botao5 = new JButton(new ImageIcon("src/imagens/peca 1.jpg"));
		this.botao6 = new JButton(new ImageIcon("src/imagens/peca 1.jpg"));
		painel.add(botao1);
		painel.add(botao2);
		painel.add(botao3);
		painel.add(botao4);
		painel.add(botao5);
		painel.add(botao6);
		
	}
	public GUIJogador(GridLayout layout){
		this.painel= new JPanel(layout);
		this.botao1 = new JButton(new ImageIcon("src/imagens/peca 1 hor.jpg"));
		this.botao2 = new JButton(new ImageIcon("src/imagens/peca 1 hor.jpg"));
		this.botao3 = new JButton(new ImageIcon("src/imagens/peca 1 hor.jpg"));
		this.botao4 = new JButton(new ImageIcon("src/imagens/peca 1 hor.jpg"));
		this.botao5 = new JButton(new ImageIcon("src/imagens/peca 1 hor.jpg"));
		this.botao6 = new JButton(new ImageIcon("src/imagens/peca 1 hor.jpg"));
		
		painel.add(botao1);
		painel.add(botao2);
		painel.add(botao3);
		painel.add(botao4);
		painel.add(botao5);
		painel.add(botao6);
		
	}

	public JPanel getPainel() {
		return painel;
	}

	public void setPainel(JPanel painel) {
		this.painel = painel;
	}

	public JButton getBotao1() {
		return botao1;
	}

	public void setBotao1(JButton botao1) {
		this.botao1 = botao1;
	}

	public JButton getBotao2() {
		return botao2;
	}

	public void setBotao2(JButton botao2) {
		this.botao2 = botao2;
	}

	public JButton getBotao3() {
		return botao3;
	}

	public void setBotao3(JButton botao3) {
		this.botao3 = botao3;
	}

	public JButton getBotao4() {
		return botao4;
	}

	public void setBotao4(JButton botao4) {
		this.botao4 = botao4;
	}

	public JButton getBotao5() {
		return botao5;
	}

	public void setBotao5(JButton botao5) {
		this.botao5 = botao5;
	}

	public JButton getBotao6() {
		return botao6;
	}

	public void setBotao6(JButton botao6) {
		this.botao6 = botao6;
	}

	
}
