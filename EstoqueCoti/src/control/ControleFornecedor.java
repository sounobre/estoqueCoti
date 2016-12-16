package control;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet({"/ControleFornecedor", "/template/cadastroFornecedor.html"})
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
				String cidade = request.getParameter("");
				String estado = request.getParameter("");
				String email = request.getParameter("");
				Integer codigo = new Integer (request.getParameter("codFornecedor"));
				String pessoaContato = request.getParameter("");
				String cnpj = request.getParameter("");
				Date inicioAtividades = new Date (request.getParameter(""));

				
			}catch(Exception e){
				e.printStackTrace();
			}
}

}
