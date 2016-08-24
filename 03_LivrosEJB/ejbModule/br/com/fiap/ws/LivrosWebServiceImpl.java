package br.com.fiap.ws;

import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebService;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import br.com.fiap.bean.LivrosBean;
import br.com.fiap.bean.LivrosBeanRemote;
import br.com.fiap.entity.Livros;

@WebService(serviceName="livrosWebService")
public class LivrosWebServiceImpl implements LivrosWebService {

	@Override
	public List<Livros> listar() {
		try {
			InitialContext ctx = new InitialContext();
			LivrosBeanRemote service = (LivrosBeanRemote) ctx.lookup(name);
			
			lista = service.getAll();
		} catch (NamingException e) {
			e.printStackTrace();
		}
		return lista;
	}


}
