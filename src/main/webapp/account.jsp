<%@page import="db.classes.User"%>
<%@page import="db.classes.Team"%>
<%@page import="com.mycompany.youngfifachampions.Repositories"%>

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
	    User user = (User) session.getAttribute("USER");
            Team team = (Team) session.getAttribute("TEAM");
	%>
	<h1>Zalogowany jako: <%=user.getLogin() %></h1>
        <a href="modifyAcc.html">ModyfikujDane</a><br><br>
        <a href="myTournaments.jsp">Turnieje</a><br><br>
        <%
            Repositories repo = new Repositories();
            //Pobranie drużyny, jeśli pusta to umożliwiamy dodanie
            if(team!=null){
                %><a href="manageTeam.jsp">Modyfikuj dane drużyny</a><%
            }else{
                %><a href="addTeam.html">Dodaj drużynę</a><%
            }
            %>
            
</body>
</html>