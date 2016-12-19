package control;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Fornecedor;
import persistence.FornecedorDao;


@WebServlet({"/ControleFornecedor", "/template/cadastroFornecedor.html","/template/buscaFornecedor.html"})
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
		}
	}

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
				
				GregorianCalendar cal = new GregorianCalendar(new Integer(data[2]), new Integer(data[1]) - 1, new Integer(data[0]));
				
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
								
				System.out.println(sdf.format(cal.getTime()));
				
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
				f.setInicioAtividades( new Date (sdf.format(cal.getTime())));
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
		List<Fornecedor> listaFornecedores = new FornecedorDao().listarFornecedores();
		
		request.setAttribute("listaFornecedores", listaFornecedores);
		request.getRequestDispatcher("cadFornecedores.jsp").forward(request, response);
}

}
