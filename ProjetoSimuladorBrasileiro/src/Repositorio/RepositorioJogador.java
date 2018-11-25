package Repositorio;
import Basicas.Jogadores;;


public interface RepositorioJogador {
	
	public void inserirJogador(Jogadores jogador); 
	public void atualizaJogador(Jogadores jogador); 
	public Jogadores buscaJogador(int numeroregistro); 
	public void removeJogador(int numeroregistro);
	public void listar(); 

}
