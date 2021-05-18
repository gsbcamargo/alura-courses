<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List,br.com.gabriel.gerenciador.model.Materia"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Alura Servlet Course</title>
</head>
<body>

	<c:import url="partial-logout.jsp"/>

	Usuário logado: ${userSigned.login}
	
	<br>
	<br>

	<c:if test="${not empty company}">
		Empresa ${company} cadastrada com sucesso!
	</c:if>
	
	Lista de empresas: <br/>
	
	<ul>
		<c:forEach items="${companies}" var="company">
			
			<li>${company.name} - <fmt:formatDate value="${company.openingDate}" pattern="dd/MM/yyyy"/> </li>
			<a href="/gerenciador/input?action=ShowCompany&id=${company.id}">Editar</a>
			<a href="/gerenciador/input?action=RemoveCompany&id=${company.id}">Remover</a>
			<br>
			<br>
		</c:forEach>
	</ul>
	<a href="input?action=NewCompanyForm">Adicionar empresa</a>
	
</body>
</html>