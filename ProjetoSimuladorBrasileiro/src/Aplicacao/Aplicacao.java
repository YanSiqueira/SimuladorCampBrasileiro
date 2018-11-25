package Aplicacao;

import Negocio.*;
import Repositorio.*;

import javax.swing.JOptionPane;

import Basicas.*;

import java.util.Date;



public class Aplicacao {
	
	public static void main(String[] args) {
		
		
		ControleJogadores ctrJogadores = new ControleJogadores();
		ControleClube ctrClube = new ControleClube(); 
		ControlePartida ctrPartida = new ControlePartida(); 
		Date data = new Date(); 
		
		/*Jogadores jogador1 = new Jogadores("Caio", 22, 1, 1, 12, 1, 0);
		Jogadores jogador2 = new Jogadores("Pedro", 22, 2, 2, 12, 2, 0);
		Jogadores jogador3 = new Jogadores("Ricardo", 22, 3, 4, 12, 4, 0);*/
		
		Clube clube1 = new Clube("Santos", 1, 0, 0, 0, 0, 0, 0, "Vila Belmiro", 7);
		Clube clube2 = new Clube("São Paulo", 2, 0, 0, 0, 0, 0, 0, "Morumbi", 7);
		
		
		ctrClube.insereClube(clube1);
		ctrClube.insereClube(clube2);
		/*Partida partida1 = new Partida(clube1, clube2, data, 1, false, 1); 
		ctrPartida.inserePartida(partida1);*/
		
				
		
		int contadorIDjogador = 0; 
		
		for (int i = 0; i < 20; i++) {
			String nome = JOptionPane.showInputDialog("Digite um nome "); 
			String posicaoS = JOptionPane.showInputDialog("Digite uma posicao "); 
			int posicao = Integer.parseInt(posicaoS); 
			System.out.println("");
			contadorIDjogador += 1; 
			Jogadores jogador = new Jogadores(nome, 22, contadorIDjogador, posicao, 3*posicao, i+1, 0);
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
			String nome = JOptionPane.showInputDialog("Digite um nome "); 
			String posicaoS = JOptionPane.showInputDialog("Digite uma posicao "); 
			int posicao = Integer.parseInt(posicaoS); 
			System.out.println("");
			contadorIDjogador += 1; 
			Jogadores jogador = new Jogadores(nome, 22, contadorIDjogador, posicao, 3*posicao, i+1, 0);
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
		
		Partida partida1 = new Partida(clube1, clube2, data, 1, false, 1); 
		ctrPartida.inserePartida(partida1);
		
		ctrPartida.resultadoPartida(partida1, ctrClube);
		ctrPartida.lista();
		
		System.out.println("Clube: "+ clube1.getNome() + "Pontos: " + clube1.getPontosCampAtual() + "Saldo : " + (clube1.getGolsProCampAtual()-clube1.getGolsContraCampAtual()) );
		System.out.println("Clube: "+ clube2.getNome() + "Pontos: " + clube2.getPontosCampAtual() + "Saldo : " + (clube2.getGolsProCampAtual()-clube2.getGolsContraCampAtual()) );
		
		
		
		
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
