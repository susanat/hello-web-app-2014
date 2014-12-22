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

import com.ipartek.formacion.helloweb.bean.Mensaje;
import com.ipartek.formacion.helloweb.util.Constante;

/**
 * Servlet Filter implementation class FilterJsp
 */
public class JspFilter implements Filter {

    public FilterConfig filterConfig;
    private final static Logger log = Logger.getLogger(JspFilter.class);
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
	    if (null == requesthttp.getSession().getAttribute(
		    Constante.USER_SESSION)
		    && checkWebPages(requesthttp.getServletPath())) {

		// URL url = new URL(requesthttp.getRequestURL().toString());

		// System.out.println(requesthttp.getServletPath());
		Mensaje msg = new Mensaje(Constante.MSG_SIN_PERMISOS,
			Mensaje.MSG_TYPE_DANGER);
		requesthttp.setAttribute(Constante.MSG_KEY, msg);
		String url = requesthttp.getContextPath() + "/";
		// System.out.println(url);
		responsehttp.sendRedirect(url + Constante.JSP_LOGIN);
		// response.sendRedirect(url);
		/*
		 * requesthttp.getRequestDispatcher("/" + Constante.JSP_LOGIN)
		 * .forward(request, response);
		 */

	    } else {
		chain.doFilter(request, response);
		return;
	    }
	} else {
	    log.warn("");
	}
	// pass the request along the filter chain
	chain.doFilter(request, response);
	return;
    }

    private boolean checkWebPages(final String path) {
	boolean exito = true;
	if (path.equalsIgnoreCase("/" + Constante.JSP_LOGIN)
	/* || path.equalsIgnoreCase("/" + Constante.JSP_SALUDO) */) {
	    exito = false;

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
