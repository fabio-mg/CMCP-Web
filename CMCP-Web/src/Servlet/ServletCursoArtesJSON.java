package Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Geral.JSonFacade;
import Modelo.CursoArtes;

@WebServlet("/cursoArtesJSON")
public class ServletCursoArtesJSON extends HttpServlet {
	/*
	 * configurar a request e a response para todos os métodos
	 */
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		super.service(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		try {
			out.println(JSonFacade.getCursoArtesJSon());
		} catch (Exception e) {
			e.printStackTrace();
			out.println(JSonFacade.errorToJSon(e));
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		StringBuilder sb = JSonFacade.montaJSon(request);
		PrintWriter out = response.getWriter();
		try {
			CursoArtes c = JSonFacade.jSonToCursoArtes(sb.toString());
			c.incluir();
		} catch (Exception e) {
			e.printStackTrace();
			out.println(JSonFacade.errorToJSon(e));
		}
	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		StringBuilder sb = JSonFacade.montaJSon(request);
		PrintWriter out = response.getWriter();
		try {
			CursoArtes c = JSonFacade.jSonToCursoArtes(sb.toString());
			c.atualizar();
		} catch (Exception e) {
			e.printStackTrace();
			out.println(JSonFacade.errorToJSon(e));
		}
	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		StringBuilder sb = JSonFacade.montaJSon(request);
		PrintWriter out = response.getWriter();
		try {
			CursoArtes c = JSonFacade.jSonToCursoArtes(sb.toString());
			c.excluir();
		} catch (Exception e) {
			e.printStackTrace();
			out.println(JSonFacade.errorToJSon(e));
		}
	}

}
