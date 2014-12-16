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
import com.ipartek.formacion.helloweb.bean.Mensaje;

/**
 * Servlet Filter implementation class JspFilter
 */
public class JspFilter implements Filter {

	private final static Logger log = Logger.getLogger(JspFilter.class);

	private FilterConfig fConfig;
	private HttpServletRequest requestHttp;
	private Mensaje msg;

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		fConfig = null;
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(final ServletRequest request, final ServletResponse response, final FilterChain chain)
			throws IOException, ServletException {

		if (request instanceof HttpServletRequest) {
			log.trace(((HttpServletRequest) request).getRequestURL());
			requestHttp = (HttpServletRequest) request;

			if (!"login.jsp".equalsIgnoreCase(requestHttp.getRequestURI())) {
				// Usuario NO está validado
				if (null == requestHttp.getSession().getAttribute(Constantes.USER_SESSION)) {
					msg = new Mensaje(Mensaje.MSG_TYPE_DANGER, "Intento de acceder a una JSP sin estas validado, IP "
							+ request.getRemoteAddr());
					request.setAttribute(Constantes.MSG_KEY, msg);
					request.getRequestDispatcher("/" + Constantes.JSP_LOGIN).forward(request, response);
				} else {
					// Usuario validado continuar
					chain.doFilter(request, response);
					return;
				}
			}
		} else {
			log.warn("Request no es HttpServletRequest");
		}

	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(final FilterConfig fConfig) throws ServletException {
		this.fConfig = fConfig;
	}

}
