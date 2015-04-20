<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login pagina</title>
<!--  alle stylesheets  -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/custom.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/bootstrap.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/bootstrap-theme.min.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/bootstrap.min.css" />
</head>
<body>
	<!--   main container -->
	<div class="container">
		<!--     navbar begin -->
		<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">ATD</a>
			</div>
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<li><a href="#">Parkeren</a></li>
					<li><a href="#">Reparatie</a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li><a href="#">Login</a></li>
					<li>
						<!-- aanmeld button -->
						<button type="button" class="btn btn-success navbar-btn">aanmelden</button>
					</li>
				</ul>
			</div>
		</div>
		<!-- navbar-einde --> </nav>
		<!-- login scherm -->
		<div class="master-login clearfix">
			<h1>Login</h1>
			<p>Log hier in om gebruik te maken van het ATD systeem</p>
			<form action="Login.do" method="post">
				<div class="input-group">
					<span class="input-group-addon" id="basic-addon1">
						Gebruikersnaam </span> <input name="username" type="text" class="form-control"
						aria-describedby="basic-addon1">
				</div>
				<div class="input-group">
					<span class="input-group-addon" id="basic-addon1">Wachtwoord</span>
					<input type="password" name="password" class="form-control"
						aria-describedby="basic-addon1">
				</div>
				<input type="submit" class="btn btn-success navbar-btn pull-right"
					value="aanmelden">
				<%
					Object msgs = request.getAttribute("error");
					if (msgs != null) {
						out.println(msgs);
					}
				%>
			
		</div>
		</form>
		<!--    footer  -->
		<div class="footer">
			<p>Team 3</p>
		</div>
	</div>
	<!-- alle javascript files -->
	<script src="${pageContext.request.contextPath}/js/jquery-1.11.2.js"></script>
	<script src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
</body>

</html>
