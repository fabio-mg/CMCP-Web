<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>CMCP - Cadastro de Alunos</title>
</head>
<body>
	<h3>CMCP - Cadastro de Aluno</h3>
	<form action="manterAluno" method="post">
		<strong>R.A.:</strong> <br>
		<input type="text" name="ra" size="10"> <br>

		<strong>Nome:</strong> <br>
		<input type="text" name="nome" size="100"> <br>
		
		<strong>Endereço:</strong> <br>
		<input type="text" name="endereco" size="100"> <br>
		
		<strong>Telefone:</strong> <br>
		<input type="text" name="telefone" size="15"> <br>
		
		<strong>E-Mail:</strong> <br>
		<input type="text" name="email" size="85"> <br>
		
		<strong>RG:</strong> <br>
		<input type="text" name="rg"> <br>
		
		<strong>CPF:</strong> <br>
		<input type="text" name="cpf"> <br>
		
		<strong>Login:</strong> <br>
		<input type="text" name="login"> <br>
		
		<strong>Senha:</strong> <br>
		<input type="password" name="senha"> <br> <br>
			
		
		<input type="submit" name="action" value="Gravar">
		<input type="submit" name="action" value="Consultar">
		<input type="submit" name="action" value="Excluir">
	</form>
</body>
</html>
