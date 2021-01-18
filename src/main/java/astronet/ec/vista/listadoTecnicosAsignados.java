<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"
	xmlns:ui="http://java.sun.com/jsf/facelets"
	xmlns:f="http://java.sun.com/jsf/core"
	xmlns:p="http://primefaces.org/ui"
	xmlns:a="http://xmlns.jcp.org/jsf/passthrough"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:c="http://xmlns.jcp.org/jsp/jstl/core">

<h:head>

	<!-- Required meta tags -->
	<meta charset="utf-8" />
	<meta name="viewport"
		content="width=device-width, initial-scale=1, shrink-to-fit=no" />

	<title>Reportes</title>

	<link rel="stylesheet"
		href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" />
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
	<link rel="stylesheet" href="resources/assets/css/table.css" />
	<link rel="stylesheet" href="resources/assets/css/fondo.css" />

	<!-- Bootstrap CSS -->
	<!--     <link rel="stylesheet" href="resources/bootstrap/css/bootstrap.min.css"/> -->
	<!-- CSS personalizado -->
	<link rel="stylesheet" href="resources/main.css" />

	<!--datables CSS básico-->
	<!--     <link rel="stylesheet" type="text/css" href="resources/datatables/datatables.min.css"/> -->
	<!--     datables estilo bootstrap 4 CSS   -->
	<link rel="stylesheet" type="text/css"
		href="resources/datatables/DataTables-1.10.18/css/dataTables.bootstrap4.min.css" />

	<!--     font awesome con CDN   -->
	<link rel="stylesheet"
		href="https://use.fontawesome.com/releases/v5.8.2/css/all.css"
		integrity="sha384-oS3vJWv+0UjzBfQzYUhtDYW+Pj2yciDJxpsK1OYPAYjqT085Qq/1cq5FLXAZQ7Ay"
		crossorigin="anonymous" />

	<script type="text/javascript" src="resources/assets/js/permisos.js">
	</script>

</h:head>
<body>
	<nav class="navbar navbar-default">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand" href="callcenter.xhtml"><img
				src="resources/assets/img/logo.png" /></a>
		</div>
		<ul class="nav navbar-nav">
			<li class="dropdown"><a class="dropdown-toggle"
				data-toggle="dropdown" href="callcenter.xhtml">Call Center <span
					class="caret"></span></a>
				<ul class="dropdown-menu">
					<li><a href="registro.xhtml">Registros</a></li>
					<li><a href="listadoInstalaciones.xhtml">Instalaciones</a></li>
					<li><h:form>
							<p:commandButton class="nuevaInstalacion"
								onclick="$('#myModal').modal('show')"></p:commandButton>
						</h:form></li>

				</ul></li>

			<li class="dropdown"><a class="dropdown-toggle"
				data-toggle="dropdown" href="#" onclick="acceso()">Clientes<span
					class="caret"></span></a>
				<ul class="dropdown-menu">
					<li><a href="clientes1.xhtml" id="boton">Clientes</a></li>
					<li><a href="registrarEmpleado.xhtml" id="boton12">Empleado</a></li>
				</ul></li>

		</ul>

		<ul class="nav navbar-nav navbar-right">
			<li><a> #{login.empleado.nombre}</a></li>
			<li><a id="dep"> #{login.empleado.departamento}</a></li>
			<li><h:form>
					<a> <h:commandButton class="btnExit" action="#{login.logout()}"
							value="Exit" image="./resources/assets/img/exit.png" />
					</a>
				</h:form></li>

		</ul>

	</div>
	</nav>
	<div style="height: 50px"></div>
	<div class="centerTexto">
		<h2>Listado de Verificacion</h2>
	</div>

	<!--Ejemplo tabla con DataTables-->
	<div class="container">
		<div class="row">
			<div class="col-lg-12">
				<div class="table-responsive">
					<h:dataTable id="example"
						class="table table-striped table-bordered" cellspacing="0"
						width="100%" style="text-align:center;"
						value="#{visitaController.listadoVisitas}" var="agendamiento"
						border="1">
						<h:column>
							<f:facet name="header" data-field="salary" data-sortable="true">Tecnico</f:facet>
												#{agendamiento.empleado.nombre }
											</h:column>
						<h:column>
							<f:facet name="header" data-field="country" data-sortable="true">Nombre Cliente</f:facet>
					
								#{agendamiento.cliente.nombre}
						</h:column>


						<h:column>
							<f:facet name="header">Coordens</f:facet>
							<h:column>
								#{agendamiento.cliente.latitud}
								
							</h:column>
							<h:column>
								#{agendamiento.cliente.longitud}								
							</h:column>

						</h:column>

						<h:column>
							<f:facet name="header">Deoartamento</f:facet>

							<h:column>
								#{agendamiento.empleado.departamento}
								
							</h:column>

						</h:column>


						<h:column>
							<f:facet name="header">Hora</f:facet>

							<h:column>
								#{agendamiento.registro.fechaHora}
							</h:column>
						</h:column>
<!-- 						<h:column> -->
<!-- 						<f:facet name="header">Contactos</f:facet> -->
<!-- 							<c:forEach var="#{telefono}" -->
<!-- 								items="${clienteController.cliente.telefonos}"> -->
<!-- 									<h:outputText value="#{telefono.telNumero}" /> -->
<!-- 							</c:forEach> -->
<!-- 						</h:column> -->

								<h:column styleClass="columnacontacto">
													<f:facet name="header" data-sortable="true">Contacto</f:facet>
													<h:form id="list">
														<h:dataTable id="kuka" value="#{clienteController.cliente.telefonos}" var="t"
															headerClass="cabeceraTabla" rowClasses="filaPar,filaImpar"
															style="width:100%">
															<h:column>
																<span class="glyphicon glyphicon-earphone"></span>
																<h:outputText value="#{t.telNumero}" size="100" />
															</h:column>
														</h:dataTable>
													</h:form>
												
												</h:column>						
						<h:column>
							<f:facet name="header">Acciones</f:facet>
							<h:column>
								<h:form>
									<h:commandButton class="btn btn-primary btnIn"
										action="#{clienteController.cambioTecnico(agendamiento.id,agendamiento.registro.id,agendamiento.cliente.id)}"
										value="Cambiar Tecnico" immediate="true" />
								</h:form>
							</h:column>
						</h:column>