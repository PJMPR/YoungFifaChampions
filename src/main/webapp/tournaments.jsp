<%@page import="java.util.List"%>
<%@page import="domain.model.Person"%>
<%@page import="domain.model.Wallet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	    Person person = (Person) session.getAttribute("person");
	    List<Wallet> wallets = (List) session.getAttribute("wallets");
	%>
	<h1>Name: <%=person.getName() %></h1>
	<h1>Surname: <%=person.getSurname() %></h1>
	<h1>Wallets:</h1>
	<ol>
		<%for(Wallet wallet: wallets){ %>
			<li><%=wallet.getAsset() %> <%=wallet.getCurrency() %></li>
		<%} %>
	</ol>
	<form action="DbServlet" method="get">
	<input type="submit" value="Wyślij">
	</form>
</body>
</html>