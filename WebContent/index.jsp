<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Authentification</title>
</head>
<body>
<%
Cookie[] cookies = null;
boolean logged = false;
cookies = request.getCookies();
if(cookies != null) {
	for(int i=0; i<cookies.length;i++) {
		if(cookies[i].getName().equals("userID")) {
			logged = true;
			break;
		}
	}
}
if(session.getAttribute("user")!=null || logged)
{
	   response.sendRedirect("demandeConge.jsp");
} 
%>
	<form action="AuthentificationServlet" method="POST">
		ID: <input type="number" name="login"/><br>
		Password: <input type="password" name="password"/><br>
		<input type="submit" value="OK">
	</form>
</body>
</html>