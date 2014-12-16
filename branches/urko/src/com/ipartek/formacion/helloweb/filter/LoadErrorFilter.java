package com.ipartek.formacion.helloweb.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.ipartek.formacion.helloweb.listener.InitListener;
import com.ipartek.formacion.helloweb.util.Constante;
import com.sun.net.httpserver.Filter;

public class LoadErrorFilter implements javax.servlet.Filter {

    public FilterConfig filterConfig;

    /**
     * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
     */
    @Override
    public void doFilter(final ServletRequest request,
	    final ServletResponse response, final FilterChain chain)
	    throws IOException, ServletException {

	if (InitListener.LOAD_ERROR) {
	    request.getRequestDispatcher(Constante.JSP_ERROR).forward(request,
		    response);
	    return;
	} else {
	    // pass the request along the filter chain
	    chain.doFilter(request, response);
	    return;
	}

    }

    @Override
    public void init(final FilterConfig filterConfig) throws ServletException {
	this.filterConfig = filterConfig;
    }

    @Override
    public void destroy() {
    }

}
