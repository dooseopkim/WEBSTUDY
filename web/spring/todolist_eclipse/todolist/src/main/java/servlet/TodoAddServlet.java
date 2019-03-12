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

	/**
	 * todoForm 에서 등록 버튼 클릭 시 서버로 데이터 저장 요청 처리하는 서블릿
	 * Status(End)
	 ***/

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		TodoDto todoDto = new TodoDto(request.getParameter("name").toString(),
				Integer.parseInt(request.getParameter("sequence").toString()),
				request.getParameter("title").toString());
		
		//혹시 몰라서 아직 넣어놈.
		boolean completeAdd = todoDao.addTodo(todoDto) == 1 ? true : false;
		
		response.sendRedirect("/todolist");
 	}
}
