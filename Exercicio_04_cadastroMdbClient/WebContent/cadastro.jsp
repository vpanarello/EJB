<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Cadastro de Livros</h1>

	<form action="mdb" method="get">
		T�tulo:<br/> 
		<input type="text" name="titulo"> <br/>
		Autor:<br/>
		<input type="text" name="autor"> <br/> 
		Pre�o:<br/>
		<input type="text" name="preco"> <br/>
		<br/>
		<input type="submit" value="Enviar" />
	</form>
</body>
</html>