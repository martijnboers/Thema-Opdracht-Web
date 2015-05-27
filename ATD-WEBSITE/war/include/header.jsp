<!--     navbar begin -->
<div class="container">
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="/ATD-WEBSITE/index.jsp">ATD</a>
			</div>
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<li><a href="#">Parkeren</a></li>
					<li><a href="/ATD-WEBSITE/werkplaats/werkplaats.jsp">Reparatie</a></li>
					<li><a href="/ATD-WEBSITE/voorraad/voorraad.jsp">Voorraad</a></li>
				</ul>
				<%@ page import="atd.domein.User"%>
				<%@ page import="atd.domein.Klant"%>
<%-- 				<%!private Object gebruiker = new Object(); %> --%>
				<%
					// Controlleer of ingelogd
					if (request.getSession().getAttribute("username") == null) {
						out.print("<ul class=\"nav navbar-nav navbar-right\"> <li><a href=\"/ATD-WEBSITE/login/login.jsp\">Login</a></li> <li> <!-- aanmeld button --> <form action=\"/ATD-WEBSITE/register/register.jsp\"><input type=\"submit\" value=\"Aanmelden\" class=\"btn btn-success navbar-btn\"></form> </li> </ul>");
					} else {
						if (request.getSession().getAttribute("username") instanceof User) {
							User user = (User) request.getSession().getAttribute("username");
							out.print("<ul class=\"nav navbar-nav navbar-right\"> <li><a href=\"/ATD-WEBSITE/Logout.do\">" + user.getNaam()
									+ "</a></li> </ul>");
						}
						if (request.getSession().getAttribute("username") instanceof Klant) {
							Klant klant = (Klant) request.getSession().getAttribute("username");
							out.print("<ul class=\"nav navbar-nav navbar-right\"> <li><a href=\"/ATD-WEBSITE/Logout.do\">" + klant.getVolledigeNaam()
									+ "</a></li> </ul>");
						}
					}
				%>
			</div>
		</div>
		<!-- navbar-einde -->
	</nav>