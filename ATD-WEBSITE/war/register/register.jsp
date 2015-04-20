<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registreer</title>
<jsp:include page="/include/style.jsp" />
</head>
<body>
	<div class="container">
		<jsp:include page="/include/header.jsp" />
		<div class="master-login clearfix">
			<h1>Registreer</h1>
			<p>Maak hier een account voor het ATD systeem</p>
			<form action="/ATD-WEBSITE/Register.do" method="POST">

				<div class="input-group">
					<span class="input-group-addon" id="basic-addon1"> Username
					</span> <input type="text" class="form-control" name="username"
						placeholder="Jan83" aria-describedby="basic-addon1">
				</div>
				<div class="input-group">
					<span class="input-group-addon" id="basic-addon1">Volledige
						naam</span> <input type="text" class="form-control" name="realname"
						placeholder="Jan de Jager" aria-describedby="basic-addon1">
				</div>
				<div class="input-group">
					<span class="input-group-addon" id="basic-addon1">Wachtwoord</span>
					<input type="password" class="form-control" name="password"
						placeholder="wachtwoord123" aria-describedby="basic-addon1">
				</div>

				<input type="submit" value="Registreren"
					class="btn btn-success btn-lg pull-right">
		</div>
		</form>
		<jsp:include page="/include/footer.jsp" />
	</div>
	<script src="${pageContext.request.contextPath}/js/jquery-1.11.2.js"></script>
	<script src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
</body>
</html>