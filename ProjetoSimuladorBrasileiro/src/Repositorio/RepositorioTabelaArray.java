package Repositorio;

import Basicas.Tabela;

public class RepositorioTabelaArray implements RepositorioTabela{

	private Tabela[] listaTabela;
	private int index; 
	public final static int tamanho = 50;
	
	public RepositorioTabelaArray() {
		this.listaTabela = new Tabela[tamanho];
		this.index = 0;
	}
	
	@Override
	public void inserirTabela(Tabela tabela) {
		// TODO Auto-generated method stub
		this.listaTabela[index] = tabela; 
		this.index += 1; 
		
	}

	@Override
	public void atualizaTabela(Tabela tabela) {
		
		for(int a=0; a<index; a++) {
			if(tabela.getIdCamp() == listaTabela[a].getIdCamp()) {
				listaTabela[a] = tabela;
			}
		}
		
	}

	@Override
	public Tabela buscaTabela(int tabelaID) {
		// TODO Auto-generated method stub
		Tabela tabela = null;
		
		for(int a = 0; a<index; a++) {
			if(listaTabela[a].getIdCamp() == tabelaID) {
				tabela = listaTabela[a];
			}
		}
		
		return tabela;
	}

	@Override
	public void removeTabela(int tabelaID) {
		// TODO Auto-generated method stub
		
		for(int a = 0; a<index; a++) {
			if(listaTabela[a].getIdCamp() == tabelaID) {
				listaTabela[a] = listaTabela[index-1]; 
				this.index -=1; 
			}
		}
		
	}

	@Override
	public void listar() {
		// TODO Auto-generated method stub
		
		for(int a=0; a<index; a++) {
			System.out.println("Nome: "+ this.listaTabela[a].getNomeCampeonato());
		}
		
	}

}
