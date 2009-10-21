package Negocios;

public class Jogada {

	private String lado;
	private Peca peca;
	
	public Jogada(String lado,Peca peca){
		this.lado = lado;
		this.peca = peca;
	}

	public String getLado() {
		return lado;
	}

	public void setLado(String lado) {
		this.lado = lado;
	}

	public Peca getPeca() {
		return peca;
	}

	public void setPeca(Peca peca) {
		this.peca = peca;
	}

}
