<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Demande Congé</title>
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
if(session.getAttribute("user")==null  || !logged)
{
	   response.sendRedirect("index.jsp");
} 
%>
	<form action="VerificationServlet" method="POST">
		Numéro du jour : <input type="number" name="day"min="1" max="100" step="1"/><br>
		<input type="submit" value="OK">
	</form>
	<a href="LogoutServlet">Se déconnecter</a>
</body>
</html>