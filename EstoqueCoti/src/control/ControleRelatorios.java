package control;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.engine.spi.SessionImplementor;

import net.sf.jasperreports.engine.JasperRunManager;
import persistence.HibernateUtil;

/**
 * Servlet implementation class ControleRelatorios
 */
@WebServlet({"/ControleRelatorios", "/ControleRelatorios2"})
public class ControleRelatorios extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControleRelatorios() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		relatorios(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		relatorios(request, response);
	}
	
protected void relatorios(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	try{
		
		SessionImplementor sim = (SessionImplementor) HibernateUtil.getSessionFactory().openSession();
		Connection con = sim.connection();
		
		InputStream arquivo = getServletContext().getResourceAsStream("/relatorios/Materiais.jasper");
		
		byte[] pdf = JasperRunManager.runReportToPdf(arquivo,null,con);
		
		ServletOutputStream out = response.getOutputStream();
		out.write(pdf);
		out.flush();
		
	}catch(Exception e){
		e.printStackTrace();
	}
	}

}
