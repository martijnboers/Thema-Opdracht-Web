<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page
	import="atd.backend.*, atd.domein.Afspraak, atd.database.OnderdelenDAO"%>
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
	<form action="/ATD-WEBSITE/Werkplaats.do" method="POST">

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
				<c:forEach var="Afspraak" items="${inbehandelingAfspraak}">
					<div class="afspraak">
						<div class="row">
							<div class="col-md-6">
								<p>
									status <span class="label label-success">${Afspraak.statusString}
									</span>
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
									</select> <label class="sr-only" for="exampleInputAmount">Amount
										(in dollars)</label>
									<div class="input-group">
										<div class="input-group-addon">Aantal</div>
										<input type="text" class="form-control" value="nieuwAantal"
											placeholder="ex. 43">

									</div>
								</div>
								<button name="run" value="bestellen" type="submit"
									class="btn btn-primary pull-right">Toevoegen</button>

							</div>
						</div>
						<table class="table table-striped">
							<thead>
								<tr>
									<th>ID</th>
									<th>Naam</th>
									<th>Aantal</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td>43</td>
									<td>Schroef</td>
									<td>43</td>
								</tr>
								<tr>
									<td>12</td>
									<td>Motor</td>
									<td>1</td>
								</tr>
								<tr>
									<td>923</td>
									<td>Bumber</td>
									<td>1</td>
								</tr>
							</tbody>
						</table>
						<div class="col-md-6 pull-right">
							<p>aantal gewerkte uren</p>
							<div class="input-group">
								<input type="text" class="form-control"> <span
									class="input-group-btn">
									<button name="run" value="afronden" class="btn btn-default"
										type="submit">afronden</button>
								</span>
							</div>

						</div>

					</div>


				</c:forEach>
			</c:when>
			<c:when test="${nieuweAfspraak != null}">
      nieuwe afspraken
    </c:when>
			<c:when test="${afgerondeAfspraak != null}">
       afgeronde	
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