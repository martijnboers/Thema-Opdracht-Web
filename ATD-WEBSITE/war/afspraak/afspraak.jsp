<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="atd.backend.*, atd.domein.*, atd.database.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Werkplaats</title>
<jsp:include page="/include/style.jsp" />
</head>
<body>

	<jsp:include page="/include/header.jsp" />
	<h1>Afspraak maken</h1>
	<p>Hier kan een klant een afspraak maken</p>
	<div class="afspraakmaken">
		<form action="/ATD-WEBSITE/Afspraak.do" method="POST">
			<form action="/ATD-WEBSITE/Afspraak.do" method="POST">

				<p>Om een afraak te maken bij ATD dient u een account aan te
					maken, Geef hier onder uw gegevens op een gewenste datum voor een
					afspraak</p>
				<div class="row">
					<div class="col-md-6">
						<h3>Auto info</h3>
						<ul>
							<li>${sessionScope.username.deAuto.merk}</li>
							<li>${sessionScope.username.deAuto.type}</li>
							<li>${sessionScope.username.deAuto.kenteken}</li>
						</ul>
					</div>
					<div class="col-md-6">
						<h3>Datum</h3>
						<p>Wanneer komt u langs</p>
						<input class="form-control" type="text" id="datepicker_vertrek"
							name="datum">
					</div>
				</div>
				<div class="form-group">
					<label for="comment">Omschrijving:</label>
					<textarea name="omschrijving" class="form-control" rows="5"
						id="comment"></textarea>
				</div>

				<input type="submit" value="Bevestig"
					class="btn btn-success btn-lg pull-right">
			</form>
			${requestScope.errorReg}
		</form>
	</div>

	<jsp:include page="/include/footer.jsp" />

	<script src="${pageContext.request.contextPath}/js/jquery-1.11.2.js"></script>
	<script src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
</body>
</html>