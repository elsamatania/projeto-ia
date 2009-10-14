package Negocios.Controle;

import javax.swing.ImageIcon;

import Negocios.Peca;
import Repositorio.Repositorio;

public class CriarPecas {

	private Repositorio pecas;
	Peca peca1 = new Peca(1, new ImageIcon("src/imagens/Icones/branco.jpg")
			.getImage(), new ImageIcon("src/imagens/Icones/branco.jpg")
			.getImage(), new ImageIcon("src/imagens/Icones/branco.jpg")
			.getImage(), new ImageIcon("src/imagens/Icones/branco.jpg")
			.getImage(), new ImageIcon("src/imagens/Icones/branco.jpg"), 0, 0,
			true);
	Peca peca2 = new Peca(1, new ImageIcon("src/imagens/Icones/brancopio.jpg")
			.getImage(), new ImageIcon("src/imagens/Icones/brancoepio.jpg")
			.getImage(), new ImageIcon("src/imagens/Icones/brancoepio.jpg")
			.getImage(), new ImageIcon("src/imagens/Icones/brancoepio.jpg")
			.getImage(), new ImageIcon("src/imagens/Icones/brancoepio.jpg"), 0,
			1, false);
	Peca peca3 = new Peca(1, new ImageIcon("src/imagens/Icones/brancoduke.jpg")
			.getImage(), new ImageIcon("src/imagens/Icones/brancoduke.jpg")
			.getImage(), new ImageIcon("src/imagens/Icones/brancoduke.jpg")
			.getImage(), new ImageIcon("src/imagens/Icones/brancoduke.jpg")
			.getImage(), new ImageIcon("src/imagens/Icones/brancoduke.jpg"), 0,
			2, false);
	Peca peca4 = new Peca(1,
			new ImageIcon("src/imagens/Icones/brancoterno.jpg").getImage(),
			new ImageIcon("src/imagens/Icones/brancoterno.jpg").getImage(),
			new ImageIcon("src/imagens/Icones/brancoterno.jpg").getImage(),
			new ImageIcon("src/imagens/Icones/brancoterno.jpg").getImage(),
			new ImageIcon("src/imagens/Icones/brancoterno.jpg"), 0, 3, false);
	Peca peca5 = new Peca(1, new ImageIcon(
			"src/imagens/Icones/brancoquadra.jpg").getImage(), new ImageIcon(
			"src/imagens/Icones/brancoquadra.jpg").getImage(), new ImageIcon(
			"src/imagens/Icones/brancoquadra.jpg").getImage(), new ImageIcon(
			"src/imagens/Icones/brancoquadra.jpg").getImage(), new ImageIcon(
			"src/imagens/Icones/brancoquadra.jpg"), 0, 4, false);
	Peca peca6 = new Peca(1,
			new ImageIcon("src/imagens/Icones/brancoquina.jpg").getImage(),
			new ImageIcon("src/imagens/Icones/brancoquina.jpg").getImage(),
			new ImageIcon("src/imagens/Icones/brancoquina.jpg").getImage(),
			new ImageIcon("src/imagens/Icones/brancoquina.jpg").getImage(),
			new ImageIcon("src/imagens/Icones/brancoquina.jpg"), 0, 5, false);
	Peca peca7 = new Peca(1, new ImageIcon("src/imagens/Icones/brancosena.jpg")
			.getImage(), new ImageIcon("src/imagens/Icones/brancosena.jpg")
			.getImage(), new ImageIcon("src/imagens/Icones/brancosena.jpg")
			.getImage(), new ImageIcon("src/imagens/Icones/brancosena.jpg")
			.getImage(), new ImageIcon("src/imagens/Icones/brancosena.jpg"), 0,
			6, false);
	Peca peca8 = new Peca(1, new ImageIcon("src/imagens/Icones/pio.jpg")
			.getImage(),
			new ImageIcon("src/imagens/Icones/pio.jpg").getImage(),
			new ImageIcon("src/imagens/Icones/pio.jpg").getImage(),
			new ImageIcon("src/imagens/Icones/pio.jpg").getImage(),
			new ImageIcon("src/imagens/Icones/pio.jpg"), 1, 1, true);
	Peca peca9 = new Peca(1, new ImageIcon("src/imagens/Icones/pioduke.jpg")
			.getImage(), new ImageIcon("src/imagens/Icones/pioduke.jpg")
			.getImage(), new ImageIcon("src/imagens/Icones/pioduke.jpg")
			.getImage(), new ImageIcon("src/imagens/Icones/pioduke.jpg")
			.getImage(), new ImageIcon("src/imagens/Icones/pioduke.jpg"), 1, 2,
			false);
	Peca peca10 = new Peca(1, new ImageIcon("src/imagens/Icones/pioterno.jpg")
			.getImage(), new ImageIcon("src/imagens/Icones/pioterno.jpg")
			.getImage(), new ImageIcon("src/imagens/Icones/pioterno.jpg")
			.getImage(), new ImageIcon("src/imagens/Icones/pioterno.jpg")
			.getImage(), new ImageIcon("src/imagens/Icones/pioterno.jpg"), 1,
			3, false);
	Peca peca11 = new Peca(1, new ImageIcon("src/imagens/Icones/pioquadra.jpg")
			.getImage(), new ImageIcon("src/imagens/Icones/pioquadra.jpg")
			.getImage(), new ImageIcon("src/imagens/Icones/pioquadra.jpg")
			.getImage(), new ImageIcon("src/imagens/Icones/pioquadra.jpg")
			.getImage(), new ImageIcon("src/imagens/Icones/pioquadra.jpg"), 1,
			4, false);
	Peca peca12 = new Peca(1, new ImageIcon("src/imagens/Icones/pioquina.jpg")
			.getImage(), new ImageIcon("src/imagens/Icones/pioquina.jpg")
			.getImage(), new ImageIcon("src/imagens/Icones/pioquina.jpg")
			.getImage(), new ImageIcon("src/imagens/Icones/pioquina.jpg")
			.getImage(), new ImageIcon("src/imagens/Icones/pioquina.jpg"), 1,
			5, false);
	Peca peca13 = new Peca(1, new ImageIcon("src/imagens/Icones/piosena.jpg")
			.getImage(), new ImageIcon("src/imagens/Icones/piosena.jpg")
			.getImage(), new ImageIcon("src/imagens/Icones/piosena.jpg")
			.getImage(), new ImageIcon("src/imagens/Icones/piosena.jpg")
			.getImage(), new ImageIcon("src/imagens/Icones/piosena.jpg"), 1, 6,
			false);
	Peca peca14 = new Peca(1, new ImageIcon("src/imagens/Icones/duke.jpg")
			.getImage(), new ImageIcon("src/imagens/Icones/duke.jpg")
			.getImage(), new ImageIcon("src/imagens/Icones/duke.jpg")
			.getImage(), new ImageIcon("src/imagens/Icones/duke.jpg")
			.getImage(), new ImageIcon("src/imagens/Icones/duke.jpg"), 2, 2,
			true);
	Peca peca15 = new Peca(1, new ImageIcon("src/imagens/Icones/duketerno.jpg")
			.getImage(), new ImageIcon("src/imagens/Icones/duketerno.jpg")
			.getImage(), new ImageIcon("src/imagens/Icones/duketerno.jpg")
			.getImage(), new ImageIcon("src/imagens/Icones/duketerno.jpg")
			.getImage(), new ImageIcon("src/imagens/Icones/duketerno.jpg"), 2,
			3, false);
	Peca peca16 = new Peca(1, new ImageIcon(
			"src/imagens/Icones/dukequardra.jpg").getImage(), new ImageIcon(
			"src/imagens/Icones/dukequadra.jpg").getImage(), new ImageIcon(
			"src/imagens/Icones/dukequadra.jpg").getImage(), new ImageIcon(
			"src/imagens/Icones/dukequadra.jpg").getImage(), new ImageIcon(
			"src/imagens/Icones/dukequadra.jpg"), 2, 4, false);
	Peca peca17 = new Peca(1, new ImageIcon("src/imagens/Icones/dukequina.jpg")
			.getImage(), new ImageIcon("src/imagens/Icones/dukequina.jpg")
			.getImage(), new ImageIcon("src/imagens/Icones/dukequina.jpg")
			.getImage(), new ImageIcon("src/imagens/Icones/dukequina.jpg")
			.getImage(), new ImageIcon("src/imagens/Icones/dukequina.jpg"), 2,
			5, false);

