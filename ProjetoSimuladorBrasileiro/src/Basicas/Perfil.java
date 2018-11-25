package Basicas;

import Negocio.ControleGerenciador;
import Repositorio.RepositorioPerfisArray;
//consertei a palavra login
public abstract class Perfil {
	//atributos
	private String nome;
	private int id;
	private String login;
	private String senha;
	//construtor
	public Perfil(String nome, int id, String login, String senha) {
		super();
		this.nome = nome;
		this.id = 10000000;//ID zerado, os dois primeiros digitos são para identificação do tido de conta, "10" para gerenciador e "11" para player.
		this.login = login;
		this.senha = senha;
	}
	//gets & sets
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	//métodos
	public void criar(String nome, String loging, String senha, String confirmarSenha, int tipoDePerfil) {
		Perfil perf = null;
		//verificando se o login já exixite.
		RepositorioPerfisArray rca = new RepositorioPerfisArray();
		if(rca.buscarLogin(login) == null) {
			//verificando senha
			if(senha.length()>4) {
				if(senha.equals(confirmarSenha)) {
					//atribundo id da conta
					char[] Id = new char[8];
					for(int i=0; i<8; i++) {
						Id[i] = Integer.toString(this.id).charAt(i);//passando de inteiros para um vetor de char para melhor manipulação dos digitos
					}
					if(tipoDePerfil == 0) {//verificando se a conta a ser criada será gerenciador ou player.
						Id[1] = '0';
						Perfil perfil = new Gerenciador(nome, this.id, loging, confirmarSenha);
						perf = perfil;
					}else {
						Id[1] = '1';
						Perfil perfil = new Gerenciador(nome, this.id, loging, confirmarSenha);//alterar "gerenciador" para "player" quando a classe existir
						perf = perfil;
					}
					this.id = Integer.parseInt(String.copyValueOf(Id));//passando de um vetor de char para um numero inteiro.
					this.id++;
					//inserindo no repositorio
					ControleGerenciador cg = new ControleGerenciador();
					cg.inserir(perf);
					
				}
			}
		}
	}
	public void alterarConta(String novoNome, String novoLogin, String novaSenha, String confirmarNovaSenha, int novoTipoDePerfil) {
		Perfil perf = null;
		//verificando se o login já exixite.
		RepositorioPerfisArray rca = new RepositorioPerfisArray();
		if(rca.buscarLogin(novoLogin) == null) {
			//verificando senha
			if(novaSenha.length()>4) {
				if(novaSenha.equals(confirmarNovaSenha)) {
					//atribundo id da conta
					char[] Id = new char[8];
					for(int i=0; i<8; i++) {
						Id[i] = Integer.toString(this.id).charAt(i);//passando de inteiros para um vetor de char para melhor manipulação dos digitos
					}
					if(novoTipoDePerfil == 0) {//verificando se a conta a ser criada será gerenciador ou player.
						Id[1] = '0';
						Perfil perfil = new Gerenciador(novoNome, this.id, novoLogin, confirmarNovaSenha);
						perf = perfil;
					}else {
						Id[1] = '1';
						Perfil perfil = new Gerenciador(novoNome, this.id, novoLogin, confirmarNovaSenha);//alterar "gerenciador" para "player" quando a classe existir
						perf = perfil;
					}
					this.id = Integer.parseInt(String.copyValueOf(Id));//passando de um vetor de char para um numero inteiro.
					//Alterando no repositorio
					ControleGerenciador cg = new ControleGerenciador();
					cg.atualizar(perf);
					
				}
			}
		}
	}
	public boolean loging(String login, String senha) {
		boolean resultadoDoLogin = false;
		//verificando se o login já exixite.
		RepositorioPerfisArray rca = new RepositorioPerfisArray();
		if(rca.buscarLogin(login) != null) {//verifica se o login existe
			//verificando senha
			if(senha.equals(rca.buscarLogin(login).senha)) {//verifica se a senha inserida bate com a senha registrada no respectivo loging
				resultadoDoLogin = true;//confirma loging 
			}
			}
		return resultadoDoLogin;
		}
	}
