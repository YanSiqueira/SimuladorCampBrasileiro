package Negocio; 

import Basicas.*;
import Negocio.*;
import Repositorio.*;


public class Fachada {
	
	private ControleClube controleClube; 
	private ControleJogadores controleJogador; 
	private ControlePartida controlePartida; 

	private static Fachada instance;
	
	public Fachada() {
		controleClube = new ControleClube();
		controleJogador = new ControleJogadores(); 
		controlePartida = new ControlePartida(); 

	}
	
	public static Fachada getInstance(){
		if (Fachada.instance == null){
			Fachada.instance = new Fachada();
		}
		return Fachada.instance;
	}
	
	public void cadastrar(Jogadores jogador) {
		controleJogador.insereJogador(jogador);
	}
	
	public void remover(int numeroRegistro) {
		controleJogador.removeJogador(numeroRegistro);
	}
	
	public Jogadores procurar(int numeroRegistro) {
		return controleJogador.buscaJogador(numeroRegistro);
	}
	
	public void atualizar (Jogadores jogador) {
		controleJogador.atualizaJogador(jogador);
	}
	
	public void listar() {
		controleJogador.listarJogadores();
	}
	
	public void cadastrar(Clube clube) {
		controleClube.insereClube(clube);
	}
	
	public void removerClube(int numeroRegistro) {
		controleClube.removeClube(numeroRegistro);
	}
	
	public Clube procurarClube(int numeroRegistro) {
		return controleClube.buscaClube(numeroRegistro); 
	}
	
	public void atualizar(Clube clube) {
		controleClube.atualizaClube(clube);
	}
	
	public void listarClube() {
		controleClube.listaClube();
	}

}
