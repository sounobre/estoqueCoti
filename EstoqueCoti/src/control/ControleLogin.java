package control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.firebirdsql.jdbc.parser.JaybirdSqlParser.function_return;

import model.Funcionario;
import persistence.FuncionarioDao;
import persistence.LoginDao;

/**
 * Servlet implementation class ControleLogin
 */
@WebServlet({"/ControleLogin","/Logar", "/template/logout.html"})
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
				
				if(url.equalsIgnoreCase("/Logar")){
					String login = request.getParameter("login");
					String senha = request.getParameter("senha");
					
				if(new LoginDao().logar(login, senha).booleanValue() == true){
					Funcionario func = new LoginDao().buscarUsuario(login);
					
					HttpSession session = request.getSession();
					
					session.setAttribute("login", login);
					session.setAttribute("nomeP", func.getNome());
					
					response.sendRedirect("template/indCadastro.jsp");
				}else{
					request.setAttribute("msg", "<div class = 'alert alert-info'>"+ "Email ou senha Incorretos!"+"</div>");
					request.getRequestDispatcher("../index.jsp").forward(request, response);
				}
					
				}else if(url.equalsIgnoreCase("/template/logout.html")){
					HttpSession session = request.getSession();
					
					session.removeAttribute("nomeP");
					session.removeAttribute("login");
					session.invalidate();
					
					response.sendRedirect( request.getContextPath() + "/");
				}
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
