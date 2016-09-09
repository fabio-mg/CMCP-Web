<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	
	<title>CMCP - Cadastro de Alunos</title>
	
	<link href="css/bootstrap.min.css" rel="stylesheet">	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<h2>CMCP - Cadastro de Alunos</h2>
		<form action="manterAluno" method="post">
			<div class="form-group">
				<label for="ra">R.A. :</label>
				<input type="text" class="form-control" id="ra" name="ra" placeholder="R.A.">  
			</div>		
			<div class="form-group">
				<label for="nome">Nome:</label>
				<input type="text" class="form-control" id="nome" name="nome" placeholder="Nome">  
			</div>		
			<div class="form-group">
				<label for="endereco">Endereço:</label>
				<input type="text" class="form-control" id="endereco" name="endereco" placeholder="Endereço">  
			</div>
			<div class="form-group">
				<label for="telefone">Telefone:</label>
				<input type="text" class="form-control" id="telefone" name="telefone" placeholder="Telefone">  
			</div>
			<div class="form-group">
				<label for="email">E-Mail:</label>
				<input type="text" class="form-control" id="email" name="email" placeholder="E-Mail">  
			</div>
			<div class="form-group">
				<label for="rg">RG:</label>
				<input type="text" class="form-control" id="rg" name="rg" placeholder="RG">  
			</div>
			<div class="form-group">
				<label for="cpf">CPF:</label>
				<input type="text" class="form-control" id="cpf" name="cpf" placeholder="CPF">  
			</div>
			<div class="form-group">
				<label for="login">Login:</label>
				<input type="text" class="form-control" id="login" name="login" placeholder="login">  
			</div>
			<div class="form-group">
				<label for="senha">Senha:</label>
				<input type="text" class="form-control" id="senha" name="senha" placeholder="Senha">  
			</div>
	
			<button type="submit" class="btn btn-default" name="action" value="gravar">Gravar</button>
			<button type="submit" class="btn btn-default" name="action" value="consultar">Consultar</button>
			<button type="submit" class="btn btn-default" name="action" value="excluir">Excluir</button>
		</form>
	</div>
</body>
</html>
