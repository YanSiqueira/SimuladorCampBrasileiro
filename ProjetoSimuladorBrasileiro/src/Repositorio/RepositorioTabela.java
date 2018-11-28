package Repositorio;
import Basicas.Tabela;

public interface RepositorioTabela {
	
	public void inserirTabela(Tabela tabela); 
	public void atualizaTabela(Tabela Tabela); 
	public Tabela buscaTabela(int tabelaID); 
	public void removeTabela(int tabelaID);
	public void listar(); 

}
