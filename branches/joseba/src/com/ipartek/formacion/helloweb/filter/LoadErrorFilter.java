package com.ipartek.formacion.helloweb.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import com.ipartek.formacion.helloweb.Constantes;
import com.ipartek.formacion.helloweb.listener.InitListener;

/**
 * Servlet Filter implementation class LoadErrorFilter
 */
public class LoadErrorFilter implements Filter {

    public FilterConfig filterConfig;

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
	filterConfig = null;
    }

    /**
     * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
     */
    public void doFilter(ServletRequest request, ServletResponse response,
	    FilterChain chain) throws IOException, ServletException {

	if (request instanceof HttpServletRequest) {
	    System.out.println(((HttpServletRequest) request).getRequestURL());
	}

	if (InitListener.LOAD_ERROR) {
	    request.getRequestDispatcher(Constantes.JSP_ERROR).forward(request,
		    response);
	} else {
	    // pass the request along the filter chain
	    chain.doFilter(request, response);
	    return;
	}
    }

    /**
     * @see Filter#init(FilterConfig)
     */
    public void init(FilterConfig fConfig) throws ServletException {
	this.filterConfig = fConfig;
    }

}
