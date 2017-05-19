package control;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Date;
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
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import persistence.HibernateUtil;
import persistence.MovimentacaoDao;

/**
 * Servlet implementation class ControleRelatorios
 */
@WebServlet({"/ControleRelatorios", "/ControleRelatorios2","/relentrada"})
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
		
		if(url.equalsIgnoreCase("/relentrada")){
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
		
	//	Map param = new HashMap();
		
	//	param.put("cod", "23");
		
		byte[] pdf = JasperRunManager.runReportToPdf(arquivo,null,con);
		
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
		
		String tipoMov = request.getParameter("tipMov");
		
		String dataini = request.getParameter("dataini");
	    	String dtini[] = dataini.split("/");
        	String diai = dtini[0];
        	String mesi = dtini[1];
        	String anoi = dtini[2];
   
		String datafim = request.getParameter("datafim");
	        String dtfim[] = datafim.split("/");
	     	String diaf = dtfim[0];
	     	String mesf = dtfim[1];
	     	String anof = dtfim[2];

		HashMap param = new HashMap();
		param.put("dataini",  anoi +"-"+mesi+"-"+diai + " 00:00:00" );
		param.put("datafim", anof +"-"+mesf+"-"+diaf + " 23:59:59" );
		
		if(tipoMov.equalsIgnoreCase("entrada")){
			param.put("tipmov", "entrada" );
			
		}else if(tipoMov.equalsIgnoreCase("saida")){
			param.put("tipmov", "saida" );
			
		}else if(tipoMov.equalsIgnoreCase("entradaesaida")){
			param.put("tipmov", "entrada or tipo = "+'"'+"saida"+'"');
		}

		InputStream arquivo = getServletContext().getResourceAsStream("/relatorios/RelMoviment.jasper");
			
		byte[] pdf = JasperRunManager.runReportToPdf(arquivo, param ,con);
		
		ServletOutputStream out = response.getOutputStream(); 
		out.write(pdf);
		out.flush();

	}catch(Exception e){
		e.printStackTrace();
	}
	}

}
