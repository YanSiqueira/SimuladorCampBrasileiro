package Negocio; 

import java.util.ArrayList;

import Basicas.*;
import Negocio.*;
import Repositorio.*;


public class Fachada {
	
	private ControleClube controleClube; 
	private ControleJogadores controleJogador; 
	private ControlePartida controlePartida; 
	private ControleTabela controleTabela; 

	private static Fachada instance;
	
	public Fachada() {
		controleClube = new ControleClube();
		controleJogador = new ControleJogadores(); 
		controlePartida = new ControlePartida(); 
		controleTabela = new ControleTabela();
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
	
	public void incluirJogadorClube(Jogadores jogador, Clube clube, ControleJogadores ctrJogadores) {
		controleClube.incluiJogador(jogador, clube, ctrJogadores);
	}
	
	public void removeJogadorClube(int numeroRegJogador, Clube clube, ControleJogadores ctrJogadores) {
		controleClube.removeJogador(numeroRegJogador, clube, ctrJogadores);
	}
	
	public void inserePartida(Partida partida) {
		controlePartida.inserePartida(partida);
	}
	
	public void atualizaPartida(Partida partida) {
		controlePartida.atualizaPartida(partida);
	}
	
	public Partida buscaPartida(int idPartida) {
		return controlePartida.buscaPartida(idPartida); 
	}
	
	public Partida buscaPartida(int idtimeCasa, int idTimeFora, RepositorioClubeArray repositorioClube) {
		return controlePartida.buscaPartida(idtimeCasa, idTimeFora, repositorioClube); 
	}
	
	public void removePartida(int idPartida) {
		controlePartida.removePartida(idPartida);
	}
	
	public void lista(ControleClube ctrClube) {
		controlePartida.lista(ctrClube);
	}
		
	public void resultadoPartida(Partida partida, ControleClube ctrClube) {
		controlePartida.resultadoPartida(partida, ctrClube);
	}
	
	public void inserirTabela(Tabela tabela) {
		controleTabela.inserirTabela(tabela);
	}
	public void atualizaTabela(Tabela tabela) {
		controleTabela.atualizaTabela(tabela);
	}
	public Tabela buscaTabela(int tabelaID) {
		return controleTabela.buscaTabela(tabelaID);
	}
	public void removeTabela(int tabelaID) {
		controleTabela.removeTabela(tabelaID);
	}
	public void GeraPartidasTabela(ControlePartida ctrPartida, ControleClube ctrClube) {
		controleTabela.GeraPartidasTabela(ctrPartida, ctrClube);
	}
	public void organizaRodadas(ControlePartida ctrPartida, ControleClube ctrClube) {
		controleTabela.organizaRodadas(ctrPartida, ctrClube);
	}
	public void listaPartidasTabela(ControlePartida ctrPartida, ControleClube ctrClube) {
		controleTabela.listaPartidasTabela(ctrPartida, ctrClube);
	}
	public ArrayList<Partida> retornaListaPartidas(ControlePartida ctrPartida) {
		return controleTabela.retornaListaPartidas(ctrPartida); 
	}
	public void listaClassificacaoTabela(ControleClube ctrClube) {
		controleTabela.listaClassificacaoTabela(ctrClube);
	}
	public void resultadoRodada(ArrayList<Partida> listaPartidas, ControleClube ctrClube ,int rodada, ControlePartida ctrPartida) {
		controleTabela.resultadoRodada(listaPartidas, ctrClube, rodada, ctrPartida);
	}
	public void imprimeResultadoRodada(ArrayList<Partida> listaPartidas, ControleClube ctrClube ,int rodada) {
		controleTabela.imprimeResultadoRodada(listaPartidas, ctrClube, rodada);
	}
}
