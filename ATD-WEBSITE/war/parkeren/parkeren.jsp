<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Parkeren</title>
<jsp:include page="/include/style.jsp" />
</head>
<body>
	<jsp:include page="/include/header.jsp" />
	<form action="/ATD-WEBSITE/Parkeren.do" method="POST">
		<h1>Parkeren</h1>
		<p>U kunt bij ons een parkeer plek reserveren, vul hier uw
			aankomst en vertrek datum en we houden een parkeer plek voor u vrij!</p>

		<div class="date-container">

			<div class="date-box">
				<h3>Van</h3>
				<p>Dag van aankomst</p>
				<input class="form-control" type="text" id="datepicker_aankomst"
					name="datum_aankomst">
			</div>
			<div class="date-box">
				<h3>Tot</h3>
				<p>Dag van vertrek</p>
				<input class="form-control" type="text" id="datepicker_vertrek"
					name="datum_vertrek">
			</div>

			<div class="date-box pull-right">
				<h3>Bevestig</h3>
				<p>Bent u zeker van uw keuze?</p>
				<button type="submit" value="reserveren" name="run"
					value="nieuwOnderdeel" class="btn btn-success ">Reserveren</button>
			</div>
		</div>

	</form>
	${requestScope.msg}
	<jsp:include page="/include/footer.jsp" />

	<script src="${pageContext.request.contextPath}/js/jquery-1.11.2.js"></script>
	<script src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
</body>
</html>