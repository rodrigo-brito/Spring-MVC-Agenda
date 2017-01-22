<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>${ title }</title>
<link rel="stylesheet"
	href="<c:url value='resources/node_modules/bootstrap/dist/css/bootstrap.min.css' />" />
<link rel="stylesheet" href="<c:url value='resources/css/style.css' />" />
</head>
<body>
	<!-- Static navbar -->
	<nav class="navbar navbar-default">
		<div class="container">
			<div class="navbar-header">
				<a class="navbar-brand" href="<c:url value='/' />">Agenda Hiber-Spring</a>
			</div>
			<ul class="nav navbar-nav">
				<li><a href="<c:url value='/listar' />"><i class="glyphicon glyphicon-list-alt"> </i> Listar Contatos</a></li>
				<li><a href="<c:url value='/cadastrar' />"><i class="glyphicon glyphicon-plus"> </i> Novo Contato</a></li>
			</ul>
			<!--/.nav-collapse -->
		</div>
		<!--/.container-fluid -->
	</nav>
	<div class="container">
		<div id="messages">
			<c:if test="${ not empty param.message }">
				<div class="alert alert-success">
					<p>${ param.message }</p>
				</div>
			</c:if>
			<c:if test="${ not empty error }">
				<div class="alert alert-danger">
					<p>${ error }</p>
				</div>
			</c:if>		
		</div>
		<div class="row">