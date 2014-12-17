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

import com.ipartek.formacion.helloweb.Constantes;
import com.ipartek.formacion.helloweb.bean.Mensaje;

/**
 * Servlet Filter implementation class JspFilter
 */
public class JspFilter implements Filter {

 
	private FilterConfig fConfig;
	private final static Logger log = Logger.getLogger("ACCESOS");
	private HttpServletRequest requesthttp;
	
	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		this.fConfig = fConfig;
	}
	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		this.fConfig = null;
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
	
		//comprobar que request sea de tipo HttpServletRequest
		if (  request instanceof HttpServletRequest ){
			log.trace( ((HttpServletRequest) request).getRequestURL()  );
			requesthttp =  (HttpServletRequest) request;
			
			//TODO comprobarlo bien que no funciona
			//check si no es login.jsp
			if ( !"/login.jsp".equalsIgnoreCase(requesthttp.getRequestURI()) ){
				
				//usuario session NO esta Validado
				if ( null == requesthttp.getSession().getAttribute(Constantes.USER_SESSION) ){
					log.warn( "Intento de acceder a una JSP sin estar validado , Remote Address " + request.getRemoteAddr() );
					//prepara mensaje de usuario no validado
					Mensaje msg = new Mensaje( "No tienes permisos " , Mensaje.MSG_TYPE_DANGER );
					request.setAttribute( Constantes.MSG_KEY,  msg );
					//cargar dispacher y forward a login
					request.getRequestDispatcher( "/"+Constantes.JSP_LOGIN ).forward(request, response);
										
				}else{
					//Usuario validado continuar
					chain.doFilter(request, response);
					return;
				}
			}else{
				log.debug( "Es login.jsp no debe filtrarse "  );
				chain.doFilter(request, response);
				return;
			}	
		}else{
			log.warn( "request no es HttpServletRequest");
		}
				
	}

	

}
