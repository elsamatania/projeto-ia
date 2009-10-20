package Negocios.Controle;

import java.awt.Image;

import javax.swing.ImageIcon;

import GUI.Tabuleiro;
import Negocios.Humano;
import Negocios.Jogador;
import Negocios.Maquina;
import Negocios.Peca;
import Repositorio.Repositorio;

public class CriarObjetos {

	private Repositorio pecas;
	private Humano jog1 = new Humano("Fábio");
	private Maquina jog2 = new Maquina("teste");
	private Maquina jog3 = new Maquina("teste");
	private Maquina jog4 = new Maquina("teste");
	private	Tabuleiro tab = new Tabuleiro(new ImageIcon("src/imagens/tabuleiro 1.jpg").getImage(), 1120, 500);

	Peca peca1 = new Peca(1, new ImageIcon("src/imagens/pecasvert1/branco.jpg")
			.getImage(), new ImageIcon("src/imagens/pecasvert1/branco.jpg")
			.getImage(), new ImageIcon("src/imagens/pecashor1/branco.jpg")
			.getImage(), new ImageIcon("src/imagens/pecasvert1/branco.jpg")
			.getImage(), new ImageIcon("src/imagens/Icones/branco.jpg"), 0, 0,
			true);
	Peca peca2 = new Peca(2, new ImageIcon("src/imagens/pecasvert1/brancopio.jpg")
			.getImage(), new ImageIcon("src/imagens/pecasvert1/brancopio.jpg")
			.getImage(), new ImageIcon("src/imagens/pecashor1/brancopio.jpg")
			.getImage(), new ImageIcon("src/imagens/pecasvert1/brancopio.jpg")
			.getImage(), new ImageIcon("src/imagens/Icones/brancopio.jpg"), 0,
			1, false);
	Peca peca3 = new Peca(3, new ImageIcon("src/imagens/pecasvert1/brancoduke.jpg")
			.getImage(), new ImageIcon("src/imagens/pecasvert1/brancoduke.jpg")
			.getImage(), new ImageIcon("src/imagens/pecashor1/brancoduke.jpg")
			.getImage(), new ImageIcon("src/imagens/pecasvert1/brancoduke.jpg")
			.getImage(), new ImageIcon("src/imagens/Icones/brancoduke.jpg"), 0,
			2, false);
	Peca peca4 = new Peca(4,
			new ImageIcon("src/imagens/pecasvert1/brancoterno.jpg").getImage(),
			new ImageIcon("src/imagens/pecasvert1/brancoterno.jpg").getImage(),
			new ImageIcon("src/imagens/pecashor1/brancoterno.jpg").getImage(),
			new ImageIcon("src/imagens/pecasvert1/brancoterno.jpg").getImage(),
			new ImageIcon("src/imagens/Icones/brancoterno.jpg"), 0, 3, false);
	Peca peca5 = new Peca(5, new ImageIcon(
			"src/imagens/pecasvert1/brancoquadra.jpg").getImage(), new ImageIcon(
			"src/imagens/pecasvert1/brancoquadra.jpg").getImage(), new ImageIcon(
			"src/imagens/pecashor1/brancoquadra.jpg").getImage(), new ImageIcon(
			"src/imagens/pecasvert1/brancoquadra.jpg").getImage(), new ImageIcon(
			"src/imagens/Icones/brancoquadra.jpg"), 0, 4, false);
	Peca peca6 = new Peca(6,
			new ImageIcon("src/imagens/pecasvert1/brancoquina.jpg").getImage(),
			new ImageIcon("src/imagens/pecasvert1/brancoquina.jpg").getImage(),
			new ImageIcon("src/imagens/pecashor1/brancoquina.jpg").getImage(),
			new ImageIcon("src/imagens/pecasvert1/brancoquina.jpg").getImage(),
			new ImageIcon("src/imagens/Icones/brancoquina.jpg"), 0, 5, false);
	Peca peca7 = new Peca(7, new ImageIcon("src/imagens/pecasvert1/brancosena.jpg")
			.getImage(), new ImageIcon("src/imagens/pecasvert1/brancosena.jpg")
			.getImage(), new ImageIcon("src/imagens/pecashor1/brancosena.jpg")
			.getImage(), new ImageIcon("src/imagens/pecasvert1/brancosena.jpg")
			.getImage(), new ImageIcon("src/imagens/Icones/brancosena.jpg"), 0,
			6, false);
	Peca peca8 = new Peca(8, new ImageIcon("src/imagens/pecasvert1/pio.jpg")
			.getImage(),
			new ImageIcon("src/imagens/pecasvert1/pio.jpg").getImage(),
			new ImageIcon("src/imagens/pecashor1/pio.jpg").getImage(),
			new ImageIcon("src/imagens/pecasvert1/pio.jpg").getImage(),
			new ImageIcon("src/imagens/Icones/pio.jpg"), 1, 1, true);
	Peca peca9 = new Peca(9, new ImageIcon("src/imagens/pecasvert1/pioduke.jpg")
			.getImage(), new ImageIcon("src/imagens/pecasvert1/pioduke.jpg")
			.getImage(), new ImageIcon("src/imagens/pecashor1/pioduke.jpg")
			.getImage(), new ImageIcon("src/imagens/pecasvert1/pioduke.jpg")
			.getImage(), new ImageIcon("src/imagens/Icones/pioduke.jpg"), 1, 2,
			false);
	Peca peca10 = new Peca(10, new ImageIcon("src/imagens/pecasvert1/pioterno.jpg")
			.getImage(), new ImageIcon("src/imagens/pecasvert1/pioterno.jpg")
			.getImage(), new ImageIcon("src/imagens/pecashor1/pioterno.jpg")
			.getImage(), new ImageIcon("src/imagens/pecasvert1/pioterno.jpg")
			.getImage(), new ImageIcon("src/imagens/Icones/pioterno.jpg"), 1,
			3, false);
	Peca peca11 = new Peca(11, new ImageIcon("src/imagens/pecasvert1/pioquadra.jpg")
			.getImage(), new ImageIcon("src/imagens/pecasvert1/pioquadra.jpg")
			.getImage(), new ImageIcon("src/imagens/pecashor1/pioquadra.jpg")
			.getImage(), new ImageIcon("src/imagens/pecasvert1/pioquadra.jpg")
			.getImage(), new ImageIcon("src/imagens/Icones/pioquadra.jpg"), 1,
			4, false);
	Peca peca12 = new Peca(12, new ImageIcon("src/imagens/pecasvert1/pioquina.jpg")
			.getImage(), new ImageIcon("src/imagens/pecasvert1/pioquina.jpg")
			.getImage(), new ImageIcon("src/imagens/pecashor1/pioquina.jpg")
			.getImage(), new ImageIcon("src/imagens/pecasvert1/pioquina.jpg")
			.getImage(), new ImageIcon("src/imagens/Icones/pioquina.jpg"), 1,
			5, false);
	Peca peca13 = new Peca(13, new ImageIcon("src/imagens/pecasvert1/piosena.jpg")
			.getImage(), new ImageIcon("src/imagens/pecasvert1/piosena.jpg")
			.getImage(), new ImageIcon("src/imagens/pecashor1/piosena.jpg")
			.getImage(), new ImageIcon("src/imagens/pecasvert1/piosena.jpg")
			.getImage(), new ImageIcon("src/imagens/Icones/piosena.jpg"), 1, 6,
			false);
	Peca peca14 = new Peca(14, new ImageIcon("src/imagens/pecasvert1/duke.jpg")
			.getImage(), new ImageIcon("src/imagens/pecasvert1/duke.jpg")
			.getImage(), new ImageIcon("src/imagens/pecashor1/duke.jpg")
			.getImage(), new ImageIcon("src/imagens/pecasvert1/duke.jpg")
			.getImage(), new ImageIcon("src/imagens/Icones/duke.jpg"), 2, 2,
			true);
	Peca peca15 = new Peca(15, new ImageIcon("src/imagens/pecasvert1/duketerno.jpg")
			.getImage(), new ImageIcon("src/imagens/pecasvert1/duketerno.jpg")
			.getImage(), new ImageIcon("src/imagens/pecashor1/duketerno.jpg")
			.getImage(), new ImageIcon("src/imagens/pecasvert1/duketerno.jpg")
			.getImage(), new ImageIcon("src/imagens/Icones/duketerno.jpg"), 2,
			3, false);
	Peca peca16 = new Peca(16, new ImageIcon(
			"src/imagens/pecasvert1/dukequadra.jpg").getImage(), new ImageIcon(
			"src/imagens/pecasvert1/dukequadra.jpg").getImage(), new ImageIcon(
			"src/imagens/pecashor1/dukequadra.jpg").getImage(), new ImageIcon(
			"src/imagens/pecasvert1/dukequadra.jpg").getImage(), new ImageIcon(
			"src/imagens/Icones/dukequadra.jpg"), 2, 4, false);
	Peca peca17 = new Peca(17, new ImageIcon("src/imagens/pecasvert1/dukequina.jpg")
			.getImage(), new ImageIcon("src/imagens/pecasvert1/dukequina.jpg")
			.getImage(), new ImageIcon("src/imagens/pecashor1/dukequina.jpg")
			.getImage(), new ImageIcon("src/imagens/pecasvert1/dukequina.jpg")
			.getImage(), new ImageIcon("src/imagens/Icones/dukequina.jpg"), 2,
			5, false);

