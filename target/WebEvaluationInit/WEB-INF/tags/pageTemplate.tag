<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib tagdir="/WEB-INF/tags/" prefix="t"%>
<%@ attribute name="title" required="true"%>
<%@ attribute name="selectedMenu" required="false"%>
<%@attribute name="extraCss" fragment="true"%>
<%@attribute name="extraJs" fragment="true"%>
<%@attribute name="customJs" fragment="true"%>

<html>
<c:url value="/resources/" var="resourcePath" />
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>${title}</title>
<t:css path="css/bootstrap.min.css" />
<t:css path="font-awesome/css/font-awesome.css" />
<t:css path="css/style.css" />
<t:css path="css/animate.css" />
<jsp:invoke fragment="extraCss" />
</head>

<body>

	<div id="wrapper">
		<!-- Navigation Begin -->
		<nav class="navbar-default navbar-static-side" role="navigation">
			<div class="sidebar-collapse">
				<ul class="nav metismenu" id="side-menu">
					<li class="nav-header">
						<div class="dropdown profile-element">
							<span> </span> <a data-toggle="dropdown" class="dropdown-toggle"
								href="#"> <span class="clear"> <span
									class="block m-t-xs"> <strong class="font-bold">Michael
											Robles</strong>
								</span> <span class="text-muted text-xs block">Administrador <b
										class="caret"></b></span>
							</span>
							</a>
							<ul class="dropdown-menu animated fadeInRight m-t-xs">
								<li><a href="login.html">Logout</a></li>
							</ul>
						</div>
						<div class="logo-element">WE</div>
					</li>
					<li id="home"><a href="${pageContext.request.contextPath}"><i class="fa fa-home"></i>
						<span class="nav-label">Home</span></a>
					</li>
					<li id="cadastro">
						<a href="#"><i class="fa fa-edit"></i><span class="nav-label">Cadastros</span><span class="fa arrow"></span></a>
						<ul class="nav nav-second-level">
							<li id="formEmpresa"><a href="${pageContext.request.contextPath}/empresa/form.html">Empresas</a></li>
							<li id="formColaborador"><a href="${pageContext.request.contextPath}/colaborador/form.html">Colaboradores</a></li>
							<li id="cadastroCargo"><a href="#">Cargos + <span class="fa arrow"></span></a>
								<ul class="nav nav-third-level">
                               		<li id="formCargo"><a href="${pageContext.request.contextPath}/cargo/form.html">Cargos</a></li>
                               		<li id="formHabilidade"><a href="${pageContext.request.contextPath}/habilidade/form.html">Habilidades</a></li>
                               		<li id="formFuncao"><a href="${pageContext.request.contextPath}/funcao/form.html">Funções</a></li>
                            	</ul>
	                        </li>
						</ul>
					</li>
					<li id="consulta"><a href="#"><i class="fa fa-edit"></i>
						<span class="nav-label">Consultas</span><span class="fa arrow"></span></a>
						<ul class="nav nav-second-level">
							<li id="listEmpresa"><a href="${pageContext.request.contextPath}/empresa/list.html">Empresas</a></li>
							<li id="listColaborador"><a href="${pageContext.request.contextPath}/colaborador/list.html">Colaboradores</a></li>
							<li id="consultaCargo"><a href="#">Cargos + <span class="fa arrow"></span></a>
								<ul class="nav nav-third-level">
									<li id="listCargo"><a href="${pageContext.request.contextPath}/cargo/list.html">Cargos</a></li>
                               		<li id="listHabilidade"><a href="${pageContext.request.contextPath}/habilidade/list.html">Habilidades</a></li>
                               		<li id="listFuncao"><a href="${pageContext.request.contextPath}/funcao/list.html">Funções</a></li>
                            	</ul>
	                        </li>
						</ul>
					</li>
					<li><a href="#"><i class="fa fa-bar-chart-o"></i> <span
							class="nav-label">Relatórios</span><span class="fa arrow"></span></a>
						<ul class="nav nav-second-level collapse">
							<li><a href="#">teste</a></li>
							<!--<li><a href="graph_flot.html">Flot Charts</a></li>
							<li><a href="graph_morris.html">Morris.js Charts</a></li>
							<li><a href="graph_rickshaw.html">Rickshaw Charts</a></li>
							<li><a href="graph_chartjs.html">Chart.js</a></li>
							<li><a href="graph_chartist.html">Chartist</a></li>
							<li><a href="c3.html">c3 charts</a></li>
							<li><a href="graph_peity.html">Peity Charts</a></li>
							<li><a href="graph_sparkline.html">Sparkline Charts</a></li> -->
						</ul></li>
				</ul>

			</div>
		</nav>

		<div id="page-wrapper" class="gray-bg">
			<div class="row border-bottom">
				<nav class="navbar navbar-static-top" role="navigation"
					style="margin-bottom: 0">
					<div class="navbar-header">
						<a class="navbar-minimalize minimalize-styl-2 btn btn-primary "
							href="#"><i class="fa fa-bars"></i> </a>
					</div>
					<ul class="nav navbar-top-links navbar-right">
						<li><a href="login.html"> <i class="fa fa-sign-out"></i>
								Log out
						</a></li>
					</ul>

				</nav>
			</div>

			<!-- Navigation End -->

			<div id="wrapper" class="wrapper wrapper-content">
				<jsp:doBody />
			</div>
			<div class="footer">
				<div>
					<strong>Copyright</strong> WebEvaluation &copy; 2016
				</div>
			</div>
		</div>

	</div>

	<!-- Mainly scripts -->
	<script src="${resourcePath}js/jquery-2.1.1.js"></script>
	<script src="${resourcePath}js/bootstrap.min.js"></script>
	<script src="${resourcePath}js/plugins/metisMenu/jquery.metisMenu.js"></script>
	<script src="${resourcePath}js/plugins/slimscroll/jquery.slimscroll.min.js"></script>
    <script src="${resourcePath}js/plugins/jeditable/jquery.jeditable.js"></script>
    
    <!-- Custom and plugin javascript -->
	<script src="${resourcePath}js/inspinia.js"></script>
	<script src="${resourcePath}js/plugins/pace/pace.min.js"></script>

	<jsp:invoke fragment="extraJs" />
	
	<jsp:invoke fragment="customJs" />

</body>


</html>