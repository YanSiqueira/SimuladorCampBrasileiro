package Basicas;


/* Posições
1- Goleiro
2- Zagueiro
3- Lateral Direito
4- Lateral Esquerdo
5- Volante
6- Meio Campo
7- Atacante  */


public class Jogadores implements Comparable<Jogadores> {
	
	private String nome; 
	private int idade; 
	private int numeroRegistro; 
	private int IdClube; 
	private int posicao; 
	private int habilidade; 
	private int numero; 
	private int gol; 
	private boolean titular; 
	private boolean reserva; 
	private int posicaoAtual;  
	
	public static int numRegistro = 0; 
	
	
	public boolean getTitular() {
		return titular;
	}


	public void setTitular(boolean titular) {
		this.titular = titular;
	}


	public boolean getReserva() {
		return reserva;
	}


	public void setReserva(boolean reserva) {
		this.reserva = reserva;
	}


	public Jogadores() {
		
		this.nome = "";
		this.idade = 0;
		this.numeroRegistro = 0;
		this.IdClube = 0;
		this.posicao = 0;
		this.posicaoAtual = 0; 
		this.habilidade = 0;
		this.numero = 0;
		this.gol = 0;
		this.titular = false; 
		this.reserva = false; 
		
	}
	
	
	public Jogadores(String nome, int idade, int numeroRegistro, int idClube, int posicao, int habilidade, int numero,
			int gol, int posicaoAtual) {
		this.nome = nome;
		this.idade = idade;
		this.numeroRegistro = numeroRegistro;
		this.IdClube = idClube;
		this.posicao = posicao;
		this.habilidade = habilidade;
		this.numero = numero;
		this.gol = gol;
		this.posicaoAtual = posicaoAtual; 
	}
	
	public Jogadores(String nome, int idade, int numeroRegistro, int posicao, int habilidade, int numero,
			int gol) {
		this.nome = nome;
		this.idade = idade;
		this.numeroRegistro = numeroRegistro;
		this.posicao = posicao;
		this.habilidade = habilidade;
		this.numero = numero;
		this.gol = gol; 
	}
	
	
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public int getNumeroRegistro() {
		return numeroRegistro;
	}
	public void setNumeroRegistro(int numeroRegistro) {
		this.numeroRegistro = numeroRegistro;
	}
	public int getIdClube() {
		return IdClube;
	}
	public void setIdClube(int idClube) {
		IdClube = idClube;
	}
	public int getPosicao() {
		return posicao;
	}
	public void setPosicao(int posicao) {
		this.posicao = posicao;
	}
	public int getHabilidade() {
		return habilidade;
	}
	public void setHabilidade(int habilidade) {
		this.habilidade = habilidade;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public int getGol() {
		return gol;
	}
	public void setGol(int gol) {
		this.gol = gol;
	}


	public int getPosicaoAtual() {
		return posicaoAtual;
	}


	public void setPosicaoAtual(int posicaoAtual) {
		this.posicaoAtual = posicaoAtual;
	}
	
	
	



	@Override
	public int compareTo(Jogadores jogador) {
		// TODO Auto-generated method stub
		int compareIdade = jogador.getIdade();
		int comparaGol = jogador.getGol(); 
		
		if(compareIdade != this.idade) {
			
			return compareIdade - this.idade;
			
		}else{
			return comparaGol - this.gol;
		}
		
		
		
		
		//ascendente
		//return this.quantidade - compareQuantidade;
		
	}
	
	
	

}