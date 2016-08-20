package br.com.fiap.bean;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.com.fiap.entity.Funcionario;

/**
 * Session Bean implementation class FuncionariosBean
 */
@Stateless
@LocalBean
public class FuncionariosBean implements FuncionariosBeanRemote {
	
	@PersistenceContext(unitName="fiapPU")
	private EntityManager em;


    public FuncionariosBean() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void add(Funcionario funcionario) {
		em.persist(funcionario);
	}

	@Override
	public List<Funcionario> getAll() {
		TypedQuery<Funcionario> query = em.
				createQuery("select f from Funcionario f",Funcionario.class);
				return query.getResultList();

	}

}
