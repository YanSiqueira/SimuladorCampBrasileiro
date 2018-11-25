package Repositorio;
import Basicas.Clube;



public interface RepositorioClube {
		
	public void inserirClube(Clube clube); 
	public void atualizaClube(Clube clube); 
	public Clube buscaClube(int numeroregistro); 
	public void removeClube(int numeroregistro);
	public void listar(); 


}
