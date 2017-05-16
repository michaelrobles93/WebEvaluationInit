<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags/" prefix="t"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/resources/" var="resourcePath" />

<!-- Toastr style -->
    <link href="${resourcePath}css/plugins/toastr/toastr.min.css" rel="stylesheet">

<t:pageTemplate title="Cadastrar Empresa - Web Evaluation">
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
				<form:form action="${s:mvcUrl('EC#novo').build()}.html"
						commandName="empresa" role="form">
				<div class="ibox-title">
					<h5>Cadastro de Empresas</h5>
				</div>
				<div class="ibox-content">
						<form:hidden path="id" />
						<div class="row">
							<div class="col-md-3">
								<div class="form-group">
									<label>CNPJ</label> <form:input path="cnpj"
											data-mask="99.999.999/9999-99" cssClass="form-control"
											cssErrorClass="form-control error" />
									<form:errors element="label" cssClass="error" path="cnpj" />
								</div>
							</div>
							<div class="col-md-3">
								<div class="form-group">
									<label>Inscrição Estadual</label> <form:input
											path="inscricaoEstadual" cssClass="form-control"
											cssErrorClass="form-control error" />
									<form:errors element="label" cssClass="error"
											path="inscricaoEstadual" />
								</div>
							</div>
							<div class="col-md-6">
								<div class="form-group">
									<label>Razão Social</label> <form:input path="razaoSocial"
											cssClass="form-control" cssErrorClass="form-control error" />
									<form:errors element="label" cssClass="error"
											path="razaoSocial" />
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-12">
								<div class="form-group">
									<label>Nome Fantasia</label> <form:input path="nomeFantasia"
											cssClass="form-control" cssErrorClass="form-control error" />
									<form:errors element="label" cssClass="error"
											path="nomeFantasia" />
								</div>
							</div>
						</div>
						<div class="row">
							<div class="ibox-title">
									<h5>Endereço</h5>
							</div>
						</div>
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

<!-- Toastr script -->
<script src="${resourcePath}js/plugins/toastr/toastr.min.js"></script>

<script>

	$(document).ready(function() {
		var msgSucesso = "Os dados da empresa foram cadastrados!";
		var msgErro = "Houve um erro ao cadastrar os dados da empresa!";
	
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
				if(${msgErro} == 1){
					msgErro = msgErro + " (CNPJ já cadastrado no sistema)";
				}
				toastr.error(msgErro,'Erro');
			}
		}	
	});
	document.getElementById("cadastro").setAttribute("class", "active");
	document.getElementById("formEmpresa").setAttribute("class", "active");
</script>