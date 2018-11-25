package Negocio;
import Basicas.Clube;
import Basicas.Jogadores;
import Basicas.Partida;
import Repositorio.RepositorioClube;
import Repositorio.RepositorioClubeArray;
import Repositorio.RepositorioJogadoresArray;


public class ControleClube {
	
	RepositorioClube repositorio = new RepositorioClubeArray(); 
	
	public void insereClube(Clube clube) {
		if(clube != null) {
			repositorio.inserirClube(clube);
		}else { 
			System.out.println("O Clube está vazio");
		}
		
	}
	
	public void atualizaClube(Clube clube) {
		if(clube != null) {
			repositorio.atualizaClube(clube);
		}else {
			System.out.println("O clube está vazio");
		}
	}
	
	public Clube buscaClube(int numeroClube) {
		if(numeroClube > 0) {
			
			return repositorio.buscaClube(numeroClube); 
		}else {
			System.out.println("Numero inválido!");
		}
		
		return null; 
	}
	
	public void removeClube(int numeroClube) {
		
		if(numeroClube > 0) {
			if(repositorio.buscaClube(numeroClube) != null) {
				repositorio.removeClube(numeroClube);
				
			}else {
				System.out.println("Clube não existe");
			}
		}else {
			System.out.println("Numero inválido!");
		}
		
	}
	
	public void listaClube() {
		if(((RepositorioClubeArray) repositorio).getListaClubes() != null) {
			
			repositorio.listar();
			
		}else {
			System.out.println("Clubes ainda não foram inseridos!");
		}
	}
	
	public void incluiJogador(Jogadores jogador, Clube clube, ControleJogadores ctrJogadores) {
		
		if(ctrJogadores.buscaJogador(jogador.getNumeroRegistro()) != null) {
			
			if(verificaJogadorClube(jogador, clube.getNumeroRegistro()) == false) {
				
				if(clube.getIndex() < Clube.getTamanhojogador()) {
					clube.incluiJogador(jogador);
				}else {
					System.out.println("Clube só pode ter "+ Clube.getTamanhojogador() + "jogadores!");
				}
			}else {
				System.out.println("Jogador já foi inserido neste clube");
			}
			
			
		}else {
			System.out.println("Jogador não existe!");
		}
		
	}
	
	public void removeJogador(int numeroRegJogador, Clube clube, ControleJogadores ctrJogadores) {
		
		if(ctrJogadores.buscaJogador(numeroRegJogador) != null) {
			
			if(verificaJogadorClube(clube, numeroRegJogador)) {
				
				if(clube.getIndex() < Clube.getTamanhojogador()) {
					clube.removeJogador(numeroRegJogador);
				}else {
					System.out.println("Clube só pode ter "+ Clube.getTamanhojogador() + "jogadores!");
				}
			}else {
				System.out.println("Jogador não foi inserido no Clube!");
			}
			
			
		}else {
			System.out.println("Jogador não existe!");
		}
		
	}
	
	public boolean verificaJogadorClube(Clube clube, int numeroRegJogador) {
		
		for(int a = 0; a < clube.getIndex(); a++) {
			if(clube.getJogadores()[a].getNumeroRegistro() == numeroRegJogador) {
				return true; 
			}
		}
		
		return false; 
	}
	
	public boolean verificaJogadorClube(Jogadores jogador, int numeroRegClube) {
		
		if(jogador.getIdClube() == numeroRegClube) {
				return true; 
			}
				
		return false; 
	}
	
	public void listaJogadores(Clube clube) {
		
		System.out.println("");
		for(int a = 0; a<clube.getIndex(); a++) {
			
				System.out.println("Nome: "+ clube.getJogadores()[a].getNome() + " Força: "+ clube.getJogadores()[a].getHabilidade() + " Posição: "+ clube.getJogadores()[a].getPosicao());
			}
			
		
	}
	
	public void atualizaDadosClube(Clube clube, Partida partida) {
		
		if(clube.getNumeroRegistro() == partida.getClubeCasa().getNumeroRegistro()) {
			
			if(partida.getGolCasa() == partida.getGolFora()) {
				
				clube.setPontosCampAtual(clube.getPontosCampAtual()+1);
				clube.setEmpateCampAtual(clube.getEmpateCampAtual()+1);
				clube.setGolsProCampAtual(clube.getGolsProCampAtual()+partida.getGolCasa()); 
				clube.setGolsContraCampAtual(clube.getGolsContraCampAtual()+partida.getGolFora()); 
				
			}else if(partida.getGolCasa() > partida.getGolFora()) {
				
				clube.setPontosCampAtual(clube.getPontosCampAtual()+3);
				clube.setEmpateCampAtual(clube.getVitoriasCampAtual()+1);
				clube.setGolsProCampAtual(clube.getGolsProCampAtual()+partida.getGolCasa()); 
				clube.setGolsContraCampAtual(clube.getGolsContraCampAtual()+partida.getGolFora()); 
			}
			
		}else if (clube.getNumeroRegistro() == partida.getClubeFora().getNumeroRegistro()){
			
			if(partida.getGolCasa() == partida.getGolFora()) {
				
				clube.setPontosCampAtual(clube.getPontosCampAtual()+1);
				clube.setEmpateCampAtual(clube.getEmpateCampAtual()+1);
				clube.setGolsProCampAtual(clube.getGolsProCampAtual()+partida.getGolFora()); 
				clube.setGolsContraCampAtual(clube.getGolsContraCampAtual()+partida.getGolCasa()); 
				
			}else if(partida.getGolCasa() < partida.getGolFora()) {
				
				clube.setPontosCampAtual(clube.getPontosCampAtual()+3);
				clube.setEmpateCampAtual(clube.getVitoriasCampAtual()+1);
				clube.setGolsProCampAtual(clube.getGolsProCampAtual()+partida.getGolFora()); 
				clube.setGolsContraCampAtual(clube.getGolsContraCampAtual()+partida.getGolCasa());  
			}
			
		}
		
		atualizaClube(clube);
	}
	

}
