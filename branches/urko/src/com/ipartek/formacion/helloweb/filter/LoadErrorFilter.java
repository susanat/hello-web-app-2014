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

import com.ipartek.formacion.helloweb.listener.InitListener;
import com.ipartek.formacion.helloweb.util.Constante;

/**
 * Servlet Filter implementation class LoadErrorFilter
 */
public class LoadErrorFilter implements Filter {

    /**
     * Default constructor.
     */

    public FilterConfig filterConfig;
    private final static Logger log = Logger.getLogger(LoadErrorFilter.class);

    /**
     * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
     */
    @Override
    public void doFilter(final ServletRequest request,
	    final ServletResponse response, final FilterChain chain)
	    throws IOException, ServletException {
	if (request instanceof HttpServletRequest) {
	    log.trace(((HttpServletRequest) request).getRequestURI());
	}
	if (InitListener.LOAD_ERROR) {
	    request.getRequestDispatcher(Constante.JSP_ERROR).forward(request,
		    response);
	    return;

	} else {
	    // pass the request along the filter chain
	    request.setCharacterEncoding("UTF-8");
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
	filterConfig = null;
    }

}
