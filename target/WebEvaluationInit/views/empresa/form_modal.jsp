<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags/" prefix="t"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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
						<div class="ibox-title">
								<h5>Endereço  
								<button class="btn btn-info" type="button" data-toggle="modal"
										data-target="#myModal">
											<i class="fa fa-plus"></i>
	                            </button>
									</h5>
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
					<div class="modal inmodal" id="myModal" tabindex="-1" role="dialog"
						aria-hidden="true" style="display: none;">
						<form:form action="" commandName="endereco" role="form">
                                <div class="modal-dialog">
                                <div
									class="modal-content animated bounceInRight">
                                        <div class="modal-header">
                                            <button type="button"
											class="close" data-dismiss="modal">
										<span aria-hidden="true">×</span><span class="sr-only">Close</span>
									</button>
                                            <h4 class="modal-title">Adicionar Endereço</h4>
                                        </div>
                                        <div class="modal-body">
                                           <div class="row">
								<div class="col-md-4">
									<div class="form-group">
										<label>Tipo</label> <form:input path="tipo"
											cssClass="form-control" cssErrorClass="form-control error" />
										<form:errors element="label" cssClass="error"
											path="tipo" />
									</div>
								</div>
								<div class="col-md-3">
									<div class="form-group">
										<label>CEP</label> <form:input path="cep" data-mask="99999-999"
											cssClass="form-control" cssErrorClass="form-control error" />
										<form:errors element="label" cssClass="error"
											path="cep" />
									</div>
								</div>
								<div class="col-md-5">
									<div class="form-group">
										<label>Estado</label> <form:select path="uf"
											cssClass="form-control" cssErrorClass="form-control error">
											<form:option value="">Selecione um estado</form:option>
											<form:option value="AC">Acre</form:option>
										</form:select>
										<form:errors element="label" cssClass="error"
											path="uf" />
									</div>
								</div>
								</div>
								<div class="row">
								<div class="col-md-6">
									<div class="form-group">
										<label>Cidade</label> <input  type="text" name="razaoSocial"
													class="form-control"/>
									</div>
								</div>
								<div class="col-md-6">
									<div class="form-group">
										<label>Bairro</label> <input type="text" name="razaoSocial"
													class="form-control"/>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-md-6">
									<div class="form-group">
										<label>Logradouro</label> <input type="text" name="nomeFantasia"
													class="form-control"/>
									</div>
								</div>
								<div class="col-md-2">
									<div class="form-group">
										<label>Número</label> <input type="text" name="nomeFantasia"
													class="form-control" />
									</div>
								</div>
								<div class="col-md-4">
									<div class="form-group">
										<label>Complemento</label> <input type="text" name="nomeFantasia"
													class="form-control" />
									</div>
								</div>
									</div>
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button"
											class="btn btn-white" data-dismiss="modal">Limpar</button>
                                            <button type="button"
											class="btn btn-primary" data-dismiss="modal">Adicionar</button>
                                        </div>
                                    </div>
                                </div>
                                </form:form>
                            </div>
			</div>
		</div>
	</div>
</jsp:body>
</t:pageTemplate>
<script>
	document.getElementById("cadastro").setAttribute("class", "active");
	document.getElementById("formEmpresa").setAttribute("class", "active");
</script>