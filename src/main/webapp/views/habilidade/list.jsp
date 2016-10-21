<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags/" prefix="t"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/resources/" var="resourcePath" />

<!-- Data Tables -->
<link
	href="${resourcePath}css/plugins/dataTables/dataTables.bootstrap.css"
	rel="stylesheet">
<link
	href="${resourcePath}css/plugins/dataTables/dataTables.responsive.css"
	rel="stylesheet">
<link
	href="${resourcePath}css/plugins/dataTables/dataTables.tableTools.min.css"
	rel="stylesheet">
	
<!-- Toastr style -->
    <link href="${resourcePath}css/plugins/toastr/toastr.min.css" rel="stylesheet">

<t:pageTemplate title="Habilidades Cadastradas - Web Evaluation">

	<div class="row">
		<div class="col-lg-12">
			<div class="ibox float-e-margins">
				<div class="ibox-title">
					<h5>Habilidades Cadastradas</h5>
					<div class="ibox-tools">
						<a class="collapse-link"> <i class="fa fa-chevron-up"></i>
						</a>
					</div>
				</div>
				<div class="ibox-content">
					<table
						class="table table-striped table-bordered table-hover dataTables-example">
						<thead>
							<tr>
								<th>Nome</th>
								<th></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${lstHabilidade}" var="habilidade">
								<tr >
									<td>${habilidade.nomeHabilidade}</td>
									<td>
										<a href="./edit.html?id=${habilidade.id}" class="edit"></a>
										<a href="#?id=${habilidade.id}" class="delete"></a>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
	<style>
body.DTTT_Print {
	background: #fff;
}

.DTTT_Print #page-wrapper {
	margin: 0;
	background: #fff;
}

button.DTTT_button, div.DTTT_button, a.DTTT_button {
	border: 1px solid #e7eaec;
	background: #fff;
	color: #676a6c;
	box-shadow: none;
	padding: 6px 8px;
}

button.DTTT_button:hover, div.DTTT_button:hover, a.DTTT_button:hover {
	border: 1px solid #d2d2d2;
	background: #fff;
	color: #676a6c;
	box-shadow: none;
	padding: 6px 8px;
}

.dataTables_filter label {
	margin-right: 5px;
}
</style>
</t:pageTemplate>
<!-- Data Tables -->
<script src="${resourcePath}js/plugins/dataTables/jquery.dataTables.js"></script>
<script
	src="${resourcePath}js/plugins/dataTables/dataTables.bootstrap.js"></script>
<script
	src="${resourcePath}js/plugins/dataTables/dataTables.responsive.js"></script>
<script
	src="${resourcePath}js/plugins/dataTables/dataTables.tableTools.min.js"></script>

<!-- Toastr script -->
<script src="${resourcePath}js/plugins/toastr/toastr.min.js"></script>

<script>
	$(document).ready(function() {
		$('.dataTables-example').dataTable({
			responsive : true,
			"dom" : 'T<"clear">lfrtip'
		});
		
		var msgSucesso = "Os dados da habilidade de cargos foram atualizados!";
		var msgErro = "Houve um erro ao atualizar os dados da habilidade de cargos!";

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
	
	document.getElementById("consulta").setAttribute("class", "active");
	document.getElementById("consultaCargo").setAttribute("class", "active");
	document.getElementById("listHabilidade").setAttribute("class", "active");
</script>
