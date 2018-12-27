package Basicas;

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
	public Perfil criar(String nome, String login, String senha, String confirmarSenha, int tipoDePerfil) {
		Perfil perf=null;
		//atribundo id da conta
		this.id++;
		char[] Id = new char[8];
		for(int i=0; i<8; i++) {
			Id[i] = Integer.toString(this.id).charAt(i);//passando de inteiros para um vetor de char para manipular os digitos que identificam se a conta é player ou gerenciador
		}
		if(tipoDePerfil == 0) {//verificando se a conta a ser criada será gerenciador ou player.
			Id[1] = '0';
			this.id = Integer.parseInt(String.copyValueOf(Id));//passando de um vetor de char para um numero inteiro.
			perf = new Gerenciador(null, 0, null, null);//criando a nova conta
		}else {
			Id[1] = '1';
			this.id = Integer.parseInt(String.copyValueOf(Id));//passando de um vetor de char para um numero inteiro.
			/*perf = new Player();*/
			}
		perf.setNome(nome);
		perf.setId(id);
		perf.setLogin(login);
		perf.setSenha(senha);
		return perf;
	}
	public Perfil alterarConta(String novoNome, String novaSenha, String confirmarNovaSenha, int novoTipoDePerfil, int id) {
		Perfil perf = null;
		//atribundo id da conta
		char[] Id = new char[8];
		for(int i=0; i<8; i++) {
			Id[i] = Integer.toString(id).charAt(i);//passando de inteiros para um vetor de char para melhor manipulação dos digitos
		}
		if(novoTipoDePerfil == 0) {//verificando se a conta alterada será gerenciador ou player.
			Id[1] = '0';
			this.id = Integer.parseInt(String.copyValueOf(Id));//passando de um vetor de char para um numero inteiro.
			perf = new Gerenciador(null, 0, null, null);
		}else {
			Id[1] = '1';
			this.id = Integer.parseInt(String.copyValueOf(Id));//passando de um vetor de char para um numero inteiro.
			/*perf = new Player();*/
		}
		perf.setNome(novoNome);
		perf.setId(id);
		perf.setLogin(this.login);
		perf.setSenha(novaSenha);
		return perf;
	}
	public boolean login(String login, String senhaPerfil, String senhaDigitada) {
		boolean resultadoDoLogin = false;
			//verifica se a senha inserida bate com a senha registrada no respectivo loging
			if(senhaDigitada.equals(senhaPerfil)) {
				//confirma login
				resultadoDoLogin = true;
			}
		return resultadoDoLogin;
		}
	@Override
	public String toString() {
		return "Perfil [nome=" + nome + ", id=" + id + ", login=" + login + ", senha=" + senha + "]";
	}
	
	}
