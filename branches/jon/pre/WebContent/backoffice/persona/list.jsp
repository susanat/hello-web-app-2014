<!DOCTYPE html>
<%@page import="java.util.ArrayList"%>
<%@page import="com.ipartek.formacion.helloweb.bean.Persona"%>
<%@page import="com.ipartek.formacion.helloweb.Constantes"%>
<html lang="es">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>BackOffice</title>

    <!-- Bootstrap Core CSS -->
    <link href="<%=request.getContextPath()+'/'+Constantes.JSP_BACKOFFICE%>/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="<%=request.getContextPath()+'/'+Constantes.JSP_BACKOFFICE%>/css/sb-admin-2.css" rel="stylesheet">

   
    <!-- Custom Fonts -->
    <link href="<%=request.getContextPath()+'/'+Constantes.JSP_BACKOFFICE%>/font-awesome-4.1.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">

	<link href="<%=request.getContextPath()+'/'+Constantes.JSP_BACKOFFICE%>/css/plugins/dataTables.bootstrap.css" rel="stylesheet" type="text/css">


    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>

    <div id="wrapper">

        <!-- Navigation -->
        <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="index.html">Hola <%=request.getParameter(Constantes.PARAMETRO_USER)%></a>
            </div>
            <!-- /.navbar-header -->

            <ul class="nav navbar-top-links navbar-right">
                <li>
                    <a href="<%=request.getContextPath()+'/'+Constantes.JSP_LOGOUT%>">[x] Desconectar</a>
                </li>
                <!-- /.dropdown -->
            </ul>
            <!-- /.navbar-top-links -->

            <div class="navbar-default sidebar" role="navigation">
                <div class="sidebar-nav navbar-collapse">
                    <ul class="nav" id="side-menu">                        
                        <li>
                            <a class="active" href="<%=request.getContextPath()+'/'+Constantes.CONTROLLER_PERSONA %>"><i class="fa fa-dashboard fa-fw"></i> Personas</a>
                        </li>                       
                    </ul>
                </div>
                <!-- /.sidebar-collapse -->
            </div>
            <!-- /.navbar-static-side -->
        </nav>

        <div id="page-wrapper">
            
            <a class="active" href="<%=request.getContextPath()+'/'+Constantes.JSP_BACK_PERSONA_FORM %>">Crear nueva persona</a>
	        
            
            <%
		ArrayList<Persona> personas = (ArrayList<Persona>)request.getAttribute( Constantes.ATT_PERSONAS );
		if ( personas == null ){
			%>
				<h2>No existe nigun persona, por favor</h2>
				<p><a href="<%=request.getContextPath()+'/'+Constantes.JSP_BACK_PERSONA_FORM%>" title="crear nueva persona">cree una nueva persona</a></p>
			<%
		}else{
			   
			Persona p = null;
			out.println("<table id=\"listaPersonas\">");				
			out.println("<thead><tr><th>ID</th><th>NOMBRE</th><th>ROL</th><th></th></tr></thead>");
			out.println("<tbody>");
			for ( int i=0; i < personas.size(); i++){
				p = personas.get(i); //detalle persona
				
				%>
				
	
				
				
					<tr>
						<td><%=p.getId() %></td>
						<td>
						<a href="<%=request.getContextPath()+'/'+Constantes.CONTROLLER_PERSONA+"?id="+p.getId()%>">
							<%=p.getNombre()%> 
						</a>
						</td>
						<td><%=p.getRol()%></td>
						<td><form action="<%=request.getContextPath()+"/"+Constantes.CONTROLLER_PERSONA%>" method="post">
							<input type="hidden"  name="id"  value="<%=p.getId()%>">
							<input type="hidden" name="<%=Constantes.OP_KEY%>" value="<%=Constantes.OP_DELETE%>">
							<input class="btn btn-danger btn-sm" type="submit" value="Eliminar" >	
							</form>
						</td>
					</tr>
			
				<%
			}
			out.println("</tbody>");
			out.println("</table>");
		
		}
	%>
	
            
            
            
            
            
            <!-- /.row -->
        </div>
        <!-- /#page-wrapper -->

    </div>
    <!-- /#wrapper -->

    <!-- jQuery Version 1.11.0 -->
    <script src="<%=request.getContextPath()+'/'+Constantes.JSP_BACKOFFICE%>/js/jquery-1.11.0.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="<%=request.getContextPath()+'/'+Constantes.JSP_BACKOFFICE%>/js/bootstrap.min.js"></script>


    <!-- Custom Theme JavaScript -->
    <script src="<%=request.getContextPath()+'/'+Constantes.JSP_BACKOFFICE%>/js/sb-admin-2.js"></script>


	<script src="<%=request.getContextPath()+'/'+Constantes.JSP_BACKOFFICE%>/js/plugins/dataTables/jquery.dataTables.js"></script>
	<script src="<%=request.getContextPath()+'/'+Constantes.JSP_BACKOFFICE%>/js/plugins/dataTables/dataTables.bootstrap.js"></script>


	<script>
		$(document).ready(function(){
			$("#listaPersonas").dataTable();
		});
	</script>

</body>

</html>


