<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<html>
<head>
<link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />
<title>Cartório</title>

</head>
<body>

	<c:if test="${empty cartorio.nome}">
		<h1 class="h1">Novo Cartório</h1>
	</c:if>
	<c:if test="${!empty cartorio.nome}">
		<h1 class="h1">Editando um Cartório</h1>
	</c:if>
	<a class="btn btn btn-info" href="<c:url value='/' />"> <span class="glyphicon glyphicon-backward"></span>Consulta
	</a>
	<c:if test="${!empty cartorio.nome}">
		<a class="btn btn btn-warning" href="<c:url value='/cadastrar' />"> <span class="glyphicon glyphicon-file"></span>Novo Cártorio
		</a>
	</c:if>
	<c:url var="addAction" value="/cadastrar">
	</c:url>
	<br />
	<br />

	<div class="panel panel-default   col-md-8 col-sm-12">
		<div class="panel-body ">
			<c:if test="${!empty mensagemerro}">
				<div class="alert alert-danger alert-dismissible" role="alert">
					<button type="button" class="close" data-dismiss="alert">x</button>
					<span>${mensagemerro}</span>
				</div>
			</c:if>
			<c:if test="${!empty mensagem}">
				<div class="alert alert-success alert-dismissible" role="alert">
					<button type="button" class="close" data-dismiss="alert">x</button>
					<span>${mensagem}</span>
				</div>
			</c:if>
			<form:form cssClass="form-horizontal" action="${addAction}" commandName="cartorio">
				<c:forEach items="${mensagemerros}" var="msg">
					<p>-${msg}</p>
				</c:forEach>
				<form:errors path="*"></form:errors>
				<form:errors path="endereco.*"></form:errors>
				<c:if test="${not empty cartorio.nome}">
					<div class="form-group">
						<label for="nome" class="col-sm-2 control-label">ID</label>
						<div class="col-sm-6">
							<form:input cssClass="form-control col-sm-2" path="id" readonly="true" size="8" disabled="true" />
							<form:hidden path="id" />
						</div>
					</div>
				</c:if>

				<div class="form-group">
					<label for="nome" class="col-sm-2 control-label">Nome do Cartório</label>
					<div class="col-sm-6">
						<form:input cssClass="form-control col-sm-6" path="nome" />
					</div>
				</div>
				<c:if test="${not empty cartorio.enderecos}">
					<c:forEach items="${cartorio.enderecos}" var="endereco" varStatus="s">
						<div class="form-group">
							<label for="nome" class="col-sm-2 control-label">ID endereco cartorio</label>
							<div class="col-sm-6">
								<form:input cssClass="form-control col-sm-2" path="enderecos[${s.index}].id" readonly="true" size="8" disabled="true" />
								<form:hidden path="enderecos[${s.index}].id" />
								<form:input cssClass="form-control col-sm-2" path="enderecos[${s.index}].cartorio.id" readonly="true" size="8" disabled="true" />
								<form:hidden path="enderecos[${s.index}].cartorio.id" />
							</div>
						</div>
					</c:forEach>
				</c:if>
				<c:if test="${empty cartorio.enderecos}">
					<div class="form-group">
						<label for="nome" class="col-sm-2 control-label">Rua</label>
						<div class="col-sm-6">
							<form:input cssClass="form-control col-sm-6" path="enderecos[0].rua" />
						</div>
					</div>
					<div class="form-group">
						<label for="nome" class="col-sm-2 control-label">Numero</label>
						<div class="col-sm-6">
							<form:input cssErrorClass="has-error" cssClass="form-control col-sm-6" path="enderecos[0].numero" />
						</div>
					</div>
				</c:if>

				<div class="form-group">
					<div class="col-sm-offset-2   col-sm-4">

						<c:if test="${!empty cartorio.nome}">
							<input type="submit" class="btn btn-primary" value="<spring:message text="Editar Cartorio"/>" />
						</c:if>
						<c:if test="${empty cartorio.nome}">
							<input class="btn btn-primary" type="submit" value="<spring:message text="Adionar Cartorio"/>" />
						</c:if>
					</div>
				</div>


			</form:form>








		</div>
	</div>









</body>
</html>
