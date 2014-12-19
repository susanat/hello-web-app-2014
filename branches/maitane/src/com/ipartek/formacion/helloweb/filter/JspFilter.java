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

import com.ipartek.formacion.helloweb.Constantes;
import com.ipartek.formacion.helloweb.bean.Message;

/**
 * Servlet Filter implementation class LoadErrorFilter
 */
public class JspFilter implements Filter {

	public FilterConfig filterConfig;
	private final static Logger log = Logger.getLogger("ACCESOS");
	private HttpServletRequest requesthttp;

	/**
	 * Default constructor.
	 */
	public JspFilter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		this.filterConfig = null;
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {

		if (request instanceof HttpServletRequest) {
			log.trace(((HttpServletRequest) request).getRequestURL());
			requesthttp = (HttpServletRequest) request;

			// check si no es login.jsp
			if (!"login.jsp".equalsIgnoreCase(requesthttp.getRequestURI())) {
				// usuario NO esta validado
				if (null == requesthttp.getAttribute(Constantes.USER_SESSION)) {
					log.warn("Intento de acceder a una JSP sin estar validado ,IP "
							+ request.getRemoteAddr());
					// preparar mensaje deusuario no validado
					Message msg = new Message("No tienes permisos",
							Message.MSG_TYPE_DANGER);
					request.setAttribute(Constantes.MSG_KEY, msg);

					// cargar dispatcher y forward a login
					request.getRequestDispatcher(Constantes.JSP_LOGIN).forward(
							request, response);

				} else {
					// usuario validado continuar
					chain.doFilter(request, response);
					return;
				}
			}
		} else {
			log.warn("reuest no es HttpServletRequest");
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		this.filterConfig = fConfig;
	}

}
