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

/**
 * Servlet Filter implementation class FilterJsp
 */
public class JspFilter implements Filter {

    public FilterConfig filterConfig;
    private final static Logger log = Logger.getLogger(JspFilter.class);

    /**
     * @see Filter#destroy()
     */
    @Override
    public void destroy() {
	filterConfig = null;
    }

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
	// pass the request along the filter chain
	chain.doFilter(request, response);
	return;
    }

    /**
     * @see Filter#init(FilterConfig)
     */
    @Override
    public void init(final FilterConfig fConfig) throws ServletException {
	this.filterConfig = fConfig;
    }

}
