package com.ipartek.formacion.helloweb.filters;

import java.io.IOException;
import java.util.Locale;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.formacion.helloweb.comun.Constantes;

public class langFilter implements Filter {

	

	
	public void init(FilterConfig filterConfig) throws ServletException {
		

	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
				
		
		//if the ServletRequest is an instance of HttpServletRequest  
        if(request instanceof HttpServletRequest) {  
           
        	try{

        		//Request  
                HttpServletRequest httpReq = (HttpServletRequest)request;
                //response
                HttpServletResponse httpRes = (HttpServletResponse) response;
                                
                //obtenemos la sesion
                HttpSession session = httpReq.getSession();
                
                
                //si la session tiene el locale, no hacemos nada, continuamos normalmente
                if (session.getAttribute(Constantes.PARAM_SESSION_LOCALE) != null) {
                	chain.doFilter(request, response);
                } else {
                	
                	//redirecciono indicando el idioma
                	Locale locale = request.getLocale();
                	
                	//compruebo si dispongo del idioma, si no, pongo el de defecto
                	
                	
                	
                	
                	
                	session.setAttribute(Constantes.PARAM_SESSION_LOCALE, request.getLocale());
                	if(httpReq.getRequestURL().indexOf("?") > 0) {
                    	httpRes.sendRedirect(httpReq.getRequestURL()+"&" + Constantes.PARAMETRO_URL_GET_LANGUAGE + "="+locale.toString());
        			} else {
        				httpRes.sendRedirect(httpReq.getRequestURL()+"?" + Constantes.PARAMETRO_URL_GET_LANGUAGE + "="+locale.toString());
        			}
                }
                
                
        	}catch (Exception ex) {
        		chain.doFilter(request, response); 
        	}
        	
        	
        } else {
        	chain.doFilter(request, response);
        }          

	}

	public void destroy() {
		

	}

}
