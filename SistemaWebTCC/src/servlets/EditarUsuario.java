package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.sistemaWebTCC.entity.Usuario;
import br.com.sistemaWebTCC.jdbc.UsuarioDAO;

/**
 * Servlet implementation class CadastroServlet
 */
public class EditarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditarUsuario() {
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
		String usuario = request.getParameter("usuario");
		String senha = request.getParameter("senha");		
		String nome = request.getParameter("nome");
		int id = Integer.parseInt(request.getParameter("id"));
		//int alimentadorID = Integer.parseInt(request.getParameter("alimentadorID"));
		
		//monta um objeto
		Usuario usuarioObj = new Usuario();
		//usuarioObj.setUsuarioID(usuarioID);
		usuarioObj.setUsuario(usuario);	
		usuarioObj.setSenha(senha);
		usuarioObj.setNome(nome);
		usuarioObj.setUsuarioID(id);
		//usuarioObj.setAlimentadorID(alimentadorID);
		
		//Salva o contato
		UsuarioDAO dao = null;
		try {
			dao = new UsuarioDAO();
			dao.editarUsuario(usuarioObj);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect(request.getContextPath()+"/resources/sistema.html");			

	}

}
