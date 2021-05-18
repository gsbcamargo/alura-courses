<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/input" var="linkInputServlet"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form action="${linkInputServlet}" method="POST">
	
		Login: <input type="text" name="login"/>
		Senha: <input type="password" name="password"/>
		<input type="hidden" name="action" value="Login"/>
		<input type="submit"/>
	</form>

</body>
</html>