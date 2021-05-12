<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
	<body>
	
		<c:if test="${not empty company}">
			Empresa ${company} cadastrada com sucesso!
		</c:if>
		
		<c:if test="${empty company}">
			Nenhuma empresa cadastrada!
		</c:if>

	</body>
</html>
