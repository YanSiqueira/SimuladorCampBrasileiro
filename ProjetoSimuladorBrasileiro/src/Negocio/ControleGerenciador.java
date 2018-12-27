package Negocio;

import Basicas.Jogadores;
import Basicas.Perfil;
import Repositorio.RepositorioPerfis;
import Repositorio.RepositorioPerfisArray;

public class ControleGerenciador {
	
	private RepositorioPerfis perfis = new RepositorioPerfisArray();
	private Perfil gerenciador = new Gerenciador(null, 0, null, null);
	private RepositorioJogador jogadores =  new  RepositorioJogadoresArray ();
	private RepositorioClube clubes = new RepositorioClubeArray();
	
	//repositorio
	public void inserir(Perfil perfil) {
		perfis.inserir(perfil);
	}
	public void atualizar(Perfil perfil) {
		perfis.atualizar(perfil);
	}
	public Perfil buscar(int id) {
		return perfis.buscar(id);
	}
	public Perfil buscarLogin(String login) {
		return perfis.buscarLogin(login);
	}
	public void remover(int id) {
		perfis.remover(id);
	}
	
	//Perfil
	public Perfil criar(String nome, String login, String senha, String confirmarSenha, int tipoDePerfil) throws loginJaExisteException, SenhaMuitoCurtaException, SenhasNaoBatemException {
		Perfil perf = null;
		//verificando senha
		if(senha.length()>=4) {
			if(senha.equals(confirmarSenha)) {
				//verificando se o login existe
				if(this.buscarLogin(login) == null) {
					//chamando metodo que cria o id e monta perfil
					perf = gerenciador.criar(nome, login, senha, confirmarSenha, tipoDePerfil);
				}else {
					loginJaExisteException ljeE = new loginJaExisteException(login);
					throw ljeE;
				}
			}else {
				SenhasNaoBatemException snbE = new SenhasNaoBatemException(senha, confirmarSenha);
				throw snbE;
			}
		}else {
			SenhaMuitoCurtaException smcE = new SenhaMuitoCurtaException(senha);
			throw smcE;
		}
		return perf;
		
	}
	public Perfil altearConta(String novoNome, String novaSenha, String confirmarNovaSenha, int novoTipoDePerfil, int id) throws SenhaMuitoCurtaException, SenhasNaoBatemException {
		Perfil perf = null;
		//verificando senha
		if(novaSenha.length()>=4) {
			if(novaSenha.equals(confirmarNovaSenha)) {
					perf = gerenciador.alterarConta(novoNome, novaSenha, confirmarNovaSenha, novoTipoDePerfil, id);
				}else {
					SenhasNaoBatemException snbE = new SenhasNaoBatemException(novaSenha, confirmarNovaSenha);
					throw snbE;
			}
		}else {
			SenhaMuitoCurtaException smcE = new SenhaMuitoCurtaException(novaSenha);
			throw smcE;
		}
		return perf;
	}
	public boolean login(String login, String senhaDigitada) {
		boolean result=false;
		if(this.buscarLogin(login)!=null) {
			String senhaPerfil = this.buscarLogin(login).getSenha();
			result = gerenciador.login(login, senhaPerfil, senhaDigitada);
		}
		return result;
	}
	
	//jogador
	public void alteraJogador(Jogadores  jogador) {
		
	}
	public void alteraClube(Clube clube) {
		
	}
	public void exclueJogador(int numeroregistro) {
		
	}
	public void exclueCampionato() {
		
	}
	@Override
	public String toString() {
		return "ControleGerenciador [perfis=" + perfis + ", gerenciador=" + gerenciador + "]";
	}
	
}
