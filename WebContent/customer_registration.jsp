<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastro Cliente</title>
</head>
<body>

	<h1>Cadastro Cliente</h1>
	<form action="CustomerResource" method="POST">
		Nome: <input type="text" name="name" required="required"/><br/>
		CPF: <input type="text" name="cpf" /><br/>
		E-Mail: <input type="text" name="email" /><br/>
		Nascimento: <input type="text" name="born"/><br/>
		Sexo: <input type="text" name="sexo" /><br/>
		Nome social: <input type="text" name="social" /><br/>
		Apelido: <input type="text" name="nickname"/><br/>
		Telefone: <input type="text" name="phone" /><br/>
		<input type="submit" value="Salvar"/>
	</form>

</body>
</html>