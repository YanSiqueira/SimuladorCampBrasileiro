package Repositorio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import Basicas.Jogadores;

public class RepositorioJogadoresArquivo implements RepositorioJogador, Serializable{

		
	private static final long serialVersionUID = 2866983109115076704L;
	private Jogadores[] listaJogadores;
	private int index; 
	public final static int tamanho = 400; 
	
	private static RepositorioJogadoresArquivo instance;
	
	private RepositorioJogadoresArquivo() {
	    this.listaJogadores = new Jogadores[tamanho];
	    this.index = 0;
	  }
	
	public static RepositorioJogador getInstance() {
	    if (instance == null) {
	      instance = lerDoArquivo();
	    }
	    return instance;
	  }
	
	private static RepositorioJogadoresArquivo lerDoArquivo() {
		RepositorioJogadoresArquivo instanciaLocal = null;

	    File in = new File("jogadores.dat");
	    FileInputStream fis = null;
	    ObjectInputStream ois = null;
	    try {
	      fis = new FileInputStream(in);
	      ois = new ObjectInputStream(fis);
	      Object o = ois.readObject();
	      instanciaLocal = (RepositorioJogadoresArquivo) o;
	    } catch (Exception e) {
	      instanciaLocal = new RepositorioJogadoresArquivo();
	    } finally {
	      if (ois != null) {
	        try {
	          ois.close();
	        } catch (IOException e) {
	        }
	      }
	    }

	    return instanciaLocal;
	}
	
	public void salvarArquivo() {
	    if (instance == null) {
	      return;
	    }
	    File out = new File("jogadores.dat");
	    FileOutputStream fos = null;
	    ObjectOutputStream oos = null;

	    try {
	      fos = new FileOutputStream(out);
	      oos = new ObjectOutputStream(fos);
	      oos.writeObject(instance);
	    } catch (Exception e) {
	      e.printStackTrace();
	    } finally {
	      if (oos != null) {
	        try {
	          oos.close();
	        } catch (IOException e) {
	        }
	      }
	    }
	  }
	
	public Jogadores[] getListaJogadores() {
		
		return listaJogadores;
	}

	@Override
	public void inserirJogador(Jogadores jogador) {
		// TODO Auto-generated method stub
		
		this.listaJogadores[index] = jogador; 
		this.index += 1; 
	
		
		
	}

	@Override
	public void atualizaJogador(Jogadores jogador) {
		// TODO Auto-generated method stub
		
		for(int a=0; a<index; a++) {
			if(jogador.getNumeroRegistro() == listaJogadores[a].getNumeroRegistro()) {
				listaJogadores[a] = jogador;
			}
		}
		
		
	}

	@Override
	public Jogadores buscaJogador(int numeroregistro) {
		Jogadores jogador = null;
		
		for(int a = 0; a<index; a++) {
			if(listaJogadores[a].getNumeroRegistro() == numeroregistro) {
				jogador = listaJogadores[a];
			}
		}
		
		return jogador;
	}

	@Override
	public void removeJogador(int numeroregistro) {
		// TODO Auto-generated method stub
		
		for(int a = 0; a<index; a++) {
			if(listaJogadores[a].getNumeroRegistro() == numeroregistro) {
				listaJogadores[a] = listaJogadores[index-1]; 
				this.index -=1; 
			}
		}
		
		
	}

	@Override
	public void listar() {
		// TODO Auto-generated method stub
		
		lerDoArquivo();
		for(int a=0; a<index; a++) {
			System.out.println("Nome: "+ this.listaJogadores[a].getNome());
		}
		
	}
	
}
