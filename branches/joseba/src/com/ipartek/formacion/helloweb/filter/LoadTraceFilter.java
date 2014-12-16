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
import com.ipartek.formacion.helloweb.bean.Message;

/**
 * Servlet Filter implementation class LoadTraceFilter
 */
public class LoadTraceFilter implements Filter {

    public FilterConfig filterconfig;
    private HttpServletRequest requesthttp;

    /**
     * Default constructor.
     */
    public LoadTraceFilter() {
	// TODO Auto-generated constructor stub
    }

    /**
     * @see Filter#destroy()
     */
    public void destroy() {
	this.filterconfig = null;

    }

    /**
     * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
     */
    public void doFilter(ServletRequest request, ServletResponse response,
	    FilterChain chain) throws IOException, ServletException {

	if (request instanceof HttpServletRequest) {
	    System.out.println("Estamos en: "
		    + ((HttpServletRequest) request).getRequestURL());
	    requesthttp = (HttpServletRequest) request;

	    // comprobamos si no es login.jsp
	    if (!"/login.jsp".equalsIgnoreCase(requesthttp.getRequestURI())) {

		// usuario no esta validado
		if (null == requesthttp.getSession().getAttribute(
			Constantes.USER_SESSION)) {
		    // Preparar mensaje de usuario no validado
		    Message mensaje = new Message();
		    mensaje.setMsg("No tienes permisos");
		    mensaje.setType(Constantes.ALERT_TYPE_DANGER);
		    request.setAttribute(Constantes.ATT_MENSAJE, mensaje);

		    // cargar dispatcher y forward a login
		    request.getRequestDispatcher("/" + Constantes.JSP_LOGIN)
			    .forward(request, response);
		}
		// usuario validado
		else {
		    chain.doFilter(request, response);
		    return;
		}
	    } else {
		System.out.println("Es login.jsp no debe filtrarse");
		chain.doFilter(request, response);
		return;
	    }
	} else {
	    System.out.println("request no es HttpServletRequest");
	}

    }

    /**
     * @see Filter#init(FilterConfig)
     */
    public void init(FilterConfig fConfig) throws ServletException {
	this.filterconfig = fConfig;
    }

}
