package com.ipartek.formacion.helloweb.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.formacion.helloweb.Constantes;
import com.ipartek.formacion.helloweb.bean.Persona;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet  {
	private static final long serialVersionUID = 1L;

	 RequestDispatcher dispatch=null;
	 //variable de sesion
	 HttpSession session=null;
	 
	 //parametros
	 
	 String pUser=null;
	 String pPass=null;
	 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*COMO REDIRIGIR UN JSP:
		**************************************/
		//recuperar session
		session= request.getSession();
		 
		 //recoger parametros del login
		 
		 getParameters(request);
		 //validar el usuario
		 
		 if(validarUserAdmin()){
			 
			 dispatch= request.getRequestDispatcher(Constantes.JSP_BACK_INDEX);
			 Persona p=new Persona(pUser, 0);
			 session.setAttribute(Constantes.USER_SESSION, p);
			 
		 }else if(validarUser()){
		 
		 	//correcto: redirigir a saludo.jsp
		 dispatch= request.getRequestDispatcher(Constantes.JSP_SALUDO);
		 //guardar usuario en sesion
		 //TODO recuperar usuario de la BBDD
		 Persona p=new Persona(pUser, 0);
		 session.setAttribute(Constantes.USER_SESSION, p);
		 }
		 	//incorrecto: enviar de nuevo a login.jsp
		 else{
		 dispatch= request.getRequestDispatcher(Constantes.JSP_LOGIN);
		 request.setAttribute(Constantes.MSG_KEY, Constantes.MSG_LOGIN_INCORRECT);
		 }
		 //despachar o servir JSP
		 dispatch.forward(request, response);
		 
		 
	}
	
	/**
	 * Recoger parametros de request
	 * @param request
	 */
	private void getParameters(HttpServletRequest request){
		pUser=request.getParameter(Constantes.PARAMETRO_USER);
		pPass=request.getParameter(Constantes.PARAMETRO_PASS);
		
	}
	
	/**
	 * Valida el susario y contraseña de un usuario administrador
	 * @return true si todos los datos son correctos y false en caso contrario
	 */
	
	private boolean validarUserAdmin(){
		boolean rdo=false;
		 if(Constantes.USER_ADMIN.equals(pUser)&&Constantes.PASS_ADMIN.equals(pPass)){
			 rdo=true;
		 }
		 return rdo;
		
	}
	
	/**
	 * Valida el susario y contraseña de un usuario normal
	 * @return true si todos los datos son correctos y false en caso contrario
	 */
	
	private boolean validarUser(){
		boolean rdo=false;
		 if(Constantes.USER.equals(pUser)&&Constantes.PASS.equals(pPass)){
			 rdo=true;
		 }
		 return rdo;
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// response.setContentType("text/html");
	      /*  PrintWriter out = response.getWriter();
	        out.println("<html>");
	        out.println("<head>");
	        out.println("<title>Hello World!</title>");
	        out.println("</head>");
	        out.println("<body>");
	        out.println("<h1>Peticion tipo GET</h1>");
	        out.println("</body>");
	        out.println("</html>");*/
		 doGet(request, response);
	}

}
