package control;

import java.io.IOException;
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
@WebServlet({"/ControleMateriais", "/template/buscar.html"})
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
				
			}
			
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
