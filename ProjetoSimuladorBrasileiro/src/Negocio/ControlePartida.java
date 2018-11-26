package Negocio;


import Basicas.Clube;
import Basicas.Partida;
import java.util.Random;
import Repositorio.RepositorioPartida;
import Repositorio.RepositorioPartidaArray;
import Repositorio.RepositorioClubeArray;


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
	
	public void lista(ControleClube ctrClube) {
		if(((RepositorioPartidaArray) repositorio).getListaPartidas() != null) {
			repositorio.listar(ctrClube);
		}else {
			System.out.println("Partidas ainda não foram criadas! ");
		}
	}
	
	public void resultadoPartida(Partida partida, ControleClube ctrClube) {
		Random gerador = new Random(); 
		Clube casa = ctrClube.buscaClube(partida.getClubeCasa());
		Clube fora = ctrClube.buscaClube(partida.getClubeFora()); 
		
		int resultadoRandom = gerador.nextInt(9); 
		
		//Define via random a vantagem de jogar em casa devido ao publico e a desvantagem
		
		if(resultadoRandom >= 7) {
			partida.setGolCasa(partida.getGolCasa()+1);
		}else if(resultadoRandom == 0) {
			partida.setGolFora(partida.getGolFora()+1);
		}
		
		if(casa.getPrestigoTorcida() >= 80) {
			partida.setPublico(5000);
		}else if(casa.getPrestigoTorcida() <= 70) {
			partida.setPublico(3000);
		}
		
		// compara os elencos para verificar o resultado da partida
		
		if(forcaElenco(casa) > forcaElenco(fora)) {
			resultadoRandom = gerador.nextInt(4); 
			if(resultadoRandom > 0) {
				partida.setGolCasa(partida.getGolCasa()+1);
			}
		}else if(forcaElenco(casa) < forcaElenco(fora)) {
			if(resultadoRandom > 0) {
				partida.setGolFora(partida.getGolFora()+1);
			}
		}else if(forcaElenco(casa) == forcaElenco(fora)) {
			resultadoRandom = gerador.nextInt(3); 
			if(resultadoRandom > 1) {
				partida.setGolCasa(partida.getGolCasa()+1);
				partida.setGolFora(partida.getGolFora()+1);
			}
		}
		
		// define a possibilidade de gols do time de casa 
		
		
		if(possibilidadeGol(casa) > 6) {
			partida.setGolCasa(partida.getGolCasa()+2);
		}else if(possibilidadeGol(casa) >= 2 && possibilidadeGol(casa) <= 6) {
			partida.setGolCasa(partida.getGolCasa()+1);
		}
		
		// define a possibilidade de gols do time de fora 
		
		if(possibilidadeGol(fora) > 6) {
			partida.setGolFora(partida.getGolFora()+2);
		}else if(possibilidadeGol(fora) >= 2 && possibilidadeGol(fora) <= 6) {
			partida.setGolFora(partida.getGolFora()+1);
		}
		
		partida.setStatusPartida(true);
		ctrClube.atualizaDadosClube(casa, partida);
		ctrClube.atualizaDadosClube(fora, partida);
		
		repositorio.atualizaPartida(partida);
		
	}
	
	public int possibilidadeGol(Clube clube) {
		int resultadoRandom = 0; 
		Random gerador = new Random(); 
		
		if(forcaElenco(clube) >= 150) {
			resultadoRandom = gerador.nextInt(10); 
		}else if(forcaElenco(clube) >= 100 && forcaElenco(clube) < 150) {
			resultadoRandom = gerador.nextInt(6); 
		}else if(forcaElenco(clube) >= 50 && forcaElenco(clube) < 100) {
			resultadoRandom = gerador.nextInt(3); 
		}else {
			resultadoRandom = gerador.nextInt(1); 
		}
		
		return resultadoRandom;
		
	}
	
	public int forcaElenco(Clube clube) {
		int forca = 0; 
		
		for(int a = 0; a < Clube.tamanhoJogador; a++) {
			if(clube.getJogadores()[a].getTitular() == true) {
				forca += clube.getJogadores()[a].getHabilidade()*ControleJogadores.verificaPosicaoJogador(clube.getJogadores()[a]); 
			}else {
				forca += (clube.getJogadores()[a].getHabilidade())/2; 
			}
			
		}
		
		return forca;
	}

}
