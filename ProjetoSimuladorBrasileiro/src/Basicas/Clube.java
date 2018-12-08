package Basicas;


public class Clube implements Comparable<Clube>{
	
	private String nome; 
	private int numeroRegistro; 
	private Jogadores jogadores[]; 
	public static final int tamanhoJogador = 20; 
	private int index; 
	private int contJogador; 
	private int idCampeonatoAtual;
	private int pontosCampAtual; 
	private int golsProCampAtual; 
	private int golsContraCampAtual; 
	private int vitoriasCampAtual; 
	private int empateCampAtual; 
	private int derrotaCampAtual; 
	private String nomeEstadio; 
	private int prestigoTorcida;
	
	
	public Clube(String nome, int numeroRegistro,
			int pontosCampAtual, int golsProCampAtual, int golsContraCampAtual, int vitoriasCampAtual,
			int empateCampAtual, int derrotaCampAtual, String nomeEstadio, int prestigoTorcida) {
		super();
		this.nome = nome;
		this.numeroRegistro = numeroRegistro;
		this.pontosCampAtual = pontosCampAtual;
		this.golsProCampAtual = golsProCampAtual;
		this.golsContraCampAtual = golsContraCampAtual;
		this.vitoriasCampAtual = vitoriasCampAtual;
		this.empateCampAtual = empateCampAtual;
		this.derrotaCampAtual = derrotaCampAtual;
		this.nomeEstadio = nomeEstadio;
		this.prestigoTorcida = prestigoTorcida;
		this.jogadores = new Jogadores[tamanhoJogador]; 
	}

	
	
	public Clube(String nome, int numeroRegistro, Jogadores[] jogadores, int contJogador, int idCampeonatoAtual,
			int pontosCampAtual, int golsProCampAtual, int golsContraCampAtual, int vitoriasCampAtual,
			int empateCampAtual, int derrotaCampAtual, String nomeEstadio, int prestigoTorcida) {
		super();
		this.nome = nome;
		this.numeroRegistro = numeroRegistro;
		this.jogadores = jogadores;
		this.contJogador = contJogador;
		this.idCampeonatoAtual = idCampeonatoAtual;
		this.pontosCampAtual = pontosCampAtual;
		this.golsProCampAtual = golsProCampAtual;
		this.golsContraCampAtual = golsContraCampAtual;
		this.vitoriasCampAtual = vitoriasCampAtual;
		this.empateCampAtual = empateCampAtual;
		this.derrotaCampAtual = derrotaCampAtual;
		this.nomeEstadio = nomeEstadio;
		this.prestigoTorcida = prestigoTorcida;
	}


	public Clube(String nome, int numeroRegistro, int contJogador, int pontosCampAtual, int golsProCampAtual,
			int golsContraCampAtual, int vitoriasCampAtual, int empateCampAtual, int derrotaCampAtual, String nomeEstadio,
			int prestigoTorcida) {
		super();
		this.nome = nome;
		this.numeroRegistro = numeroRegistro;
		this.contJogador = contJogador;
		this.pontosCampAtual = pontosCampAtual;
		this.golsProCampAtual = golsProCampAtual;
		this.golsContraCampAtual = golsContraCampAtual;
		this.vitoriasCampAtual = vitoriasCampAtual;
		this.empateCampAtual = empateCampAtual;
		this.derrotaCampAtual = derrotaCampAtual;
		this.nomeEstadio = nomeEstadio;
		this.prestigoTorcida = prestigoTorcida;
		this.jogadores = new Jogadores[tamanhoJogador]; 
	}
	
	
	Clube(){
		
		this.nome = "";
		this.numeroRegistro = 000;
		this.contJogador = 0;
		this.pontosCampAtual = 0;
		this.golsProCampAtual = 0;
		this.golsContraCampAtual = 0;
		this.vitoriasCampAtual = 0;
		this.empateCampAtual = 0;
		this.derrotaCampAtual = 0;
		this.nomeEstadio = "";
		this.prestigoTorcida = 0;
		
	}


	public int getIndex() {
		return index;
	}


	public void setIndex(int index) {
		this.index = index;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public int getNumeroRegistro() {
		return numeroRegistro;
	}


	public void setNumeroRegistro(int numeroRegistro) {
		this.numeroRegistro = numeroRegistro;
	}


	public Jogadores[] getJogadores() {
		return jogadores;
	}


	public void setJogadores(Jogadores[] jogadores) {
		this.jogadores = jogadores;
	}


	public int getContJogador() {
		return contJogador;
	}


	public void setContJogador(int contJogador) {
		this.contJogador = contJogador;
	}


	public int getIdCampeonatoAtual() {
		return idCampeonatoAtual;
	}


	public void setIdCampeonatoAtual(int idCampeonatoAtual) {
		this.idCampeonatoAtual = idCampeonatoAtual;
	}


	public int getPontosCampAtual() {
		return pontosCampAtual;
	}


	public void setPontosCampAtual(int pontosCampAtual) {
		this.pontosCampAtual = pontosCampAtual;
	}


	public int getGolsProCampAtual() {
		return golsProCampAtual;
	}


	public void setGolsProCampAtual(int golsProCampAtual) {
		this.golsProCampAtual = golsProCampAtual;
	}


	public int getGolsContraCampAtual() {
		return golsContraCampAtual;
	}


	public void setGolsContraCampAtual(int golsContraCampAtual) {
		this.golsContraCampAtual = golsContraCampAtual;
	}


	public int getVitoriasCampAtual() {
		return vitoriasCampAtual;
	}


	public void setVitoriasCampAtual(int vitoriasCampAtual) {
		this.vitoriasCampAtual = vitoriasCampAtual;
	}


	public int getEmpateCampAtual() {
		return empateCampAtual;
	}


	public void setEmpateCampAtual(int empateCampAtual) {
		this.empateCampAtual = empateCampAtual;
	}


	public int getDerrotaCampAtual() {
		return derrotaCampAtual;
	}


	public void setDerrotaCampAtual(int derrotaCampAtual) {
		this.derrotaCampAtual = derrotaCampAtual;
	}


	public String getNomeEstadio() {
		return nomeEstadio;
	}


	public void setNomeEstadio(String nomeEstadio) {
		this.nomeEstadio = nomeEstadio;
	}


	public int getPrestigoTorcida() {
		return prestigoTorcida;
	}


	public void setPrestigoTorcida(int prestigoTorcida) {
		this.prestigoTorcida = prestigoTorcida;
	}


	public static int getTamanhojogador() {
		return tamanhoJogador;
	}
	
	
	public void incluiJogador(Jogadores jogador) {
		jogador.setIdClube(this.numeroRegistro);
		this.jogadores[index] = jogador; 
		this.index += 1; 
	}
	
	public void removeJogador(int numeroRegJogador) {
		
		for(int a = 0; a<index; a++) {
			if(this.jogadores[a].getNumeroRegistro() == numeroRegJogador) {
				this.jogadores[a].setIdClube(0);
				this.jogadores[a] = this.jogadores[index-1]; 
				this.index -=1; 
			}
		}
	}
	
	
	
	@Override
	public int compareTo(Clube clube) {
		// TODO Auto-generated method stub
		int comparePontos = clube.getPontosCampAtual(); 
		int comparaVitorias = clube.getVitoriasCampAtual(); 
		 
		
		if(comparePontos != this.pontosCampAtual) {
			
			return comparePontos - this.pontosCampAtual;
			
		}else{
			return comparaVitorias - this.vitoriasCampAtual;
		}
	
	

	}

}

