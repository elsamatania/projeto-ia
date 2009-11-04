package Repositorio;

import java.util.ArrayList;

import Negocios.Jogada;
import Negocios.Peca;
import Negocios.Controle.Excessao.NaoTemPecaException;

public class RepositorioToques {
	private ArrayList<Integer> pecas;

	public RepositorioToques() {
		pecas = new ArrayList<Integer>();
	}

	public void incluir(Integer peca) {
		if (!this.procurar(peca)){
			this.pecas.add(peca);
		}
		
	}

	public void excluir(int ind) {
		pecas.remove(ind);

	}
	
	public boolean procurar(int lado) {
		boolean achei = false;
		int tan = this.tamanho();
		for (int i = 0; (i < tan && (!achei)); i++) {
			if (this.pecas.get(i) == lado) {
				achei = true;
			}

		}

		return achei;
	}

	public int tamanho() {
		return pecas.size();
	}
	
	
}
