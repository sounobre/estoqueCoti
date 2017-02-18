package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import persistence.LoginDao;

/**
 * Servlet implementation class ControleLogin
 */
@WebServlet({"/ControleLogin", "/inicio.html"})
public class ControleLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControleLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		execute(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		execute(request, response);
	}

protected void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			
				String url = request.getServletPath();
				
				if(url.equalsIgnoreCase("/inicio.html")){
					String login = request.getParameter("login");
					String senha = request.getParameter("senha");
					
				if(new LoginDao().logar(login, senha).booleanValue() == true){
					
				}
				}
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
