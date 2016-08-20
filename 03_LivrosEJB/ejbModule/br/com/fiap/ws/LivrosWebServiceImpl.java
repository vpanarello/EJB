package br.com.fiap.ws;

import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebService;

import br.com.fiap.bean.LivrosBean;
import br.com.fiap.bean.LivrosBeanRemote;
import br.com.fiap.entity.Livros;

@WebService(serviceName="livrosWebService")
public class LivrosWebServiceImpl implements LivrosWebService {
	
	LivrosBeanRemote lbr = new LivrosBean();

	@Override
	public void adicionar(@WebParam(name = "livros") Livros livro) {
		lbr.add(livro);
	}

	@Override
	public List<Livros> listar() {
		return lbr.getAll();
	}


}
