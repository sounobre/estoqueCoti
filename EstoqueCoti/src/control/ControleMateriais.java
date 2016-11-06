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

import model.Categoria;
import model.Materiais;
import persistence.CategoriaDao;
import persistence.MateriaisDao;

/**
 * Servlet implementation class ControleMateriais
 */
@WebServlet({ "/ControleMateriais", "/template/buscar.html", "/template/cadastrar.html", "/template/remover.html" })
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
			/* String categoria = request.getParameter("categoria"); */
			String preco = request.getParameter("preco");
			/* String outros = request.getParameter("catOutros"); */

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
			String descCategoria = request.getParameter("categoria");
			List<Categoria> listarCategoria2 = new ArrayList<Categoria>();
			listarCategoria2 = new CategoriaDao().listar();

			for (int a = 0; a <= listarCategoria2.size() - 1; a++) {
				if (listarCategoria2.get(a).getCategoria().equalsIgnoreCase(descCategoria)) {
					System.out.println("contem");
					categoria.setCategoria(listarCategoria2.get(a).getCategoria());
					categoria.setDescricao(listarCategoria2.get(a).getDescricao());
					categoria.setId_categoria(listarCategoria2.get(a).getId_categoria());

					mat.setCategoria(categoria);

				} else {
					System.out.println(" n�o contem");
				}

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
			if (selectPesquisa.equalsIgnoreCase("codigo")) {
				query = "SELECT M FROM Materiais AS M WHERE M.codigo = '" + campoPesquisa + "'";
				lista = new MateriaisDao().pesquisar(query);
			} else {
				MateriaisDao md = new MateriaisDao();

				lista = md.listar();

				if (lista.size() == 0) {
					System.out.println("NADA");
				} else {
					System.out.println(lista.size());
					System.out.println(lista);
				}
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
}
