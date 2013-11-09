package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.sistemaWebTCC.entity.Configuracao;
import br.com.sistemaWebTCC.jdbc.ConfiguracaoDAO;

/**
 * Servlet implementation class ConfigServlet
 */
public class ConfigServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConfigServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// buscando os parâmetros no request
		String hora1 = request.getParameter("hora1");
		String hora2 = request.getParameter("hora2");
		String hora3 = request.getParameter("hora3");
		String hora4 = request.getParameter("hora4");
		String qtsRacao = request.getParameter("qtdRacao");
		

		// monta um objeto
		Configuracao config = new Configuracao();
		// usuarioObj.setUsuarioID(usuarioID);
		config.setHora1(hora1);
		config.setHora2(hora1);
		config.setHora3(hora1);
		config.setHora4(hora1);
		config.setQtdGramas(qtsRacao);

		// Salva o contato
		ConfiguracaoDAO dao = null;
		try {
			dao = new ConfiguracaoDAO();
			dao.cadastraConfiguracao(config);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//dao.cadastraConfiguracao(config);
		response.sendRedirect(request.getContextPath() + "/resources/sistema.html");
	}

}
