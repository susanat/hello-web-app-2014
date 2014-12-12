package com.ipartek.formacion.helloweb.controller;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class FilterEncoding
 */
public class FilterEncoding implements Filter {

    /**
     * Default constructor.
     */
    public FilterEncoding() {
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
    public void doFilter(final ServletRequest request,
	    final ServletResponse response, final FilterChain chain)
	    throws IOException, ServletException {
	// TODO Auto-generated method stub
	String path = ((HttpServletRequest) request).getRequestURI();
	System.out.println(path);
	// place your code here

	request.setCharacterEncoding("UTF-8");

	// pass the request along the filter chain
	chain.doFilter(request, response);
    }

    /**
     * @see Filter#init(FilterConfig)
     */
    public void init(final FilterConfig fConfig) throws ServletException {
	// TODO Auto-generated method stub
    }

}
