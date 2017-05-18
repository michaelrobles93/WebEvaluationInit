<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags/" prefix="t"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>

<c:url value="/resources/" var="resourcePath" />

<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>Web Evaluation - Login</title>
	<t:css path="css/bootstrap.min.css" />
	<t:css path="font-awesome/css/font-awesome.css" />
	<t:css path="css/style.css" />
	<t:css path="css/animate.css" />

</head>

<body class="gray-bg">

    <div class="middle-box text-center loginscreen  animated fadeInDown">
        <div>
            <div>

                <h1 class="logo-name">WE</h1>

            </div>
            <h3>Bem Vindo ao sistema</h3>
            <p class="title title_login">WEB EVALUATION</p>
            <p>Login in.</p>
            <form class="m-t" role="form" action="${pageContext.request.contextPath}">
                <div class="form-group">
                    <input type="text" class="form-control" placeholder="Nome de usuário" required="">
                </div>
                <div class="form-group">
                    <input type="password" class="form-control" placeholder="Senha" required="">
                </div>
                <button type="submit" class="btn btn-primary block full-width m-b">Login</button>

                <a href="#"><small>Esqueceu sua senha?</small></a>
            </form>
            <p class="m-t"> <small><strong>Copyright</strong> WebEvaluation &copy; 2017</small> </p>
        </div>
    </div>

    <!-- Mainly scripts -->
    <script src="js/jquery-2.1.1.js"></script>
    <script src="js/bootstrap.min.js"></script>

</body>

</html>
