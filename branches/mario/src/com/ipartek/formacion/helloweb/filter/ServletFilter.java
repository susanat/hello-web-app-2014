package com.ipartek.formacion.helloweb.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.ipartek.formacion.helloweb.Constantes;

/**
 * Servlet Filter implementation class ServletFilter
 */
public class ServletFilter implements Filter {

    private FilterConfig fConfig;

    /**
     * @see Filter#destroy()
     */
    public void destroy() {
	this.fConfig = null;
    }

    /**
     * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
     */
    public void doFilter(ServletRequest request, ServletResponse response,
	    FilterChain chain) throws IOException, ServletException {

	HttpServletRequest requestHttp = (HttpServletRequest) request;
	HttpSession session = requestHttp.getSession();
	// existe usuario en session continua
	if (null != session.getAttribute(Constantes.USER_SESSION)) {
	    chain.doFilter(request, response);
	    return;

	    // no existe usuario en session, forward al LoginServlet
	} else {
	    requestHttp.getRequestDispatcher("/" + Constantes.PATH_LOGIN)
		    .forward(request, response);
	    return;
	}

    }

    /**
     * @see Filter#init(FilterConfig)
     */
    public void init(FilterConfig fConfig) throws ServletException {
	this.fConfig = fConfig;
    }

}
