<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>

<script src="https://code.jquery.com/jquery-2.1.3.min.js"></script>
<title>Home</title>
</head>
<body>
	<h1>Hello world!</h1>

	<P>The time on the server is ${serverTime}.</P>


	<h1>Personas</h1>
	<ol>
		<li><a href="#" id="personaGellAll">GET todas</a></li>
		<li><a href="#" id="personaById">GET by ID</a></li>
		<li><a href="#" id="personaCreate">Create by POST</a></li>
		<li><a href="#" id="personaModificar">Modificar by PUT</a></li>
		<li><a href="#" id="personaDelete">bORRAR by DELETE</a></li>
	</ol>

	<script>
	
	
			

		function getFormatedDate(unix_timestamp) {

			// create a new javascript Date object based on the timestamp
			// multiplied by 1000 so that the argument is in milliseconds, not seconds
			var date = new Date(unix_timestamp * 1000);
			// hours part from the timestamp
			var hours = date.getHours();
			// minutes part from the timestamp
			var minutes = "0" + date.getMinutes();
			// seconds part from the timestamp
			var seconds = "0" + date.getSeconds();

			// will display time in 10:30:23 format
			return hours + ':' + minutes.substr(minutes.length - 2) + ':'
					+ seconds.substr(seconds.length - 2);

		};

		
		

		$('#personaGellAll')
				.click(
						function( evento ) {

							//no ejecute el link
							evento.preventDefault();

							$
									.ajax({
										url : "http://localhost:8080/formacion/persona/",
										type : "GET",
										//data : JSON.stringify(persona),
										contentType : "application/json",
										statusCode : {
											200 : function(response) {
												alert('statusCode: Status 200');
											},
											201 : function(response) {
												alert('statusCode: Status 201');
											},
											400 : function(response) {
												alert('statusCode: Status 400');
											},
											404 : function(response) {
												alert('statusCode: Status 404');
											},
											500 : function(response) {
												alert('statusCode: Status 500'
														+ response);
											}
										},
										success : function(data, textStatus,
												xhr) {
											
											//Recorro el listado devuelto
											 $.each(data.objeto, function() {
												 
												 	//recorro cada campo
											        $.each(this, function(k, v) {
											            alert(k + ' ' + v);
											        });
											 });    
											
										},
										complete : function(xhr, textStatus) {
											console.log("Completo: "
													+ xhr.status);
										},
										error : function(jqXHR, textStatus,
												errorThrown) {

											data = jQuery
													.parseJSON(jqXHR.responseText);

											alert("Datos del error: " + "\n");

											alert("error: " + data.error + "\n");
											alert("typeError: "
													+ data.typeError + "\n");
											alert("msg: " + data.msg + "\n");
											alert("codError: " + data.codError
													+ "\n");
											alert("stackTrace: "
													+ data.stackTrace + "\n");
										}

									});

						});

		$('#personaById').click(function(evento)  {

			evento.preventDefault();

			$
					.ajax({
						url : "http://localhost:8080/formacion/persona/2",
						type : "GET",						
						contentType : "application/json",
						statusCode : {
							200 : function(response) {
								alert('statusCode: Status 200');
							},
							201 : function(response) {
								alert('statusCode: Status 201');
							},
							400 : function(response) {
								alert('statusCode: Status 400');
							},
							404 : function(response) {
								alert('statusCode: Status 404');
							},
							500 : function(response) {
								alert('statusCode: Status 500'
										+ response);
							}
						},
						success : function(data, textStatus,
								xhr) {

							alert('Success respuesta ok'
									+ "\n"
									+ "Id: "
									+ data.objeto.id
									+ "\n"
									+ "Nombre: "
									+ data.objeto.nombre
									+ "\n"
									+ "Apellidos: "
									+ data.objeto.apellidos
									+ "\n"
									+ "Edad: "
									+ data.objeto.edad
									+ "\n"
									+ "Fecha Nac.: "
									+ getFormatedDate(data.objeto.fechaNacimiento)
									+ "\n");

						},
						complete : function(xhr, textStatus) {
							console.log("Completo: "
									+ xhr.status);
						},
						error : function(jqXHR, textStatus,
								errorThrown) {

							data = jQuery
									.parseJSON(jqXHR.responseText);

							//var responseText = jQuery.parseJSON(jqXHR.responseText);
							//alert(responseText);

							alert("Datos del error: " + "\n");

							alert("error: " + data.error + "\n");
							alert("typeError: "
									+ data.typeError + "\n");
							alert("msg: " + data.msg + "\n");
							alert("codError: " + data.codError
									+ "\n");

							alert("stackTrace: "
									+ data.stackTrace + "\n");
						}

					});
		});


		$('#personaCreate')
				.click(
						function(evento) {

							evento.preventDefault();

							var persona = {
								"nombre" : "Creado",
								"apellidos" : "desde home",
								"edad" : 36,
								"fechaNacimiento": Math.floor(Date.now() / 1000)
							};

							$
									.ajax({
										url : "http://localhost:8080/formacion/persona/",
										type : "POST",
										data : JSON.stringify(persona),
										contentType : "application/json",
										statusCode : {
											200 : function(response) {
												alert('statusCode: Status 200');
											},
											201 : function(response) {
												alert('statusCode: Status 201');
											},
											400 : function(response) {
												alert('statusCode: Status 400');
											},
											404 : function(response) {
												alert('statusCode: Status 404');
											},
											500 : function(response) {
												alert('statusCode: Status 500'
														+ response);
											}
										},
										success : function(data, textStatus,
												xhr) {

											alert('Success respuesta ok'
													+ "\n"
													+ "Id: "
													+ data.objeto.id
													+ "\n"
													+ "Nombre: "
													+ data.objeto.nombre
													+ "\n"
													+ "Apellidos: "
													+ data.objeto.apellidos
													+ "\n"
													+ "Edad: "
													+ data.objeto.edad
													+ "\n"
													+ "Fecha Nac.: "
													+ getFormatedDate(data.objeto.fechaNacimiento)
													+ "\n");

										},
										complete : function(xhr, textStatus) {
											console.log("Completo: "
													+ xhr.status);
										},
										error : function(jqXHR, textStatus,
												errorThrown) {

											data = jQuery
													.parseJSON(jqXHR.responseText);

											//var responseText = jQuery.parseJSON(jqXHR.responseText);
											//alert(responseText);

											alert("Datos del error: " + "\n");

											alert("error: " + data.error + "\n");
											alert("typeError: "
													+ data.typeError + "\n");
											alert("msg: " + data.msg + "\n");
											alert("codError: " + data.codError
													+ "\n");

											alert("stackTrace: "
													+ data.stackTrace + "\n");
										}

									});
						});

		$('#personaModificar').click(function() {

			//new Persona("DesdeControler", "yepaaa", 28, new Date()

			$.ajax({
				url : "http://localhost:8080/formacion/persona/",
				type : "POST",
				data : {
					"ID" : 5
				},
				contentType : "application/json",
					statusCode : {
						200 : function(response) {
							alert('statusCode: Status 200');
						},
						201 : function(response) {
							alert('statusCode: Status 201');
						},
						400 : function(response) {
							alert('statusCode: Status 400');
						},
						404 : function(response) {
							alert('statusCode: Status 404');
						},
						500 : function(response) {
							alert('statusCode: Status 500'
									+ response);
						}
					},
					success : function(data, textStatus,
							xhr) {

						alert('Success respuesta ok'
								+ "\n"
								+ "Id: "
								+ data.objeto.id
								+ "\n"
								+ "Nombre: "
								+ data.objeto.nombre
								+ "\n"
								+ "Apellidos: "
								+ data.objeto.apellidos
								+ "\n"
								+ "Edad: "
								+ data.objeto.edad
								+ "\n"
								+ "Fecha Nac.: "
								+ getFormatedDate(data.objeto.fechaNacimiento)
								+ "\n");

					},
					complete : function(xhr, textStatus) {
						console.log("Completo: "
								+ xhr.status);
					},
					error : function(jqXHR, textStatus,
							errorThrown) {

						data = jQuery
								.parseJSON(jqXHR.responseText);

						//var responseText = jQuery.parseJSON(jqXHR.responseText);
						//alert(responseText);

						alert("Datos del error: " + "\n");

						alert("error: " + data.error + "\n");
						alert("typeError: "
								+ data.typeError + "\n");
						alert("msg: " + data.msg + "\n");
						alert("codError: " + data.codError
								+ "\n");

						alert("stackTrace: "
								+ data.stackTrace + "\n");
					}

				});
	});
		
			
		$('#personaDelete').click(function() {

			//new Persona("DesdeControler", "yepaaa", 28, new Date()

			var persona = {
				"id" : 1,
				"nombre" : "Modificado",
				"apellidos" : "Por home",
				"edad" : 40,
				"fechaNacimiento" : Math.floor(Date.now() / 1000)

			};

			$.ajax({
				url : "http://localhost:8080/formacion/persona/",
				type : "PUT",
				data : JSON.stringify(persona),
				contentType : "application/json",
				statusCode : {
					200 : function(response) {
						alert('statusCode: Status 200');
					},
					201 : function(response) {
						alert('statusCode: Status 201');
					},
					400 : function(response) {
						alert('statusCode: Status 400');
					},
					404 : function(response) {
						alert('statusCode: Status 404');
					},
					500 : function(response) {
						alert('statusCode: Status 500'
								+ response);
					}
				},
				success : function(data, textStatus,
						xhr) {

					alert('Success respuesta ok'
							+ "\n"
							+ "Borrado: "
							+ data.objeto);

				},
				complete : function(xhr, textStatus) {
					console.log("Completo: "
							+ xhr.status);
				},
				error : function(jqXHR, textStatus,
						errorThrown) {

					data = jQuery
							.parseJSON(jqXHR.responseText);

					//var responseText = jQuery.parseJSON(jqXHR.responseText);
					//alert(responseText);

					alert("Datos del error: " + "\n");

					alert("error: " + data.error + "\n");
					alert("typeError: "
							+ data.typeError + "\n");
					alert("msg: " + data.msg + "\n");
					alert("codError: " + data.codError
							+ "\n");

					alert("stackTrace: "
							+ data.stackTrace + "\n");
				}

			});
});
	</script>

</body>
</html>
