package com.ipartek.formacion.busredsociales.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import com.ipartek.formacion.busredsociales.comun.Globales;


/**
 * Servlet Filter implementation class FilterCriticalErrors
 */
public class FilterCriticalErrors implements Filter {

    /**
     * Default constructor. 
     */
    public FilterCriticalErrors() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		
		/*
		if(request instanceof HttpServletRequest) 
		{
			HttpServletRequest httpres = (HttpServletRequest) request;			
			
		}
		*/
		
		
		
		
		// place your code here
		if(Globales.GLOBAL_IS_CRITICAL_ERROR) {
			request.getRequestDispatcher("ErrorGrave.jsp").forward(request, response);
		}else{
			chain.doFilter(request, response);
		}

		//En este caso no quiero que continue comprobando otros filtros
		// pass the request along the filter chain
		//chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
