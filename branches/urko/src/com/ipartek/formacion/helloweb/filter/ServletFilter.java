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
    private final static Logger log = Logger.getLogger(JspFilter.class);
    private HttpServletRequest requesthttp = null;
    private HttpServletResponse responsehttp = null;

    public ServletFilter() {
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
    public void doFilter(final ServletRequest request,
	    final ServletResponse response, final FilterChain chain)
	    throws IOException, ServletException {

	if (request instanceof HttpServletRequest) {
	    log.trace(((HttpServletRequest) request).getRequestURI());
	    requesthttp = (HttpServletRequest) request;
	    String url = requesthttp.getContextPath() + "/";
	    if (null != requesthttp.getSession().getAttribute(
		    Constante.USER_SESSION)) {
		// pass the request along the filter chain
		chain.doFilter(request, response);
		return;
	    } else {
		/*
		 * requesthttp.getRequestDispatcher("/" + Constante.JSP_LOGIN)
		 * .forward(request, response);
		 */
		log.trace(url);
		responsehttp.sendRedirect(url + Constante.JSP_LOGIN);
		return;
	    }
	}

    }

    /**
     * @see Filter#init(FilterConfig)
     */
    @Override
    public void init(final FilterConfig fConfig) throws ServletException {
	// TODO Auto-generated method stub
    }

}
