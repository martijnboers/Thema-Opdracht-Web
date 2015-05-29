<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login pagina</title>
<!--  alle stylesheets  -->
<jsp:include page="/include/style.jsp" />
</head>
<body>
	<!--   main container -->
		<jsp:include page="/include/header.jsp" />
		<!-- login scherm -->
		<div class="master-login clearfix">
			<h1>Login</h1>
			<p>Log hier in om gebruik te maken van het ATD systeem</p>
			<form action="/ATD-WEBSITE/Login.do" method="post">
				<div class="input-group">
					<span class="input-group-addon" id="basic-addon1"> Gebruikersnaam
					</span> <input name="username" type="text" class="form-control"
						aria-describedby="basic-addon1" value="${cookie.username.value }">
				</div>
				<div class="input-group">
					<span class="input-group-addon" id="basic-addon1">Wachtwoord</span>
					<input type="password" name="password" class="form-control"
						aria-describedby="basic-addon1">
				</div>
				${requestScope.error}
				<input type="submit" class="btn btn-success btn-lg pull-right"
					value="aanmelden">
				
				
			
		</div>
		</form>
		<!--  footer  -->
		<jsp:include page="/include/footer.jsp" />
	</div>
	<!-- alle javascript files -->
	<script src="${pageContext.request.contextPath}/js/jquery-1.11.2.js"></script>
	<script src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
</body>

</html>
