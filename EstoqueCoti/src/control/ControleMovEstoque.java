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
import com.google.gson.JsonParser;

import model.HistoricoEstoque;
import model.MovimentacaoEstoque;
import persistence.MovimentacaoDao;


@WebServlet(name = "/ControleMovEstoque", urlPatterns = {"/ControleMovEstoque","/template/buscaMaterialExist.html","/template/cadEntradaEstq.html"})
public class ControleMovEstoque extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private Boolean cadastrado = false;
    
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
				 
				
				if(url.equalsIgnoreCase("/template/buscaMaterialExist.html")){
					buscar(request, response);
				}
				else if (url.equalsIgnoreCase("/ControleMovEstoque")){
					verificaExistencia(request, response);
				
				}else if (url.equalsIgnoreCase("entrada")){
					cadastrarEntrada(request, response);
					
				}else if (url.equalsIgnoreCase("saida")){
					cadastrarSaida(request, response);
				
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
			
		} else if(tipoPesquisa.equalsIgnoreCase("nome")){
			query = "select M.nome, M.codigo, C.categoria from Materiais M  "
					+ " inner join M.categoria as C"
					+ "where M.nome = " + palavraPesquisa;
			List<MovimentacaoEstoque> listaDeMateriais = new MovimentacaoDao().buscar();
			request.setAttribute("listaDeMateriais", listaDeMateriais);
			request.getRequestDispatcher("entradaEstoque.jsp").forward(request, response);
			
		}else if(tipoPesquisa.equalsIgnoreCase("codigo")){
			query = "select M.nome, M.codigo, C.categoria from Materiais M  "
					+ " inner join M.categoria as C"
					+ "where M.codigo = " + palavraPesquisa;
			List<MovimentacaoEstoque> listaDeMateriais = new MovimentacaoDao().buscar();
			request.setAttribute("listaDeMateriais", listaDeMateriais);
			request.getRequestDispatcher("entradaEstoque.jsp").forward(request, response);
			
		}else if(tipoPesquisa.equalsIgnoreCase("categoria")){
			query = "select M.nome, M.codigo, C.categoria from Materiais M  "
					+ " inner join M.categoria as C"
					+ "where M.codigo = " + palavraPesquisa;
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
			
		    if (listamovestoque.isEmpty()){
		      cadastrado = false;

		    //  JsonParser parser = new JsonParser();
		    //  JsonObject retorno = parser.parse("{\"retorno\" :\"ProdutoNaoCadastrado\"}").getAsJsonObject();
		     
        //      response.getWriter().print(retorno);
				
		    } else{
		      cadastrado = true;
		      
		      JsonElement j = new Gson().toJsonTree(listamovestoque); 
				
				String json = j.toString(); 
			//	JsonParser parser = new JsonParser();
			  //  JsonObject retorno = parser.parse(\"retorno\" :\"ProdutoCadastrado\").getAsJsonObject();
			//    String ret = retorno.toString();
			    
				response.getWriter().print(json);
		    }   
			
			
			
					
		}catch(Exception e){
			e.printStackTrace();
		}
}

