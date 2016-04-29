<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	
	<title>CMCP - Aluno Cadastrado com sucesso !</title>
	
	<link href="css/bootstrap.min.css" rel="stylesheet">	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<h2>CMCP - Aluno Cadastrado com sucesso !</h2>		
			<div class="form-group">
				<label for="ra">R.A. : ${aluno.ra}</label>  
			</div>		
			<div class="form-group">
				<label for="nome">Nome: ${aluno.nome}</label>
			</div>		
			<div class="form-group">
				<label for="endereco">Endereço: ${aluno.endereco}</label>
			</div>
			<div class="form-group">
				<label for="telefone">Telefone: ${aluno.telefone}</label>
			</div>
			<div class="form-group">
				<label for="email">E-Mail: ${aluno.email}</label>
			</div>
			<div class="form-group">
				<label for="rg">RG: ${aluno.rg}</label>
			</div>
			<div class="form-group">
				<label for="cpf">CPF: ${aluno.cpf}</label>
			</div>
			<div class="form-group">
				<label for="login">Login: ${aluno.login}</label>
			</div>
	</div>
</body>
</html>
