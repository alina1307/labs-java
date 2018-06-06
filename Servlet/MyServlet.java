package com.example;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        response.setContentType("text/html; charset=UTF8");
        PrintWriter out = response.getWriter();

        try {

            String header = request.getParameter("header");
            int rows = Integer.parseInt(request.getParameter("rows"));
            int columns = Integer.parseInt(request.getParameter("columns"));
            String color = request.getParameter("color");

            out.println("<html>");
            out.println("<head><title>"+request.getParameter("header")+"</title></head>");
            out.println("<body>");
			out.println("<h1>"+request.getParameter("header")+"</h1>");
            out.println("<table style='background-color:"+color+";'>");
            for (int i=0; i < rows; i++) {
                out.println("<tr>");
                for (int j=0; j < columns; j++) {
                    out.println("<td>"+i+"</td>");
                }
                out.println("</tr>");
            }
            out.println("</table>");

            out.println("</body></html>");
        } finally {
            out.close();  
        }
    }
}
