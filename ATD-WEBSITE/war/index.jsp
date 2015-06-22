<%@page import="atd.domein.Privilege"%>
<%@page import="atd.domein.AccountWrapper"%>
<%@page import="java.awt.print.Printable"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
	AccountWrapper account = (AccountWrapper) request.getSession().getAttribute("username");
	Privilege priv = account.getPriv();

	if (priv == Privilege.KLANT) {
		response.sendRedirect("mijnatd/index.jsp");
	} else if (priv == Privilege.MONTEUR) {
		response.sendRedirect("werkplaats/werkplaats.jsp");
	} else if (priv == Privilege.ADMIN) {
		response.sendRedirect("werkplaats/werkplaats.jsp");
	} else if (priv == Privilege.UNAUTHENTICATED){
		response.sendRedirect("login/login.jsp");
	}
%>