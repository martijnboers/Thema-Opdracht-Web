<!--     navbar begin -->
<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#">ATD</a>
		</div>
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li><a href="#">Parkeren</a></li>
				<li><a href="#">Reparatie</a></li>
			</ul>
			<%
				// Controlleer of ingelogd
				if (request.getSession().getAttribute("username") == null) {
					out.print("<ul class=\"nav navbar-nav navbar-right\"> <li><a href=\"#\">Login</a></li> <li> <!-- aanmeld button --> <button type=\"button\" class=\"btn btn-success navbar-btn\">aanmelden</button> </li> </ul>");
				} else {
					out.print("<ul class=\"nav navbar-nav navbar-right\"> <li><a href=\"/ATD-WEBSITE/Logout.do\">" + request.getSession().getAttribute("username") + "</a></li> </ul>");
				}
			%>
		</div>
	</div>
	<!-- navbar-einde -->
</nav>