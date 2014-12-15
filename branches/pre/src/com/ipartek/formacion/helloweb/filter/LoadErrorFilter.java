package com.ipartek.formacion.helloweb.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.ipartek.formacion.helloweb.Constantes;
import com.ipartek.formacion.helloweb.listener.InitListener;

/**
 * Filtro para comprobar si ha habia un error en el <code>InitListener</code>
 * al arrancar la AppWeb
 * @see com.ipartek.formacion.helloweb.listener.InitListener
 */
public class LoadErrorFilter implements Filter {
	public FilterConfig filterConfig; 
    

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		if ( InitListener.LOAD_ERROR ){			
			request.getRequestDispatcher(Constantes.JSP_ERROR).forward(request, response);				
		}
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	public void init(FilterConfig filterConfig) throws ServletException {
		this.filterConfig = filterConfig; 
	}

	public void destroy() {		
		
	}

	

}
