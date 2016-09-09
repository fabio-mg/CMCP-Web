package Geral;

import java.io.BufferedReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import Modelo.CursoArtes;
import Modelo.CursoInformatica;

public class JSonFacade {

	public static StringBuilder montaJSon(HttpServletRequest request) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader reader = request.getReader();
		try {
			String line;
			while ((line = reader.readLine()) != null) {
				sb.append(line).append('\n');
			}
		} finally {
			reader.close();
		}
		return sb;
	}

	public static String getCursoArtesJSon() {
		JSONArray vetor = new JSONArray();

		String sqlStr = " SELECT * FROM TABCURSO_ARTES "
				+ " INNER JOIN TABCURSO ON (IDTABCURSO = TABCURSO_IDTABCURSO) ";

		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlStr);) {

			try (ResultSet rs = stm.executeQuery()) {

				while (rs.next()) {
					JSONObject object = new JSONObject();
					try {
						object.put("idCurso", rs.getInt("IDTABCURSO"));
						object.put("nome", rs.getString("NOME"));
						object.put("dataInicio", rs.getString("DATA_INICIO"));
						object.put("dataTermino", rs.getString("DATA_TERMINO"));
						object.put("horario", rs.getString("HORARIO"));
						object.put("numVagas", rs.getInt("NUM_VAGAS"));
						object.put("valor", rs.getBigDecimal("VALOR"));
						object.put("descMaterial", rs.getString("DESC_MATERIAL"));
						object.put("nomeLivro", rs.getString("NOME_LIVRO"));

						vetor.put(object);
					} catch (JSONException e) {
						e.printStackTrace();
					}
				}

			} catch (SQLException e) {
				e.printStackTrace();

			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}

		return vetor.toString();
	}

	public static CursoArtes jSonToCursoArtes(String json) throws IOException {
		try {
			JSONObject registro = new JSONObject(json);
			
			int id = registro.getInt("idCurso");
			String nome = registro.getString("nome");
			String dataInicio = registro.getString("dataInicio");
			String dataTermino = registro.getString("dataTermino");
			String horario = registro.getString("horario");
			int numVagas = registro.getInt("numVagas");
			BigDecimal valor = BigDecimal.valueOf(registro.getDouble("valor"));
			String descMaterial = registro.getString("valor");
			String nomeLivro = registro.getString("nomeLivro");
			
			
			CursoArtes c = new CursoArtes();
			c.setIdCurso(id);
			c.setNome(nome);
			
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
			Date data = null;
			try {
				data = format.parse(dataInicio);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			Calendar calDtIni = Calendar.getInstance();
			calDtIni.setTime(data);
			c.setDataInicio(calDtIni);
			
			
			format = new SimpleDateFormat("dd/MM/yyyy");
			data = null;
			try {
				data = format.parse(dataTermino);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			Calendar calDtTer = Calendar.getInstance();
			calDtTer.setTime(data);
			c.setDataTermino(calDtTer);
			c.setHorario(horario);
			c.setNumeroVagas(numVagas);
			c.setValor(valor);
			c.setMateriais(descMaterial);
			c.setLivros(nomeLivro);
				
			return c;
		} catch (JSONException jsone) {
			jsone.printStackTrace();
			throw new IOException(jsone);
		}
	}

	public static String getCursoInformaticaJSon() {
		JSONArray vetor = new JSONArray();

		String sqlStr = " SELECT * FROM TABCURSO_INFOR "
				+ " INNER JOIN TABCURSO ON (IDTABCURSO = TABCURSO_IDTABCURSO) ";

		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlStr);) {

			try (ResultSet rs = stm.executeQuery()) {

				while (rs.next()) {
					JSONObject object = new JSONObject();
					try {
						object.put("idCurso", rs.getInt("IDTABCURSO"));
						object.put("nome", rs.getString("NOME"));
						object.put("dataInicio", rs.getString("DATA_INICIO"));
						object.put("dataTermino", rs.getString("DATA_TERMINO"));
						object.put("horario", rs.getString("HORARIO"));
						object.put("numVagas", rs.getInt("NUM_VAGAS"));
						object.put("valor", rs.getBigDecimal("VALOR"));
						object.put("numLaboratorio", rs.getInt("NUM_LABORATORIO"));
						object.put("software", rs.getString("SOFTWARE"));

						vetor.put(object);
					} catch (JSONException e) {
						e.printStackTrace();
					}
				}

			} catch (SQLException e) {
				e.printStackTrace();

			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}

		return vetor.toString();
	}
	
	
	public static CursoInformatica jSonToCursoInformatica(String json) throws IOException {
		try {
			JSONObject registro = new JSONObject(json);
			
			int id = registro.getInt("idCurso");
			String nome = registro.getString("nome");
			String dataInicio = registro.getString("dataInicio");
			String dataTermino = registro.getString("dataTermino");
			String horario = registro.getString("horario");
			int numVagas = registro.getInt("numVagas");
			BigDecimal valor = BigDecimal.valueOf(registro.getDouble("valor"));
			int numLab = registro.getInt("numLaboratorio");
			String software = registro.getString("software");
			
			
			CursoInformatica c = new CursoInformatica();
			c.setIdCurso(id);
			c.setNome(nome);
			
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
			Date data = null;
			try {
				data = format.parse(dataInicio);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			Calendar calDtIni = Calendar.getInstance();
			calDtIni.setTime(data);
			c.setDataInicio(calDtIni);
			
			
			format = new SimpleDateFormat("dd/MM/yyyy");
			data = null;
			try {
				data = format.parse(dataTermino);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			Calendar calDtTer = Calendar.getInstance();
			calDtTer.setTime(data);
			c.setDataTermino(calDtTer);
			c.setHorario(horario);
			c.setNumeroVagas(numVagas);
			c.setValor(valor);
			c.setNumeroLaboratorio(numLab); 
			c.setSoftwares(software);
				
			return c;
		} catch (JSONException jsone) {
			jsone.printStackTrace();
			throw new IOException(jsone);
		}
	}

	public static String errorToJSon(Exception e) {
		JSONObject object = new JSONObject();
		try {
			object.put("error", e.toString());
		} catch (JSONException e1) {
			e.printStackTrace();
		}
		return object.toString();
	}

}
