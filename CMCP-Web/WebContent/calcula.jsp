<html>

<head>
	<title>Calculadora que deveria funcionar...</title>
</head>

<body>
	<form name="frm" onsubmit="return false">
		<strong>Número 1:</strong> <br> <input type="text" name="num1"
			size="10"> <br> <strong>Número 2:</strong> <br> <input
			type="text" name="num2" size="10"> <br> <strong>Resultado:</strong>
		<br> <input type="text" name="resultado" size="10"> <br>


		<input type="submit" name="btnSomar" value="Somar" onclick="soma()">
		<input type="submit" name="btnSubtrair" value="Subtrair" onclick="subtrair()"> 
		<input type="submit" name="btnMultiplicar" value="Multiplicar" onclick="multiplicar()"> 
		<input type="submit" name="btnDividir" value="Dividir" onclick="dividir()">
	</form>

	<script type="text/javascript">
		function soma() {
			val1 = parseFloat(document.frm.num1.value);
			val2 = parseFloat(document.frm.num2.value);
			result = val1 + val2;
			document.frm.resultado.value = result;
		}

		function subtrair() {
			val1 = parseFloat(document.frm.num1.value);
			val2 = parseFloat(document.frm.num2.value);
			result = val1 - val2;
			document.frm.resultado.value = result;
		}

		function multiplicar() {
			val1 = parseFloat(document.frm.num1.value);
			val2 = parseFloat(document.frm.num2.value);
			result = val1 * val2;
			document.frm.resultado.value = result;
		}

		function dividir() {
			val1 = parseFloat(document.frm.num1.value);
			val2 = parseFloat(document.frm.num2.value);
			result = val1 / val2;
			document.frm.resultado.value = result;
		}
	</script>
</body>


</html>