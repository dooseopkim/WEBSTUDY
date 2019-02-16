package com.gooditeas.aboutmeapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TodayServlet
 */
@WebServlet("/today")
public class TodayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");
      
    public TodayServlet() {
    	super();
    }
    
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    
	    //request.setCharacterEncoding("UTF-8");
	    response.setContentType("text/html;charset=UTF-8");
	    
	    
	    LocalDateTime nowDateTime = LocalDateTime.now();
	    
	    PrintWriter printWriter = response.getWriter();
	    printWriter.print(buildHtmlSource(nowDateTime));
	}
    
	
	private static String buildHtmlSource(LocalDateTime nowDateTime) {
	    StringBuilder sb = new StringBuilder();
	    String formattedDateTime = nowDateTime.format(dateTimeFormatter);
	    String frontHtml ="<!DOCTYPE html>\n" + 
	            "<html lang=\"ko\">\n" + 
	            "<head>\n" + 
	            "    <meta charset=\"UTF-8\">\n" + 
	            "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" + 
	            "    <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">\n" + 
	            "    <title>today</title>\n" + 
	            "</head>\n" + 
	            "<body>\n" + 
	            "    <a href = \"/aboutme\"> 메인으로 </a><br/>\n" + 
	            "";
	    String backHtml = "</body>\n" + "</html>";
	    return sb.append(frontHtml).append(formattedDateTime).append(backHtml).toString();
	}
}
