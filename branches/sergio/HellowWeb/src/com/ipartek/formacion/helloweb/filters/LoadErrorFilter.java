package com.ipartek.formacion.helloweb.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.ipartek.formacion.helloweb.comun.Constantes;

/**
 * Servlet Filter implementation class LoadErrorFilter
 */
public class LoadErrorFilter implements Filter {

	private FilterConfig filterConfig = null;
	private static Logger log = Logger.getLogger(LoadErrorFilter.class);
	
    /**
     * Default constructor. 
     */
    public LoadErrorFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
		this.filterConfig = null;
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		if(request instanceof HttpServletRequest) 
		{
			HttpServletRequest httpres = (HttpServletRequest) request;			
			log.trace(httpres.getRequestURL());
			
		}
		
		
		
		
		
		
		
		// place your code here
		if(Constantes.LOAD_ERROR) {
			request.getRequestDispatcher(Constantes.JSP_ERROR).forward(request, response);
		}
		
		
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		this.filterConfig = fConfig;
	}

}