	Peca peca18 = new Peca(18, new ImageIcon("src/imagens/pecasvert1/dukesena.jpg")
			.getImage(), new ImageIcon("src/imagens/pecasvert1/dukesena.jpg")
			.getImage(), new ImageIcon("src/imagens/pecashor1/dukesena.jpg")
			.getImage(), new ImageIcon("src/imagens/pecasvert1/dukesena.jpg")
			.getImage(), new ImageIcon("src/imagens/Icones/dukesena.jpg"), 2,
			6, false);
	Peca peca19 = new Peca(19, new ImageIcon("src/imagens/pecasvert1/terno.jpg")
			.getImage(), new ImageIcon("src/imagens/pecasvert1/terno.jpg")
			.getImage(), new ImageIcon("src/imagens/pecashor1/terno.jpg")
			.getImage(), new ImageIcon("src/imagens/pecasvert1/terno.jpg")
			.getImage(), new ImageIcon("src/imagens/Icones/terno.jpg"), 3, 3,
			true);
	Peca peca20 = new Peca(20,
			new ImageIcon("src/imagens/pecasvert1/ternoquadra.jpg").getImage(),
			new ImageIcon("src/imagens/pecasvert1/ternoquadra.jpg").getImage(),
			new ImageIcon("src/imagens/pecashor1/ternoquadra.jpg").getImage(),
			new ImageIcon("src/imagens/pecasvert1/ternoquadra.jpg").getImage(),
			new ImageIcon("src/imagens/Icones/ternoquadra.jpg"), 3, 4, false);
	Peca peca21 = new Peca(21,
			new ImageIcon("src/imagens/pecasvert1/ternoquina.jpg").getImage(),
			new ImageIcon("src/imagens/pecasvert1/ternoquina.jpg").getImage(),
			new ImageIcon("src/imagens/pecashor1/ternoquina.jpg").getImage(),
			new ImageIcon("src/imagens/pecasvert1/ternoquina.jpg").getImage(),
			new ImageIcon("src/imagens/Icones/ternoquina.jpg"), 3, 5, false);
	Peca peca22 = new Peca(22, new ImageIcon("src/imagens/pecasvert1/ternosena.jpg")
			.getImage(), new ImageIcon("src/imagens/pecasvert1/ternosena.jpg")
			.getImage(), new ImageIcon("src/imagens/pecashor1/ternosena.jpg")
			.getImage(), new ImageIcon("src/imagens/pecasvert1/ternosena.jpg")
			.getImage(), new ImageIcon("src/imagens/Icones/ternosena.jpg"), 3,
			6, false);
	Peca peca23 = new Peca(23, new ImageIcon("src/imagens/pecasvert1/quadra.jpg")
			.getImage(), new ImageIcon("src/imagens/pecasvert1/quadra.jpg")
			.getImage(), new ImageIcon("src/imagens/pecashor1/quadra.jpg")
			.getImage(), new ImageIcon("src/imagens/pecasvert1/quadra.jpg")
			.getImage(), new ImageIcon("src/imagens/Icones/quadra.jpg"), 4, 4,
			true);
	Peca peca24 = new Peca(24, new ImageIcon(
			"src/imagens/pecasvert1/quadraquina.jpg").getImage(), new ImageIcon(
			"src/imagens/pecasvert1/quadraquina.jpg").getImage(), new ImageIcon(
			"src/imagens/pecashor1/quadraquina.jpg").getImage(), new ImageIcon(
			"src/imagens/pecasvert1/quadraquina.jpg").getImage(), new ImageIcon(
			"src/imagens/Icones/quadraquina.jpg"), 4, 5, false);
	Peca peca25 = new Peca(25,
			new ImageIcon("src/imagens/pecasvert1/quadrasena.jpg").getImage(),
			new ImageIcon("src/imagens/pecasvert1/quadrasena.jpg").getImage(),
			new ImageIcon("src/imagens/pecashor1/quadrasena.jpg").getImage(),
			new ImageIcon("src/imagens/pecasvert1/quadrasena.jpg").getImage(),
			new ImageIcon("src/imagens/Icones/quadrasena.jpg"), 4, 6, false);
	Peca peca26 = new Peca(26, new ImageIcon("src/imagens/pecasvert1/quina.jpg")
			.getImage(), new ImageIcon("src/imagens/pecasvert1/quina.jpg")
			.getImage(), new ImageIcon("src/imagens/pecashor1/quina.jpg")
			.getImage(), new ImageIcon("src/imagens/pecasvert1/quina.jpg")
			.getImage(), new ImageIcon("src/imagens/Icones/quina.jpg"), 5, 5,
			true);
	Peca peca27 = new Peca(27, new ImageIcon("src/imagens/pecasvert1/quinasena.jpg")
			.getImage(), new ImageIcon("src/imagens/pecasvert1/quinasena.jpg")
			.getImage(), new ImageIcon("src/imagens/pecashor1/quinasena.jpg")
			.getImage(), new ImageIcon("src/imagens/pecasvert1/quinasena.jpg")
			.getImage(), new ImageIcon("src/imagens/pecasvert1/quinasena.jpg"), 5,
			6, false);
	Peca peca28 = new Peca(28, new ImageIcon("src/imagens/pecasvert1/sena.jpg")
			.getImage(), new ImageIcon("src/imagens/pecasvert1/sena.jpg")
			.getImage(), new ImageIcon("src/imagens/pecashor1/sena.jpg")
			.getImage(), new ImageIcon("src/imagens/pecasvert1/sena.jpg")
			.getImage(), new ImageIcon("src/imagens/Icones/sena.jpg"), 6, 6,
			true);

	public CriarObjetos() {
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

	public Humano getJog1() {
		return jog1;
	}

	public void setJog1(Humano jog1) {
		this.jog1 = jog1;
	}

	public Maquina getJog2() {
		return jog2;
	}

	public void setJog2(Maquina jog2) {
		this.jog2 = jog2;
	}

	public Maquina getJog3() {
		return jog3;
	}

	public void setJog3(Maquina jog3) {
		this.jog3 = jog3;
	}

	public Maquina getJog4() {
		return jog4;
	}

	public void setJog4(Maquina jog4) {
		this.jog4 = jog4;
	}

	public Repositorio getPecas() {
		return this.pecas;
	}

	public Tabuleiro getTab() {
		return tab;
	}

	public void setTab(Tabuleiro tab) {
		this.tab = tab;
	}
	

}
