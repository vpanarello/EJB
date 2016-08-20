package br.com.fiap.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.interfaces.Cadastro;

@WebServlet("/cadastro")
public class CadastroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	Cadastro cadastro;
       
    public CadastroServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("LISTADO!");
		PrintWriter out = response.getWriter();
		response.setContentType("text/html"); 
		
		out.println("<ul>");
		
		for(String str : cadastro.buscarNomes()) {
			out.println("<li>" + str + "</li>");
		}
		out.println("</ul>");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("RECEBIDO!");
		String str = request.getParameter("nome");
	
		cadastro.incluirNome(str);
	
	}

}