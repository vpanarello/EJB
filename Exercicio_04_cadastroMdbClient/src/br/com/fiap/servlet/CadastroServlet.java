

import java.io.IOException;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/livros")
public class CadastroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public CadastroServlet() {
        super();
        
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			InitialContext ctx = new InitialContext();
			LivrosBeanRemote service = (LivrosBeanRemote) ctx.lookup("ejb:/03_LivrosEJB/LivrosBean!br.com.fiap.bean.LivrosBeanRemote");
			
			List<Livros> lista = service.getAll();
			
			request.setAttribute("lista", lista);
			request.getRequestDispatcher("lista.jsp").forward(request, response);
			
			} catch (NamingException e) {
			e.printStackTrace();
		}
		
		
		
	
		// response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Livros livro =  new Livros();
		
		livro.setAutor(request.getParameter("autor"));
		livro.setTitulo(request.getParameter("titulo"));
		livro.setPreco(Double.parseDouble(request.getParameter("preco")));
		
		try {
			InitialContext ctx = new InitialContext();
			LivrosBeanRemote service = (LivrosBeanRemote) ctx.lookup("ejb:/03_LivrosEJB/LivrosBean!br.com.fiap.bean.LivrosBeanRemote");
			
			service.add(livro);
			
			request.setAttribute("ok", true);
			
			
			doGet(request, response);
			
			
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

}