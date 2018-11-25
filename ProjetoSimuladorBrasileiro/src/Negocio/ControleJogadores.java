package Negocio;

import Basicas.Jogadores;
import Repositorio.RepositorioJogador;
import Repositorio.RepositorioJogadoresArray;; 


public class ControleJogadores {
	
	
	RepositorioJogador repositorioJogador = new RepositorioJogadoresArray(); 
	
	public void insereJogador(Jogadores jogador) {
		
		if(jogador != null) {
			repositorioJogador.inserirJogador(jogador);
		}else {
			System.out.println("O Jogador está vazio");
		}
		
	}
	
	public void atualizaJogador(Jogadores jogador) {
		
		if(jogador != null) {
			repositorioJogador.atualizaJogador(jogador);
		}else {
			System.out.println("O Jogador está vazio");
		}
		
	}
	
	public Jogadores buscaJogador(int numeroregistro) {
		if(numeroregistro > 0) {
			return repositorioJogador.buscaJogador(numeroregistro); 
		}
		return null; 
	}
	
	public void removeJogador(int numeroregistro) {
		
		if(numeroregistro > 0) {
			if(buscaJogador(numeroregistro) != null) {
				repositorioJogador.removeJogador(numeroregistro); 
			}else {
				System.out.println("Erro, jogador não existe!");
			}
			
		}
	}
	
	public void listarJogadores() {
		if(((RepositorioJogadoresArray) repositorioJogador).getListaJogadores() != null) {
			repositorioJogador.listar();
		}else {
			System.out.println("Jogadores ainda não foram inseridos");
		}
	}
	
	public double verificaPosicaoJogador(Jogadores jogador) {
		
		
		if(jogador.getPosicao() == jogador.getPosicaoAtual()) {
			return 1; 
		}else if(jogador.getPosicao() <= jogador.getPosicaoAtual()-1) {
			
			return 0.3;
		}else if(jogador.getPosicao() < jogador.getPosicaoAtual()) {
			return 0.2;
		}else if(jogador.getPosicao() >= jogador.getPosicaoAtual()-1) {
			return 0.2; 
		}else if(jogador.getPosicao() > jogador.getPosicaoAtual()) {
			return 0.3; 
		}
		
		return 0; 
	}
	
	public void atualizaGols(Jogadores jogador, int gols) {
		jogador.setGol(jogador.getGol()+gols); 
	}

}
