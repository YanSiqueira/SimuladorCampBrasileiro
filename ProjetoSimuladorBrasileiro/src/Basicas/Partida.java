package Basicas;
import java.util.Date;

public class Partida {
	
	private Clube clubeCasa; 
	private Clube clubeFora; 
	private int golCasa; 
	private int golFora; 
	private int golJogadorFora[]; 
	private int golJogadorCasa[]; 
	private Date data;
	private int publico; 
	private double renda; 
	private int rodada; 
	private boolean statusPartida;
	private int partidaID; 
	
	public Partida(Clube clubeCasa, Clube clubeFora, Date data, int rodada, boolean statusPartida, int partidaID) {
		this.clubeCasa = clubeCasa;
		this.clubeFora = clubeFora;
		this.data = data;
		this.rodada = rodada;
		this.statusPartida = statusPartida;
		this.partidaID = partidaID;
	}
	
	
	
	public int getPartidaID() {
		return partidaID;
	}



	public void setPartidaID(int partidaID) {
		this.partidaID = partidaID;
	}



	public Clube getClubeCasa() {
		return clubeCasa;
	}

	public void setClubeCasa(Clube clubeCasa) {
		this.clubeCasa = clubeCasa;
	}

	public Clube getClubeFora() {
		return clubeFora;
	}

	public void setClubeFora(Clube clubeFora) {
		this.clubeFora = clubeFora;
	}

	public int getGolCasa() {
		return golCasa;
	}

	public void setGolCasa(int golCasa) {
		this.golCasa = golCasa;
	}

	public int getGolFora() {
		return golFora;
	}

	public void setGolFora(int golFora) {
		this.golFora = golFora;
	}

	public int[] getGolJogadorFora() {
		return golJogadorFora;
	}

	public void setGolJogadorFora(int[] golJogadorFora) {
		this.golJogadorFora = golJogadorFora;
	}

	public int[] getGolJogadorCasa() {
		return golJogadorCasa;
	}

	public void setGolJogadorCasa(int[] golJogadorCasa) {
		this.golJogadorCasa = golJogadorCasa;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public int getPublico() {
		return publico;
	}

	public void setPublico(int publico) {
		this.publico = publico;
	}

	public double getRenda() {
		return renda;
	}

	public void setRenda(double renda) {
		this.renda = renda;
	}

	public int getRodada() {
		return rodada;
	}

	public void setRodada(int rodada) {
		this.rodada = rodada;
	}

	public boolean isStatusPartida() {
		return statusPartida;
	}

	public void setStatusPartida(boolean statusPartida) {
		this.statusPartida = statusPartida;
	} 
	
	
	
	

}
