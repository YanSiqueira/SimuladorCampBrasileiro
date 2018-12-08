package Negocio;

import Basicas.Jogadores;
import Basicas.Partida;
import Basicas.Tabela;
import Basicas.Clube;
import Negocio.ControlePartida;
import Repositorio.RepositorioClubeArray;
import Repositorio.RepositorioPartidaArray;
import Repositorio.RepositorioTabelaArray;
import Negocio.ControleClube;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;


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
			for (int j = 0; j < ((RepositorioClubeArray) ctrClube.repositorio).getIndex(); j++) {
				
				if(listaIDClube[i] != listaIDClube[j]) {
					if(ctrPartida.buscaPartida(listaIDClube[i], listaIDClube[j], (RepositorioClubeArray)ctrClube.repositorio) == null) {
						Partida partida = new Partida(listaIDClube[i], listaIDClube[j], data, 0, false, cont); 
						ctrPartida.inserePartida(partida);
						cont += 1; 
						
					}
					if(ctrPartida.buscaPartida(listaIDClube[j], listaIDClube[i], (RepositorioClubeArray)ctrClube.repositorio) == null) {
						Partida partida = new Partida(listaIDClube[j], listaIDClube[i], data, 0, false, cont); 
						ctrPartida.inserePartida(partida);
						cont += 1;
					}
				}
			}
		}
	}
	
	public void organizaRodadas(ControlePartida ctrPartida, ControleClube ctrClube) {
		
		
		int qtdListaPartidas = ((RepositorioPartidaArray) ctrPartida.repositorio).getIndex();
		int contRodadas = 1; 
		int contJogosRodada = 0; 
		
		
		
		while(contRodadas < 7) {
			
			while(contJogosRodada < 2) {
				
					Partida partida = retornaPartida(ctrPartida, contRodadas); 
					
					if(partida != null) {
					
					if(verificaClubeRodada(ctrPartida, partida.getClubeCasa(), partida.getClubeFora(),  contRodadas) == false) { 
						
						partida.setRodada(contRodadas);
						ctrPartida.atualizaPartida(partida);
						partida = ctrPartida.buscaPartida(partida.getClubeFora(), partida.getClubeCasa(), (RepositorioClubeArray) ctrClube.repositorio); 
						partida.setRodada(contRodadas+3);
						ctrPartida.atualizaPartida(partida);
						contJogosRodada++;
					}
				
					}else {
						break;
					}
				
				
			}
			contJogosRodada = 0;
			contRodadas++; 
		}
		
		
		
	}
	
	public Partida retornaPartida(ControlePartida ctrPartida, int rodada) {
		
		Partida partida = null; 
		
		for (int i = 0; i < ((RepositorioPartidaArray) ctrPartida.repositorio).getIndex(); i++) {
			if(((RepositorioPartidaArray) ctrPartida.repositorio).getListaPartidas()[i].getRodada() == 0 && !verificaClubeRodada(ctrPartida, ((RepositorioPartidaArray) ctrPartida.repositorio).getListaPartidas()[i].getClubeCasa(), ((RepositorioPartidaArray) ctrPartida.repositorio).getListaPartidas()[i].getClubeFora(),  rodada)) {
				partida = ((RepositorioPartidaArray) ctrPartida.repositorio).getListaPartidas()[i]; 
				
				return partida; 
			}
		}
		
		return partida; 
	}
	
	public boolean verificaClubeRodada(ControlePartida ctrPartida, int clubeCasa , int clubeFora, int rodada) {
		
		for (int i = 0; i < ((RepositorioPartidaArray) ctrPartida.repositorio).getIndex(); i++) {
			if(((RepositorioPartidaArray) ctrPartida.repositorio).getListaPartidas()[i].getRodada() == rodada) {
				if(((RepositorioPartidaArray) ctrPartida.repositorio).getListaPartidas()[i].getClubeCasa() == clubeCasa || ((RepositorioPartidaArray) ctrPartida.repositorio).getListaPartidas()[i].getClubeFora() == clubeCasa || ((RepositorioPartidaArray) ctrPartida.repositorio).getListaPartidas()[i].getClubeCasa() == clubeFora || ((RepositorioPartidaArray) ctrPartida.repositorio).getListaPartidas()[i].getClubeFora() == clubeFora) {
					return true;
				}
				 
			}
		}
		
		return false; 
	}
	
	
	public void listaPartidasTabela(ControlePartida ctrPartida, ControleClube ctrClube) {
		
		int index = ((RepositorioPartidaArray) ctrPartida.repositorio).getIndex(); 
		Partida listaPartidas[] = new Partida[index];
		
		for(int a = 0; a < index; a++) {
			listaPartidas[a] =  ((RepositorioPartidaArray) ctrPartida.repositorio).getListaPartidas()[a]; 
		}
				
		
		
		Arrays.sort(listaPartidas);
		
		
		
		ArrayList<Partida> listPartida = new ArrayList<Partida>();

		listPartida.addAll(Arrays.asList(listaPartidas));
		
		for(int a = 0; a < listPartida.size(); a++) {
			System.out.println(listPartida.get(a).getPartidaID() +  " Jogo: " + ctrClube.buscaClube(listPartida.get(a).getClubeCasa()).getNome() +  " x "  + ctrClube.buscaClube(listPartida.get(a).getClubeFora()).getNome() + " Rodada: " + listPartida.get(a).getRodada());
		}
		
	}
	
	public ArrayList<Partida> retornaListaPartidas(ControlePartida ctrPartida) {
		
		int index = ((RepositorioPartidaArray) ctrPartida.repositorio).getIndex(); 
		Partida listaPartidas[] = new Partida[index];
		
		for(int a = 0; a < index; a++) {
			listaPartidas[a] =  ((RepositorioPartidaArray) ctrPartida.repositorio).getListaPartidas()[a]; 
		}
				
		
		
		Arrays.sort(listaPartidas);
		
		
		
		ArrayList<Partida> listPartida = new ArrayList<Partida>();

		listPartida.addAll(Arrays.asList(listaPartidas));
		
		return listPartida;
		
	}
	
	public void listaClassificacaoTabela(ControleClube ctrClube) {
		
		int index = ((RepositorioClubeArray) ctrClube.repositorio).getIndex(); 
		Clube listaClube[] = new Clube[index];
		
		for(int a = 0; a < index; a++) {
			listaClube[a] = ((RepositorioClubeArray) ctrClube.repositorio).getListaClube()[a]; 
		}
				
		
		
		Arrays.sort(listaClube);
		
		
		
		ArrayList<Clube> listClube = new ArrayList<Clube>();

		listClube.addAll(Arrays.asList(listaClube));
		
		for (Clube clube : listClube) {
			System.out.println("Nome: "+ clube.getNome() + " Pontos: " + clube.getPontosCampAtual()+ " Saldo: " + (clube.getGolsProCampAtual()-clube.getGolsContraCampAtual()) );
		}
		
		
		
	}
	
	public void resultadoRodada(ArrayList<Partida> listaPartidas, ControleClube ctrClube ,int rodada, ControlePartida ctrPartida) {
		
		for (Partida partida : listaPartidas) {
			if(partida.getRodada() == rodada) {
				ctrPartida.resultadoPartida(partida, ctrClube);
			}
		}	
		
	}
	
	
	public void imprimeResultadoRodada(ArrayList<Partida> listaPartidas, ControleClube ctrClube ,int rodada) {
		
		for (Partida partida : listaPartidas) {
			if(partida.getRodada() == rodada) {
				System.out.println(ctrClube.buscaClube(partida.getClubeCasa()).getNome() + " " + partida.getGolCasa() +  "x" + partida.getGolFora() + " " + ctrClube.buscaClube(partida.getClubeFora()).getNome());
			}
		}	
		
	}
}
		
		
	
	
	



