package Repositorio;

import Basicas.Perfil;

public class RepositorioPerfisArray implements RepositorioPerfis{
	
	private Perfil[] perfis;
	private final static int TAMANHO = 100;
	
	public RepositorioPerfisArray() {
		super();
		this.perfis = new Perfil[TAMANHO];
	}
	@Override
	public void inserir(Perfil perfil) { //insere na primeira possição não nula
		for(int i=0;i<TAMANHO;i++) {
			if(perfis[i] == null) {
				perfis[i] = perfil;
				break;
			}
		}
	}

	@Override
	public void atualizar(Perfil perfil) { //procura o perfil pelo Id e subistitui o antigo pelo atualizado.
		for(int i=0;i<TAMANHO;i++) {
			if(perfis[i] != null) {
				if(perfis[i].getId() == perfil.getId()) {
					perfil.setLogin(perfis[i].getLogin());
					perfis[i]=perfil;
					break;
				}
			}
		}
	}
	@Override
	public Perfil buscar(int id) { //procura o perfil pelo id e o retorna se achar-lo. retorna nulo caso contrário.
		Perfil perf = null;
		 for(int i=0;i<TAMANHO;i++) {
				if(perfis[i] != null) {
					if(perfis[i].getId() == id) {
						perf = perfis[i];
						break;
					}
				}
			}
		 return perf;
	}
	@Override
	public void remover(int id) { //procura o perfil pelo id e o subistitui por nulo.
		for(int i=0;i<TAMANHO;i++) {
			if(perfis[i] != null) {
				if(perfis[i].getId() == id) {
					perfis[i] = null;
					break;
				}
			}
		}
	}
	@Override
	public Perfil buscarLogin(String login) { //procura o perfil pelo login. Será usado pelo Criar() para verificar se o login ja existe.
		for(int i=0;i<TAMANHO;i++) {
			if(perfis[i] != null) {
				if(perfis[i].getLogin().equals(login)) {
					return perfis[i];
				}
			}
		}
		 return null;
	}
	@Override
	public String toString() {
		return "RepositorioPerfisArray [perfis=" + Arrays.toString(perfis) + "]";
	}
}
