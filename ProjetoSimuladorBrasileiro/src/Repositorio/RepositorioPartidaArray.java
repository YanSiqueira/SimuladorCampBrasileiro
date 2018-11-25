package Repositorio;

import Basicas.Partida;

public class RepositorioPartidaArray implements RepositorioPartida{
	
	private Partida[] listaPartidas; 
	private int index; 
	public final static int tamanho = 380; 
	
	public  RepositorioPartidaArray() {
		this.index = 0; 
		this.listaPartidas = new Partida[tamanho]; 
	}

	public Partida[] getListaPartidas() {
		return listaPartidas;
	}


	@Override
	public void inserirPartida(Partida partida) {
		// TODO Auto-generated method stub
		this.listaPartidas[index] = partida; 
		this.index += 1; 
		
	}

	@Override
	public void atualizaPartida(Partida partida) {
		// TODO Auto-generated method stub
		for(int a = 0; a < index; a++) {
			if(listaPartidas[a].getPartidaID() == partida.getPartidaID()) {
				listaPartidas[a] = partida; 
			}
		}
		
	}

	@Override
	public Partida buscaPartida(int partidaID) {
		// TODO Auto-generated method stub
		for(int a = 0; a < index; a++) {
			if(listaPartidas[a].getPartidaID() == partidaID) {
				return listaPartidas[a]; 
			}
		}
		
		return null;
	}

	@Override
	public Partida buscaPartida(int idTimeCasa, int idTimeFora) {
		// TODO Auto-generated method stub
		
		for(int a = 0; a < index; a++) {
			if(listaPartidas[a].getClubeCasa().getNumeroRegistro() == idTimeCasa && listaPartidas[a].getClubeFora().getNumeroRegistro() == idTimeFora) {
				return listaPartidas[a]; 
			}
		}
		
		return null;
	}

	@Override
	public void removePartida(int partidaID) {
		// TODO Auto-generated method stub
		for(int a = 0; a < index; a++) {
			if(listaPartidas[a].getPartidaID() == partidaID) {
				listaPartidas[a] = listaPartidas[index-1]; 
				this.index -= 1; 
			}
		}
	}

	@Override
	public void listar() {
		// TODO Auto-generated method stub
		for(int a = 0; a < index; a++) {
			System.out.println("Jogo: " + listaPartidas[a].getClubeCasa().getNome() +  " x "  + listaPartidas[a].getClubeFora().getNome() + " Rodada: " + listaPartidas[a].getRodada());
		}
		
	}

	@Override
	public void listar(int rodada) {
		// TODO Auto-generated method stub
		
	}

}
