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

<t:pageTemplate title="Cadastrar Cargo - Web Evaluation">
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
				<form:form action="novo.html"
						commandName="cargo" role="form">
					<div class="ibox-title">
						<h5>Cadastro de Cargo</h5>
					</div>
					<div class="ibox-content">
						<form:hidden path="id" />
						<div class="row">
							<div class="col-md-12">
								<div class="form-group">
									<label>Cargo</label>
									<div class="input-group">
										<form:input path="nomeCargo"
												cssClass="form-control" cssErrorClass="form-control error" />
										<form:errors element="label" cssClass="error" path="nomeCargo" />
									</div>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-6">
								<div class="form-group">
									<label>CBO</label>
									<div class="input-group">
										<form:select path="cbo"
												cssClass="form-control chosen-select" cssErrorClass="form-control error" >
											<form:option value="0" label="Selecione uma opção" />
											<c:forEach items="${lstCbo}" var="cbo">
												<form:option value="${cbo.id}" label="${cbo.id} - ${cbo.nomeCargo}" />
											</c:forEach>
										</form:select>
										<form:errors element="label" cssClass="error" path="cbo" />
									</div>
								</div>
							</div>
							<div class="col-md-6">
								<div class="form-group">
									<label>Cargo Superior Direto</label> 
									<div class="input-group">
										<form:select path="cargoSuperiorDireto"
												cssClass="form-control chosen-select" cssErrorClass="form-control error" >
											<form:option value="0" label="Selecione uma opção" />
											<c:forEach items="${lstCargo}" var="cbo">
												<form:option value="${cargo.id}" label="${cargo.nomeCargo}" />
											</c:forEach>
										</form:select>
									</div>
									<form:errors element="label" cssClass="error"
											path="cargoSuperiorDireto" />
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-6">
								<div class="form-group">
									<label>Empresa</label> 
									<form:select path="empresa"
											cssClass="form-control chosen-select" cssErrorClass="form-control error" >
										<form:option value="0" label="Selecione uma opção" />
										<c:forEach items="${lstEmpresa}" var="empresa">
											<form:option value="${empresa}" label="${empresa.razaoSocial}" />
										</c:forEach>
									</form:select>
									<form:errors element="label" cssClass="error"
											path="empresa" />
								</div>
							</div>
							<div class="col-md-6">
								<div class="form-group">
									<label>Função</label> 
									<div class="input-group">
										<form:select path="funcao" cssClass="form-control" 
												cssErrorClass="form-control error" >
											<form:option value="0" label="Selecione uma opção" />
											<c:forEach items="${lstFuncao}" var="funcao">
												<form:option value="${funcao.id}" label="${funcao.descricao}" />
											</c:forEach>
										</form:select>
									</div>
									<form:errors element="label" cssClass="error"
										path="funcao" />
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-12">
								<div class="form-group">
									<label>Missão</label> <form:textarea path="missao" cssClass="form-control"
											cssErrorClass="form-control error" />
									<form:errors element="label" cssClass="error" path="missao" />
								</div>
							</div>
						</div>
					</div>					
						<div class="row" style="margin: 0;">
							<div class="ibox-title">
									<h5>Competências</h5>
							</div>
						</div>
					<div class="ibox-content">
						<div class="row">
							<div class="col-md-6">
								<div class="form-group">
									<label>Habilidades</label> 
									<div class="input-group">
										<form:select path="habilidades" multiple="true"
												cssClass="form-control chosen-select" cssErrorClass="form-control error" >
											<c:forEach items="${lstHabilidade}" var="habilidade">
												<form:option value="${habilidade.id}" label="${habilidade.nomeHabilidade}" />
											</c:forEach>
										</form:select>
									</div>
									<form:errors element="label" cssClass="error"
											path="habilidades" />
								</div>
							</div>
							<div class="col-md-6">
								<div class="form-group">
									<label>Educacao</label> 
									<div class="input-group">
										<form:select path="educacao" cssClass="form-control" 
												cssErrorClass="form-control error" >
											<form:option value="0" label="Selecione uma opção" />
											<c:forEach items="${lstEducacao}" var="educacao">
												<form:option value="${educacao}" label="${educacao.descricao}" />
											</c:forEach>
										</form:select>
									</div>
									<form:errors element="label" cssClass="error"
											path="educacao" />
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-12">
								<div class="form-group">
									<label>Experiência</label> <form:textarea path="experiencia" cssClass="form-control"
											cssErrorClass="form-control error" />
									<form:errors element="label" cssClass="error" path="experiencia" />
								</div>
							</div>
						</div>
						<div class="row">
							 <div class="col-md-6">
							 	<div class="checkbox i-checks">
							 		<label><form:checkbox path="boExperiencia" value="" checked="" /> Experiência Obrigatório </label>
							 	</div>
							 </div>
							 <div class="col-md-6">
								<div class="form-group">
									<label>Status</label> <form:select path="status" cssClass="form-control" 
												cssErrorClass="form-control error" >
											<c:forEach items="${lstStatus}" var="status">
												<form:option value="${status}" label="${status.descricao}" />
											</c:forEach>
										</form:select>
									<form:errors element="label" cssClass="error" path="status" />
								</div>
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
	
<!-- Toastr script -->
<script src="${resourcePath}js/plugins/toastr/toastr.min.js"></script>

<!-- iCheck -->
<script src="${resourcePath}js/plugins/iCheck/icheck.min.js"></script>

<script>

	$(document).ready(function() {
		var msgSucesso = "Os dados do cargo foram cadastrados!";
		var msgErro = "Houve um erro ao cadastrar os dados do cargo!";
	
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
	
	 var config = {
	         '.chosen-select'           : {},
	         '.chosen-select-deselect'  : {allow_single_deselect:true},
	         '.chosen-select-no-single' : {disable_search_threshold:10},
	         '.chosen-select-no-results': {no_results_text:'Oops, Nada encontrado!'},
	         '.chosen-select-width'     : {width:"95%"}
	     }
	     for (var selector in config) {
	         $(selector).chosen(config[selector]);
	     }
 
	 $(document).ready(function () {
         $('.i-checks').iCheck({
             checkboxClass: 'icheckbox_square-green',
             radioClass: 'iradio_square-green',
         });
     });
	 
 	document.getElementById("cadastro").setAttribute("class", "active");
	document.getElementById("cadastroCargo").setAttribute("class", "active");
	document.getElementById("formCargo").setAttribute("class", "active");
</script>