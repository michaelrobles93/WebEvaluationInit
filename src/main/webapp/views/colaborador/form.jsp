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
						<h5>Cadastro de Colaborador</h5>
					</div>
					<div class="ibox-content">
						<form:hidden path="id" />
						<div class="row">
							<div class="col-md-6">
								<div class="form-group">
									<label>Nome</label> <form:input path="nome"
											cssClass="form-control" cssErrorClass="form-control error" />
									<form:errors element="label" cssClass="error" path="nome" />
								</div>
							</div>
							<div class="col-md-6">
								<div class="form-group">
									<label>Sobrenome</label> <form:input path="sobrenome"
											cssClass="form-control" cssErrorClass="form-control error" />
									<form:errors element="label" cssClass="error" path="sobrenome" />
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-3">
								<div class="form-group">
									<label>Data Admissão</label> <form:input path="admissoes[0].dataAdmissao" data-mask="99/99/9999"
											cssClass="form-control" cssErrorClass="form-control error" />
									<form:errors element="label" cssClass="error" path="admissoes[0].dataAdmissao" />
								</div>
							</div>
							<div class="col-md-3">
								<div class="form-group">
									<label>Data de Nascimento</label> <form:input
											path="dataNascimento" data-mask="99/99/9999"
											cssClass="form-control" cssErrorClass="form-control error" />
									<form:errors element="label" cssClass="error"
											path="dataNascimento" />
								</div>
							</div>
							<div class="col-md-6">
								<div class="form-group">
									<label>E-mail</label> <form:input path="email"
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
											<form:select path="admissoes[0].empresa.id" id="empresa"
													cssClass="form-control chosen-select" cssErrorClass="form-control error" >
												<form:option value="0" label="Selecione uma opção" />
												<c:forEach items="${lstEmpresa}" var="empresa">
													<form:option value="${empresa.id}" label="${empresa.nomeFantasia}" />
												</c:forEach>
											</form:select>
										</div>
									<form:errors element="label" cssClass="error" path="admissoes[0].empresa" />
								</div>
							</div>
							<div class="col-md-6">
								<div class="form-group">
									<label>Cargo</label>
										<div class="input-group">
											<form:select path="cargo.id" id="cargo"
													cssClass="form-control" cssErrorClass="form-control error" >
												<form:option value="" label="Selecione uma opção" />
												<c:forEach items="${lstCargo}" var="cargo">
													<form:option value="${cargo.id}" label="${cargo.nomeCargo}" />
												</c:forEach>
											</form:select>
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
										<form:select path="colaboradorSuperiorImediato.id" id="colaboradorSuperiorImediato"
												cssClass="form-control" cssErrorClass="form-control error" >
											<form:option value="" label="Selecione uma opção" />
											<c:forEach items="${lstColaborador}" var="colaboradorSuperiorImediato">
												<form:option value="${colaboradorSuperiorImediato.id}" label="${colaboradorSuperiorImediato.nomeCargo}" />
											</c:forEach>
										</form:select>
										<form:errors element="label" cssClass="error" path="colaboradorSuperiorImediato.id" />
									</div>
								</div>
							</div>
							<div class="col-md-3">
								<div class="form-group">
									<label>CPF</label> <form:input path="cpf"
											data-mask="999.999.999-99" cssClass="form-control"
											cssErrorClass="form-control error" />
									<form:errors element="label" cssClass="error" path="cpf" />
								</div>
							</div>
							<div class="col-md-3">
								<div class="form-group">
									<label>CTPS</label> <form:input path="ctps"
											cssClass="form-control" cssErrorClass="form-control error" />
									<form:errors element="label" cssClass="error" path="ctps" />
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-3">
								<div class="form-group">
									<label>Estado Civil</label> 
									<form:select path="estadoCivil"
											cssClass="form-control" cssErrorClass="form-control error" >
										<form:option value="" label="Selecione uma opção" />
										<c:forEach items="${estadoCivil}" var="estado">
											<form:option value="${estado}" label="${estado.descricao}" />
										</c:forEach>
									</form:select>
									<form:errors element="label" cssClass="error"
											path="estadoCivil" />
									
								</div>
							</div>
							<div class="col-md-3">
								<div class="form-group">
									<label>Gênero</label> 
									<form:select path="genero"
											cssClass="form-control" cssErrorClass="form-control error" >
										<form:option value="" label="Selecione uma opção" />
										<c:forEach items="${generos}" var="genero">
											<form:option value="${genero}" label="${genero.descricao}" />
										</c:forEach>
									</form:select>
									<form:errors element="label" cssClass="error" path="genero" />
								</div>
							</div>
							<div class="col-md-6">
								<div class="form-group">
									<label>RG</label> <form:input path="rg" cssClass="form-control"
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
										<form:select path="habilidades" multiple="true"
												cssClass="form-control chosen-select" cssErrorClass="form-control error" >
											<c:choose>
												<c:when test="${cargo.id == null}">
													<c:forEach items="${lstHabilidade}" var="habilidade">
														<form:option value="${habilidade.id}" label="${habilidade.nomeHabilidade}" />
													</c:forEach>
												</c:when>
												<c:otherwise>
													<c:forEach items="${lstHabilidade}" var="habilidade">
														<c:set var="isSelected" value="${false}" />
														<c:forEach items="${cargo.habilidades}" var="cargoHabilidade">
															<c:if test="${habilidade.id == cargoHabilidade.id}">
																<c:set var="isSelected" value="${true}" />
															</c:if>
														</c:forEach>
														<c:choose>
															<c:when test="${isSelected}">
																<form:option selected="selected" value="${habilidade.id}" label="${habilidade.nomeHabilidade}" />
															</c:when>
															<c:otherwise>
																<form:option value="${habilidade.id}" label="${habilidade.nomeHabilidade}" />
															</c:otherwise>
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
									<label>CEP</label> <form:input path="enderecos[0].cep" data-mask="99999-999"
											cssClass="form-control" cssErrorClass="form-control error" />
									<form:errors element="label" cssClass="error" path="enderecos[0].cep" />
								</div>
							</div>
							<div class="col-md-9">
								<div class="form-group">
									<label>Cidade</label> <form:input path="enderecos[0].cidade"
											cssClass="form-control" cssErrorClass="form-control error" />
									<form:errors element="label" cssClass="error" path="enderecos[0].cidade" />
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-6">
								<div class="form-group">
									<label>Estado</label> <form:select path="enderecos[0].uf"
											cssClass="form-control" cssErrorClass="form-control error">
										<form:option value="">Selecione um estado</form:option>
										<form:option value="AC">Acre</form:option>
										<form:option value="AL">Alagoas</form:option>
										<form:option value="AP">Amapá</form:option>	 
										<form:option value="AM">Amazonas</form:option>
										<form:option value="BA">Bahia</form:option>
										<form:option value="CE">Ceará</form:option>
										<form:option value="DF">Distrito Federal</form:option>
										<form:option value="ES">Espirito Santo</form:option>
										<form:option value="GO">Goiás</form:option>
										<form:option value="MA">Maranhão</form:option>
										<form:option value="MT">Mato Grosso</form:option>
										<form:option value="MS">Mato Grosso do Sul</form:option>
										<form:option value="MG">Minas Gerais</form:option>
										<form:option value="PA">Pará</form:option>
										<form:option value="PB">Paraíba</form:option>
										<form:option value="PR">Paraná</form:option>
										<form:option value="PE">Pernambuco</form:option>
										<form:option value="PI">Piauí</form:option>
										<form:option value="RJ">Rio de Janeiro</form:option>
										<form:option value="RN">Rio Grande do Norte</form:option>
										<form:option value="RS">Rio Grande do Sul</form:option>
										<form:option value="RO">Rondônia</form:option>
										<form:option value="RR">Roraima</form:option>
										<form:option value="SC">Santa Catarina</form:option>
										<form:option value="SP">São Paulo</form:option>
										<form:option value="SE">Sergipe</form:option>
										<form:option value="TO">Tocantins</form:option>
									</form:select>
									<form:errors element="label" cssClass="error" path="enderecos[0].uf" />
								</div>
							</div>
							<div class="col-md-6">
								<div class="form-group">
									<label>Bairro</label> <form:input path="enderecos[0].bairro"
											cssClass="form-control" cssErrorClass="form-control error"/>
									<form:errors element="label" cssClass="error" path="enderecos[0].bairro" />
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-6">
								<div class="form-group">
									<label>Logradouro</label> <form:input path="enderecos[0].logradouro" 
									cssClass="form-control" cssErrorClass="form-control error"/>
									<form:errors element="label" cssClass="error" path="enderecos[0].logradouro" />
								</div>
							</div>
							<div class="col-md-2">
								<div class="form-group">
									<label>Número</label> <form:input path="enderecos[0].numero"
											cssClass="form-control" cssErrorClass="form-control error"/>
									<form:errors element="label" cssClass="error" path="enderecos[0].numero" />
								</div>
							</div>
							<div class="col-md-4">
								<div class="form-group">
									<label>Complemento</label> <form:input path="enderecos[0].complemento" 
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
									<label>Residencial</label> <form:input path="telefones[0].numero"
											cssClass="form-control phone" cssErrorClass="form-control error" />
									<form:errors element="label" cssClass="error" path="telefones[0].numero" />
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-4">
								<div class="form-group">
									<label>Celular</label> <form:input path="telefones[1].numero"
											cssClass="form-control phone" cssErrorClass="form-control error" />
									<form:errors element="label" cssClass="error" path="telefones[1].numero" />
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-4">
								<div class="form-group">
									<label>Comercial</label> <form:input path="telefones[2].numero"
											cssClass="form-control phone" cssErrorClass="form-control error" />
									<form:errors element="label" cssClass="error" path="telefones[2].numero" />
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

