package br.com.fiap.servlet;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.bean.ComentarioBeanRemote;
import br.com.fiap.entity.Comentario;

@WebServlet("/ecom")
public class ComentariosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	public ComentariosServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			InitialContext ctx = new InitialContext();
			ComentarioBeanRemote service = (ComentarioBeanRemote) ctx.lookup("ejb:/05_AtividadeFinal/ComentarioBean!br.com.fiap.bean.ComentarioBeanRemote");

			List<Comentario> comentarios = service.getAll();

			request.setAttribute("lista", comentarios);
			request.getRequestDispatcher("lista.jsp").forward(request, response);

		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doGet(request, response);
		Comentario comentario =  new Comentario();

		comentario.setAssunto(request.getParameter("assunto"));
		comentario.setData(new Date());
		comentario.setTitulo(request.getParameter("titulo"));

		try {
			InitialContext ctx = new InitialContext();
			ComentarioBeanRemote service = (ComentarioBeanRemote) ctx.lookup("ejb:/05_AtividadeFinal/ComentarioBean!br.com.fiap.bean.ComentarioBeanRemote");
			service.add(comentario);
			request.setAttribute("ok", true);
			doGet(request, response);

		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
}

