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

<style>
	input{ background-color: #000;}
</style>

<t:pageTemplate title="Cadastrar Colaborador - Web Evaluation">
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
				<form:form action="${s:mvcUrl('CC#novo').build()}.html"
						commandName="colaborador" role="form">
					<div class="ibox-title">
						<h5>Visualizar dados do Colaborador</h5>
					</div>
					<div class="ibox-content">
						<form:hidden path="id" />
						<div class="row">
							<div class="col-md-6">
								<div class="form-group">
									<label>Nome</label> <form:input readonly="true" path="nome"
											cssClass="form-control" cssErrorClass="form-control error" />
									<form:errors element="label" cssClass="error" path="nome" />
								</div>
							</div>
							<div class="col-md-6">
								<div class="form-group">
									<label>Sobrenome</label> <form:input readonly="true" path="sobrenome"
											cssClass="form-control" cssErrorClass="form-control error" />
									<form:errors element="label" cssClass="error" path="sobrenome" />
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-3">
								<div class="form-group">
									<label>Data Admissão</label> <form:input readonly="true" path="admissoes[0].dataAdmissao" data-mask="99/99/9999"
											cssClass="form-control" cssErrorClass="form-control error" />
									<form:errors element="label" cssClass="error" path="admissoes[0].dataAdmissao" />
								</div>
							</div>
							<div class="col-md-3">
								<div class="form-group">
									<label>Data de Nascimento</label> <form:input readonly="true"
											path="dataNascimento" data-mask="99/99/9999"
											cssClass="form-control" cssErrorClass="form-control error" />
									<form:errors element="label" cssClass="error"
											path="dataNascimento" />
								</div>
							</div>
							<div class="col-md-6">
								<div class="form-group">
									<label>E-mail</label> <form:input readonly="true" path="email"
											cssClass="form-control" cssErrorClass="form-control error" />
									<form:errors element="label" cssClass="error" path="email" />
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-6">
								<div class="form-group">
									<label>Empresa</label>
										<div class="input-group">
											<form:input readonly="true" path="admissoes[0].empresa.nomeFantasia" id="empresa"
													cssClass="form-control" cssErrorClass="form-control error" />
												
										</div>
									<form:errors element="label" cssClass="error" path="admissoes[0].empresa" />
								</div>
							</div>
							<div class="col-md-6">
								<div class="form-group">
									<label>Cargo</label>
										<div class="input-group">
											<form:input readonly="true" path="cargo.nomeCargo" id="cargo"
													cssClass="form-control" cssErrorClass="form-control error" />
										</div>
									<form:errors element="label" cssClass="error" path="cargo.id" />
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-6">
								<div class="form-group">
									<label>Superior Imediato</label>
									<div class="input-group">
										<form:input readonly="true" path="colaboradorSuperiorImediato.nome" id="colaboradorSuperiorImediato"
												cssClass="form-control" cssErrorClass="form-control error" />
										<form:errors element="label" cssClass="error" path="colaboradorSuperiorImediato.id" />
									</div>
								</div>
							</div>
							<div class="col-md-3">
								<div class="form-group">
									<label>CPF</label> <form:input readonly="true" path="cpf"
											data-mask="999.999.999-99" cssClass="form-control"
											cssErrorClass="form-control error" />
									<form:errors element="label" cssClass="error" path="cpf" />
								</div>
							</div>
							<div class="col-md-3">
								<div class="form-group">
									<label>CTPS</label> <form:input readonly="true" path="ctps"
											cssClass="form-control" cssErrorClass="form-control error" />
									<form:errors element="label" cssClass="error" path="ctps" />
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-3">
								<div class="form-group">
									<label>Estado Civil</label> 
									<form:input readonly="true" path="estadoCivil.descricao"
											cssClass="form-control" cssErrorClass="form-control error" />
									<form:errors element="label" cssClass="error"
											path="estadoCivil" />
									
								</div>
							</div>
							<div class="col-md-3">
								<div class="form-group">
									<label>Gênero</label> 
									<form:input readonly="true" path="genero.descricao"
											cssClass="form-control" cssErrorClass="form-control error" />
									<form:errors element="label" cssClass="error" path="genero" />
								</div>
							</div>
							<div class="col-md-6">
								<div class="form-group">
									<label>RG</label> <form:input readonly="true" path="rg" cssClass="form-control"
											cssErrorClass="form-control error" />
									<form:errors element="label" cssClass="error" path="rg" />
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
										<form:select disabled="true" path="habilidades" multiple="true"
												cssClass="form-control chosen-select" cssErrorClass="form-control error" >
											<c:choose>
												<c:when test="${colaborador.id == null}">
													<c:forEach items="${lstHabilidade}" var="habilidade">
														<form:option value="${habilidade.id}" label="${habilidade.nomeHabilidade}" />
													</c:forEach>
												</c:when>
												<c:otherwise>
													<c:forEach items="${lstHabilidade}" var="habilidade">
														<c:set var="isSelected" value="${false}" />
														<c:forEach items="${colaborador.habilidades}" var="colaboradorHabilidade">
															<c:if test="${habilidade.id == colaboradorHabilidade.id}">
																<c:set var="isSelected" value="${true}" />
															</c:if>
														</c:forEach>
														<c:choose>
															<c:when test="${isSelected}">
																<form:option selected="selected" value="${habilidade.id}" label="${habilidade.nomeHabilidade}" />
															</c:when>
														</c:choose>
													</c:forEach>
												</c:otherwise>
											</c:choose>
										</form:select>
									</div>
									<form:errors element="label" cssClass="error"
											path="habilidades" />
								</div>
							</div>
							<div class="col-md-6">
								<div class="form-group">
									<label>Educação</label> 
									<div class="input-group">
										<form:input readonly="true" path="educacao.descricao" cssClass="form-control" 
												cssErrorClass="form-control error" />
									</div>
									<form:errors element="label" cssClass="error"
											path="educacao" />
								</div>
							</div>
						</div>
					</div>					
					<div class="row" style="margin: 0;">
						<div class="ibox-title">
								<h5>Endereço</h5>
						</div>
					</div>
					<div class="ibox-content">
						<div class="row">
							<div class="col-md-3">
								<div class="form-group">
									<label>CEP</label> <form:input readonly="true" path="enderecos[0].cep" data-mask="99999-999"
											cssClass="form-control" cssErrorClass="form-control error" />
									<form:errors element="label" cssClass="error" path="enderecos[0].cep" />
								</div>
							</div>
							<div class="col-md-9">
								<div class="form-group">
									<label>Cidade</label> <form:input readonly="true" path="enderecos[0].cidade"
											cssClass="form-control" cssErrorClass="form-control error" />
									<form:errors element="label" cssClass="error" path="enderecos[0].cidade" />
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-6">
								<div class="form-group">
									<label>Estado</label> <form:input readonly="true" path="enderecos[0].uf"
											cssClass="form-control" cssErrorClass="form-control error" />
									<form:errors element="label" cssClass="error" path="enderecos[0].uf" />
								</div>
							</div>
							<div class="col-md-6">
								<div class="form-group">
									<label>Bairro</label> <form:input readonly="true" path="enderecos[0].bairro"
											cssClass="form-control" cssErrorClass="form-control error"/>
									<form:errors element="label" cssClass="error" path="enderecos[0].bairro" />
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-6">
								<div class="form-group">
									<label>Logradouro</label> <form:input readonly="true" path="enderecos[0].logradouro" 
									cssClass="form-control" cssErrorClass="form-control error"/>
									<form:errors element="label" cssClass="error" path="enderecos[0].logradouro" />
								</div>
							</div>
							<div class="col-md-2">
								<div class="form-group">
									<label>Número</label> <form:input readonly="true" path="enderecos[0].numero"
											cssClass="form-control" cssErrorClass="form-control error"/>
									<form:errors element="label" cssClass="error" path="enderecos[0].numero" />
								</div>
							</div>
							<div class="col-md-4">
								<div class="form-group">
									<label>Complemento</label> <form:input readonly="true" path="enderecos[0].complemento" 
									cssClass="form-control" cssErrorClass="form-control error" />
									<form:errors element="label" cssClass="error" path="enderecos[0].complemento" />
								</div>
							</div>
                        </div>
                    </div>
                    <div class="row" style="margin: 0;">
						<div class="ibox-title">
								<h5>Telefones</h5>
						</div>
					</div>
					<div class="ibox-content">
						<div class="row">
							<div class="col-md-4">
								<div class="form-group">
									<label>Residencial</label> <form:input readonly="true" path="telefones[0].numero"
											cssClass="form-control phone" cssErrorClass="form-control error" />
									<form:errors element="label" cssClass="error" path="telefones[0].numero" />
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-4">
								<div class="form-group">
									<label>Celular</label> <form:input readonly="true" path="telefones[1].numero"
											cssClass="form-control phone" cssErrorClass="form-control error" />
									<form:errors element="label" cssClass="error" path="telefones[1].numero" />
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-4">
								<div class="form-group">
									<label>Comercial</label> <form:input readonly="true" path="telefones[2].numero"
											cssClass="form-control phone" cssErrorClass="form-control error" />
									<form:errors element="label" cssClass="error" path="telefones[2].numero" />
								</div>
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

<script>
	$(document).ready(function() {

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
	});
</script>