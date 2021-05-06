<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/newCompany" var="linkServletNewCompany"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form action="${linkServletNewCompany}" method="POST">
	
		Nome: <input type="text" name="name"/>
		Data de Abertura: <input type="text" name="openingDate"/>
	
		<input type="submit" />
	</form>

</body>
</html>