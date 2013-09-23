package servlets;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

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
		/*Timestamp hora1 = request.getParameter("hora1");
		Timestamp hora2 = request.getParameter("hora2");
		Timestamp hora3 = request.getParameter("hora3");
		Timestamp hora4 = request.getParameter("hora4");
		Timestamp horaExemplo = new Timestamp(new Date("00 00 0000 12 00 00").getTime());
		
		
		//1 é quantidade de ração nos horários programados
		int qtsRacao = request.getParameter("1");
		

		// monta um objeto
		Configuracao config = new Configuracao();
		// usuarioObj.setUsuarioID(usuarioID);
		config.setHora1(hora1);
		config.setHora2(hora1);
		config.setHora3(hora1);
		config.setHora4(hora1);
		config.setQtdGramas(qtsRacao);
*/
		// Salva o contato
		ConfiguracaoDAO dao = null;
		try {
			dao = new ConfiguracaoDAO();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//dao.cadastraConfiguracao(config);
		response.sendRedirect(request.getContextPath() + "/resources/sistema.html");
	}

}
