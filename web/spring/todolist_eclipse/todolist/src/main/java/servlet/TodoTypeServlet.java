package servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import dao.TodoDao;
import dto.TodoDto;

@WebServlet("/todo/type/*")
public class TodoTypeServlet extends HttpServlet {

	private TodoDao todoDao;

	@Override
	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");
		todoDao = new TodoDao();
		
		String id = getIdParam(request);
		String type = getJsonMap(request).get("type").toUpperCase();

		TodoDto todoDto = new TodoDto();
		todoDto.setId(Long.parseLong(id));
		todoDto.setType(type);

		String completeUpdate = "fail";
		if (todoDao.updateTodo(todoDto) == 1) {
			completeUpdate = "success";
		}

		Map<String, String> resMap = new HashMap<>();
		resMap.put("completeUpdate", completeUpdate);

		String json = new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(resMap);
		PrintWriter out = response.getWriter();
		out.println(json);
		out.close();
	}

	private String getIdParam(HttpServletRequest request) {
		String pathInfo = request.getPathInfo();
		String[] pathParts = pathInfo.split("/");
		String id = pathParts[1];
		return id;
	}

	private Map<String, String> getJsonMap(HttpServletRequest request) throws IOException {
		BufferedReader br = request.getReader();
		StringBuilder sb = new StringBuilder();
		String line = "";
		
		while ((line = br.readLine()) != null) {
			sb.append(line);
		}
		
		String jsonString = sb.toString();
		ObjectMapper mapper = new ObjectMapper();
		Map<String, String> typeMap = mapper.readValue(jsonString, new TypeReference<Map<String, String>>() {
		});
		return typeMap;
	}

}
