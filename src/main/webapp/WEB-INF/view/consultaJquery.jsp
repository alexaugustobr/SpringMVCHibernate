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
	<h1 class="h1">Consulta de Cartórios</h1>


	<a class="btn btn btn-warning" href="<c:url value='/cadastrar' />"> <span class="glyphicon glyphicon-file"></span>Novo Cártorio
	</a>
	<br />
	<br />
	<div class="panel panel-default col-md-8 col-sm-12">
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

			<div class="form-group">
				<c:if test="${!empty listCartorios}">
					<table class="table table-bordered table-striped">
						<thead>
							<tr>
								<th class="text-center col-md-1">#</th>
								<th class="col-md-2">Nome</th>
								<th class="text-center col-md-1">Editar</th>
								<th class="text-center col-md-1">Deletar</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${listCartorios}" var="cartorio">
								<tr>
									<td class="text-center">${cartorio.id}</td>
									<td>${cartorio.nome}</td>
									<td class="text-center"><a class="btn btn-link btn-xs" href="<c:url value='/editar/${cartorio.id}' />"><span class="glyphicon glyphicon-pencil"></span></a></td>
									<td class="text-center"><a class="btn btn-link btn-xs" href="<c:url value='/remover/${cartorio.id}' />"> <span class="glyphicon glyphicon-remove"></span></a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>


				</c:if>
			</div>


		</div>
	</div>
</body>
<script src="/assets/js/jquery-3.2.1.min.js"></script>

<script>
	function atualizarTable() {
	
// 	containerDiv.hide();
	
// 	tableBody.empty();
	
// 	salvarBtn.attr( "disabled", true);
	
	var resposta = $.ajax({
		type: 'get',
		url: '/cartorios'
		//,
// 		data: {
// 			projetoId: projetoId
// 		}
	});
	
	resposta.done(function(data) {
		console.log(data);
// 			$.each(data, function(key, json) {
// 				console.log(json.cartorio.endereco);
// 			});
	});
// 	resposta.fail(function(tarefas) {
// 		$('<p/>', {
// 			text: 'Nenhuma tarefa para deploy neste projeto'
// 		}).appendTo(container);
		
// 	});
	}
	
	
	$(document).ready(function() {
		//var salvarBtn = $('#salvarBtn');
		atualizarTable();
		
	});
</script>
</html>
