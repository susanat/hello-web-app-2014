package com.ipartek.formacion.helloweb.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.ipartek.formacion.helloweb.util.Constante;

/**
 * Servlet Filter implementation class ServletFilter
 */
public class ServletFilter implements Filter {
    public FilterConfig filterConfig;
    private final static Logger log = Logger.getLogger(ServletFilter.class);
    private HttpServletRequest requesthttp = null;
    private HttpServletResponse responsehttp = null;

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
	    requesthttp = (HttpServletRequest) request;
	    responsehttp = (HttpServletResponse) response;
	    String url = requesthttp.getContextPath() + "/";
	    // System.out.println(url);
	    if (null != requesthttp.getSession().getAttribute(
		    Constante.USER_SESSION)
		    || checkWebPages(requesthttp.getServletPath())) {
		// pass the request along the filter chain
		chain.doFilter(request, response);

		return;
	    } else {
		/*
		 * requesthttp.getRequestDispatcher("/" + Constante.JSP_LOGIN)
		 * .forward(request, response);
		 */
		log.trace(url);
		// responsehttp.sendRedirect(url + Constante.JSP_LOGIN);
		return;
	    }
	}

    }

    private boolean checkWebPages(final String path) {
	boolean exito = false;
	System.out.println(path + "-" + "/" + Constante.SERVLET_LOGIN);
	if (path.equalsIgnoreCase("/" + Constante.SERVLET_LOGIN)
	/* || path.equalsIgnoreCase("/" + Constante.JSP_SALUDO) */) {
	    exito = true;

	}
	return exito;
    }

    /**
     * @see Filter#init(FilterConfig)
     */
    @Override
    public void init(final FilterConfig fConfig) throws ServletException {
	this.filterConfig = fConfig;
    }

}
