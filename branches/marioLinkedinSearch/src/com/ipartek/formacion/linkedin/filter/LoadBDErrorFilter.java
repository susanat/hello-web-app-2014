package com.ipartek.formacion.linkedin.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.ipartek.formacion.linkedin.bean.Mensaje;
import com.ipartek.formacion.linkedin.listener.InitListener;

/**
 * Filtro para comprobar si ha habia un error en el <code>InitListener</code> al
 * arrancar la AppWeb
 *
 */
public class LoadBDErrorFilter implements Filter {
    public FilterConfig filterConfig;

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
    public void doFilter(ServletRequest request, ServletResponse response,
	    FilterChain chain) throws IOException, ServletException {

	if (InitListener.LOAD_BD_ERROR) {
	    Mensaje mens = new Mensaje(
		    "Hay un problema en la conexión con la base de datos. Es probable que la aplicación no funcione correctamente. Sentimos las molestias",
		    Mensaje.MSG_TYPE_DANGER);
	    request.setAttribute("mensaje", mens);
	    chain.doFilter(request, response);
	    return;
	} else {
	    // pass the request along the filter chain
	    chain.doFilter(request, response);
	    return;
	}

    }

    /**
     * @see Filter#init(FilterConfig)
     */
    @Override
    public void init(FilterConfig fConfig) throws ServletException {
	this.filterConfig = fConfig;
    }

}
