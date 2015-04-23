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

	<jsp:include page="/include/header.jsp" />
	<div class="master-login clearfix">
		<h1>Registreer</h1>
		<p>
			<input type="checkbox" id="checkbox"> als werknemen
			aanmelden?
		</p>
		<form action="/ATD-WEBSITE/Register.do" method="POST">

			<p>Om een afraak te maken bij ATD dient u een account aan te
				maken, Geef hier onder uw gegevens op een gewenste datum voor een
				afspraak</p>
			<div class="input-group">
				<span class="input-group-addon" id="basic-addon1"> Username </span>
				<input type="text" class="form-control" placeholder="Jantje32"
					aria-describedby="basic-addon1">
			</div>
			<div class="input-group">
				<span class="input-group-addon" id="basic-addon1"> Password </span>
				<input type="password" class="form-control"
					placeholder="wachtwoord123" aria-describedby="basic-addon1">
			</div>
			<div class="input-group">
				<span class="input-group-addon" id="basic-addon1"> Naam </span> <input
					type="text" class="form-control" placeholder="Jan kees"
					aria-describedby="basic-addon1">
			</div>
			<div class="input-group">
				<span class="input-group-addon" id="basic-addon1">Postcode</span> <input
					type="text" class="form-control" placeholder="1541TW"
					aria-describedby="basic-addon1">
			</div>
			<div class="input-group">
				<span class="input-group-addon" id="basic-addon1">Email</span> <input
					type="text" class="form-control" placeholder="yourmail@gmail.com"
					aria-describedby="basic-addon1">
			</div>

			<h2>De auto</h2>
			<div class="input-group">
				<span class="input-group-addon" id="basic-addon1"> Kenteken </span>
				<input type="text" id="block1" class="block form-control"
					placeholder="15-XS-2" aria-describedby="basic-addon1">
			</div>
			<div class="input-group">
				<span class="input-group-addon" id="basic-addon1"> Merk </span> <input
					type="text" id="block2" class="block form-control" placeholder="audi"
					aria-describedby="basic-addon1">
			</div>
			<div class="input-group">
				<span class="input-group-addon" id="basic-addon1"> Type </span> <input
					type="text" id="block3" class="block form-control" placeholder="cabrio"
					aria-describedby="basic-addon1">
			</div>

			<button type="button" value="Registreren"
				class="btn btn-success btn-lg pull-right">aanmelden</button>
		</form>
	</div>
	</form>


	<jsp:include page="/include/footer.jsp" />
</body>
</html>