<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List, br.com.gabriel.gerenciador.servlet.Company"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Alura Servlet Course</title>
</head>
<body>

	<c:if test="${not empty company}">
		Empresa ${company} cadastrada com sucesso!
	</c:if>
	
	Lista de empresas: <br/>
	
	<ul>
		<c:forEach items="${companies}" var="company">
			
			<li>${company.name} - <fmt:formatDate value="${company.openingDate}" pattern="dd/MM/yyyy"/> </li>
			<a href="/gerenciador/showCompany?id=${company.id}">Editar</a>
			<a href="/gerenciador/removeCompany?id=${company.id}">Remover</a>
		</c:forEach>
	</ul>
	
</body>
</html>