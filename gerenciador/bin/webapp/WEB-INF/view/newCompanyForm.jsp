<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/input" var="inputServlet"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<c:import url="partial-logout.jsp"/>

	<form action="${inputServlet}" method="POST">
	
		Nome: <input type="text" name="name"/>
		Data de Abertura: <input type="text" name="openingDate"/>
		<input type="hidden" name="action" value="NewCompany"/>
		<input type="submit"/>
	</form>
	<br>	
	<a href="input?action=ListCompany">Voltar para a lista</a>

</body>
</html>