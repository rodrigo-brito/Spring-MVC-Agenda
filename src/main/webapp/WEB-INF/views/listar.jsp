<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Lista de Contatos</title>
    <link rel="stylesheet" href="<c:url value='resources/node_modules/bootstrap/dist/css/bootstrap.min.css' />" />
	<link rel="stylesheet" href="<c:url value='resources/css/style.css' />" />
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-8 col-md-offset-2">
				<div id="main-panel" class="well">
	    			<h1 class="text-center">Lista de Contatos</h1>
					<table class="table table-striped">
						<tr>
							<th>Nome</th>
							<th>Telefone</th>
							<th>E-mail</th>
							<th></th>
						</tr>
						<c:forEach items="${contatos}" var="contato">
							<tr>
								<td>${contato.nome}</td>
								<td>${contato.telefone}</td>
								<td>${contato.email}</td>
								<td>
									<a href="<c:url value='/editar?id=${contato.id}' />" class="btn btn-primary"><i class="glyphicon glyphicon-pencil"></i></a>
									<a href='<c:url value='/excluir?id=${contato.id}' />' class="btn btn-danger"><i class="glyphicon glyphicon-trash"></i></a>
								</td>
							</tr>
						</c:forEach>
					</table>
				</div>		
			</div>
		</div>
	</div>
</body>
</html>