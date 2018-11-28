package Negocio;

import Basicas.Jogadores;
import Basicas.Partida;
import Basicas.Tabela;
import Basicas.Clube;
import Negocio.ControlePartida;
import Repositorio.RepositorioClubeArray;
import Repositorio.RepositorioTabelaArray;
import Negocio.ControleClube;
import java.util.Date;
import java.util.Random;


public class ControleTabela   {
	
	RepositorioTabelaArray repositorioTabela = new RepositorioTabelaArray();
	
	public void inserirTabela(Tabela tabela) {
		
		repositorioTabela.inserirTabela(tabela);
		
	}

	
	public void atualizaTabela(Tabela tabela) {
		
		repositorioTabela.atualizaTabela(tabela);
		
	}

	
	public Tabela buscaTabela(int tabelaID) {
		
		return repositorioTabela.buscaTabela(tabelaID);
	}

	
	public void removeTabela(int tabelaID) {
		
		repositorioTabela.removeTabela(tabelaID);
	}

	
	public void listar() {
		
		repositorioTabela.listar();
	}
	
	public void GeraPartidasTabela(ControlePartida ctrPartida, ControleClube ctrClube) {
		
		Date data = new Date(); 
		int cont = 0; 
		int listaIDClube[] =   new int[20];
		
		
		
		for (int i = 0; i < ((RepositorioClubeArray) ctrClube.repositorio).getIndex(); i++) {
			listaIDClube[i] = ((RepositorioClubeArray) ctrClube.repositorio).getListaClube()[i].getNumeroRegistro();
			
		}
		
		for (int i = 0; i < ((RepositorioClubeArray) ctrClube.repositorio).getIndex(); i++) {
			int rodada = 0; 
			for (int j = 0; j < ((RepositorioClubeArray) ctrClube.repositorio).getIndex(); j++) {
				if(listaIDClube[i] != listaIDClube[j]) {
					
					if(ctrPartida.buscaPartida(listaIDClube[i], listaIDClube[j], (RepositorioClubeArray)ctrClube.repositorio) == null) {
						rodada += 1;
						Partida partida = new Partida(listaIDClube[i], listaIDClube[j], data, rodada, false, cont); 
						ctrPartida.inserePartida(partida);
						cont += 1; 
						
					}
					if(ctrPartida.buscaPartida(listaIDClube[j], listaIDClube[i], (RepositorioClubeArray)ctrClube.repositorio) == null) {
						Partida partida = new Partida(listaIDClube[j], listaIDClube[i], data, rodada+3, false, cont); 
						ctrPartida.inserePartida(partida);
						cont += 1; 
					}
				}
			}
		}
	}
		
}
		
		
	
	
	



