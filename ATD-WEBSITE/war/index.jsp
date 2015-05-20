<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ page import="atd.database.BerichtenDAO"%>
<%@ page import="atd.domein.Bericht"%>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home</title>
<jsp:include page="/include/style.jsp" />
</head>
<body>
	<div class="container">
		<jsp:include page="/include/header.jsp" />
		<h2>Maak nieuw bericht</h2>
		<br>
		<form action="/ATD-WEBSITE/BlogPost.do" method="POST">

			<div class="input-group">
				<span class="input-group-addon" style="width: 150px"
					id="basic-addon1"> Bericht </span> <input type="text"
					class="form-control" name="bericht" placeholder="Input text"
					aria-describedby="basic-addon1">
			</div>
			<input type="submit" value="Bericht toevoegen"
				class="btn btn-success btn-lg pull-right">
		</form>
		<br> <br>
		<h2>Nieuwe berichten:</h2>
		<br>

		<%-- 		<c:forEach var="Berichten" items="${BerichtenDAO.getAllBerichten()}"> --%>
		<!-- 			<div class="jumbotron"> -->
		<!-- 				</p> -->
		<!-- 				<p> -->
		<!-- 					<a -->
		<!-- 						style="float: right; display: inline-block; margin: -60px -47px;" -->
		<%-- 						href="DeletePost.do?id=${Berichten.ID }">x</a> --%>
		<%-- 					${Berichten.bericht} --%>
		<!-- 				</p> -->
		<!-- 				<p> -->
		<%-- 					<em><small>- ${Berichten.getOwner.getNaam} " @ " ${Berichten.Date} --%>
		<!-- 					</small></em> -->
		<!-- 				</p> -->
		<!-- 			</div> -->
		<!-- 			<br> -->
		<%-- 		</c:forEach> --%>

		<%
			for (Bericht ber : BerichtenDAO.getAllBerichten()) {
				out.print("<div class=\"jumbotron\"></p><p><a style=\"float:right; display:inline-block; margin:-60px -47px;\" href=\"DeletePost.do?id="
						+ ber.getID()
						+ "\">x</a>"
						+ ber.getBericht()
						+ "</p><p><em><small>- "
						+ ber.getOwner().getNaam()
						+ " @ "
						+ ber.getDate() + "</small></em></div><br>");

			}
		%>
		<jsp:include page="/include/footer.jsp" />
</body>
</html>