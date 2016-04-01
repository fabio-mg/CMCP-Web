package Servelet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Modelo.Aluno;

@WebServlet("/manterAluno")
public class AlunoController extends HttpServlet {
	private static final long serialVersionUID = 4878692514348200921L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		boolean alunoExiste = false;
		Aluno aluno = new Aluno();
		
		
		// Pega parâmetros
		String action = request.getParameter("action").trim().toLowerCase();
		String ra = request.getParameter("ra").trim();
		String nome = request.getParameter("nome").trim();
		String endereco = request.getParameter("endereco").trim();
		String telefone = request.getParameter("telefone").trim();
		String email = request.getParameter("email").trim();
		String rg = request.getParameter("rg").trim();
		String cpf = request.getParameter("cpf").trim();
		String login = request.getParameter("login").trim();
		String senha = request.getParameter("senha").trim();
		
		PrintWriter out = response.getWriter();

		// Se foi informado o ID então carrega o aluno
		if (!ra.trim().equals("")) {
			aluno.setIdAluno(Integer.parseInt(ra));
			aluno.carregar();
			alunoExiste = !aluno.getNome().trim().equals("");
		}
		
		if (action.equals("gravar")) {
			aluno.setNome(nome);
			aluno.setRG(rg);
			aluno.setCPF(cpf);
			aluno.setEndereco(endereco);
			aluno.setTelefone(telefone);
			aluno.setEmail(email);
			aluno.setLogin(login);
			aluno.setSenha(senha);
			if (alunoExiste) {
				aluno.atualizar();
			} else {
				aluno.incluir();
			}
			
			out.println("<html>");
			out.println("	<head>");
			out.println("		<title>CMCP - Cadastrar Aluno</title>");
			out.println("	</head>");
			out.println("	<body>");
			out.println("		Aluno Cadastrado com sucesso.");
			out.println("	</body>");
			out.println("</html>");
		} else {
			if (ra.trim().equals("")) {
				out.println("<html>");
				out.println("	<head>");
				out.println("		<title>CMCP - Cadastrar Aluno</title>");
				out.println("	</head>");
				out.println("	<body>");
				out.println("		R.A. não foi informado. " + action);
				out.println("	</body>");
				out.println("</html>");
			} else {
				if (!alunoExiste) {
					out.println("<html>");
					out.println("	<head>");
					out.println("		<title>CMCP - Cadastrar Aluno</title>");
					out.println("	</head>");
					out.println("	<body>");
					out.println("		Aluno não localizado. R.A. Informado não existe.");
					out.println("	</body>");
					out.println("</html>");
				} else {
					if (action.equals("excluir")) {
						aluno.excluir();
						out.println("<html>");
						out.println("	<head>");
						out.println("		<title>CMCP - Cadastrar Aluno</title>");
						out.println("	</head>");
						out.println("	<body>");
						out.println("		Aluno excluído com sucesso.");
						out.println("	</body>");
						out.println("</html>");
					} else {
						out.println("<html>");
						out.println("	<head>");
						out.println("		<title>CMCP - Cadastrar Aluno</title>");
						out.println("	</head>");
						out.println("	<body>");
						
						
						
						

						out.println("		<strong>R.A.:</strong> <br>");
						out.println("		" + aluno.getIdAluno() + "<br>");

						out.println("		<strong>Nome:</strong> <br>");
						out.println("		" + aluno.getNome() + "<br>");

						out.println("		<strong>Endereço:</strong> <br>");
						out.println("		" + aluno.getEndereco() + "<br>");

						out.println("		<strong>Telefone:</strong> <br>");
						out.println("		" + aluno.getTelefone() + "<br>");

						out.println("		<strong>E-Mail:</strong> <br>");
						out.println("		" + aluno.getEmail() + "<br>");

						out.println("		<strong>RG:</strong> <br>");
						out.println("		" + aluno.getRG() + "<br>");

						out.println("		<strong>CPF:</strong> <br>");
						out.println("		" + aluno.getCPF() + "<br>");

						out.println("		<strong>Login:</strong> <br>");
						out.println("		" + aluno.getLogin() + "<br>");

						out.println("</body></html>");
					}
				}
			}

		}

	}
}
