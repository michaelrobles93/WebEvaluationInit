<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags/" prefix="t"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/resources/" var="resourcePath" />

<link href="${resourcePath}css/plugins/chosen/chosen.css" rel="stylesheet">
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

<t:pageTemplate title="Relatório - Web Evaluation">
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
				<form:form action="list.html"
						modelAttribute="relatorio" role="form">
					<div class="ibox-title">
						<h5>Relatório</h5>
					</div>
					<div class="row" style="margin: 0;">
						<div class="ibox-title">
							<h5>Empresa</h5>
						</div>
					</div>
					<div class="ibox-content">
						<div class="checkbox i-checks">
							<table>
							<tbody>
								<tr>
								<form:select path="empresa.id" id="empresa"
										cssClass="form-control chosen-select" cssErrorClass="form-control error" >
									<form:option value="0" label="Todas" />
									<c:forEach items="${lstEmpresa}" var="empresa">
										<form:option value="${empresa.id}" label="${empresa.razaoSocial}" />
									</c:forEach>
								</form:select>
						 		</tr>
						 	</tbody>
					 		</table>
					 	</div>
					</div>
					<div class="row" style="margin: 0;">
						<div class="ibox-title">
							<h5>Habilidades</h5>
						</div>
					</div>
					<div class="ibox-content">
						<div class="checkbox i-checks">
							<table>
							<tbody>
								<tr>
								<c:forEach items="${lstHabilidade}" var="habilidade">
									<c:if test="${i % total == 0}">
										</tr>
										<tr>
									</c:if>
						 			<td><label><form:checkbox path="lstHabilidade" value="${habilidade.id}" checked="" /> ${habilidade.nomeHabilidade}</label></td>
						 			<c:set var="i" value="${i+1}"/>
						 		</c:forEach>
						 		</tr>
						 	</tbody>
					 		</table>
					 	</div>
					</div>
					<div class="row" style="margin: 0;">
						<div class="ibox-title">
							<h5>Educação</h5>
						</div>
					</div>
					<div class="ibox-content">
						<div class="checkbox i-checks">
							<c:set var="i" value="${0}"/>
							<table>
							<tbody>
								<tr>
								<c:forEach items="${lstEducacao}" var="educacao">
					 				<c:if test="${i % total == 0}">
										</tr>
										<tr>
									</c:if>
						 			<td><label><form:checkbox path="lstEducacao" value="${educacao.value}" checked="" /> ${educacao.descricao}</label></td>
						 			<c:set var="i" value="${i+1}"/>
					 			</c:forEach>
					 			</tr>
					 		</tbody>
					 		</table>
					 	</div>
					 </div>
					 <div class="row" style="margin: 0;">
						<div class="ibox-title">
							<h5>Função</h5>
						</div>
					 </div>
					 <div class="ibox-content">
						<div class="checkbox i-checks">
							<c:set var="i" value="${0}"/>
							<table>
							<tbody>
								<tr>
								<c:forEach items="${lstFuncao}" var="funcao">
					 				<c:if test="${i % total == 0}">
										</tr>
										<tr>
									</c:if>
						 			<td><label><form:checkbox path="lstFuncao" value="${funcao.id}" checked="" /> ${funcao.descricao}</label></td>
						 			<c:set var="i" value="${i+1}"/>
					 			</c:forEach>
					 			</tr>
					 		</tbody>
					 		</table>
					 	</div>
					 </div>
					 <div class="row" style="margin: 0;">
						<div class="ibox-title">
							<h5>Gênero</h5>
						</div>
					 </div>
					 <div class="ibox-content">
						<div class="checkbox i-checks">
							<c:set var="i" value="${0}"/>
							<table>
							<tbody>
								<tr>
								<c:forEach items="${lstGenero}" var="genero">
					 				<c:if test="${i % total == 0}">
										</tr>
										<tr>
									</c:if>
						 			<td><label><form:checkbox path="lstGenero" value="${genero}" checked="" /> ${genero.descricao}</label></td>
						 			<c:set var="i" value="${i+1}"/>
					 			</c:forEach>
					 			</tr>
					 		</tbody>
					 		</table>
					 	</div>
						<div class="row">
							<div class="col-md-12">
								<button class="btn btn-primary pull-right" type="submit">
									<strong>Procurar</strong>
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

<!-- iCheck -->
<script src="${resourcePath}js/plugins/iCheck/icheck.min.js"></script>

<script>
	document.getElementById("relatorio").setAttribute("class", "active");
	document.getElementById("formRelatorio").setAttribute("class", "active");
 
	 $(document).ready(function () {
         $('.i-checks').iCheck({
             checkboxClass: 'icheckbox_square-green',
             radioClass: 'iradio_square-green',
         });
     });
	 
</script>