package control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import model.MovimentacaoEstoque;
import persistence.MovimentacaoDao;


@WebServlet(name = "/ControleMovEstoque", urlPatterns = {"/ControleMovEstoque","/template/buscaMaterialExist.html","/template/cadEntradaEstq.html"})
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
				String Controller = request.getParameter("controller");
				if(Controller != null){
					url = Controller;
				}
				 String codigo = request.getParameter("codigoteste");
				 String categoria = request.getParameter("categoria");
				 String nome = request.getParameter("nome");
				 String qtdEntrada = request.getParameter("qtdEntrada");
				 String local = request.getParameter("descricao");
				 String qtdMinima = request.getParameter("descricao");
				 String qtdMaxima = request.getParameter("descricao");
				
				if(url.equalsIgnoreCase("/template/buscaMaterialExist.html")){
					buscar(request, response);
				}
				else if (url.equalsIgnoreCase("/ControleMovEstoque")){
					verificaExistencia(request, response);
				
				}else if (url.equalsIgnoreCase("entrada")){
					cadastrarEntrada(request, response);
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
			String codigo = request.getParameter("codigoTeste");
			String query = "select M from MovimentacaoEstoque M where M.codigo = " + codigo;
			List<MovimentacaoEstoque> listamovestoque = new MovimentacaoDao().existCadastrado(query);
			String retorno = "";
		    if (listamovestoque.isEmpty()){
		      retorno = "Produto não cadastrado";
		    } else{
		      retorno = "ok";
		    }   
			
			
			JsonElement j = new Gson().toJsonTree(listamovestoque); 
			
			String json = j.toString(); 
			
			System.out.println(json);
			
			response.getWriter().print(json);
					
		}catch(Exception e){
			e.printStackTrace();
		}
}

protected void cadastrarEntrada(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	try{
		 
		 
		 String codigo = request.getParameter("codigoteste");
		 String categoria = request.getParameter("categoria");
		 String nome = request.getParameter("nome");
		 String qtdEntrada = request.getParameter("qtdEntrada");
		 String local = request.getParameter("descricao");
		 String qtdMinima = request.getParameter("descricao");
		 String qtdMaxima = request.getParameter("descricao");
		 
		 MovimentacaoEstoque mv = new MovimentacaoEstoque();
		 HttpSession session = request.getSession(); //resgata usuário logado
		 
		 Integer emEstoque = new MovimentacaoDao().qtdEstoque(codigo);
		 Integer entrando = new Integer (qtdEntrada);
		 String estoqueAtualizado = Integer.toString(emEstoque + entrando);
		 
		 mv.setLoginMov((String) session.getAttribute("nomeP"));
		 mv.setTipo("Entrada");
		 mv.setData(new Date());
		 
		 mv.setCodigo(codigo);
		 mv.setCategoria(categoria);
		 mv.setLocal(local);
		 mv.setNome(nome);
		 mv.setQtdEstoque(estoqueAtualizado);
		 mv.setQtdMin(qtdMinima);
		 mv.setQtdMax(qtdMaxima);
		 
		 new MovimentacaoDao().cadastrarEntrada(mv);
		 
		 request.getRequestDispatcher("/template/cadEntradaEstq.html").forward(request, response);
		
		
		
	}catch(Exception e){
		e.printStackTrace();
	}
	
}






























}