	Peca peca18 = new Peca(1, new ImageIcon("src/imagens/Icones/dukesena.jpg")
			.getImage(), new ImageIcon("src/imagens/Icones/dukesena.jpg")
			.getImage(), new ImageIcon("src/imagens/Icones/dukesena.jpg")
			.getImage(), new ImageIcon("src/imagens/Icones/dukesena.jpg")
			.getImage(), new ImageIcon("src/imagens/Icones/dukesena.jpg"), 2,
			6, false);
	Peca peca19 = new Peca(1, new ImageIcon("src/imagens/Icones/terno.jpg")
			.getImage(), new ImageIcon("src/imagens/Icones/terno.jpg")
			.getImage(), new ImageIcon("src/imagens/Icones/terno.jpg")
			.getImage(), new ImageIcon("src/imagens/Icones/terno.jpg")
			.getImage(), new ImageIcon("src/imagens/Icones/terno.jpg"), 3, 3,
			true);
	Peca peca20 = new Peca(1,
			new ImageIcon("src/imagens/Icones/trnoquadra.jpg").getImage(),
			new ImageIcon("src/imagens/Icones/ternoquadra.jpg").getImage(),
			new ImageIcon("src/imagens/Icones/ternoquadra.jpg").getImage(),
			new ImageIcon("src/imagens/Icones/ternoquadra.jpg").getImage(),
			new ImageIcon("src/imagens/Icones/ternoquadra.jpg"), 3, 4, false);
	Peca peca21 = new Peca(1,
			new ImageIcon("src/imagens/Icones/ternoquina.jpg").getImage(),
			new ImageIcon("src/imagens/Icones/ternoquina.jpg").getImage(),
			new ImageIcon("src/imagens/Icones/ternoquina.jpg").getImage(),
			new ImageIcon("src/imagens/Icones/ternoquina.jpg").getImage(),
			new ImageIcon("src/imagens/Icones/ternoquina.jpg"), 3, 5, false);
	Peca peca22 = new Peca(1, new ImageIcon("src/imagens/Icones/ternosena.jpg")
			.getImage(), new ImageIcon("src/imagens/Icones/ternosena.jpg")
			.getImage(), new ImageIcon("src/imagens/Icones/ternosena.jpg")
			.getImage(), new ImageIcon("src/imagens/Icones/ternosena.jpg")
			.getImage(), new ImageIcon("src/imagens/Icones/ternosena.jpg"), 3,
			6, false);
	Peca peca23 = new Peca(1, new ImageIcon("src/imagens/Icones/quadra.jpg")
			.getImage(), new ImageIcon("src/imagens/Icones/quadra.jpg")
			.getImage(), new ImageIcon("src/imagens/Icones/quadra.jpg")
			.getImage(), new ImageIcon("src/imagens/Icones/quadra.jpg")
			.getImage(), new ImageIcon("src/imagens/Icones/quadra.jpg"), 4, 4,
			true);
	Peca peca24 = new Peca(1, new ImageIcon(
			"src/imagens/Icones/quadraquina.jpg").getImage(), new ImageIcon(
			"src/imagens/Icones/quadraquina.jpg").getImage(), new ImageIcon(
			"src/imagens/Icones/quadraquina.jpg").getImage(), new ImageIcon(
			"src/imagens/Icones/quadraquina.jpg").getImage(), new ImageIcon(
			"src/imagens/Icones/quadraquina.jpg"), 4, 5, false);
	Peca peca25 = new Peca(1,
			new ImageIcon("src/imagens/Icones/quadrasena.jpg").getImage(),
			new ImageIcon("src/imagens/Icones/quadrasena.jpg").getImage(),
			new ImageIcon("src/imagens/Icones/quadrasena.jpg").getImage(),
			new ImageIcon("src/imagens/Icones/quadrasena.jpg").getImage(),
			new ImageIcon("src/imagens/Icones/quadrasena.jpg"), 4, 6, false);
	Peca peca26 = new Peca(1, new ImageIcon("src/imagens/Icones/quina.jpg")
			.getImage(), new ImageIcon("src/imagens/Icones/quina.jpg")
			.getImage(), new ImageIcon("src/imagens/Icones/quina.jpg")
			.getImage(), new ImageIcon("src/imagens/Icones/quina.jpg")
			.getImage(), new ImageIcon("src/imagens/Icones/quina.jpg"), 5, 5,
			true);
	Peca peca27 = new Peca(1, new ImageIcon("src/imagens/Icones/quinasena.jpg")
			.getImage(), new ImageIcon("src/imagens/Icones/quinasena.jpg")
			.getImage(), new ImageIcon("src/imagens/Icones/quinasena.jpg")
			.getImage(), new ImageIcon("src/imagens/Icones/quinasena.jpg")
			.getImage(), new ImageIcon("src/imagens/Icones/quinasena.jpg"), 5,
			6, false);
	Peca peca28 = new Peca(1, new ImageIcon("src/imagens/Icones/sena.jpg")
			.getImage(), new ImageIcon("src/imagens/Icones/sena.jpg")
			.getImage(), new ImageIcon("src/imagens/Icones/sena.jpg")
			.getImage(), new ImageIcon("src/imagens/Icones/sena.jpg")
			.getImage(), new ImageIcon("src/imagens/Icones/sena.jpg"), 6, 6,
			true);

	public CriarPecas() {
		this.pecas = new Repositorio();
		pecas.incluir(peca1);
		pecas.incluir(peca2);
		pecas.incluir(peca3);
		pecas.incluir(peca4);
		pecas.incluir(peca5);
		pecas.incluir(peca6);
		pecas.incluir(peca7);
		pecas.incluir(peca8);
		pecas.incluir(peca9);
		pecas.incluir(peca10);
		pecas.incluir(peca11);
		pecas.incluir(peca12);
		pecas.incluir(peca13);
		pecas.incluir(peca14);
		pecas.incluir(peca15);
		pecas.incluir(peca16);
		pecas.incluir(peca17);
		pecas.incluir(peca18);
		pecas.incluir(peca19);
		pecas.incluir(peca20);
		pecas.incluir(peca21);
		pecas.incluir(peca22);
		pecas.incluir(peca23);
		pecas.incluir(peca24);
		pecas.incluir(peca25);
		pecas.incluir(peca26);
		pecas.incluir(peca27);
		pecas.incluir(peca28);
	}

	public Repositorio getPecas() {
		return this.pecas;
	}

}
