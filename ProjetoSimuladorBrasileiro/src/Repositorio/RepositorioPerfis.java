package Repositorio;
import Basicas.Perfil;

public interface RepositorioPerfis {
	public void inserir(Perfil perfil);
	public void atualizr(Perfil perfil);
	public Perfil buscar(int id);
	public void remover(int id);
	public Perfil buscarLogin(String login);
}
