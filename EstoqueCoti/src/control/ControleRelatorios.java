package control;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.engine.spi.SessionImplementor;

import model.HistoricoEstoque;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import persistence.HibernateUtil;
import persistence.MovimentacaoDao;

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
		executeRel(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		executeRel(request, response);
	}
	
	protected void executeRel(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		try{
			
			String url = request.getServletPath();
		
		if(url.equalsIgnoreCase("/ControleRelatorios2")){
		relEntrada(request, response);
		
		}else if(url.equalsIgnoreCase("/ControleRelatorios")){
			relatorios(request, response);
		}
	
	}catch (Exception e){
		e.printStackTrace();
	}
	}
	
protected void relatorios(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	try{
		
		SessionImplementor sim = (SessionImplementor) HibernateUtil.getSessionFactory().openSession();
		Connection con = sim.connection();
		
		InputStream arquivo = getServletContext().getResourceAsStream("/relatorios/Materiais.jasper");
		
		Map param = new HashMap();
		
		param.put("cod", "23");
		
		byte[] pdf = JasperRunManager.runReportToPdf(arquivo,param,con);
		
		ServletOutputStream out = response.getOutputStream();
		out.write(pdf);
		out.flush();
		
	}catch(Exception e){
		e.printStackTrace();
	}
	}

protected void relEntrada(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	try{
		
		SessionImplementor sim = (SessionImplementor) HibernateUtil.getSessionFactory().openSession();
		Connection con = sim.connection();
		
		InputStream arquivo = getServletContext().getResourceAsStream("/relatorios/RelEntrada3.jasper");
		
		String query = "select H from HistoricoEstoque as H";
		
		List<HistoricoEstoque> lista = new MovimentacaoDao().RelEntrada(query);
		
		System.out.println(lista.toString());
		
		JRBeanCollectionDataSource ds = new JRBeanCollectionDataSource(lista);
		
		byte[] pdf = JasperRunManager.runReportToPdf(arquivo, null ,ds);
		
		ServletOutputStream out = response.getOutputStream();
		out.write(pdf);
		out.flush();
		
	}catch(Exception e){
		e.printStackTrace();
	}
	}

}
