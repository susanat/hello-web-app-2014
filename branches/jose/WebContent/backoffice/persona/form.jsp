<%@page import="com.ipartek.formacion.helloweb.bean.Persona"%>
<%@page import="com.ipartek.formacion.helloweb.bean.Persona.Rol"%>
<%@page import="com.ipartek.formacion.helloweb.Constantes"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
	//crear persona nueva
	Persona p = (Persona) request.getAttribute(Constantes.ATT_PERSONA);
	String cabecera = "Crear nueva Persona";
	String buttonValue = "Crear";
	String op = Constantes.OP_CREATE;
	boolean isNew = true;
	if (p == null) {
		p = new Persona("");
	} else {
		cabecera = "Modificar " + p.getNombre();
		buttonValue = "Modificar";
		isNew = false;
		op = Constantes.OP_UPDATE;
	}
%>



<%@include file="/includes/head.jsp"%>
<%@include file="/includes/nav.jsp"%>

<!-- 
<div id="page-wrapper">

	<!-- TITULO -->
	<!-- 
	<div class="row">
		<div class="col-lg-12">
			<h1 class="page-header"><%=cabecera%></h1>
		</div>
		<!-- class="col-lg-12" -->
	<!-- 	
	</div>
	<!-- class="row" -->

	<!-- BOTON -->
	<div class="row">
		<div class="col-lg-12">
			<div class="panel panel-default">
				<div class="panel-heading">
					<%=cabecera%>
				</div>

				<div class="panel-body">
					<div class="row">
						<div class="col-lg-6">
							<h2>
								<a
									href="<%=request.getContextPath() + "/"
					+ Constantes.CONTROLLER_PERSONA%>">volver</a>
							</h2>
						</div>
						<!-- class="col-lg-6" -->
					</div>
					<!-- class="row" -->

					<div class="row">
						<div class="col-lg-6">
							<form role="form"
								action="
								<%=request.getContextPath() + "/"
					+ Constantes.CONTROLLER_PERSONA%>"
								method="post">
								<div class="form-group">
									<label>Id</label> <input name="id" type="text"
										value="<%=p.getId()%>" readonly class="form-control">
								</div>
								<div class="form-group">
									<label>Nombre</label> <input name="name" type="text"
										placeholder="Escriba un nombre" class="form-control"
										value="<%=p.getNombre()%>">
								</div>
								<div class="form-group">
									<label>Edad</label> <input name="edad" type="numeric"
										placeholder="Escriba una edad" class="form-control"
										value="<%=p.getEdad()%>">
								</div>

								<div class="form-group">
									<label>Rol</label> 
									<select name="rol" class="form-control" display="none">
										<%for (Rol rol:Rol.values()){
											%>
											<option value ="<%=rol%>" <%=rol.equals(p.getRol()) ? "selected" : ""%>><%=rol%></option>
											<%
										}
										%>
									</select>
									<!-- 
                                            <label>Rol</label>
                                            <div class="radio">
                                                <label>
                                                    <input type="radio" checked="" value="option1" id="optionsRadios1" name="optionsRadios"><%=Persona.Rol.ADMINISTRADOR%>
                                                </label>
                                            </div>
                                            <div class="radio">
                                                <label>
                                                    <input type="radio" value="option2" id="optionsRadios2" name="optionsRadios"><%=Persona.Rol.USER%>
                                                </label>
                                            </div>
                                         -->
								</div>
								<!--
								<input name="rol" type="text" readonly value="<%=p.getRol()%>">
								 -->
								<input type="hidden" name="<%=Constantes.OP_KEY%>"
									value="<%=op%>">
								<button class="btn btn-outline btn-primary" type="submit"><%=buttonValue%></button>

							</form>
							<!-- Form INSERT/UPDATE -->

						</div>
						<!-- class="col-lg-6" -->
					</div>
					<!-- class="row" -->
				</div>
				<!-- class="panel-body" -->

			</div>
			<!-- class="panel panel-default" -->
		</div>
		<!-- class="col-lg-12" -->
	</div>
	<!-- class="row" -->
	<%@include file="/includes/footer.jsp"%>