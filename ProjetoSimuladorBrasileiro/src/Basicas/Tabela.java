package Basicas;


public  class  Tabela {

	private String ano; 
	private int idCamp; 
	private String nomeCampeonato; 
	private String campeao;
	
	public String getAno() {
		return ano;
	}
	public void setAno(String ano) {
		this.ano = ano;
	}
	public int getIdCamp() {
		return idCamp;
	}
	public void setIdCamp(int idCamp) {
		this.idCamp = idCamp;
	}
	public String getNomeCampeonato() {
		return nomeCampeonato;
	}
	public void setNomeCampeonato(String nomeCampeonato) {
		this.nomeCampeonato = nomeCampeonato;
	}
	public String getCampeao() {
		return campeao;
	}
	public void setCampeao(String campeao) {
		this.campeao = campeao;
	}
	public Tabela(String ano, int idCamp, String nomeCampeonato, String campeao) {
		this.ano = ano;
		this.idCamp = idCamp;
		this.nomeCampeonato = nomeCampeonato;
		this.campeao = campeao;
	} 
	
	
	
	
}