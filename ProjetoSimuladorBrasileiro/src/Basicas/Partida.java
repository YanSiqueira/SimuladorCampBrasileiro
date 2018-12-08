package Basicas;
import java.util.Date;

public class Partida implements Comparable<Partida>{
	
	private int clubeCasa; 
	private int clubeFora; 
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
	
	public Partida(int clubeCasa, int clubeFora, Date data, int rodada, boolean statusPartida, int partidaID) {
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



	public int getClubeCasa() {
		return this.clubeCasa;
	}

	public void setClubeCasa(int clubeCasa) {
		this.clubeCasa = clubeCasa;
	}

	public int getClubeFora() {
		return clubeFora;
	}

	public void setClubeFora(int clubeFora) {
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

	public boolean getStatusPartida() {
		return statusPartida;
	}

	public void setStatusPartida(boolean statusPartida) {
		this.statusPartida = statusPartida;
	}



	@Override
	public int compareTo(Partida partida) {
		// TODO Auto-generated method stub
		int compareRodada = partida.getRodada(); 
		return this.rodada - compareRodada;
	} 
	
	
	
	

}
