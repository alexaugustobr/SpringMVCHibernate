<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page session="false"%>
<html>
<head>
<link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />
<title>Cartório</title>

</head>
<body>
	<h1 class="h1">Consulta de Cartórios</h1>


	<a class="btn btn btn-warning" href="<c:url value='/cadastrar' />"> <span class="glyphicon glyphicon-file"></span>Novo Cártorio
	</a>
	<br />
	<br />
	<div class="panel panel-default col-md-8 col-sm-12">
		<div class="panel-body ">
			<c:forEach items="${mensagemerros}" var="msg">
				<div class="alert alert-danger alert-dismissible" role="alert">
					<button type="button" class="close" data-dismiss="alert">x</button>
					<span>${msg}</span>
				</div>
			</c:forEach>
			<c:if test="${!empty mensagem}">
				<div class="alert alert-success alert-dismissible" role="alert">
					<button type="button" class="close" data-dismiss="alert">x</button>
					<span>${mensagem}</span>
				</div>
			</c:if>
			<form id="atualizarForm" method="post" action="/editar/todos" autocomplete="off">
				<div class="form-group">
					<table class="table table-bordered table-striped">
						<thead>
							<tr>
								<th class="text-center col-md-1">#</th>
								<th class="col-md-2">Nome</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${cartorios}" var="cartorio" varStatus="status">
								<tr>
									<td><input type="hidden" name="cartorios[${status.index}].id" value="${cartorio.id}">${cartorio.id}</td>

									<td>
										<div class="form-group  has-error">
											<input type="text" class="form-control " name="cartorios[${status.index}].nome" value="${cartorio.nome}" style="width: 70px;">
										</div>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				<button id="atualizarButton" type="submit" class="btn btn-primary">Salvar</button>
			</form>
		</div>
	</div>
</body>
</html>
