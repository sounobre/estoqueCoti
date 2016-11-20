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


@WebServlet({"/ControleCategorias", "/template/cadastroCat.html","/template/buscaCat.html"})
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
			request.getRequestDispatcher("/template/cadastro.jsp").forward(request, response);
			
	}catch(Exception e){
		e.printStackTrace();
	}
}

protected void buscar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
			try{
				
			List<Categoria>	listaCat = new CategoriaDao().listar();
			
			request.setAttribute("listaCat", listaCat);
			request.getRequestDispatcher("cadastro.jsp#categoria").forward(request, response);
				
			}catch(Exception e){
				e.printStackTrace();
			}
}

}
