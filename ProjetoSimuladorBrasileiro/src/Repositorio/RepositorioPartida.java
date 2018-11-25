package Repositorio;

import Basicas.Partida;

public interface RepositorioPartida {
	
	
	public void inserirPartida(Partida partida); 
	public void atualizaPartida(Partida partida); 
	public Partida buscaPartida(int partidaID); 
	public Partida buscaPartida(int idTimeCasa, int idTimeFora); 
	public void removePartida(int partidaID);
	public void listar(); 
	public void listar(int rodada); 
	
}
