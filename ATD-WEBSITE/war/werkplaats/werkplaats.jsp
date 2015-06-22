<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page
	import="atd.backend.*,  atd.domein.*,atd.database.OnderdelenDAO"%>
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


	<p>Bekijk hier de afspraken</p>
	<form action="/ATD-WEBSITE/Werkplaats.do" method="POST">

		<div class="btn-group btn-group-justified" role="group"
			aria-label="...">
			<div class="knop btn-group" role="group">
				<button type="submit" name="run" value="inbehandeling"
					class="knop btn btn-default ladda-button"
					data-spinner-color="#006400" data-style="expand-left">
					<span class="ladda-label">Inbehandeling</span>
				</button>
			</div>
			<div class="btn-group" role="group">
				<button type="submit" name="run" value="nieuw"
					class="knop btn btn-default ladda-button"
					data-spinner-color="#006400" data-style="expand-left">
					<span class="ladda-label">Nieuw</span>
				</button>
			</div>
			<div class="btn-group" role="group">
				<button type="submit" name="run" value="afgerond"
					class="knop btn btn-default ladda-button"
					data-spinner-color="#006400" data-style="expand-left">
					<span class="ladda-label">Afgerond</span>
				</button>
			</div>

		</div>


		<c:choose>
			<c:when test="${inbehandelingAfspraak != null}">
				<c:forEach var="Afspraak" items="${inbehandelingAfspraak}">
					<div class="afspraak">
						<!-- aparte form voor elk veld -->
						<form action="/ATD-WEBSITE/Werkplaats.do" method="POST">
							<div class="row">
								<div class="col-md-6">
									<p>
										<strong>status</strong> <span class="label label-success">${Afspraak.statusString}
										</span> </br> <strong>datum</strong> ${Afspraak.dateString}
									</p>

									<h4>Afspraak nr. ${Afspraak.ID}</h4>
									<p>${Afspraak.omschrijving}</p>
								</div>
								<div class="col-md-6">
									<h4>Klant info</h4>
									<ul>
										<li>${Afspraak.klant.username}</li>
										<li>${Afspraak.klant.email}</li>
										<li>${Afspraak.klant.postcode}</li>
									</ul>
								</div>
							</div>
							<div class="row">
								<div class="col-md-6">
									<h4>Auto info</h4>
									<ul>
										<li>${Afspraak.auto.merk}</li>
										<li>${Afspraak.auto.kenteken}</li>
										<li>${Afspraak.auto.type}</li>
									</ul>
								</div>
								<div class="col-md-6">

									<div class="form-group">
										<label for="sel1">Selecteer onderdeel (kies een):</label> <select
											name="nieuwOnderdeel" class="form-control" id="sel1">
											<c:forEach var="Onderdeel"
												items="${OnderdelenDAO.getAllOnderdelen()}">
												<option value="${Onderdeel.ID}">${Onderdeel.naam}</option>
											</c:forEach>
										</select>
										<div class="input-group">
											<div class="input-group-addon">Aantal</div>
											<input type="text" class="form-control" name="nieuwAantal"
												placeholder="ex. 43">

										</div>
									</div>
									<button name="toevoegen" value="${Afspraak.ID}" type="submit"
										class="btn btn-primary pull-right">Toevoegen</button>

								</div>
						</form>
					</div>
					<c:choose>
						<c:when test="${!Afspraak.alleOnderdelen.isEmpty()}">
							<div class="panel panel-default">
								<div class="panel-heading">onderdelen details</div>
								<table class="table table-striped" id="onderdelen-table">

									<thead>
										<tr>
											<th>Naam</th>
											<th>Aantal</th>
											<th>Prijs/stk</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach var="Onderdeel" items="${Afspraak.alleOnderdelen}">
											<tr>
												<td>${Onderdeel.naam}</td>
												<td>${Onderdeel.aantal}</td>
												<td class="prijs">${Onderdeel.prijs}</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
						</c:when>
						<c:otherwise>
							<div class="alert alert-info" role="alert">
								<p>Deze klus heeft nog geen onderdelen gebruikt</p>
							</div>
						</c:otherwise>
					</c:choose>
					<form action="/ATD-WEBSITE/Werkplaats.do" method="POST">
						<div class="col-md-6 pull-right">
							<p>aantal gewerkte uren</p>
							<div class="input-group">
								<input type="text" name="uren" class="form-control"> <span
									class="input-group-btn">
									<button name="afronden" value="${Afspraak.ID}"
										class="btn btn-default" type="submit">afronden</button>
								</span>
							</div>
						</div>
			</div>
	</form>
	</c:forEach>
	</c:when>
	<c:when test="${nieuweAfspraak != null}">
		<c:forEach var="Afspraak" items="${nieuweAfspraak}">
			<div class="afspraak">
				<div class="row">
					<div class="col-md-6">
						<p>
							status <span class="label label-warning">${Afspraak.statusString}
							</span> </br> <strong>datum</strong> ${Afspraak.dateString}
						</p>
						<h4>Afspraak nr. ${Afspraak.ID}</h4>
						<p>${Afspraak.omschrijving}</p>
					</div>
					<div class="col-md-6">
						<h4>Auto info</h4>
						<ul>
							<li>${Afspraak.auto.merk}</li>
							<li>${Afspraak.auto.kenteken}</li>
							<li>${Afspraak.auto.type}</li>
						</ul>
					</div>
				</div>
				<button class="btn btn-warning pull-right" name="aanmelden"
					value="${Afspraak.ID}" type="submit">Aanmelden</button>

			</div>
		</c:forEach>
	</c:when>
	<c:when test="${afgerondeAfspraak != null}">
		<c:forEach var="Afspraak" items="${afgerondeAfspraak}">
			<div class="afspraak">
				<div class="row">
					<div class="col-md-6">
						<p>
							status <span class="label label-default">${Afspraak.statusString}
							</span>
						</p>
						<h4>Afspraak nr. ${Afspraak.ID}</h4>
						<p>${Afspraak.omschrijving}</p>
					</div>
					<div class="col-md-6">
						<h4>Auto info</h4>
						<ul>
							<li>${Afspraak.auto.merk}</li>
							<li>${Afspraak.auto.kenteken}</li>
							<li>${Afspraak.auto.type}</li>
						</ul>
					</div>
				</div>
				<div class="panel panel-default">
					<div class="panel-heading">monteur details</div>
					<table class="table">
						<thead>
							<tr>
								<th>Monteur</th>
								<th>Uren</th>
								<th>Uur loon</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>${Afspraak.monteur.naam}</td>
								<td>${Afspraak.uren}</td>
								<td>${Afspraak.monteur.uurloon}</td>
							</tr>

						</tbody>
					</table>
				</div>
				<div class="panel panel-default">
					<div class="panel-heading">onderdelen details</div>
					<table class="table table-striped" id="onderdelen-table">

						<thead>
							<tr>
								<th>Naam</th>
								<th>Aantal</th>
								<th>Prijs/stk</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="Onderdeel" items="${Afspraak.alleOnderdelen}">
								<tr>
									<td>${Onderdeel.naam}</td>
									<td>${Onderdeel.aantal}</td>
									<td class="prijs">${Onderdeel.prijs}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				<h4 class="pull-right">
					<strong>totaal prijs</strong>
					<div class="totaalPrijs">${Afspraak.totaalPrijs}</div>
				</h4>
			</div>
		</c:forEach>
	</c:when>
	<c:otherwise>
		<div class="alert alert-info" role="alert">
			<p>Kies in het menu een afspraak die je wil bekijken</p>
		</div>

	</c:otherwise>
	</c:choose>
	<!-- error ophalen -->
	${requestScope.error}
	<jsp:include page="/include/footer.jsp" />
	</div>
	<script src="${pageContext.request.contextPath}/js/jquery-1.11.2.js"></script>
	<script src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
	<script src="${pageContext.request.contextPath}/js/accounting.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/main.js"></script>
</body>
</html>