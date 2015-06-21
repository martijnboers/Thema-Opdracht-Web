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
		<br>
		<center><h3>Je hebt geen toegang tot deze pagina</h3></center>
		<br>
		<jsp:include page="/include/footer.jsp" />
		</div>
		<script src="${pageContext.request.contextPath}/js/jquery-1.11.2.js"></script>
		<script src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
</body>
</html>