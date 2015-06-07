<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ page import="atd.database.BerichtenService"%>
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
	<div class="homepage">
		<img src="${pageContext.request.contextPath}/images/homepage1.jpg">
		<h1>Welkom bij ATD</h1>
		<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.
			Vivamus varius augue non dolor pharetra sagittis. Maecenas laoreet
			metus a felis pretium, vitae eleifend purus varius. Vivamus sed porta
			lorem, ultrices consectetur tellus. Vivamus vitae arcu iaculis ligula
			tincidunt pharetra sit amet vel nibh. Ut nec tellus felis. Donec
			congue vel dolor quis efficitur. Nam at elementum mauris, in luctus
			nisl. Donec lobortis vulputate est, ac volutpat metus facilisis quis.
			Cras fringilla tellus nec turpis accumsan, tincidunt malesuada velit
			sodales. Donec volutpat magna lectus, nec tincidunt massa vehicula
			at. Vestibulum suscipit diam quis mattis vehicula. Etiam ut tellus at
			dui tincidunt interdum eu nec urna. Sed interdum id nulla vel
			laoreet. Vestibulum scelerisque, massa quis maximus porttitor, mauris
			felis auctor risus, vel commodo turpis sem eget magna.</p>
	</div>
	<jsp:include page="/include/footer.jsp" />
</body>
</html>