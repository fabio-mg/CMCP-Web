<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	
	<title>CMCP - Curso de Artes Cadastrado com Sucesso!</title>
	
	<link href="css/bootstrap.min.css" rel="stylesheet">	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<h2>CMCP - Curso de Artes Cadastrado com Sucesso!</h2>
		
			<div class="form-group">
				<label for="idCurso">Código do Curso: ${cursoArtes.idCurso}</label>
			</div>
						
			<div class="form-group">
				<label for="nome">Nome: ${cursoArtes.nome}</label>
			</div>
			
			<div class="form-group">
				<label for="dataInicio">Data Início: ${cursoArtes.dataInicio}</label>
			</div>
			
			<div class="form-group">
				<label for="dataTermino">Data Término: ${cursoArtes.dataTermino}</label>
			</div>
			
			<div class="form-group">
				<label for="horario">Horário: ${cursoArtes.horario}</label>
			</div>
			
			<div class="form-group">
				<label for="numVagas">Número de Vagas: ${cursoArtes.numVagas}</label>
			</div>
			
			<div class="form-group">
				<label for="valor">Valor: ${cursoArtes.valor}</label>
			</div>
			
			<div class="form-group">
				<label for="descMat">Descrição dos Materiais: ${cursoArtes.descMateriais}</label>
			</div>
			
			<div class="form-group">
				<label for="livrosUtil">Livros Utilizados: ${cursoArtes.livrosUtil}</label>
			</div>
	</div>
</body>
</html>


