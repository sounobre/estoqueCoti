package filtro;

import java.io.IOException;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import control.ControleLogin;

/**
 * Servlet Filter implementation class FiltroLogin
 */
@WebFilter(
		dispatcherTypes = {
				DispatcherType.REQUEST, 
				DispatcherType.FORWARD, 
				DispatcherType.INCLUDE, 
				DispatcherType.ERROR
		}
					, 
		urlPatterns = { 
				"/FiltroLogin", 
				//"/template/*"
		})
public class FiltroLogin implements Filter {

    
    public FiltroLogin() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		
		HttpServletResponse res = (HttpServletResponse) response;
		HttpServletRequest req = (HttpServletRequest) request;
		
		
		String url = req.getServletPath();
		
		HttpSession session = req.getSession();
		
	   if((session.getAttribute("login") == null) && (url.equalsIgnoreCase("/template/login.jsp"))){	
		ControleLogin cl = new ControleLogin();
		cl.execute(req, res);
	   }
		
	  
		if((session.getAttribute("login") != null) && (url.equalsIgnoreCase("/template/login.jsp")) || (url.equalsIgnoreCase("/template/index.jsp")
				|| (session.getAttribute("login") != null) )){
			//Se estiver logado, deixa a pagina ser exibida
			chain.doFilter(request, response);
		}else{
			//mandar embora
			res.sendRedirect( req.getContextPath() );
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
