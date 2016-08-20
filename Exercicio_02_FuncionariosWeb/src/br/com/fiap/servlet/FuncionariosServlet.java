package br.com.fiap.servlet;

import java.io.IOException;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.bean.FuncionariosBeanRemote;
import br.com.fiap.entity.Funcionario;


@WebServlet("/funcionario")
public class FuncionariosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public FuncionariosServlet() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		FuncionariosBeanRemote service;
		try {
			InitialContext ctx = new InitialContext();
			service = (FuncionariosBeanRemote) ctx.lookup("ejb:/Exercicio_02_Funcionarios/FuncionariosBean!br.com.fiap.bean.FuncionariosBeanRemote");
			
			List<Funcionario> lista = service.getAll();
			request.setAttribute("lista", lista);
			request.getRequestDispatcher("funcionario.jsp").forward(request, response);
			
		} catch (NamingException e) {
			
			e.printStackTrace();
		}
	//	response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}