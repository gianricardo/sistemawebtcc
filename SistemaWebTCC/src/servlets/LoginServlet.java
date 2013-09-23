package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.sistemaWebTCC.entity.Usuario;
import br.com.sistemaWebTCC.jdbc.*;


/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			process(request, response);
		} catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			process(request, response);
		} catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		String usuario = request.getParameter("usuario");
		String senha = request.getParameter("senha");
		UsuarioDAO dao = new UsuarioDAO();
		Usuario usuarioValido = dao.validaUsuario(usuario, senha);
		
		//comunicacao com o banco de dados
		if(usuarioValido != null){
			request.getSession().setAttribute("usuario", usuarioValido.getUsuario());
			request.getSession().setAttribute("id", usuarioValido.getUsuarioID());
			request.getSession().setAttribute("usuarioAdm", usuarioValido.getAdm());
			response.sendRedirect(request.getContextPath()+"/resources/sistema.html");
		}else{
			response.sendRedirect(request.getContextPath()+"/index.html");
		}
	}

}
