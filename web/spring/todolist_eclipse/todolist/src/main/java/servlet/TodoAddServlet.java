package servlet;

import dao.TodoDao;
import dto.TodoDto;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/todo")
public class TodoAddServlet extends HttpServlet {

	private final TodoDao todoDao = new TodoDao();

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		String name = request.getParameter("name");
		int sequence = Integer.parseInt(request.getParameter("sequence"));
		String title = request.getParameter("title");

		TodoDto todoDto = new TodoDto(name, sequence, title);
		todoDao.addTodo(todoDto);

		response.sendRedirect("/todolist");
	}
}
