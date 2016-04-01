package Servelet;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import Modelo.CursoArtes;

@WebServlet("/manterCursoArtes")
public class CursoArtesController extends HttpServlet {
	private static final long serialVersionUID = -6039208777507422490L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		boolean cursoExiste = false;
		CursoArtes cursoArtes = new CursoArtes();

		
		
		// Pega par�metros
		String action = request.getParameter("action").trim().toLowerCase();
		String idCurso = request.getParameter("idCurso").trim();
		String nome = request.getParameter("nome").trim();
		String dataInicio = request.getParameter("dataInicio").trim();
		String dataTermino = request.getParameter("dataTermino").trim();
		String horario = request.getParameter("horario").trim();
		String numVagas = request.getParameter("numVagas").trim();
		String valor = request.getParameter("valor").trim();
		String descMat = request.getParameter("descMat").trim();
		String livrosUtil = request.getParameter("livrosUtil").trim();

		PrintWriter out = response.getWriter();

		// Se foi informado o ID ent�o carrega o aluno
		if (!idCurso.trim().equals("")) {
			cursoArtes.setIdCurso( Integer.parseInt(idCurso) );
			cursoArtes.carregar();
			cursoExiste = !cursoArtes.getNome().trim().equals("");
		}

		if (action.equals("gravar")) {
			
			cursoArtes.setNome(nome);			
			
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
			Date data = null;
			try {
				data = format.parse(dataInicio);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Calendar calDtIni = Calendar.getInstance();
			calDtIni.setTime(data);
			cursoArtes.setDataInicio( calDtIni );
			
			try {
				data = format.parse(dataTermino);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			Calendar calDtFin = Calendar.getInstance();
			calDtFin.setTime(data);
			cursoArtes.setDataTermino( calDtFin );
			cursoArtes.setValor( new BigDecimal(Double.parseDouble(valor)) );
			cursoArtes.setHorario(horario);
			cursoArtes.setNumeroVagas( Integer.parseInt(numVagas) );
			cursoArtes.setMateriais(descMat);
			cursoArtes.setLivros(livrosUtil);
			if (cursoExiste) {
				cursoArtes.atualizar();
			} else {
				cursoArtes.incluir();
			}

			out.println("<html>");
			out.println("	<head>");
			out.println("		<title>CMCP - Cadastrar Curso de Artes</title>");
			out.println("	</head>");
			out.println("	<body>");
			out.println("		Curso de Artes Cadastrado com sucesso.");
			out.println("	</body>");
			out.println("</html>");
		} else {
			if (idCurso.trim().equals("")) {
				out.println("<html>");
				out.println("	<head>");
				out.println("		<title>CMCP - Cadastrar Curso de Artes</title>");
				out.println("	</head>");
				out.println("	<body>");
				out.println("		C�digo do curso n�o informado.");
				out.println("	</body>");
				out.println("</html>");
				
			} else {
				if (!cursoExiste) {
					out.println("<html>");
					out.println("	<head>");
					out.println("		<title>CMCP - Cadastrar Curso de Artes</title>");
					out.println("	</head>");
					out.println("	<body>");
					out.println("		Curso n�o localizado. C�digo do curso Informado n�o existe.");
					out.println("	</body>");
					out.println("</html>");
				} else {
					if (action.equals("excluir")) {
						cursoArtes.excluir();
						
						out.println("<html>");
						out.println("	<head>");
						out.println("		<title>CMCP - Cadastrar Curso de Artes</title>");
						out.println("	</head>");
						out.println("	<body>");
						out.println("		Curso exclu�do com sucesso.");
						out.println("	</body>");
						out.println("</html>");
					} else {
						out.println("<html>");
						out.println("	<head>");
						out.println("		<title>CMCP - Cadastrar Curso de Artes</title>");
						out.println("	</head>");
						out.println("	<body>");
						
						
						out.println("		<strong>C�digo do Curso:</strong> <br>");
						out.println("		" + cursoArtes.getIdCurso() + "<br>");

						out.println("		<strong>Nome:</strong> <br>");
						out.println("		" + cursoArtes.getNome() + "<br>");

						
						Calendar c = cursoArtes.getDataInicio();
						SimpleDateFormat s = new SimpleDateFormat("dd/MM/yyyy");
						String a = s.format(c.getTime());
						
						out.println("		<strong>Data In�io</strong> <br>");
						out.println("		" + a + "<br>");
						
						
						Calendar c2 = cursoArtes.getDataTermino();
						SimpleDateFormat s2 = new SimpleDateFormat("dd/MM/yyyy");
						String a2 = s2.format(c2.getTime());						
						
						out.println("		<strong>Data T�rmino</strong> <br>");
						out.println("		" + a2 + "<br>");
						
						out.println("		<strong>Hor�rio</strong> <br>");
						out.println("		" + cursoArtes.getHorario() + "<br>");
						

						out.println("		<strong>N�mero de Vagas:</strong> <br>");
						out.println("		" + cursoArtes.getNumeroVagas() + "<br>");

						out.println("		<strong>Valor</strong> <br>");
						out.println("		" + cursoArtes.getValor() + "<br>");

						out.println("		<strong>Descri��o de Material</strong> <br>");
						out.println("		" + cursoArtes.getMateriais() + "<br>");

						out.println("		<strong>Nome dos Livros</strong> <br>");
						out.println("		" + cursoArtes.getLivros() + "<br>");


						out.println("</body></html>");
					}
				}
			}

		}

	}
}
