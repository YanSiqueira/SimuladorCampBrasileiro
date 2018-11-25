package Repositorio;

import Basicas.Jogadores;

public class RepositorioJogadoresArray implements RepositorioJogador{
	
	private Jogadores[] listaJogadores;
	private int index; 
	public final static int tamanho = 400; 
	
	public Jogadores[] getListaJogadores() {
		return listaJogadores;
	}

	public RepositorioJogadoresArray() {
		this.listaJogadores = new Jogadores[tamanho];
		this.index = 0;
	}

	@Override
	public void inserirJogador(Jogadores jogador) {
		// TODO Auto-generated method stub
		
		this.listaJogadores[index] = jogador; 
		this.index += 1; 
		
	}

	@Override
	public void atualizaJogador(Jogadores jogador) {
		// TODO Auto-generated method stub
		
		for(int a=0; a<index; a++) {
			if(jogador.getNumeroRegistro() == listaJogadores[a].getNumeroRegistro()) {
				listaJogadores[a] = jogador;
			}
		}
		
	}

	@Override
	public Jogadores buscaJogador(int numeroregistro) {
		Jogadores jogador = null;
		
		for(int a = 0; a<index; a++) {
			if(listaJogadores[a].getNumeroRegistro() == numeroregistro) {
				jogador = listaJogadores[a];
			}
		}
		
		return jogador;
	}

	@Override
	public void removeJogador(int numeroregistro) {
		// TODO Auto-generated method stub
		
		for(int a = 0; a<index; a++) {
			if(listaJogadores[a].getNumeroRegistro() == numeroregistro) {
				listaJogadores[a] = listaJogadores[index-1]; 
				this.index -=1; 
			}
		}
		
	}

	@Override
	public void listar() {
		// TODO Auto-generated method stub
		
		for(int a=0; a<index; a++) {
			System.out.println("Nome: "+ this.listaJogadores[a].getNome());
		}
		
	}

}