protected void cadastrarEntrada(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	try{
		 
		 Integer id = new Integer (request.getParameter("id"));
		 String codigo = request.getParameter("codigo");
		 String categoria = request.getParameter("categoria");
		 String nome = request.getParameter("nome");
		 String qtdEntrada = request.getParameter("qtdEntrada");
		 String local = request.getParameter("local");
		 String qtdMinima = request.getParameter("qtdMinima");
		 String qtdMaxima = request.getParameter("qtdMaxima");
		 String qtdEstoque = request.getParameter("qtdEstoque");
		 
		 MovimentacaoEstoque mv = new MovimentacaoEstoque();
		 HttpSession session = request.getSession(); //resgata usuário logado
		 
		 Integer emEstoque = 0;
		 if(cadastrado){
		 emEstoque = new Integer (new MovimentacaoDao().qtdEstoque(codigo));
		 }else {
			 emEstoque = new Integer (qtdEstoque); 
		 }
		 Integer entrando = new Integer (qtdEntrada);
		 String estoqueAtualizado = Integer.toString(emEstoque + entrando);
		 
		 mv.setId(id);
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
		 
		 HistoricoEstoque he = new HistoricoEstoque();
		 he.setLoginMov((String) session.getAttribute("nomeP"));
		 he.setTipo("Entrada");
		 he.setData(new Date());
		 
		 he.setCodigo(codigo);
		 he.setCategoria(categoria);
		 he.setLocal(local);
		 he.setNome(nome);
		 he.setQtdEstoque(estoqueAtualizado);
		 he.setQtdMin(qtdMinima);
		 he.setQtdMax(qtdMaxima);
		 he.setQtdEntradaSaida(qtdEntrada);
		 
		 if(cadastrado){
			 new MovimentacaoDao().atualizarEntrada(mv);
			 new MovimentacaoDao().cadastrarEntradaHistorico(he);
		 }else{
		 new MovimentacaoDao().cadastrarEntrada(mv);
		 new MovimentacaoDao().cadastrarEntradaHistorico(he);
		 }
		 
		
		
		
	}catch(Exception e){
		e.printStackTrace();
	}
}
	protected void cadastrarSaida(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			 
			 Integer id = new Integer (request.getParameter("id"));
			 String codigo = request.getParameter("codigo");
			 String categoria = request.getParameter("categoria");
			 String nome = request.getParameter("nome");
			 String qtdEntrada = request.getParameter("qtdEntrada");
			 String local = request.getParameter("local");
			 String qtdMinima = request.getParameter("qtdMinima");
			 String qtdMaxima = request.getParameter("qtdMaxima");
			 String qtdEstoque = request.getParameter("qtdEstoque");
			 
			 MovimentacaoEstoque mv = new MovimentacaoEstoque();
			 HttpSession session = request.getSession(); //resgata usuário logado
			 
			 Integer emEstoque = 0;
			 if(cadastrado){
			 emEstoque = new Integer (new MovimentacaoDao().qtdEstoque(codigo));
			 }else {
				 emEstoque = new Integer (qtdEstoque); 
			 }
			 Integer entrando = new Integer (qtdEntrada);
			 String estoqueAtualizado = Integer.toString(emEstoque - entrando);
			 
			 mv.setId(id);
			 mv.setLoginMov((String) session.getAttribute("nomeP"));
			 mv.setTipo("Saida");
			 mv.setData(new Date());
			 
			 mv.setCodigo(codigo);
			 mv.setCategoria(categoria);
			 mv.setLocal(local);
			 mv.setNome(nome);
			 mv.setQtdEstoque(estoqueAtualizado);
			 mv.setQtdMin(qtdMinima);
			 mv.setQtdMax(qtdMaxima);
			 
			 HistoricoEstoque he = new HistoricoEstoque();
			 he.setLoginMov((String) session.getAttribute("nomeP"));
			 he.setTipo("Saida");
			 he.setData(new Date());
			 
			 he.setCodigo(codigo);
			 he.setCategoria(categoria);
			 he.setLocal(local);
			 he.setNome(nome);
			 he.setQtdEstoque(estoqueAtualizado);
			 he.setQtdMin(qtdMinima);
			 he.setQtdMax(qtdMaxima);
			 he.setQtdEntradaSaida(qtdEntrada);
			 
			 if(cadastrado){
				 new MovimentacaoDao().atualizarEntrada(mv);
				 new MovimentacaoDao().cadastrarEntradaHistorico(he);
			 }else{
			 new MovimentacaoDao().cadastrarEntrada(mv);
			 new MovimentacaoDao().cadastrarEntradaHistorico(he);
			 }
			 
			
			
			
		}catch(Exception e){
			e.printStackTrace();
		}

	
	
}






























}
