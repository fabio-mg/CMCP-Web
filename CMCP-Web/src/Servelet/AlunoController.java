package Servelet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
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
			
			
		} else {
			if (ra.trim().equals("")) {
				
			} else {
				if (!alunoExiste) {
					
				} else {
					if (action.equals("excluir")) {
						aluno.excluir();
						
					} else {
						
					}
				}
			}

		}
		
		request.setAttribute("aluno", aluno.getAlunoTO());
		RequestDispatcher view = request.getRequestDispatcher("AlunoCadastrado.jsp");
		view.forward(request, response); 
	}
}
