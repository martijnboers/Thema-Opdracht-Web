<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page
	import="atd.backend.*, atd.database.OnderdelenDAO, atd.domein.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Werkplaats</title>
<jsp:include page="/include/style.jsp" />
</head>
<body>

	<jsp:include page="/include/header.jsp" />
	<h1>Werkplaats</h1>
	<p>hier komen de afspraken / reparaties die gedaan moeten worden</p>
	<form action="/ATD-WEBSITE/Afspraak.do" method="POST">

		<div class="btn-group btn-group-justified" role="group"
			aria-label="...">
			<div class="btn-group" role="group">
				<button type="submit" name="run" value="inbehandeling"
					class="btn btn-default">Inbehandeling</button>
			</div>
			<div class="btn-group" role="group">
				<button type="submit" name="run" value="nieuw"
					class="btn btn-default">Nieuw</button>
			</div>
			<div class="btn-group" role="group">
				<button type="submit" name="run" value="afgerond"
					class="btn btn-default">Afgerond</button>
			</div>

		</div>

		<c:choose>
			<c:when test="${inbehandelingAfspraak != null}">
       Salary is very low to survive.
    </c:when>
			<c:when test="${nieuweAfspraak != null}">
        Salary is very good.
    </c:when>
			<c:when test="${afgerondeAfspraak != null}">
        Salary is very good.
    </c:when>
			<c:otherwise>
				<p>Kies in het menu een afspraak die je wil bekijken</p>
			</c:otherwise>
		</c:choose>
		<jsp:include page="/include/footer.jsp" />
		</div>
		<script src="${pageContext.request.contextPath}/js/jquery-1.11.2.js"></script>
		<script src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
</body>
</html>