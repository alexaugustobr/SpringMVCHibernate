<%@ taglib
  uri="http://java.sun.com/jsp/jstl/core"
  prefix="c"%>
<%@ taglib
  uri="http://www.springframework.org/tags"
  prefix="spring"%>
<%@ taglib
  uri="http://www.springframework.org/tags/form"
  prefix="form"%>
<%@ page session="false"%>
<html>
<head>
<link
  rel="stylesheet"
  type="text/css"
  href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />
<title>Cart�rio</title>

</head>
<body>

  <c:if test="${empty cartorio.nome}">
    <h1 class="h1">Novo Cart�rio</h1>
  </c:if>
  <c:if test="${!empty cartorio.nome}">
    <h1 class="h1">Editando um Cart�rio</h1>
  </c:if>
  <a
    class="btn btn btn-info"
    href="<c:url value='/' />"> <span
    class="glyphicon glyphicon-backward"></span>Consulta
  </a>
  <c:if test="${!empty cartorio.nome}">
    <a
      class="btn btn btn-warning"
      href="<c:url value='/cadastrar' />"> <span
      class="glyphicon glyphicon-file"></span>Novo C�rtorio
    </a>
  </c:if>
  <c:url
    var="addAction"
    value="/cadastrar">
  </c:url>
<br/><br/>

  <div class="panel panel-default   col-md-8 col-sm-12">
    <div class="panel-body ">
      <c:if test="${!empty mensagemerro}">
        <div
          class="alert alert-danger alert-dismissible"
          role="alert">
          <button
            type="button"
            class="close"
            data-dismiss="alert">x</button>
          <span>${mensagemerro}</span>
        </div>
      </c:if>
      <c:if test="${!empty mensagem}">
        <div
          class="alert alert-success alert-dismissible"
          role="alert">
          <button
            type="button"
            class="close"
            data-dismiss="alert">x</button>
          <span>${mensagem}</span>
        </div>
      </c:if>
      <form:form
        cssClass="form-horizontal"
        action="${addAction}"
        commandName="cartorio">

        <c:if test="${!empty cartorio.nome}">
          <div class="form-group">
            <label
              for="nome"
              class="col-sm-2 control-label">ID</label>
            <div class="col-sm-6">
              <form:input
                cssClass="form-control col-sm-2"
                path="id"
                readonly="true"
                size="8"
                disabled="true" />
              <form:hidden path="id" />
            </div>
          </div>
        </c:if>

        <div class="form-group">
          <label
            for="nome"
            class="col-sm-2 control-label">Nome do Cart�rio</label>
          <div class="col-sm-6">
            <form:input
              id="someinput"
              cssClass="form-control col-sm-6"
              required="required"
              path="nome" />
          </div>
        </div>



        <div class="form-group">
          <div class="col-sm-offset-2   col-sm-4">

            <c:if test="${!empty cartorio.nome}">
              <input
                type="submit"
                class="btn btn-primary"
                value="<spring:message text="Editar Cartorio"/>" />
            </c:if>
            <c:if test="${empty cartorio.nome}">
              <input
                class="btn btn-primary"
                type="submit"
                value="<spring:message text="Adionar Cartorio"/>" />
            </c:if>
          </div>
        </div>


      </form:form>








    </div>
  </div>









</body>
</html>
