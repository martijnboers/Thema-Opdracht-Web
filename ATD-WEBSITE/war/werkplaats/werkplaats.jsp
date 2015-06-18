<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
	<ul class="nav nav-tabs nav-justified">
		<li role="presentation" class="active"><a href="#">Alle
				afspraken</a></li>
		<li role="presentation"><a href="#">Mijn afspraken</a></li>
		<li role="presentation"><a href="#">Geen monteur</a></li>
	</ul>
	<div class="afspraak">
		<div class="row">
			<div class="col-md-6">
				<h4>Afspraak #43</h4>
				<p>Lorem ipsum dolor sit dolor a tincidunt. Mauris at elementum
					arcu, quis consequat elit amet, consectetur adipiscing elit.
					Curabitur consectetur non dolor a tincidunt. Mauris at elementum
					arcu, quis consequat elit</p>
			</div>
			<div class="col-md-6">
				<h4>Klant info</h4>
				<ul>
					<li>Mark</li>
					<li>0634532423</li>
					<li>Utrecht</li>
				</ul>
			</div>
		</div>
		<div class="row">
			<div class="col-md-6">
				<h4>Auto info</h4>
				<ul>
					<li>Audi</li>
					<li>Cabrio</li>
					<li>Diesel</li>
				</ul>
			</div>
			<div class="col-md-6">
				<form role="form">
					<div class="form-group">
						<label for="sel1">Selecteer onderdeel (kies een):</label> <select
							class="form-control" id="sel1">
							<option>onderdeel 1</option>
							<option>onderdeel 2</option>
							<option>ondedeel 3</option>
							<option>onderdeel 4</option>
						</select> <label class="sr-only" for="exampleInputAmount">Amount
							(in dollars)</label>
						<div class="input-group">
							<div class="input-group-addon">Aantal</div>
							<input type="text" class="form-control" id="exampleInputAmount"
								placeholder="ex. 43">

						</div>
					</div>
					<button type="submit" class="btn btn-primary pull-right">Toevoegen</button>
				</form>
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
					<button class="btn btn-default" type="submit">afronden</button>
				</span>
			</div>
		</div>
		<div class="clearfix"></div>
	</div>

	<div class="afspraak">
		<div class="row">
			<div class="col-md-6">
				<h4>Afspraak #943</h4>
				<p>Lorem ipsum dolor sit dolor a tincidunt. Mauris at elementum
					arcu, quis consequat elit amet, consectetur adipiscing elit.
					Curabitur consectetur non dolor a tincidunt. Mauris at elementum
					arcu, quis consequat elit</p>
			</div>
			<div class="col-md-6">
				<h4>Auto info</h4>
				<ul>
					<li>Range rover</li>
					<li>4x4</li>
					<li>Benzine</li>
				</ul>
			</div>
		</div>
		<button class="btn btn-success pull-right" type="submit">Aanmelden</button>

		<div class="clearfix"></div>
	</div>
	<jsp:include page="/include/footer.jsp" />
	</div>
	<script src="${pageContext.request.contextPath}/js/jquery-1.11.2.js"></script>
	<script src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
</body>
</html>