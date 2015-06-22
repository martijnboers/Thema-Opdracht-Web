<%@page import="atd.domein.Privilege"%>
<%@page import="atd.domein.AccountWrapper"%>
<%@page import="java.awt.print.Printable"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="/include/style.jsp" />
<%
	AccountWrapper account = (AccountWrapper) request.getSession().getAttribute("username");
	Privilege priv = account.getPriv();

	if (priv == Privilege.KLANT) {
		response.setHeader("Location", "ATD-WEBSITE/mijnatd/index.jsp");
		out.print("Klant");
	} else if (priv == Privilege.MONTEUR) {
		out.print("Monteur");
	} else if (priv == Privilege.ADMIN) {
		out.print("Admin");
	} else if (priv == Privilege.UNAUTHENTICATED){
		out.print("Unauth");
	}
%>