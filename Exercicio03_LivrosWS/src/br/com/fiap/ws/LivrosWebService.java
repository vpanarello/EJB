package br.com.fiap.ws;

public interface LivrosWebService {
	void add(Livros livro);
	List<Livros> getAll();
}