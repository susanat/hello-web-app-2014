package com.ipartek.formacion.helloweb.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.ipartek.formacion.helloweb.Constantes;
import com.ipartek.formacion.helloweb.listener.InitListener;

/**
 * Filtro para comprobar si ha habia un error en el <code>InitListener</code> al
 * arrancar la AppWeb
 * 
 * @see com.ipartek.formacion.helloweb.listener.InitListener
 */
public class LoadErrorFilter implements Filter {

	public FilterConfig filterConfig;
	private final static Logger log = Logger.getLogger(LoadErrorFilter.class);

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {

		if (request instanceof HttpServletRequest) {
			log.trace(((HttpServletRequest) request).getRequestURL());
		}

		if (InitListener.LOAD_ERROR) {
			request.getRequestDispatcher(Constantes.JSP_ERROR).forward(request,
					response);
			return;
		} else {
			// pass the request along the filter chain
			chain.doFilter(request, response);
			return;
		}

	}

	public void init(FilterConfig filterConfig) throws ServletException {
		this.filterConfig = filterConfig;
	}

	public void destroy() {
		filterConfig = null;
	}

}
