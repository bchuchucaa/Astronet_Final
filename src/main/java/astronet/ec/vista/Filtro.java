package astronet.ec.vista;

import java.io.IOException;
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

/**
 * Servlet Filter implementation class Filtro
 */
@WebFilter({"/listadoEmpleado.xhtml","/listadoInstalaciones.xhtml","/registrarEmpleado.xhtml","/clientes1.xhtm"})
public class Filtro implements Filter {
    /**
     * Default constructor. 
     */
    public Filtro() {
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
		// TODO Auto-generated method stub
		// place your code here
		// pass the request along the filter chain
		chain.doFilter(request, response);
		HttpServletRequest request1= (HttpServletRequest) request;
		HttpServletResponse response1= (HttpServletResponse)response;
		HttpSession session= request1.getSession(false);
		String loginUri= request1.getContextPath()+"/index.xhtml";
		boolean loggenIn =session !=null && session.getAttribute("user")!=null;
		boolean loginRequest = request1.getRequestURI().equals(loginUri);
		if(loggenIn ||loginRequest) {
			chain.doFilter(request, response);
		}else {
			response1.sendRedirect(loginUri);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}
}