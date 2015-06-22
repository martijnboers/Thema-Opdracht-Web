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
				<a class="navbar-brand" href="/ATD-WEBSITE/index.jsp"><img
					class="logo"
					src="${pageContext.request.contextPath}/images/logo.png" /></a>
			</div>
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<%@ page import="atd.domein.User"%>
				<%@ page import="atd.domein.Klant"%>
				<%@page import="atd.domein.Privilege"%>

				<%
					// Controlleer of ingelogd
					if (request.getSession().getAttribute("username") == null) {
						request.getSession().setAttribute("priv", Privilege.UNAUTHENTICATED);
						out.print("<ul class='nav navbar-nav'>" + "</ul>");
						out.print("<ul class=\"nav navbar-nav navbar-right\"> <li><a href=\"/ATD-WEBSITE/login/login.jsp\">Login</a></li> <li> <!-- aanmeld button --> <form action=\"/ATD-WEBSITE/register/register.jsp\"><input type=\"submit\" value=\"Aanmelden\" class=\"btn btn-success navbar-btn\"></form> </li> </ul>");
					} else {
						if (request.getSession().getAttribute("username") instanceof User) {
							request.getSession().setAttribute("priv", Privilege.MONTEUR);
							out.print("<ul class='nav navbar-nav'>" + "<li><a href='/ATD-WEBSITE/werkplaats/werkplaats.jsp'>Werkplaats</a></li>" + "<li><a href='/ATD-WEBSITE/voorraad/voorraad.jsp'>Voorraad</a></li>" + "</ul>");
							User user = (User) request.getSession().getAttribute("username");
							out.print("<ul class=\"nav navbar-nav navbar-right\"> <li><a href=\"/ATD-WEBSITE/Logout.do\">  " + user.getNaam() + " uitloggen</a></li> </ul>");
						}
						if (request.getSession().getAttribute("username") instanceof Klant) {
							request.getSession().setAttribute("priv", Privilege.KLANT);
							out.print("<ul class='nav navbar-nav'>" + "<li><a href='/ATD-WEBSITE/parkeren/parkeren.jsp'>Parkeren</a></li>" + "<li><a href='/ATD-WEBSITE/afspraak/afspraak.jsp'>Afspraak plannen</a></li>" + "</ul>");
							Klant klant = (Klant) request.getSession().getAttribute("username");
							out.print("<ul class=\"nav navbar-nav navbar-right\"> <li><a href=\"/ATD-WEBSITE/Logout.do\">" + klant.getNaam() + " uitloggen</a></li> </ul>");
						}
					}
				%>
			</div>
		</div>
		<!-- navbar-einde -->
	</nav>