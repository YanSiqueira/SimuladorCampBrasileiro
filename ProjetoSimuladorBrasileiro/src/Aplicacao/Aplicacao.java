package Aplicacao;

import Negocio.*;
import Repositorio.RepositorioJogadoresArquivo;

import javax.swing.JOptionPane;

import Basicas.*;

import java.util.Date;
import java.util.Iterator;
import java.util.Random;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Aplicacao {
	
	public static void main(String[] args) {
		
		/*Jogadores jogador11 = new Jogadores("aaaaa", 12, 1, 1, 3, 1, 5);
		Jogadores jogador22 = new Jogadores("bbbbb", 22, 2, 1, 3, 1, 1);
		Jogadores jogador33 = new Jogadores("ccccc", 12, 3, 1, 3, 1, 1);
		Jogadores jogador44 = new Jogadores("ddddd", 27, 4, 1, 3, 1, 9);
		Jogadores jogador55 = new Jogadores("eeeee", 27, 5, 1, 3, 1, 2);
		
		Jogadores  lista[] = new Jogadores[5];
		 lista[0] = jogador22;
		 lista[1] = jogador33;
		 lista[2] = jogador11;
		 lista[3] = jogador44;
		 lista[4] = jogador55;
		
		
		
		for (int i = 0; i < 5; i++) {
			System.out.println(lista[i].getNome() + " " + lista[i].getIdade() + " " + lista[i].getGol());
			
		}
		
		Arrays.sort(lista);
		
		for (int i = 0; i < 5; i++) {
			System.out.println(lista[i].getNome() + " " + lista[i].getIdade() + " " + lista[i].getGol());
			
		}*/
		
		
		ControleJogadores ctrJogadores = new ControleJogadores();
		ControleClube ctrClube = new ControleClube(); 
		ControlePartida ctrPartida = new ControlePartida(); 
		ControleTabela ctrTabela = new ControleTabela(); 
		Date data = new Date(); 
		Random ran = new Random(); 
		
		/*Jogadores jogador1 = new Jogadores("Caio", 22, 1, 1, 12, 1, 0);
		Jogadores jogador2 = new Jogadores("Pedro", 22, 2, 2, 12, 2, 0);
		Jogadores jogador3 = new Jogadores("Ricardo", 22, 3, 4, 12, 4, 0);*/
		
		Clube clube1 = new Clube("Santos", 2, 0, 0, 0, 0, 0, 0, "Vila Belmiro", 7);
		Clube clube2 = new Clube("São Paulo", 3, 0, 0, 0, 0, 0, 0, "Morumbi", 7);
		Clube clube3 = new Clube("Anapolina", 5, 0, 0, 0, 0, 0, 0, "Vila Belmiro", 7);
		Clube clube4 = new Clube("Caixias", 7, 0, 0, 0, 0, 0, 0, "Morumbi", 7);
		/*Partida partida1 = new Partida(2, 3, data, 1, false, 1); */
		
		
		ctrClube.insereClube(clube1);
		ctrClube.insereClube(clube2);
		ctrClube.insereClube(clube3);
		ctrClube.insereClube(clube4);
		/*ctrPartida.inserePartida(partida1);*/
		
		
		
		
				
		
		int contadorIDjogador = 0; 
		
		for (int i = 0; i < 20; i++) {
			/*String nome = JOptionPane.showInputDialog("Digite um nome "); 
			String posicaoS = JOptionPane.showInputDialog("Digite uma posicao ");
			int posicao = Integer.parseInt(posicaoS); */
			int posicao = ran.nextInt(8)+1; 
			contadorIDjogador += 1; 
			Jogadores jogador = new Jogadores("aaaaa", 22, contadorIDjogador, posicao, 3*posicao, i+1, 0);
			ctrJogadores.insereJogador(jogador);
			ctrClube.incluiJogador(jogador, clube1, ctrJogadores);
			if(i < 11) {
				jogador.setTitular(true);
				jogador.setPosicaoAtual(jogador.getPosicao());
			}else {
				jogador.setTitular(false);
				jogador.setPosicaoAtual(jogador.getPosicao());
			}
			jogador.setIdClube(clube1.getNumeroRegistro());
			ctrJogadores.atualizaJogador(jogador);
			ctrClube.atualizaClube(clube1);
			System.out.println(contadorIDjogador);
			
		}
		
		System.out.println("Lista Jogadores do Clube : "+ clube1.getNome());
		ctrClube.listaJogadores(clube1);
		System.out.println(" ");
		
		for (int i = 0; i < 20; i++) {
			/*String nome = JOptionPane.showInputDialog("Digite um nome "); 
			String posicaoS = JOptionPane.showInputDialog("Digite uma posicao ");
			int posicao = Integer .parseInt(posicaoS); */
			int posicao = ran.nextInt(8)+1; 
			contadorIDjogador += 1; 
			Jogadores jogador = new Jogadores("bbbbb", 22, contadorIDjogador, posicao, 3*posicao, i+1, 0);
			ctrJogadores.insereJogador(jogador);
			ctrClube.incluiJogador(jogador, clube2, ctrJogadores);
			if(i < 11) {
				jogador.setTitular(true);
				jogador.setPosicaoAtual(jogador.getPosicao());
			}else {
				jogador.setTitular(false);
				jogador.setPosicaoAtual(jogador.getPosicao());
			}
			jogador.setIdClube(clube2.getNumeroRegistro());
			ctrJogadores.atualizaJogador(jogador);
			ctrClube.atualizaClube(clube2);
			System.out.println(contadorIDjogador);
		}
		
		
		System.out.println("Lista Jogadores do Clube : "+ clube2.getNome());
		ctrClube.listaJogadores(clube2);
		System.out.println(" ");
		
		
		for (int i = 0; i < 20; i++) {
			/*String nome = JOptionPane.showInputDialog("Digite um nome "); 
			String posicaoS = JOptionPane.showInputDialog("Digite uma posicao ");
			int posicao = Integer.parseInt(posicaoS); */
			int posicao = ran.nextInt(8)+1; 
			contadorIDjogador += 1; 
			Jogadores jogador = new Jogadores("ccccc", 22, contadorIDjogador, posicao, 3*posicao, i+1, 0);
			ctrJogadores.insereJogador(jogador);
			ctrClube.incluiJogador(jogador, clube3, ctrJogadores);
			if(i < 11) {
				jogador.setTitular(true);
				jogador.setPosicaoAtual(jogador.getPosicao());
			}else {
				jogador.setTitular(false);
				jogador.setPosicaoAtual(jogador.getPosicao());
			}
			jogador.setIdClube(clube3.getNumeroRegistro());
			ctrJogadores.atualizaJogador(jogador);
			ctrClube.atualizaClube(clube3);
			System.out.println(contadorIDjogador);
		}
		
		
		System.out.println("Lista Jogadores do Clube : "+ clube3.getNome());
		ctrClube.listaJogadores(clube3);
		System.out.println(" ");
		
		for (int i = 0; i < 20; i++) {
			/*String nome = JOptionPane.showInputDialog("Digite um nome "); 
			String posicaoS = JOptionPane.showInputDialog("Digite uma posicao ");
			int posicao = Integer.parseInt(posicaoS); */
			int posicao = ran.nextInt(8)+1; 
			contadorIDjogador += 1; 
			Jogadores jogador = new Jogadores("ddddd", 22, contadorIDjogador, posicao, 3*posicao, i+1, 0);
			ctrJogadores.insereJogador(jogador);
			ctrClube.incluiJogador(jogador, clube4, ctrJogadores);
			if(i < 11) {
				jogador.setTitular(true);
				jogador.setPosicaoAtual(jogador.getPosicao());
			}else {
				jogador.setTitular(false);
				jogador.setPosicaoAtual(jogador.getPosicao());
			}
			jogador.setIdClube(clube4.getNumeroRegistro());
			ctrJogadores.atualizaJogador(jogador);
			ctrClube.atualizaClube(clube4);
			System.out.println(contadorIDjogador);
		}


		System.out.println("Lista Jogadores do Clube : "+ clube4.getNome());
		ctrClube.listaJogadores(clube4);
		System.out.println(" ");
		
		ctrTabela.GeraPartidasTabela(ctrPartida, ctrClube);
		
		/*ctrPartida.resultadoPartida(partida1, ctrClube);*/
		
		System.out.println(" ");
		ctrTabela.organizaRodadas(ctrPartida, ctrClube);
		ctrTabela.listaPartidasTabela(ctrPartida, ctrClube);
		
		/*System.out.println(ctrClube.buscaClube(partida1.getClubeCasa()).getNome() + " " + partida1.getGolCasa() +  "x" + partida1.getGolFora() + " " + ctrClube.buscaClube(partida1.getClubeFora()).getNome());*/
		
		System.out.println("Rodada 1 ");
		
		ctrTabela.resultadoRodada(ctrTabela.retornaListaPartidas(ctrPartida), ctrClube, 1, ctrPartida);
		ctrTabela.imprimeResultadoRodada(ctrTabela.retornaListaPartidas(ctrPartida), ctrClube, 1);
		
		System.out.println("");
		
		System.out.println("Classificação ");
		
		ctrTabela.listaClassificacaoTabela(ctrClube);
		
		System.out.println("");
		
		System.out.println("Rodada 2 ");
		
		System.out.println("");
		
		ctrTabela.resultadoRodada(ctrTabela.retornaListaPartidas(ctrPartida), ctrClube, 2, ctrPartida);
		ctrTabela.imprimeResultadoRodada(ctrTabela.retornaListaPartidas(ctrPartida), ctrClube, 2);
		
		System.out.println("Classificação ");
		
		System.out.println("");
		
		ctrTabela.listaClassificacaoTabela(ctrClube);
		
		System.out.println("");
		
		System.out.println("Rodada 3 ");
		
		System.out.println("");
		
		ctrTabela.resultadoRodada(ctrTabela.retornaListaPartidas(ctrPartida), ctrClube, 3, ctrPartida);
		ctrTabela.imprimeResultadoRodada(ctrTabela.retornaListaPartidas(ctrPartida), ctrClube, 3);
		
		System.out.println("Classificação ");
		
		System.out.println("");
		
		ctrTabela.listaClassificacaoTabela(ctrClube);
		
		
		
		
		/*ctrJogadores.insereJogador(jogador1);
		ctrJogadores.insereJogador(jogador2);
		ctrJogadores.insereJogador(jogador3);
		
		ctrJogadores.listarJogadores();
		
		System.out.println("");
		
		Jogadores jogadorAUX = ctrJogadores.buscaJogador(2);
		
		jogadorAUX.setNome("Fabio");
		
		ctrJogadores.atualizaJogador(jogadorAUX);
		
		ctrJogadores.listarJogadores();
		
		System.out.println("");
		
		ctrJogadores.removeJogador(2);
		
		ctrJogadores.listarJogadores();
		
		System.out.println("");*/
		
			
		
	}

}
