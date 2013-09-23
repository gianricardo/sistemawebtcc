package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.sistemaWebTCC.entity.Usuario;
import br.com.sistemaWebTCC.jdbc.UsuarioDAO;

import com.google.gson.Gson;

/**
 * Servlet implementation class CadastroServlet
 */
public class ConsultarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConsultarUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}
	
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		UsuarioDAO dao;
		try {
			dao = new UsuarioDAO();
			Usuario usuario = dao.consultarUsuario(Integer.parseInt(request.getSession().getAttribute("id").toString()));

			String json = new Gson().toJson(usuario);
			//Padrão de devolução dos dados Json{"id":1, "nome":"dieison", "adm":1}
		    response.setContentType("application/json");
		    response.setCharacterEncoding("UTF-8");
		    try {
				response.getWriter().write(json);
			} catch (IOException e) {
				e.printStackTrace();
			}
		    
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
