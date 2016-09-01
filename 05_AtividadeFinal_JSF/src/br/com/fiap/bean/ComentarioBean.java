package br.com.fiap.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import br.com.fiap.entity.Comentario;

@ManagedBean
@RequestScoped
public class ComentarioBean implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Comentario comentario;
	private int status;
	

	
	public ComentarioBean(){
		comentario = new Comentario();
		
	}
	public Comentario getComentario() {
		return comentario;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public void setComentario(Comentario comentario) {
		this.comentario = comentario;
	}
	
	public String cadastrar() {
		
		System.out.println(this.comentario.getAssunto());

		try {
			InitialContext ctx = new InitialContext();
			
			this.comentario.setData(new Date());
																
			ComentarioBeanRemote service = (ComentarioBeanRemote) ctx.lookup("ejb:/05_AtividadeFinal/ComentarioBean!br.com.fiap.bean.ComentarioBeanRemote");
			service.add(this.comentario);

			return "lista";
		} catch (Exception e) {
			e.printStackTrace();
			return "falha";
		}
	}		

	public List<Comentario> getListar() {
		
		List<Comentario> comentarios = new ArrayList<>();
		try {
			InitialContext ctx = new InitialContext();
			ComentarioBeanRemote service = (ComentarioBeanRemote) ctx.lookup("ejb:/05_AtividadeFinal/ComentarioBean!br.com.fiap.bean.ComentarioBeanRemote");

			comentarios = service.getAll();
			
		} catch (NamingException e) {
		
			e.printStackTrace();
		}
		return comentarios;
	}
}