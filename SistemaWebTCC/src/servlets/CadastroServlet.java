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
public class CadastroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CadastroServlet() {
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
				
		//buscando os parâmetros no request
		//int usuarioID = Integer.parseInt(request.getParameter("usuarioID"));
		String usuario = request.getParameter("usuario");
		String senha = request.getParameter("senha");		
		String nome = request.getParameter("nome");
		//int alimentadorID = Integer.parseInt(request.getParameter("alimentadorID"));
		int adm=0;
		if(request.getParameter("adm").toString() == "on"){
			adm = 1;
		}
		
		//monta um objeto
		Usuario usuarioObj = new Usuario();
		//usuarioObj.setUsuarioID(usuarioID);
		usuarioObj.setUsuario(usuario);	
		usuarioObj.setSenha(senha);
		usuarioObj.setNome(nome);
		//usuarioObj.setAlimentadorID(alimentadorID);
		usuarioObj.setAdm(adm);
		
		//Salva o contato
		UsuarioDAO dao = null;
		try {
			dao = new UsuarioDAO();
			dao.cadastraUsuario(usuarioObj);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect(request.getContextPath()+"/resources/sistema.html");
	}

}
