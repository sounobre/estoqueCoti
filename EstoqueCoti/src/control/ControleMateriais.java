package control;

import java.io.IOException;
import java.lang.ref.ReferenceQueue;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Materiais;
import persistence.MateriaisDao;

/**
 * Servlet implementation class ControleMateriais
 */
@WebServlet({"/ControleMateriais", "/template/buscar.html", "/template/cadastrar.html"})
public class ControleMateriais extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ControleMateriais() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		execute(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		execute(request, response);
	}
	
protected void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = request.getServletPath();
		
		try{
			
			if(url.equalsIgnoreCase("/template/buscar.html")){
				buscar(request, response);	
			}else if(url.equalsIgnoreCase("/template/cadastrar.html")){
				cadastrar(request,response);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

protected void cadastrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	try{
		
		String codigo = request.getParameter("codigo");
		String nome = request.getParameter("nome");
		String descricao = request.getParameter("descricao");
		String medida = request.getParameter("unimed");
		String fornecedor = request.getParameter("fornecedor");
		String qtd_Min = request.getParameter("qtd_Min");
		String qtd_Max = request.getParameter("qtd_Max");
		String estoque = request.getParameter("estoque");
		String categoria = request.getParameter("categoria");
		String preco = request.getParameter("preco");
		String outros = request.getParameter("catOutros");
		
		Materiais mat = new Materiais();
		
		if(outros != null){
			mat.setCategoria(outros);
		}else{
		mat.setCategoria(categoria);
		}
		mat.setCodigo(codigo);
		mat.setDescricao(descricao);
		mat.setEstoque(new Double (estoque));
		mat.setFornecedor(fornecedor);
		mat.setMedida(medida);
		mat.setNome(nome);
		mat.setPreco(new Double(preco));
		mat.setQtd_Max(new Double(qtd_Max));
		mat.setQtd_Min(new Double(qtd_Min));
		
		MateriaisDao md = new MateriaisDao();
		md.cadastrar(mat);
		
		request.setAttribute("msg", "Cadastro efetuado com sucesso!");
		request.getRequestDispatcher("/template/cadastro.jsp").forward(request, response);
		
	}catch(Exception e){
		e.printStackTrace();
	}
}

protected void buscar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			try{
				List<Materiais> lista = new ArrayList<Materiais>();
				MateriaisDao md = new MateriaisDao();
				
				lista = md.listar();
				
				if(lista.size() == 0){
					System.out.println("NADA");
				}else{
					System.out.println(lista.size());
					System.out.println(lista);
				}
				
				request.setAttribute("lista", lista);
				
				request.getRequestDispatcher("cadastro.jsp").forward(request, response);
					
				
			}catch(Exception e){
				e.printStackTrace();
			}
	
}

}
