package com.ipartek.formacion.buscadorLinkedIn.filtros;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.ipartek.formacion.buscadorLinkedIn.listener.InitListener;

/**
 * Servlet Filter implementation class loadErrorFilter
 */
public class loadErrorFilter implements Filter {

    /**
     * Default constructor.
     */
    public loadErrorFilter() {
	// TODO Auto-generated constructor stub
    }

    /**
     * @see Filter#destroy()
     */
    @Override
    public void destroy() {
	// TODO Auto-generated method stub
    }

    /**
     * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
	    FilterChain chain) throws IOException, ServletException {
	if (InitListener.LOAD_ERROR) {
	    request.setAttribute("mensajeError", InitListener.LOAD_ERROR_MSG);
	    request.getRequestDispatcher("/error.jsp").forward(request,
		    response);
	} else {

	    // pass the request along the filter chain
	    chain.doFilter(request, response);
	}
    }

    /**
     * @see Filter#init(FilterConfig)
     */
    @Override
    public void init(FilterConfig fConfig) throws ServletException {
	// TODO Auto-generated method stub
    }

}
