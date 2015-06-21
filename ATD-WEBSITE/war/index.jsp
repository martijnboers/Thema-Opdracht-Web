<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ page import="atd.services.BerichtenService"%>
<%@ page import="atd.domein.Bericht"%>
<%
	BerichtenService berichtenService = new BerichtenService();
	request.setAttribute("berichtenService", berichtenService);
%>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home</title>
<jsp:include page="/include/style.jsp" />
</head>
<body>

	<jsp:include page="/include/header.jsp" />
	<h2>Uw berichten:</h2>
	<br>

	<!-- Met EL -->
	<c:forEach var="Bericht" items="${berichtenService.alleBerichten}">
		<div class="jumbotron">
			</p>
			<p>
				<a style="float: right; display: inline-block; margin: -60px -47px;"
					href="DeletePost.do?id=${Bericht.id }">x</a> ${Bericht.bericht}
			</p>
			<p>
				<em><small>- ${Bericht.owner.naam} @ ${Bericht.date} </small></em>
			</p>
		</div>
		<br>
	</c:forEach>

	<jsp:include page="/include/footer.jsp" />
</body>
</html>