package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Local;
import persistence.LocalDao;

/**
 * Servlet implementation class ControleLocal
 */
@WebServlet({"/ControleLocal","/template/cadastroLocal.html"})
public class ControleLocal extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControleLocal() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		execute(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		execute(request, response);
	}
	
protected void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			try{
				
				String url = request.getContextPath();
				
				if(url.equalsIgnoreCase("/template/cadastrarLocal.html")){
					cadastro(request, response);
				}
				
			}catch(Exception e){
				e.printStackTrace();
			}
	}

protected void cadastro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			
			String id = request.getParameter("lId");
			String localNovo = request.getParameter("nomeDoNovoLocal");
			String localExistente = request.getParameter("nomeDoLocalExistente");
			String codLocal = request.getParameter("codDoLocal");
			String descLocal = request.getParameter("descDoLocal");
			String corredorNovo = request.getParameter("nomeDoNovoCorredor");
			String corredorExistente = request.getParameter("nomeDoCorredorExistente");
			String codCorredor = request.getParameter("codDoCorredor");
			String descCorredor = request.getParameter("descDoCorredor");
			String prateleiraNova = request.getParameter("nomeDaNovaPrateleira");
			String prateleiraExistente = request.getParameter("nomeDaPrateleiraExistente");
			String codPrateleira = request.getParameter("codDaPrateleira");
			String descprateleira = request.getParameter("descDaPrateleira");
			
			String q = "SELECT L.lNome, L.cNome, L.pNome FROM Local WHERE L.lNome = "+ localNovo + " AND L.cNome = "+ corredorNovo +" AND L.pNome = "+ prateleiraNova;
			
			if(new LocalDao().validarDuoplicidadeDeLocal(q).isEmpty()){
				Local l = new Local();
				
				
			}
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
}

}
