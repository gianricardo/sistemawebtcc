package servlets;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

/**
 * Servlet implementation class VerificaAdm
 */
public class VerificaAdm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VerificaAdm() {
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
		String json = "";
		Map<String,String> usuarioAdm = new HashMap<>();
		if(request.getSession().getAttribute("usuarioAdm") != null){
			usuarioAdm.put("usuarioAdm", request.getSession().getAttribute("usuarioAdm").toString());	
		}else{
			usuarioAdm.put("usuarioAdm", "0");
		}
		json = new Gson().toJson(usuarioAdm);
	    response.setContentType("application/json");
	    response.setCharacterEncoding("UTF-8");
	    try {
			response.getWriter().write(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
