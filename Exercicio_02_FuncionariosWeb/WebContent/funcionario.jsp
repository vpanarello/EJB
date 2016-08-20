<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<style>

body {
	font-family: sans-serif;
}



 td {
	border: solid blue 1px;
}

#alert {
	width: 200px;
	background-color: red;
	color: white;
	text-align: center;

}

</style>
<body>


	<c:choose>
		<c:when test="${ok==true}">
        <h5 id="alert">Cadastro Efetuado</h5>
        <br />
		</c:when>
		<c:otherwise>
		</c:otherwise>
	</c:choose>


	
	
	</h1>

	<h2>Lista de Livros</h2>
	
	<table>
		<tr>
			<td>CPF</td>
			<td>Nome</td>
			<td>Cargo</td>
			<td>Sal�rio</td>
			<td>IRPF</td>
			<td>INSS</td>
		</tr>
		<c:forEach var="liv" items="${lista}">
			<tr>
				<td>
					${liv.cpf}
				</td>
				<td>
					${liv.nome}
				</td>
				<td>
					${liv.cargo}
				</td>
				<td>
					${liv.salario}
				</td>
				<td>
					${liv.irpf}
				</td>
				<td>
					${liv.inss}
				</td>
			</tr>
		</c:forEach>
	
	</table>
	
	<li>
		<ul><a href="cadastro.jsp">Cadastro</a></ul>
	</li>
	
</body>
</html>
