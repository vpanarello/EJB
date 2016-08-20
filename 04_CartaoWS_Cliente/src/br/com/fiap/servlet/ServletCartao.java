package br.com.fiap.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.ws.CartaoWebService;
import br.com.fiap.ws.CartaoWebServiceProxy;


@WebServlet("/cartao")
public class ServletCartao extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletCartao() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		 response.setContentType("text/html");

		 try {
		 String cartao = request.getParameter("cartao");
		 double valor = Double.parseDouble(request.getParameter("valor"));
		 CartaoWebService card = new CartaoWebServiceProxy();
		 out.print(card.validarCartao(cartao, valor));
		 } catch(Exception e){
		 out.print(e.getMessage());
		 }		
	}

}
