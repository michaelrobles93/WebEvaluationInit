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

<t:pageTemplate title="Cadastrar Habilidades - Web Evaluation">
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
				<form:form action="${s:mvcUrl('HC#novo').build()}.html"
						commandName="habilidade" role="form">
					<div class="ibox-title">
						<h5>Cadastro de Habilidades</h5>
					</div>
					<div class="ibox-content">
						<form:hidden path="id" />
						<div class="row">
							<div class="col-md-12">
								<div class="form-group">
									<label>Nome</label> <form:input path="nomeHabilidade" cssClass="form-control"
											cssErrorClass="form-control error" />
									<form:errors element="label" cssClass="error" path="nomeHabilidade" />
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-12">
								<div class="form-group">
									<label>Descrição</label> <form:textarea path="descricao" cssClass="form-control"
											cssErrorClass="form-control error" />
									<form:errors element="label" cssClass="error" path="descricao" />
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

<script	src="${resourcePath}js/plugins/dataTables/dataTables.bootstrap.js"></script>
<script	src="${resourcePath}js/plugins/dataTables/dataTables.responsive.js"></script>
<script	src="${resourcePath}js/plugins/dataTables/dataTables.tableTools.min.js"></script>

<!-- Toastr script -->
<script src="${resourcePath}js/plugins/toastr/toastr.min.js"></script>

<script>

	$(document).ready(function() {
		var msgSucesso = "Os dados da habilidade de cargos foram cadastrados!";
		var msgErro = "Houve um erro ao cadastrar os dados da habilidade de cargos!";
	
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
	         '.chosen-select-no-results': {no_results_text:'Oops, nothing found!'},
	         '.chosen-select-width'     : {width:"95%"}
	     }
	     for (var selector in config) {
	         $(selector).chosen(config[selector]);
	     }
 
	document.getElementById("cadastro").setAttribute("class", "active");
	document.getElementById("cadastroCargo").setAttribute("class", "active");
	document.getElementById("formHabilidade").setAttribute("class", "active");
</script>