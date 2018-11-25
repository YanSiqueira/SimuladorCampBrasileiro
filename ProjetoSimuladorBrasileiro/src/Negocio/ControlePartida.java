package Negocio;


import Basicas.Clube;
import Basicas.Partida;
import java.util.Random;
import Repositorio.RepositorioPartida;
import Repositorio.RepositorioPartidaArray;
import Repositorio.RepositorioClubeArray;
import Negocio.ControleJogadores;

public class ControlePartida {
	
	RepositorioPartida repositorio = new RepositorioPartidaArray(); 
	
	public void inserePartida(Partida partida) {
		if(partida != null) {
			repositorio.inserirPartida(partida);
		}else {
			System.out.println("A partida está vazia!");
		}
	}
	
	public void atualizaPartida(Partida partida) {
		if(partida != null) {
			repositorio.atualizaPartida(partida);
		}else {
			System.out.println("A partida está vazia!");
		}
	}
	
	public Partida buscaPartida(int idPartida) {
		if(idPartida > 0) {
			return repositorio.buscaPartida(idPartida); 
		}else {
			System.out.println("ID inválido! ");
		}
		
		return null; 
	}
	
	public Partida buscaPartida(int idtimeCasa, int idTimeFora, RepositorioClubeArray repositorioClube) {
		if(repositorioClube.buscaClube(idtimeCasa) != null && repositorioClube.buscaClube(idTimeFora) != null) {
			return repositorio.buscaPartida(idtimeCasa, idTimeFora); 
		}else {
			System.out.println("ID do Clube inválido! ");
		}
		
		return null; 
	}
	
	public void removePartida(int idPartida) {
		
		if(repositorio.buscaPartida(idPartida) != null) {
			repositorio.removePartida(idPartida);
		}else{
			System.out.println("Partida não existe!");
		}
		
	}
	
	public void lista() {
		if(((RepositorioPartidaArray) repositorio).getListaPartidas() != null) {
			repositorio.listar();
		}else {
			System.out.println("Partidas ainda não foram criadas! ");
		}
	}
	
	public void resultadoPartida(Partida partida) {
		Random gerador = new Random(); 
		
		int resultadoRandom = gerador.nextInt(9); 
		
		//Define via random a vantagem de jogar em casa devido ao publico e a desvantagem
		
		if(resultadoRandom >= 7) {
			partida.setGolCasa(partida.getGolCasa()+1);
		}else if(resultadoRandom == 0) {
			partida.setGolFora(partida.getGolFora()+1);
		}
		
		if(partida.getClubeCasa().getPrestigoTorcida() >= 80) {
			partida.setPublico(5000);
		}else if(partida.getClubeCasa().getPrestigoTorcida() <= 70) {
			partida.setPublico(3000);
		}
		
		// compara os elencos para verificar o resultado da partida
		
		if(forcaElenco(partida.getClubeCasa()) > forcaElenco(partida.getClubeFora())) {
			partida.setGolCasa(partida.getGolCasa()+1);
		}else if(forcaElenco(partida.getClubeCasa()) < forcaElenco(partida.getClubeFora())) {
			partida.setGolFora(partida.getGolFora()+1);
		}else if(forcaElenco(partida.getClubeCasa()) == forcaElenco(partida.getClubeFora())) {
			resultadoRandom = gerador.nextInt(3); 
			if(resultadoRandom > 1) {
				partida.setGolCasa(partida.getGolCasa()+1);
				partida.setGolFora(partida.getGolFora()+1);
			}
		}
		
		// define a possibilidade de gols do time de casa 
		
		if(forcaElenco(partida.getClubeCasa()) >= 150) {
			resultadoRandom = gerador.nextInt(10); 
		}else if(forcaElenco(partida.getClubeCasa()) >= 100 && forcaElenco(partida.getClubeCasa()) < 150) {
			resultadoRandom = gerador.nextInt(6); 
		}else if(forcaElenco(partida.getClubeCasa()) >= 50 && forcaElenco(partida.getClubeCasa()) < 100) {
			resultadoRandom = gerador.nextInt(3); 
		}else {
			resultadoRandom = gerador.nextInt(2); 
		}
		
		if(resultadoRandom > 6) {
			partida.setGolCasa(partida.getGolCasa()+2);
		}else if(resultadoRandom >= 2 && resultadoRandom <= 6) {
			partida.setGolCasa(partida.getGolCasa()+1);
		}
		
		// define a possibilidade de gols do time de fora 
		
		if(forcaElenco(partida.getClubeFora()) >= 150) {
			resultadoRandom = gerador.nextInt(10); 
		}else if(forcaElenco(partida.getClubeFora()) >= 100 && forcaElenco(partida.getClubeFora()) < 150) {
			resultadoRandom = gerador.nextInt(6); 
		}else if(forcaElenco(partida.getClubeFora()) >= 50 && forcaElenco(partida.getClubeFora()) < 100) {
			resultadoRandom = gerador.nextInt(3); 
		}else {
			resultadoRandom = gerador.nextInt(2); 
		}
		
		if(resultadoRandom > 6) {
			partida.setGolFora(partida.getGolFora()+2);
		}else if(resultadoRandom >= 2 && resultadoRandom <= 6) {
			partida.setGolFora(partida.getGolFora()+2);
		}
		
		partida.setStatusPartida(true);
		
		repositorio.atualizaPartida(partida);
		
	}
	
	public int forcaElenco(Clube clube) {
		int forca = 0; 
		
		for(int a = 0; a < Clube.tamanhoJogador; a++) {
			if(clube.getJogadores()[a].getTitular() == true) {
				forca += clube.getJogadores()[a].getHabilidade(); 
			}else {
				forca += (clube.getJogadores()[a].getHabilidade())/2; 
			}
			
		}
		
		return forca;
	}

}
