<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>CMCP - Cadastrar Curso de Informatica</title>
</head>

<body>
	<h3>CMCP - Cadastrar Curso de Informatica</h3>
	<form action="manterCursoInformatica" method="post">
		<strong>Código do Curso:</strong> <br>
		<input type="text" name="idCurso" size="10"> <br>

		<strong>Nome:</strong> <br>
		<input type="text" name="nome" size="100"> <br>
		
		<strong>Data Início</strong> <br>
		<input type="text" name="dataInicio" size="10"> <br>
		
		<strong>Data Término</strong> <br>
		<input type="text" name="dataTermino" size="10"> <br>
		
		<strong>Horário</strong> <br>
		<input type="text" name="horario" size="5"> <br>
		
		<strong>Número de Vagas</strong> <br>
		<input type="text" name="numVagas" size="5"> <br>
		
		<strong>Valor</strong> <br>
		<input type="text" name="valor" size="10"> <br>
		
		<strong>Número do Laboratório</strong> <br>
		<input type="text" name="numLab" size="10"> <br>
		
		<strong>Softwares</strong> <br>
		<input type="text" name="softwares" size="100"> <br> <br>
			
		<input type="submit" name="action" value="Gravar">
		<input type="submit" name="action" value="Consultar">
		<input type="submit" name="action" value="Excluir">
	</form>
</body>
</html>