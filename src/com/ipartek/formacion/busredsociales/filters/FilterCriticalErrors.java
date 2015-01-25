package com.ipartek.formacion.busredsociales.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import com.ipartek.formacion.busredsociales.comun.Globales;
import com.ipartek.formacion.busredsociales.criticalsteps.CriticalStepLogic;


/**
 * Servlet Filter implementation class FilterCriticalErrors
 */
public class FilterCriticalErrors implements Filter {

	private FilterConfig config;

	public void setFilterConfig(FilterConfig config) {
		this.config = config;
	}

	public FilterConfig getFilterConfig() {
		return config;
	}
	
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
			
		
		ServletContext context = getFilterConfig().getServletContext();
		
		//chequeamos todos los pasos
		CriticalStepLogic.checkAllSteps(context);
		
		//comprobamos si lo podemos arreglar
		if(CriticalStepLogic.getCriticalError()) {
			CriticalStepLogic.configureAllSteps(context);
		}
		
		
		
		if(CriticalStepLogic.getCriticalError()) {
			request.getRequestDispatcher("ErrorGrave.jsp").forward(request, response);
		} else {
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
		setFilterConfig(fConfig);
	}

}
