package servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addform")
public class TodoFormServlet extends HttpServlet {
    /**
     * Todo등록 버튼 클릭 시 todoForm.jsp로 포워딩.
     * Status(END)
     * **/
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	response.setContentType("text/html;charset=utf-8");
    	RequestDispatcher requestDispatcher = request.getRequestDispatcher("todoForm.jsp");
        requestDispatcher.forward(request,response);
    }
}
