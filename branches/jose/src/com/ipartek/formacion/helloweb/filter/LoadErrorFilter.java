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
 * Servlet Filter implementation class LoadErrorFilter
 */
public class LoadErrorFilter implements Filter {
	public FilterConfig filterConfig;

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		if (InitListener.LOAD_ERROR) {
			request.getRequestDispatcher(Constantes.JSP_ERROR).forward(request,
					response);
		}
		// TODO Auto-generated method stub
		// place your code here

		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#Filter()
	 */
    public LoadErrorFilter() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}


	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig filterConfig) throws ServletException {
		this.filterConfig = filterConfig;
	}


}
