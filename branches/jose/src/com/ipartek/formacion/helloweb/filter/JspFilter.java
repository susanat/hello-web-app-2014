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
	private FilterConfig fConfig;
	private HttpServletRequest requesthttp;
	private static Logger log = Logger.getLogger("ACCESOS");

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
		this.fConfig = null;
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {


		if (request instanceof HttpServletRequest) {
			log.trace(((HttpServletRequest) request).getRequestURI());
			requesthttp = (HttpServletRequest) request;

			// che si no es login.jsp
			if (!"login.jsp".equalsIgnoreCase(requesthttp.getRequestURI())) {

			// usuario NO esta Validado
			if (null == requesthttp.getSession().getAttribute(
					Constantes.USER_SESSION)) {
				// preparar mensaje de usuario no validado
					log.warn("Intento de acceder a una JSP sin estar validado, RemoteAdress "
							+ requesthttp.getRemoteAddr());
				Mensaje msg = new Mensaje(
						"Intento de acceder a una JSP sin estar validado",
						Mensaje.MSG_TYPE_DANGER);
				request.setAttribute(Constantes.MSG_KEY, msg);
				request.getRequestDispatcher(Constantes.JSP_LOGIN).forward(
						request, response);
				// cargar dispacher y forward a login
					request.getRequestDispatcher("/" + Constantes.JSP_LOGIN)
							.forward(request, response);

			} else {
				// Usuario Validado - continuar
				chain.doFilter(request, response);
				return;
			}
			} else {
				log.debug("Es login.jsp no bebe filtrarse");
				chain.doFilter(request, response);
				return;

			}
		} else {
			log.warn("request no es HttpServletRequest");
		}

	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		this.fConfig = fConfig;
	}

}
