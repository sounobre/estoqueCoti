package control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Categoria;
import persistence.CategoriaDao;


@WebServlet({"/ControleCategorias", "/template/cadastroCat.html","/template/buscaCat.html", "/template/excluirCat.html", "/template/alterarCat.html"})
public class ControleCategorias extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ControleCategorias() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		execute(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		execute(request, response);
	}
	
protected void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			String url = request.getServletPath();
			
			if(url.equalsIgnoreCase("/template/cadastroCat.html")){
				cadastrar(request,response);
			}else if(url.equalsIgnoreCase("/template/buscaCat.html")){
				buscar(request, response);
			}else if(url.equalsIgnoreCase("/template/excluirCat.html")){
				excluir(request, response);
			}else if(url.equalsIgnoreCase("/template/alterarCat.html")){
				alterar(request, response);
			}
		
	}

protected void cadastrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	try{
		String nomeCat = request.getParameter("nomeCatCadastro");
		String descCat = request.getParameter("descCatCadastro");
		
		Categoria categoria = new Categoria();
			
			categoria.setId_categoria(null);
			categoria.setCategoria(nomeCat);
			categoria.setDescricao(descCat);
			
			new CategoriaDao().cadastrar(categoria);
			
			request.setAttribute("msg", "Cadastro de categoria efetuado com sucesso!");
			request.getRequestDispatcher("/template/cadCategoria.jsp").forward(request, response);
			
	}catch(Exception e){
		e.printStackTrace();
	}
}

protected void buscar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
			try{
				
			List<Categoria>	listaCat = new CategoriaDao().listar();
			
			request.setAttribute("listaCat", listaCat);
			request.getRequestDispatcher("cadCategoria.jsp").forward(request, response);
				
			}catch(Exception e){
				e.printStackTrace();
			}
}

protected void excluir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
			try{
				Categoria categoria = new Categoria();
				String idCategoria = request.getParameter("idCategoria");
				
				categoria.setId_categoria(new Integer(idCategoria));
				
				new CategoriaDao().remover(categoria);
				
				request.setAttribute("msg", "Categoria removida com Sucesso");
				request.getRequestDispatcher("cadCategoria.jsp").forward(request, response);
				
			}catch(Exception e){
				e.printStackTrace();
			}
}

protected void alterar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
			try{
				
				String id = request.getParameter("id");
				String nome = request.getParameter("nomeCategoria");
				String descricao = request.getParameter("descricaoCategoria");
				
				Categoria categoria = new Categoria();
				
				categoria.setId_categoria(new Integer(id));
				categoria.setCategoria(nome);
				categoria.setDescricao(descricao);
				
				new CategoriaDao().alterarCat(categoria);
				
				request.setAttribute("msg", "Categoria Alterada com Sucesso");
				request.getRequestDispatcher("cadCategoria.jsp").forward(request, response);
				
			}catch(Exception e){
				e.printStackTrace();
			}
}

}






















