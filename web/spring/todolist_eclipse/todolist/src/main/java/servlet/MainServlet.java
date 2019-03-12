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
import java.util.ArrayList;
import java.util.List;

@WebServlet("/")
public class MainServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private final TodoDao todoDao = new TodoDao();
    /**
     *  localhost:8080/ 로 접근 시 화면에 보여줄 데이터 받아서
     *  main.jsp로 forwarding
     *  Status(END)
     *  */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");

        List<TodoDto> totalDoList=todoDao.getTodos();
        List<TodoDto> todoList = new ArrayList<>();
        List<TodoDto> doingList = new ArrayList<>();
        List<TodoDto> doneList = new ArrayList<>();
        for(TodoDto todo : totalDoList){
            String todoType = todo.getType();
            switch (todoType){
                case "TODO":
                    todoList.add(todo);
                    break;
                case "DOING":
                    doingList.add(todo);
                    break;
                case "DONE":
                    doneList.add(todo);
                    break;
                default:
                    break;
            }
        }
        request.setAttribute("todoList",todoList);
        request.setAttribute("doingList",doingList);
        request.setAttribute("doneList",doneList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("main.jsp");
        dispatcher.forward(request,response);
    }
}