<script>
	
	document.getElementById("cadastro").setAttribute("class", "active");
	document.getElementById("formColaborador").setAttribute("class", "active");
	
	$('#empresa').on('change',function(){
		var data = {}
		data["id"] = $("#empresa").val();
		$('#cargo').
		html('<option value="">Selecione uma opção</option>');
		$('#colaboradorSuperiorImediato').
		html('<option value="">Selecione uma opção</option>');
		$.ajax({
			type: "POST",
			url : "/WebEvaluationInit/ajax/searchingCargos.html",
			data : JSON.stringify(data),
			contentType: "application/json",
            dataType: "json",
			success : function(data) {
				console.log("SUCCESS: ", data);
				$.each(data, function(i, item) {
					$('#cargo').
						append('<option value="'+item.id+'">'+item.nomeCargo+'</option>');
				});
			},
			error : function(e) {
				console.log("ERROR: ", e);
			},
			done : function(e) {
				console.log("DONE");
			}
		});
	});
	
	$('#cargo').on('change',function(){
		var data = {}
		data["id"] = $("#cargo").val();
		$('#colaboradorSuperiorImediato').
		html('<option value="">Selecione uma opção</option>');
		$.ajax({
			type: "POST",
			url : "/WebEvaluationInit/ajax/searchingColaboradores.html",
			data : JSON.stringify(data),
			contentType: "application/json",
            dataType: "json",
			success : function(data) {
				console.log("SUCCESS: ", data);
				$.each(data, function(i, item) {
					$('#colaboradorSuperiorImediato').
						append('<option value="'+item.id+'">'+item.nome+'</option>');
				});
			},
			error : function(e) {
				console.log("ERROR: ", e);
			},
			done : function(e) {
				console.log("DONE");
			}
		});
	});
	
	$(document).ready(function() {
		
		var msgSucesso = "Os dados do colaborador foram cadastrados!";
		var msgErro = "Houve um erro ao cadastrar os dados da colaborador!";
	
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
		
		if (${sucesso} == 1){
			toastr.success(msgSucesso, 'Sucesso');	
		}else{
			if (${sucesso} == 0){
				toastr.error(msgErro,'Erro');
			}
		}
	});
	
	function carregaComboCargo(){
		alert('aaa');
	}

</script>