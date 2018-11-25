package Negocio;

import Basicas.Jogadores;
import Basicas.Perfil;
import Repositorio.RepositorioPerfis;
import Repositorio.RepositorioPerfisArray;

public class ControleGerenciador {
	
	private RepositorioPerfis perfis = new RepositorioPerfisArray();
	/*private RepositorioJogador jogadores =  new  RepositorioJogadoresArray ();
	private RepositorioClube clubes = new RepositorioClubeArray();*/
	
	//metodos
	public void inserir(Perfil perfil) {
		perfis.inserir(perfil);
	}
	public void atualizar(Perfil perfil) {
		perfis.atualizr(perfil);
	}
	public void buscar(int id) {
		perfis.buscar(id);
	}
	public void remover(int id) {
		perfis.remover(id);
	}
	//metodos de gerenciador
	/*public void alteraJogador(Jogadores  jogador) {
		
		if(jogador != null) {
			jogadores.atualizaJogador(jogador);
		}else {
			System.out.println("O Jogador está vazio");
		}
	}
	public void alteraClube(Clube clube) {
		if(clube != null) {
			clubes.atualizaClube(clube);
		}else {
			System.out.println("O clube está vazio");
		}
	}
	public void exclueJogador(int numeroregistro) {
		
		if(numeroregistro > 0) {
			if(jogadores.buscaJogador(numeroregistro) != null) {
				jogadores.removeJogador(numeroregistro); 
			}else {
				System.out.println("Erro, jogador não existe!");
			}
			
		}
	}
	public void exclueCampionato() {
		
	}*/
}