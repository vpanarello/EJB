package br.com.fiap.bean;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.com.fiap.entity.Comentario;

@Stateless
public class ComentarioBean implements  ComentarioBeanRemote {

	@PersistenceContext(unitName="fiapPU")
	private EntityManager em;

	@Override
	public void add(Comentario comentario) {
		em.persist(comentario);
	}

	@Override
	public List<Comentario> getAll() {

		TypedQuery<Comentario> query = em.createQuery("select c from Comentario c",
				Comentario.class);
		return query.getResultList();
	}

}
