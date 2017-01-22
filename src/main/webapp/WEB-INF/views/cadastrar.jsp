<%@ include file="header.jsp" %>
<div class="col-md-8 col-md-offset-2">
	<div id="main-panel" class="well">
		<h1 class="text-center">Novo Contato</h1>
		<form action="<c:url value='/salvar' />" method="post">
			<div class="form-group">
				<label for="nome">Nome:</label>
				<input type="text" class="form-control" name="nome" value="${contato.nome}" />
				<form:errors path="contato.nome" class="label-error" />
			</div>
			<div class="form-group">
				<label for="telefone">Telefone:</label>
				<input type="text" class="form-control" name="telefone" value="${contato.telefone}" />
				<form:errors path="contato.telefone" class="label-error" />
			</div>
			<div class="form-group">
				<label for="email">E-mail:</label>
				<input type="text" class="form-control" name="email" value="${contato.email}" />
				<form:errors path="contato.email" class="label-error" />
			</div>
			<button class="btn btn-primary btn-block" type="submit">Salvar</button>
		</form>
	</div>
</div>
<%@ include file="footer.jsp" %>