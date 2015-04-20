<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
  <html>

  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Voorraad beheer</title>
    <!--  alle stylesheets  -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/custom.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap-theme.min.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" /> </head>

  <body>
    <!--   main container -->
    <div class="container">
      <!--     navbar begin -->
      <nav class="navbar navbar-inverse">
        <div class="container-fluid">
          <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
              <span class="sr-only">Toggle navigation</span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
            </button> <a class="navbar-brand" href="#">ATD</a> </div>
          <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
              <li><a href="#">Monteurs</a></li>
              <li><a href="#">Facturatie</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
              <!--         gebruikers naam -->
              <%@ page import="atd.domein.User" %>
              <li><a href="#"><% User user = (User)request.getAttribute("user"); out.print(user.getNaam()); %></a></li>
            </ul>
          </div>
        </div>
        <!-- navbar-einde -->
      </nav>
      <h2>Voorraad</h2>
      <p>Click op een onderdeel om te bestellen en aanpassing te kunnen maken</p>
      <div class="input-group">
        <span class="input-group-addon" id="basic-addon1">Aantal</span>
        <input type="text" class="form-control" placeholder="2342" aria-describedby="basic-addon1" id="aantal">
        <span class="input-group-btn">
          <button class="btn btn-success" type="button">updaten</button>
        </span>
      </div>
      <div class="input-group">
        <span class="input-group-addon" id="basic-addon1">Naam</span>
        <input type="text" class="form-control" placeholder="Auto motor" aria-describedby="basic-addon1" id="naam" readonly> </div>
      <div class="input-group">
        <span class="input-group-addon" id="basic-addon1">Prijs</span>
        <input type="text" class="form-control" placeholder="$234.43" aria-describedby="basic-addon1" id="prijs" readonly> </div>
      <div class="row">
        <div class="col-lg-6"> </div>
        <div class="col-lg-6">
          <div class="input-group">
            <input type="text" class="form-control" placeholder="geef aantal op">
            <span class="input-group-btn">
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
            <tr>
              <td>Wiel</td>
              <td>32</td>
              <td>$43.40</td>
            </tr>
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
        <div class="footer ">
          <p>Team 3</p>
        </div>
        <!-- alle javascript files -->
        <script src="${pageContext.request.contextPath}/js/jquery-1.11.2.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
        <script src="${pageContext.request.contextPath}/js/main.js"></script>
  </body>

  </html>
