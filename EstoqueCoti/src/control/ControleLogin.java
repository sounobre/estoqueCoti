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
import model.MovimentacaoEstoque;
import persistence.FuncionarioDao;
import persistence.LoginDao;

/**
 * Servlet implementation class ControleLogin
 */
@WebServlet({"/ControleLogin","/template/login.jsp", "/template/logout.html","/template/estoqueEmBaixa.html"})
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

public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
				
				String url = request.getServletPath();
				
				if(url.equalsIgnoreCase("/template/login.jsp")){
					String login = request.getParameter("login");
					String senha = request.getParameter("senha");
					
				if(new LoginDao().logar(login, senha).booleanValue() == true){
					Funcionario func = new LoginDao().buscarUsuario(login);
					
					HttpSession session = request.getSession();
					
					session.setAttribute("login", login);
					session.setAttribute("nomeP", func.getNome());
					
				
										
				if(new LoginDao().verificaMinimo().size() > 0) {
						request.setAttribute("bol", "<section class='panel' id='abaixoEstoque'> "
                 + "  <div class='panel-heading' style='font-size: large; text-align: center; color: red'>"
                 + "  <a href = '/EstoqueCoti/template/estoqueEmBaixa.html'> Existem itens com quantidade abaixo do limite permitido no estoque!</a> "
                 + "  </div>   "
				+ "	</section>");
						request.getRequestDispatcher("/template/indCadastro.jsp").forward(request, response);
					}
					
				
					
											
					
					
				}else{
					request.setAttribute("msg", "<div class = 'alert alert-info'>"+ "Email ou senha Incorretos!"+"</div>");
					request.getRequestDispatcher("index.jsp").forward(request, response);
				}
					
				}else if(url.equalsIgnoreCase("/template/logout.html")){
					HttpSession session = request.getSession();
					
					session.removeAttribute("nomeP");
					session.removeAttribute("login");
					session.invalidate();
					
					response.sendRedirect( request.getContextPath() + "/");
				}else if(url.equalsIgnoreCase("/template/login.jsp")){
										
					response.sendRedirect("/template/login.jsp");
					
				} else if(url.equalsIgnoreCase("/template/estoqueEmBaixa.html")){
					estoqueEmBaixa(request, response);
				}
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}

public void estoqueEmBaixa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	try{
		
		List<MovimentacaoEstoque> lista =  new LoginDao().verificaMinimo();
		request.setAttribute("lista", lista);
		request.getRequestDispatcher("/template/estoqueEmBaixa.jsp").forward(request, response);
		
	}catch(Exception e){
		e.printStackTrace();
	}
	
	
	
}

}
