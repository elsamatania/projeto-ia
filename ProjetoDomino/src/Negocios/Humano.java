package Negocios;

public class Humano extends Jogador {

	private boolean jogou;

	public Humano(String nome) {
		super(nome);
		this.setJogou(false);

	}

	public Peca jogar(int id) {
		Peca resp = this.jogo.procurarId(id);
		return resp;
	}
	
	public void excluirPeca(int id){
		jogo.excluirId(id);
	}

	public void setJogou(boolean jogou) {
		this.jogou = jogou;
	}

	public boolean isJogou() {
		return jogou;
	}
	

}
