<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags/" prefix="t"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/resources/" var="resourcePath" />

<!-- Toastr style -->
<link href="${resourcePath}css/plugins/toastr/toastr.min.css" rel="stylesheet">
<link href="${resourcePath}css/plugins/iCheck/custom.css" rel="stylesheet">

<c:set var="i" value="${0}" />
<c:set var="total" value="${3}" />

<style>
	.checkbox label::before {display: none !important;}
	table {width: 100%;}
	table td{width: 33%;}
</style>

<t:pageTemplate title="Cadastrar Usuários - Web Evaluation">
	<jsp:attribute name="extraJs">
      <t:js path="js/plugins/jasny/jasny-bootstrap.min.js"></t:js>
	</jsp:attribute>
	<jsp:attribute name="extraCss">
		<t:css
			path="css/plugins/awesome-bootstrap-checkbox/awesome-bootstrap-checkbox.css"></t:css>
	</jsp:attribute>
	<jsp:body>
	<div class="row">
		<div class="col-lg-12">
			<div class="ibox float-e-margins">
				<form:form action="${s:mvcUrl('UC#novo').build()}.html"
						commandName="usuario" role="form">
					<div class="ibox-title">
						<h5>Cadastro de Usuários</h5>
					</div>
					<div class="ibox-content">
						<form:hidden path="id" />
						<div class="row">
							<div class="col-md-6">
								<div class="form-group">
									<label>Nome</label> <form:input path="nome" cssClass="form-control"
											cssErrorClass="form-control error" />
									<form:errors element="label" cssClass="error" path="nome" />
								</div>
							</div>
							<div class="col-md-6">
								<div class="form-group">
									<label>Sobrenome</label> <form:input path="sobrenome" cssClass="form-control"
											cssErrorClass="form-control error" />
									<form:errors element="label" cssClass="error" path="sobrenome" />
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-12">
								<div class="form-group">
									<label>E-mail</label> <form:input path="email" cssClass="form-control"
											cssErrorClass="form-control error" />
									<form:errors element="label" cssClass="error" path="email" />
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-6">
								<div class="form-group">
									<label>Usuário</label> <form:input path="usuario" cssClass="form-control"
											cssErrorClass="form-control error" />
									<form:errors element="label" cssClass="error" path="usuario" />
								</div>
							</div>
							<c:if test="${usuario.id == null }">
							<div class="col-md-6">
								<div class="form-group">
									<label>Senha</label> <form:password path="senha" cssClass="form-control"
											cssErrorClass="form-control error" />
									<form:errors element="label" cssClass="error" path="senha" />
								</div>
							</div>
							</c:if>
						</div>
						<div class="row" style="margin: 0;">
							<div class="ibox-title">
								<h5>Permissões</h5>
							</div>
						</div>
						<div class="ibox-content">
							<div class="checkbox i-checks">
								<c:set var="i" value="${0}"/>
								<table>
								<tbody>
									<tr>
									<c:choose>
										<c:when test="${usuario.id == null}">
											<c:forEach items="${lstRole}" var="role">
												<c:if test="${i % total == 0}">
													</tr>
													<tr>
												</c:if>
									 			<td><label><form:checkbox path="role" value="${role.id}" checked="" /> ${role.role}</label></td>
									 			<c:set var="i" value="${i+1}"/>
									 		</c:forEach>
										</c:when>
										<c:otherwise>
											<c:forEach items="${lstRole}" var="role">
												<c:set var="isSelected" value="${false}" />
												<c:if test="${i % total == 0}">
													</tr>
													<tr>
												</c:if>
												<c:forEach items="${usuario.role}" var="usuarioRole">
													<c:if test="${role.id == usuarioRole.id}">
														<c:set var="isSelected" value="${true}" />
													</c:if>
												</c:forEach>
												<c:choose>
													<c:when test="${isSelected}">
														<td><label><form:checkbox path="role" value="${role.id}" checked="checked" /> ${role.role}</label></td>
														<c:set var="i" value="${i+1}"/>
													</c:when>
													<c:otherwise>
														<td><label><form:checkbox path="role" value="${role.id}" checked="" /> ${role.role}</label></td>
														<c:set var="i" value="${i+1}"/>
													</c:otherwise>
												</c:choose>
											</c:forEach>
										</c:otherwise>
									</c:choose>
							 		</tr>
							 	</tbody>
						 		</table>
						 	</div>
						</div>
						<div class="row">
							<div class="col-md-12">
								<button class="btn btn-primary pull-right" type="submit">
									<strong>Cadastrar</strong>
								</button>
							</div>
						</div>
					</div>
				</form:form>
			</div>
		</div>
	</div>
</jsp:body>
</t:pageTemplate>

<!-- Chosen -->
<script src="${resourcePath}js/plugins/chosen/chosen.jquery.js"></script>

<script	src="${resourcePath}js/plugins/dataTables/dataTables.bootstrap.js"></script>
<script	src="${resourcePath}js/plugins/dataTables/dataTables.responsive.js"></script>
<script	src="${resourcePath}js/plugins/dataTables/dataTables.tableTools.min.js"></script>

<!-- Toastr script -->
<script src="${resourcePath}js/plugins/toastr/toastr.min.js"></script>
<!-- iCheck -->
<script src="${resourcePath}js/plugins/iCheck/icheck.min.js"></script>
<script>

	$(document).ready(function() {
		var msgSucesso = "Os dados do usuário foram cadastrados!";
		var msgErro = "Houve um erro ao cadastrar os dados do usuário!";
	
		toastr.options = {
		  "closeButton": true,
		  "debug": false,
		  "progressBar": false,
		  "positionClass": "toast-top-full-width",
		  "onclick": null,
		  "showDuration": "200",
		  "hideDuration": "1000",
		  "timeOut": "7000",
		  "extendedTimeOut": "1000",
		  "showEasing": "swing",
		  "hideEasing": "linear",
		  "showMethod": "fadeIn",
		  "hideMethod": "fadeOut"
		}
		
		if (${sucesso} == 1){
			toastr.success(msgSucesso, 'Sucesso');	
		}else{
			if (${sucesso} == 0){
				toastr.error(msgErro,'Erro');
			}
		}	
	});
 
	 $(document).ready(function () {
         $('.i-checks').iCheck({
             checkboxClass: 'icheckbox_square-green',
             radioClass: 'iradio_square-green',
         });
     });

	document.getElementById("admin").setAttribute("class", "active");
	document.getElementById("usuario").setAttribute("class", "active");
	document.getElementById("formUsuario").setAttribute("class", "active");
</script>