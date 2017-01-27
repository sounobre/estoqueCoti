package control;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Funcionario;
import model.Pessoa;
import persistence.FuncionarioDao;


@WebServlet({"/ControleFuncionario", "/template/cadastroFuncionario.html","/template/buscaFuncionario.html", 
	"/template/excluirFuncionario.html", "/template/alteraFuncionario.html"})
public class ControleFuncionario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ControleFuncionario() {
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
		
		if(url.equalsIgnoreCase("/template/cadastroFuncionario.html")){
			cadastrar(request, response);
		}else if(url.equalsIgnoreCase("/template/buscaFuncionario.html")){
			buscar(request, response);
		}else if("/template/excluirFuncionario.html".equalsIgnoreCase(url)){
			excluir(request, response);
		}else if(url.equalsIgnoreCase("/template/alteraFuncionario.html")){
			alterar(request, response);
		}
	}

@SuppressWarnings("deprecation")
protected void cadastrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			try{
							
				String nome = request.getParameter("nomeFuncionario");
				String telefone = request.getParameter("telFuncionario");
				String endereco = request.getParameter("endFuncionario");
				String numeroDoEndereco = request.getParameter("numEndFuncionario");
				String cep = request.getParameter("cepFuncionario");
				String bairro = request.getParameter("bairroFuncionario");
				String cidade = request.getParameter("cidadeFuncionario");
				String estado = request.getParameter("estadoFuncionario");
				String email = request.getParameter("emailFuncionario");
				String perfil = request.getParameter("perfilDoFuncionario");
				String cargo = request.getParameter("cargoDoFuncionario");
				String salario = request.getParameter("salarioDoFuncionario");
				String setor =  request.getParameter("setordoFuncionario");
				String identidade = request.getParameter("identidadedoFuncionario");
				
				Funcionario f = new Funcionario();
				f.setBairro(bairro);
				f.setCep(cep);
				f.setCidade(cidade);
				f.setPerfil(perfil);
				f.setCargo(cargo);
				f.setEmail(email);
				f.setEndereco(endereco);
				f.setEstado(estado);
				f.setid(null);
				f.setSalario(salario);
				f.setNome(nome);
				f.setNumeroDoEndereco(numeroDoEndereco);
				f.setSetor(setor);
				f.setTelefone(telefone);
				f.setIdentidade(identidade);
				
				if(new FuncionarioDao().verificaIdentidade(identidade).size() > 0){
					request.setAttribute("msg", "Funcionario Já cadastrado");
					request.getRequestDispatcher("cadFuncionarios.jsp").forward(request, response);
				}else{
				
				new FuncionarioDao().cadadstro(f);
				
				request.setAttribute("msg", "Funcionario cadastrado com sucesso");
				request.getRequestDispatcher("cadFuncionarios.jsp").forward(request, response);
				}
				
			}catch(Exception e){
				e.printStackTrace();
			}
}

protected void buscar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	try{
		String select = request.getParameter("selectPesquisaForn");
		String dado = request.getParameter("campoPesquisaForn");
		String q; // query de pesquisa
		List<Funcionario> listaFuncionarios = new ArrayList<Funcionario>();
		
		if(select.equalsIgnoreCase("nome")){
			q = "SELECT F FROM Funcionario F where F.nome like '%"+ dado + "%'";
			listaFuncionarios = new FuncionarioDao().pesquisar(q);				
		
		}else if(select.equalsIgnoreCase("todos")){
			listaFuncionarios = new FuncionarioDao().listarFuncionarios();
		
		}else if(select.equalsIgnoreCase("perfil")){
			q = "SELECT F FROM Funcionario F where F.perfil like '%" + dado + "%'";
			listaFuncionarios =  new FuncionarioDao().pesquisar(q);
		
		}else if(select.equalsIgnoreCase("identidade")){
			q = "SELECT F FROM Funcionario F where F.identidade like '%" + dado + "%'";
			listaFuncionarios =  new FuncionarioDao().pesquisar(q);
		}
	


	
		request.setAttribute("listaFuncionarios", listaFuncionarios);
		request.getRequestDispatcher("cadFuncionarios.jsp").forward(request, response);
		
	}catch(Exception e){
		e.printStackTrace();
	}
}
protected void excluir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
	    Funcionario f = new Funcionario();
		String id = request.getParameter("id");
		
		f.setid(new Integer (id));
		
		new FuncionarioDao().excluir(f);
		
		request.setAttribute("msg", "Excluído com sucesso");
		request.getRequestDispatcher("cadFuncionarios.jsp").forward(request, response);
		
		}catch(Exception e ){
			e.printStackTrace();
		}
		
	
}
protected void alterar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			String nome = request.getParameter("nomeFuncionario");
			String telefone = request.getParameter("telDoFuncionario");
			String endereco = request.getParameter("endDoFuncionario");
			String numeroDoEndereco = request.getParameter("numEndDoFuncionario");
			String cep = request.getParameter("cepDoFuncionario");
			String bairro = request.getParameter("bairroDoFuncionario");
			String cidade = request.getParameter("cidadeDoFuncionario");
			String estado = request.getParameter("estadoDoFuncionario");
			String email = request.getParameter("emailDoFuncionario");
			String perfil = request.getParameter("perfilDoFuncionario");
			String cargo = request.getParameter("cargoDoFuncionario");
			String salario = request.getParameter("salarioDoFuncionario");
			String setor =  request.getParameter("setorDoFuncionario");
			String identidade = request.getParameter("identidadedoFuncionario");
			Integer id = new Integer (request.getParameter("id"));
			
			Funcionario f = new Funcionario();
			f.setBairro(bairro);
			f.setCep(cep);
			f.setCidade(cidade);
			f.setPerfil(perfil);
			f.setCargo(cargo);
			f.setEmail(email);
			f.setEndereco(endereco);
			f.setEstado(estado);
			f.setid(id);
			f.setSalario(salario);
			f.setNome(nome);
			f.setNumeroDoEndereco(numeroDoEndereco);
			f.setSetor(setor);
			f.setTelefone(telefone);
			f.setIdentidade(identidade);
		
			new FuncionarioDao().alterar(f);
			
			request.setAttribute("msg", "Funcionario alterado com sucesso");
			request.getRequestDispatcher("cadFuncionarios.jsp").forward(request, response);
			
		}catch(Exception e){
			e.printStackTrace();
		}
	
	
}

}
