<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="atd.backend.*, atd.database.OnderdelenDAO, atd.domein.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Voorraad beheer</title>
<!--  alle stylesheets  -->
<jsp:include page="/include/style.jsp" />
</head>

<body>
	<!--   main container -->
	<div class="container">
		<jsp:include page="/include/header.jsp" />
		<h2>Voorraad</h2>
		<p>Click op een onderdeel om te bestellen en aanpassing te kunnen
			maken</p>
		<div class="input-group">
			<span class="input-group-addon" id="basic-addon1">Aantal</span> <input
				type="text" class="form-control" placeholder="2342"
				aria-describedby="basic-addon1" id="aantal"> <span
				class="input-group-btn">
				<button class="btn btn-success" type="button">updaten</button>
			</span>
		</div>
		<div class="input-group">
			<span class="input-group-addon" id="basic-addon1">Naam</span> <input
				type="text" class="form-control" placeholder="Auto motor"
				aria-describedby="basic-addon1" id="naam" readonly>
		</div>
		<div class="input-group">
			<span class="input-group-addon" id="basic-addon1">Prijs</span> <input
				type="text" class="form-control" placeholder="$234.43"
				aria-describedby="basic-addon1" id="prijs" readonly>
		</div>
		<div class="row">
			<div class="col-lg-6"></div>
			<div class="col-lg-6">
				<div class="input-group">
					<input type="text" class="form-control"
						placeholder="geef aantal op"> <span
						class="input-group-btn">
						<button class="btn btn-success" type="button">bestellen</button>

					</span>
				</div>
			</div>
			<table class="table table-default" id="voorraad-table">

				<thead>
					<tr>
						<th>Naam</th>
						<th>Aantal</th>
						<th>Prijs</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="Onderdeel"
						items="${dbOnderdelen.getAllOnderdelen()}">
						<tr>
							<td>${Onderdeel.naam}</td>
							<td>${Onderdeel.voorraad }</td>
							<td>${Onderdeel.prijs }</td>
						</tr>
					</c:forEach>

					<tr>
						<td>auto dak</td>
						<td>43</td>
						<td>$87.40</td>
					</tr>
					<tr>
						<td>auto raam</td>
						<td>23</td>
						<td>$1200.00</td>
					</tr>
					<tr>
						<td>dashboard</td>
						<td>2</td>
						<td>$234.30</td>
					</tr>
					<tr>
						<td>stoel</td>
						<td>87</td>
						<td>$32.40</td>
					</tr>
					<tr>
						<td>Deur</td>
						<td>34</td>
						<td>$85.40</td>
					</tr>
				</tbody>
			</table>
			<!--  footer  -->
			<jsp:include page="/include/footer.jsp" />
			<!-- alle javascript files -->
			<script src="${pageContext.request.contextPath}/js/jquery-1.11.2.js"></script>
			<script src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
			<script src="${pageContext.request.contextPath}/js/main.js"></script>
</body>

</html>
