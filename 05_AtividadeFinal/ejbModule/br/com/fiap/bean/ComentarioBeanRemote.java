package br.com.fiap.bean;

import java.util.List;

import javax.ejb.Remote;
import br.com.fiap.entity.Comentario;

@Remote
public interface ComentarioBeanRemote {
	
	void add(Comentario comentario);
	List<Comentario> getAll();

}
