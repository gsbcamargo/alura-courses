<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:url value="/input" var="linkInputServlet"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form action="${linkInputServlet}" method="post">
	
		Nome: <input type="text" name="name" value="${company.name}"/>
		Data de Abertura: <input type="text" name="openingDate" 
			value="<fmt:formatDate value="${company.openingDate}" pattern="dd/MM/yyyy"/>"/>
		<input type="hidden" name="id" value="${company.id}"/>
		<input type="hidden" name="action" value="EditCompany"/>
		<input type="submit"/>
	</form>

</body>
</html>