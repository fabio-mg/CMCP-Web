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


import Modelo.CursoInformatica;

@WebServlet("/manterCursoInformatica")
public class CursoInformaticaController extends HttpServlet {
	private static final long serialVersionUID = -6039208777507422490L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		boolean cursoExiste = false;
		CursoInformatica cursoInformatica = new CursoInformatica();

		
		
		// Pega parâmetros
		String action = request.getParameter("action").trim().toLowerCase();
		String idCurso = request.getParameter("idCurso").trim();
		String nome = request.getParameter("nome").trim();
		String dataInicio = request.getParameter("dataInicio").trim();
		String dataTermino = request.getParameter("dataTermino").trim();
		String horario = request.getParameter("horario").trim();
		String numVagas = request.getParameter("numVagas").trim();
		String valor = request.getParameter("valor").trim();
		String numLab = request.getParameter("numLab").trim();
		String softwares = request.getParameter("softwares").trim();

		PrintWriter out = response.getWriter();

		// Se foi informado o ID então carrega o aluno
		if (!idCurso.trim().equals("")) {
			cursoInformatica.setIdCurso( Integer.parseInt(idCurso) );
			cursoInformatica.carregar();
			cursoExiste = !cursoInformatica.getNome().trim().equals("");
		}

		if (action.equals("gravar")) {
			
			cursoInformatica.setNome(nome);			
			
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
			cursoInformatica.setDataInicio( calDtIni );
			
			try {
				data = format.parse(dataTermino);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			Calendar calDtFin = Calendar.getInstance();
			calDtFin.setTime(data);
			cursoInformatica.setDataTermino( calDtFin );
			cursoInformatica.setValor( new BigDecimal(Double.parseDouble(valor)) );
			cursoInformatica.setHorario(horario);
			cursoInformatica.setNumeroVagas( Integer.parseInt(numVagas) );
			cursoInformatica.setNumeroLaboratorio( Integer.parseInt(numLab) );
			cursoInformatica.setSoftwares(softwares);
			if (cursoExiste) {
				cursoInformatica.atualizar();
			} else {
				cursoInformatica.incluir();
			}

			/*
			out.println("<html>");
			out.println("	<head>");
			out.println("		<title>CMCP - Cadastrar Curso de Informatica</title>");
			out.println("	</head>");
			out.println("	<body>");
			out.println("		Curso de Informatica Cadastrado com sucesso.");
			out.println("	</body>");
			out.println("</html>");*/
		} else {
			if (idCurso.trim().equals("")) {
				/*
				out.println("<html>");
				out.println("	<head>");
				out.println("		<title>CMCP - Cadastrar Curso de Informatica</title>");
				out.println("	</head>");
				out.println("	<body>");
				out.println("		Código do curso não informado.");
				out.println("	</body>");
				out.println("</html>");
				*/
			} else {
				if (!cursoExiste) {
					/*
					out.println("<html>");
					out.println("	<head>");
					out.println("		<title>CMCP - Cadastrar Curso de Informatica</title>");
					out.println("	</head>");
					out.println("	<body>");
					out.println("		Curso não localizado. Código do curso Informado não existe.");
					out.println("	</body>");
					out.println("</html>");
					*/
				} else {
					if (action.equals("excluir")) {
						cursoInformatica.excluir();
						/*
						out.println("<html>");
						out.println("	<head>");
						out.println("		<title>CMCP - Cadastrar Curso de Informatica</title>");
						out.println("	</head>");
						out.println("	<body>");
						out.println("		Curso excluído com sucesso.");
						out.println("	</body>");
						out.println("</html>");
						*/
					} else {
						/*
						out.println("<html>");
						out.println("	<head>");
						out.println("		<title>CMCP - Cadastrar Curso de Informatica</title>");
						out.println("	</head>");
						out.println("	<body>");
						
						
						out.println("		<strong>Código do Curso:</strong> <br>");
						out.println("		" + cursoInformatica.getIdCurso() + "<br>");

						out.println("		<strong>Nome:</strong> <br>");
						out.println("		" + cursoInformatica.getNome() + "<br>");

						
						Calendar c = cursoInformatica.getDataInicio();
						SimpleDateFormat s = new SimpleDateFormat("dd/MM/yyyy");
						String a = s.format(c.getTime());
						
						out.println("		<strong>Data Iníio</strong> <br>");
						out.println("		" + a + "<br>");
						
						
						Calendar c2 = cursoInformatica.getDataTermino();
						SimpleDateFormat s2 = new SimpleDateFormat("dd/MM/yyyy");
						String a2 = s2.format(c2.getTime());						
						
						out.println("		<strong>Data Término</strong> <br>");
						out.println("		" + a2 + "<br>");
						
						out.println("		<strong>Horário</strong> <br>");
						out.println("		" + cursoInformatica.getHorario() + "<br>");
						
						out.println("		<strong>Número de Vagas:</strong> <br>");
						out.println("		" + cursoInformatica.getNumeroVagas() + "<br>");

						out.println("		<strong>Valor</strong> <br>");
						out.println("		" + cursoInformatica.getValor() + "<br>");

						out.println("		<strong>Número do Laboratório</strong> <br>");
						out.println("		" + cursoInformatica.getNumeroLaboratorio() + "<br>");

						out.println("		<strong>Softwares</strong> <br>");
						out.println("		" + cursoInformatica.getSoftwares() + "<br>");


						out.println("</body></html>");
						*/
					}
				}
			}

		}
		
		RequestDispatcher view = request.getRequestDispatcher("CadastrarCursoInformatica.jsp");
		view.forward(request, response);
	}
}
