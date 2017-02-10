package control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.firebirdsql.jdbc.parser.JaybirdSqlParser.extractFunction_return;

import model.Local;
import persistence.LocalDao;

/**
 * Servlet implementation class ControleLocal
 */
@WebServlet({"/ControleLocal","/template/cadastroLocal.html", "/template/buscarLocal.html","/template/alteraLocal.html"})
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
				
				String url = request.getServletPath();
				
				if(url.equalsIgnoreCase("/template/cadastroLocal.html")){
					cadastro(request, response);
				}else if(url.equalsIgnoreCase("/template/buscarLocal.html")){
					buscar(request, response);
				}else if(url.equalsIgnoreCase("/template/alteraLocal.html")){
					alterar(request, response);
				}
			}catch(Exception e){
				e.printStackTrace();
			}
	}

protected void cadastro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			
			//Integer id = new Integer(request.getParameter("lId"));
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
			
			String q = "SELECT L.lNome, L.cNome, L.pNome FROM Local L WHERE L.lNome = '"+ localNovo + "' AND L.cNome = '"+ corredorNovo +"' AND L.pNome = '"+ prateleiraNova+"'";
			
			if(new LocalDao().validarDuoplicidadeDeLocal(q).isEmpty()){
				Local lo = new Local();
				lo.setlId(null);
				lo.setlNome(localNovo);
				lo.setlCodigo(codLocal);
				lo.setLdescricao(descLocal);
				lo.setcNome(corredorNovo);
				lo.setcCodigo(codCorredor);
				lo.setcDescricao(descCorredor);
				lo.setpNome(prateleiraNova);
				lo.setpCodigo(codPrateleira);
				lo.setpDescricao(descprateleira);
				
				new LocalDao().cadastrar(lo);
				
				request.setAttribute("msg", "Local Cadastrado com Sucesso!");
				request.getRequestDispatcher("cadLocais.jsp").forward(request, response);
				
				
			}else{
				
							
				
				request.setAttribute("msg", "Local Já Cadastrado!");
				request.getRequestDispatcher("cadLocais.jsp").forward(request, response);
			}
			
			
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
}

protected void buscar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	try{
		String q = "select L from Local L";
		
		List<Local> listaLocal = new LocalDao().buscar(q);
		
		request.setAttribute("listaLocal", listaLocal);
		request.getRequestDispatcher("cadLocais.jsp").forward(request, response);
		
	}catch(Exception e){
		e.printStackTrace();
	}
	
	
}

protected void alterar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
			try{
				
				Integer id = new Integer(request.getParameter("Lid"));
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
				
				Local lo = new Local();
				lo.setlId(id);
				lo.setlNome(localNovo);
				lo.setlCodigo(codLocal);
				lo.setLdescricao(descLocal);
				lo.setcNome(corredorNovo);
				lo.setcCodigo(codCorredor);
				lo.setcDescricao(descCorredor);
				lo.setpNome(prateleiraNova);
				lo.setpCodigo(codPrateleira);
				lo.setpDescricao(descprateleira);
				
				new LocalDao().atualizar(lo);
				
				request.setAttribute("msg", "Local Atualizado com Sucesso!");
				request.getRequestDispatcher("cadLocais.jsp").forward(request, response);
				
				
			}catch(Exception e){
				e.printStackTrace();
			}
			
}
protected void remover(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	try{
		Integer id = new Integer(request.getParameter("lId"));
		
		Local l = new Local();
		l.setlId(id);
		new LocalDao().remover(l);
		
		request.setAttribute("msg", "Local removido com sucesso!");
		request.getRequestDispatcher("cadLocais.jsp").forward(request, response);
		
	}catch(Exception e){
		e.printStackTrace();
	}
}
}






























