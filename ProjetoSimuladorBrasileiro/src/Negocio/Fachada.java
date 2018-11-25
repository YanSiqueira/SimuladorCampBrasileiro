package Negocio; 

import Basicas.*;
import Negocio.*;
import Repositorio.*;


public class Fachada {
	
	private ControleClube controleClube; 
	private ControleJogadores controleJogador; 
//	private ControleClientes clientes;
	private static Fachada instance;
	
	public Fachada() {
		controleClube = new ControleClube();
		controleJogador = new ControleJogadores(); 
//		clientes = new ControleClientes();
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
	

}
