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
		<form action="/ATD-WEBSITE/Register.do" method="POST">
			<p>
				<input type="checkbox" id="checkbox" name="checkbox"> als
				werknemen aanmelden?
			</p>
			<p>Om een afraak te maken bij ATD dient u een account aan te
				maken, Geef hier onder uw gegevens op een gewenste datum voor een
				afspraak</p>

			${requestScope.errorReg}

			<div class="input-group">
				<span class="input-group-addon"> Username </span> <input
					name="username" type="text" class="form-control"
					placeholder="Jantje32" aria-describedby="basic-addon1"
					value="${param.username }">
			</div>
			<div class="input-group">
				<span class="input-group-addon"> Password </span> <input
					name="password" type="password" class="form-control"
					placeholder="wachtwoord123" value="${param.password }"
					aria-describedby="basic-addon1">
			</div>
			<div class="input-group">
				<span class="input-group-addon"> Naam </span> <input name="realname"
					type="text" class="form-control" placeholder="Jan kees"
					value="${param.realname }" aria-describedby="basic-addon1">
			</div>
			<div class="input-group">
				<span class="input-group-addon">Postcode</span> <input type="text"
					class="form-control" id="postcode" name="postcode"
					placeholder="1541TW" value="${param.postcode }"
					aria-describedby="basic-addon1">
			</div>
			<div class="input-group">
				<span class="input-group-addon">Email</span> <input type="text"
					class="form-control" id="email" name="email"
					placeholder="yourmail@gmail.com" value="${param.email }"
					aria-describedby="basic-addon1">
			</div>

			<h2>De auto</h2>
			<div class="input-group">
				<span class="input-group-addon"> Kenteken </span> <input type="text"
					id="block1" name="kenteken" class="block form-control"
					placeholder="15-XS-2" value="${param.kenteken }"
					aria-describedby="basic-addon1">
			</div>
			<div class="input-group">
				<span class="input-group-addon"> Merk </span> <input type="text"
					id="block2" class="block form-control" placeholder="audi"
					value="${param.merk }" name="merk"
					aria-describedby="basic-addon1">
			</div>
			<div class="input-group">
				<span class="input-group-addon"> Type </span> <input type="text"
					id="block3" name="type" class="block form-control"
					placeholder="cabrio" value="${param.type }"
					aria-describedby="basic-addon1">
			</div>

			<input type="submit" value="Registreren"
				class="btn btn-success btn-lg pull-right">
		</form>
	</div>
	</form>


	<jsp:include page="/include/footer.jsp" />
</body>
</html>