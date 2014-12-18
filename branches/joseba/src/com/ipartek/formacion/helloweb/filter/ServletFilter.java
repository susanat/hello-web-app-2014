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

    public FilterConfig filterconfig;

    /**
     * Default constructor.
     */
    public ServletFilter() {
	// TODO Auto-generated constructor stub
    }

    /**
     * @see Filter#destroy()
     */
    public void destroy() {
	filterconfig = null;
    }

    /**
     * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
     */
    public void doFilter(ServletRequest request, ServletResponse response,
	    FilterChain chain) throws IOException, ServletException {
	HttpServletRequest requestHttp = (HttpServletRequest) request;
	HttpSession session = requestHttp.getSession();
	if (session.getAttribute(Constantes.USER_SESSION) != null) {
	    // existe sesion
	    chain.doFilter(request, response);
	    return;
	} else {
	    // No existe sesion, redirigimos al servlet
	    request.getRequestDispatcher(Constantes.PATH_LOGIN).forward(
		    requestHttp, response);
	    ;

	}

    }

    /**
     * @see Filter#init(FilterConfig)
     */
    public void init(FilterConfig fConfig) throws ServletException {
	this.filterconfig = fConfig;
    }

}
