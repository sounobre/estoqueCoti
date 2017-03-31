package control;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MovimentacaoEstoque;
import persistence.MovimentacaoDao;


@WebServlet({"/ControleMovEstoque","/template/buscaMaterialExist.html","/template/cadEntradaEstq.html"})
public class ControleMovEstoque extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ControleMovEstoque() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		execute(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		execute(request, response);
	}
	
protected void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			try{
				
				String url = request.getServletPath();
				
				if(url.equalsIgnoreCase("/template/buscaMaterialExist.html")){
					buscar(request, response);
				}
				else if (url.equalsIgnoreCase("/template/cadEntradaEstq.html")){
					verificaExistencia(request, response);
				}
				
				
				
			}catch(Exception e){
				e.printStackTrace();
			}
	
	}

protected void buscar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	try{
		
		String tipoPesquisa = request.getParameter("selectPesquisaForn");
		String palavraPesquisa = request.getParameter("campoPesquisaForn");
		String query = "";
		
		if(tipoPesquisa.equalsIgnoreCase("todos")){
			query = "select M.nome, M.codigo, C.categoria from Materiais M  "
					+ " inner join M.categoria as C";
			List<MovimentacaoEstoque> listaDeMateriais = new MovimentacaoDao().buscar();
			request.setAttribute("listaDeMateriais", listaDeMateriais);
			request.getRequestDispatcher("entradaEstoque.jsp").forward(request, response);
		}
		
	}catch(Exception e){
			e.printStackTrace();
		}
}

protected void verificaExistencia(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			
			String codigo = request.getParameter("codigo");
			String query = "select M from MovimentacaoEstoque M where M.codigo = " + codigo;
			
			if (new MovimentacaoDao().existCadastrado(query).isEmpty()){
				request.setAttribute("modalEntrada", "<Strong>Este produto não está cadastrado no estoque</strong>");
			}
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
}

}
