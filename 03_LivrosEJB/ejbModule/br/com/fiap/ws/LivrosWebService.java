package br.com.fiap.ws;

import java.util.List;

import javax.ejb.Remote;
import javax.jws.WebMethod;
import javax.jws.WebService;

import br.com.fiap.entity.Livros;

@WebService
@Remote
public interface LivrosWebService {
	
	@WebMethod
	List<Livros> listar();
	
}
