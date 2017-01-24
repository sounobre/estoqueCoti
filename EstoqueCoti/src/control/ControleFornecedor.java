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

import model.Fornecedor;
import model.Pessoa;
import persistence.FornecedorDao;


@WebServlet({"/ControleFornecedor", "/template/cadastroFornecedor.html","/template/buscaFornecedor.html", 
	"/template/excluirForn.html", "/template/alteraFornecedor.html"})
public class ControleFornecedor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ControleFornecedor() {
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
		
		if(url.equalsIgnoreCase("/template/cadastroFornecedor.html")){
			cadastrar(request, response);
		}else if(url.equalsIgnoreCase("/template/buscaFornecedor.html")){
			buscar(request, response);
		}else if("/template/excluirForn.html".equalsIgnoreCase(url)){
			excluir(request, response);
		}else if(url.equalsIgnoreCase("/template/alteraFornecedor.html")){
			alterar(request, response);
		}
	}

@SuppressWarnings("deprecation")
protected void cadastrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			try{
							
				String nome = request.getParameter("nomeFornecedor");
				String telefone = request.getParameter("telFornecedor");
				String endereco = request.getParameter("endFornecedor");
				String numeroDoEndereco = request.getParameter("numEndFornecedor");
				String cep = request.getParameter("cepFornecedor");
				String bairro = request.getParameter("bairroFornecedor");
				String cidade = request.getParameter("cidadeFornecedor");
				String estado = request.getParameter("estadoFornecedor");
				String email = request.getParameter("emailFornecedor");
				Integer codigo = new Integer (request.getParameter("codFornecedor"));
				String pessoaContato = request.getParameter("nomeDoContatoFornecedor");
				String cnpj = request.getParameter("cnpjFornecedor");
				String inicioAtividades =  request.getParameter("inicioAtividadesFornecedor");
				
				String[] data = inicioAtividades.split("/");
				
				Calendar cal = Calendar.getInstance();
				
				cal.set(new Integer(data[2]), new Integer(data[1]) - 1, new Integer(data[0]));
				
				
				
				
				
				Fornecedor f = new Fornecedor();
				f.setBairro(bairro);
				f.setCep(cep);
				f.setCidade(cidade);
				f.setCnpj(cnpj);
				f.setCodigo(codigo);
				f.setEmail(email);
				f.setEndereco(endereco);
				f.setEstado(estado);
				f.setid(null);
				f.setInicioAtividades(cal.getTime());
				f.setNome(nome);
				f.setNumeroDoEndereco(numeroDoEndereco);
				f.setPessoaContato(pessoaContato);
				f.setTelefone(telefone);
				
				if(new FornecedorDao().verificaCNPJ(cnpj).size() > 0){
					request.setAttribute("msg", "Fornecedor Já cadastrado");
					request.getRequestDispatcher("cadFornecedores.jsp").forward(request, response);
				}else{
				
				new FornecedorDao().cadadstro(f);
				
				request.setAttribute("msg", "Fornecedor cadastrado com sucesso");
				request.getRequestDispatcher("cadFornecedores.jsp").forward(request, response);
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
		List<Fornecedor> listaFornecedores = new ArrayList<Fornecedor>();
		
		if(select.equalsIgnoreCase("nome")){
			q = "SELECT F FROM Fornecedor F where F.nome like '%"+ dado + "%'";
			listaFornecedores = new FornecedorDao().pesquisar(q);				
		
		}else if(select.equalsIgnoreCase("todos")){
			listaFornecedores = new FornecedorDao().listarFornecedores();
		
		}else if(select.equalsIgnoreCase("codigo")){
			q = "SELECT F FROM Fornecedor F where F.codigo like '%" + dado + "%'";
			listaFornecedores =  new FornecedorDao().pesquisar(q);
		
		}else if(select.equalsIgnoreCase("cnpj")){
			q = "SELECT F FROM Fornecedor F where F.cnpj like '%" + dado + "%'";
			listaFornecedores =  new FornecedorDao().pesquisar(q);
		}
	


	
		request.setAttribute("listaFornecedores", listaFornecedores);
		request.getRequestDispatcher("cadFornecedores.jsp").forward(request, response);
		
	}catch(Exception e){
		e.printStackTrace();
	}
}
protected void excluir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
	    Fornecedor f = new Fornecedor();
		String id = request.getParameter("id");
		
		f.setid(new Integer (id));
		
		new FornecedorDao().excluir(f);
		
		request.setAttribute("msg", "Excluído com sucesso");
		request.getRequestDispatcher("cadFornecedores.jsp").forward(request, response);
		
		}catch(Exception e ){
			e.printStackTrace();
		}
		
	
}
protected void alterar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			Integer id = new Integer(request.getParameter("id"));
			String nome = request.getParameter("nomeFornecedor");
			String telefone = request.getParameter("telFornecedor");
			String endereco = request.getParameter("endFornecedor");
			String numeroDoEndereco = request.getParameter("numEndFornecedor");
			String cep = request.getParameter("cepFornecedor");
			String bairro = request.getParameter("bairroFornecedor");
			String cidade = request.getParameter("cidadeFornecedor");
			String estado = request.getParameter("estadoFornecedor");
			String email = request.getParameter("emailFornecedor");
			Integer codigo = new Integer (request.getParameter("codFornecedor"));
			String pessoaContato = request.getParameter("nomeDoContatoFornecedor");
			String cnpj = request.getParameter("cnpjFornecedor");
			String inicioAtividades =  request.getParameter("inicioAtividadesFornecedor");
			
			String[] data = inicioAtividades.split("/");
			
			Calendar cal = Calendar.getInstance();
			
			cal.set(new Integer(data[2]), new Integer(data[1]) - 1, new Integer(data[0]));
				
			
			Fornecedor f = new Fornecedor();
			f.setid(id);
			f.setBairro(bairro);
			f.setCep(cep);
			f.setCidade(cidade);
			f.setCnpj(cnpj);
			f.setCodigo(codigo);
			f.setEmail(email);
			f.setEndereco(endereco);
			f.setEstado(estado);
			f.setInicioAtividades(cal.getTime());
			f.setNome(nome);
			f.setNumeroDoEndereco(numeroDoEndereco);
			f.setPessoaContato(pessoaContato);
			f.setTelefone(telefone);
			
			 
			
			new FornecedorDao().alterar(f);
			
			
			
			request.setAttribute("msg", "Fornecedor alterado com sucesso");
			request.getRequestDispatcher("cadFornecedores.jsp").forward(request, response);
			
		}catch(Exception e){
			e.printStackTrace();
		}
	
	
}

}
