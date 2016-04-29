<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	
	<title>CMCP - Cadastrar Curso de Artes</title>
	
	<link href="css/bootstrap.min.css" rel="stylesheet">	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<h2>CMCP - Cadastrar Curso de Artes</h2>
		<form action="manterCursoArtes" method="post">
			<div class="form-group">
				<label for="idCurso">Código do Curso:</label>
				<input type="text" class="form-control" id="idCurso" name="idCurso" placeholder="Código do Curso">  
			</div>
			
			<div class="form-group">
				<label for="nome">Nome:</label>
				<input type="text" class="form-control" id="nome" name="nome" placeholder="Nome do Curso">  
			</div>
			
			<div class="form-group">
				<label for="dataInicio">Data Início:</label>
				<input type="text" class="form-control" id="dataInicio" name="dataInicio" placeholder="Data Início:">  
			</div>
			
			<div class="form-group">
				<label for="dataTermino">Data Término:</label>
				<input type="text" class="form-control" id="dataTermino" name="dataTermino" placeholder="Data Término:">  
			</div>
			
			<div class="form-group">
				<label for="horario">Horário:</label>
				<input type="text" class="form-control" id="horario" name="horario" placeholder="Horário:">  
			</div>
			
			<div class="form-group">
				<label for="numVagas">Número de Vagas:</label>
				<input type="text" class="form-control" id="numVagas" name="numVagas" placeholder="Número de Vagas:">  
			</div>
			
			<div class="form-group">
				<label for="valor">Valor:</label>
				<input type="text" class="form-control" id="valor" name="valor" placeholder="Valor:">  
			</div>
			
			<div class="form-group">
				<label for="descMat">Descrição dos Materiais:</label>
				<input type="text" class="form-control" id="descMat" name="descMat" placeholder="Descrição dos Materiais">  
			</div>
			
			<div class="form-group">
				<label for="livrosUtil">Livros Utilizados:</label>
				<input type="text" class="form-control" id="livrosUtil" name="livrosUtil" placeholder="Livros Utilizados">  
			</div>
			
			<button type="submit" class="btn btn-default" name="action">Gravar</button>
			<button type="submit" class="btn btn-default" name="action">Consultar</button>
			<button type="submit" class="btn btn-default" name="action">Excluir</button>
		</form>
	</div>
</body>
</html>


