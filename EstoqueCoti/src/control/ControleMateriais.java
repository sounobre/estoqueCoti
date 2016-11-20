package control;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.ref.ReferenceQueue;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.firebirdsql.jdbc.parser.JaybirdSqlParser.extractFunction_return;

import model.Categoria;
import model.Materiais;
import persistence.CategoriaDao;
import persistence.MateriaisDao;

/**
 * Servlet implementation class ControleMateriais
 */
@WebServlet({ "/ControleMateriais", "/template/buscar.html", "/template/cadastrar.html", "/template/remover.html", "/template/alterar.html" })
public class ControleMateriais extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
		
	public ControleMateriais() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		execute(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		execute(request, response);
	}

	protected void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = request.getServletPath();

		try {

			if (url.equalsIgnoreCase("/template/buscar.html")) {
				buscar(request, response);
			} else if (url.equalsIgnoreCase("/template/cadastrar.html")) {
				cadastrar(request, response);
			} else if (url.equalsIgnoreCase("/template/remover.html")) {
				remover(request, response);
			}else if (url.equalsIgnoreCase("/template/alterar.html")) {
				alterar(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	protected void cadastrar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {

			String codigo = request.getParameter("codigo");
			String nome = request.getParameter("nome");
			String descricao = request.getParameter("descricao");
			String medida = request.getParameter("unimed");
			String fornecedor = request.getParameter("fornecedor");
			String qtd_Min = request.getParameter("qtd_Min");
			String qtd_Max = request.getParameter("qtd_Max");
			String estoque = request.getParameter("estoque");
			String preco = request.getParameter("preco");
			

			Materiais mat = new Materiais();
			List<Materiais> lm = new ArrayList<Materiais>();

			mat.setCodigo(codigo);
			mat.setDescricao(descricao);
			mat.setEstoque(new Double(estoque));
			mat.setFornecedor(fornecedor);
			mat.setMedida(medida);
			mat.setNome(nome);
			mat.setPreco(new Double(preco));
			mat.setQtd_Max(new Double(qtd_Max));
			mat.setQtd_Min(new Double(qtd_Min));

			Categoria categoria = new Categoria();
			String nomeCategoria = request.getParameter("categoria");
			String outrosNomeCategoria = request.getParameter("catOutrosNome");
			String outrosDescCategoria = request.getParameter("catOutrosDescricao");
			

			 if(nomeCategoria.equalsIgnoreCase("outros")){
					categoria.setCategoria(outrosNomeCategoria);
					categoria.setDescricao(outrosDescCategoria);
					categoria.setId_categoria(null);
					new CategoriaDao().cadastrar(categoria);
				}
				

			

			MateriaisDao md = new MateriaisDao();
			md.cadastrar(mat);

			request.setAttribute("msg", "Cadastro efetuado com sucesso!");
			request.getRequestDispatcher("/template/cadastro.jsp").forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void buscar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Materiais> lista = new ArrayList<Materiais>();
		String selectPesquisa = request.getParameter("selectPesquisaMat");
		String campoPesquisa = request.getParameter("campoPesquisaMat");
		String query;

		try {
			if(campoPesquisa.isEmpty()){
				MateriaisDao md = new MateriaisDao();

				lista = md.listar();
			}else if (selectPesquisa.equalsIgnoreCase("codigo")) {
				query = "SELECT M FROM Materiais AS M WHERE M.codigo = '" + campoPesquisa + "'";
				lista = new MateriaisDao().pesquisar(query);
			} else if(selectPesquisa.equalsIgnoreCase("nome")){
				query = "SELECT M FROM Materiais AS M WHERE M.nome = '" + campoPesquisa + "'";
				lista = new MateriaisDao().pesquisar(query);
			}else if(selectPesquisa.equalsIgnoreCase("medida")){
				query = "SELECT M FROM Materiais AS M WHERE M.medida = '" + campoPesquisa + "'";
				lista = new MateriaisDao().pesquisar(query);
			}else if(selectPesquisa.equalsIgnoreCase("fornecedor")){
				query = "SELECT M FROM Materiais AS M WHERE M.fornecedor = '" + campoPesquisa + "'";
				lista = new MateriaisDao().pesquisar(query);
			}else if(selectPesquisa.equalsIgnoreCase("categoria")){
				query = "SELECT M FROM Materiais M "
						+ " INNER JOIN M.categoria C WHERE C.categoria = '" + campoPesquisa + "'";
				lista = new MateriaisDao().pesquisar(query);
			}

			request.setAttribute("lista", lista);

			request.getRequestDispatcher("cadastro.jsp").forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	List<Categoria> listarCategoria;

	public List<Categoria> getListarCategoria() {
		try {

			listarCategoria = new CategoriaDao().listar();

			if (listarCategoria.size() < 1) {
				new CategoriaDao().cadastrarOutros();
				listarCategoria = new CategoriaDao().listar();
			} else {
				listarCategoria = new CategoriaDao().listar();

			}

			System.out.println(listarCategoria);

		} catch (Exception e) {

		}
		return listarCategoria;
	}

	public void setListarCategoria(List<Categoria> listarCategoria) {
		this.listarCategoria = listarCategoria;
	}

	protected void remover(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Materiais mat = new Materiais();
		
		String id_material =  request.getParameter("id_material");
		
		try{
			
		
		mat.setId_material(new Integer(id_material));
		
		new MateriaisDao().remover(mat);
		
		request.getRequestDispatcher("cadastro.jsp").forward(request, response);
		
	}catch(Exception e){
		e.printStackTrace();
	}
	}
	
	protected void alterar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	//retorno materiais	
		Materiais mat = new Materiais();	
			String id = request.getParameter("id");
			String codigo = request.getParameter("codigo");
			String nome   = request.getParameter("nome");
			String descricao = request.getParameter("descricao");
			String medida = request.getParameter("unimed");
			String fornecedor = request.getParameter("fornecedor");
			String qtd_Min = request.getParameter("qtd_Min");
			String qtd_Max = request.getParameter("qtd_Max");
			String estoque = request.getParameter("estoque");
			String preco = request.getParameter("preco");
		
			PrintWriter out = response.getWriter();
			
			String q = "SELECT M FROM Materiais AS M WHERE M.id_material = " + id;
			
			try{
				
			List<Materiais>	listaAlt = new MateriaisDao().pesquisar(q);
			
			
			
			// retorno Categoria
					Categoria cat = new Categoria();
						String categoria = request.getParameter("categoria");
						Integer idCategoria;
						String descCategoria;
						
						String outrosNomeCategoriaAlt = request.getParameter("catOutrosNomeAlt");
						String outrosDescCategoriaAlt = request.getParameter("catOutrosDescricaoAlt");
						
						if(categoria == null){
							categoria = listaAlt.get(0).getCategoria().getCategoria();
							idCategoria =  listaAlt.get(0).getCategoria().getId_categoria();
							descCategoria = listaAlt.get(0).getCategoria().getDescricao();
							
							cat.setCategoria(categoria);
							cat.setId_categoria(idCategoria);
							cat.setDescricao(descCategoria);
						}else if(categoria.equalsIgnoreCase("outros")){
							cat.setCategoria(outrosNomeCategoriaAlt);
							cat.setDescricao(outrosDescCategoriaAlt);
							cat.setId_categoria(null);
							new CategoriaDao().cadastrar(cat);
						}
							
				
					mat.setId_material(new Integer(id));
					mat.setCodigo(codigo);
					mat.setCategoria(cat);
					mat.setDescricao(descricao);
					mat.setEstoque(new Double(estoque));
					mat.setFornecedor(fornecedor);
					mat.setMedida(medida);
					mat.setNome(nome);
					mat.setPreco(new Double(preco));
					mat.setQtd_Max(new Double(qtd_Max));
					mat.setQtd_Min(new Double(qtd_Min));			
					
 				new MateriaisDao().alterar(mat);
				
				
			
			request.setAttribute("msg", "Alteração efetuada com sucesso!");	
			request.getRequestDispatcher("cadastro.jsp").forward(request, response);	
				
			}catch(Exception e){
				e.printStackTrace();
			}
	}
}
