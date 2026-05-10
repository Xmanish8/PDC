import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class CalculatorServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        double num1 = Double.parseDouble(request.getParameter("num1"));
        double num2 = Double.parseDouble(request.getParameter("num2"));
        String operation = request.getParameter("operation");

        double result = 0;
//javac -cp "C:\Users\Dell\Downloads\apache-tomcat-9.0.117\lib\servlet-api.jar" CalculatorServlet.java
        switch (operation) {
            case "add": result = num1 + num2; break;
            case "subtract": result = num1 - num2; break;
            case "multiply": result = num1 * num2; break;
            case "divide": result = num2 != 0 ? num1 / num2 : 0; break;
        }

        out.println("<h2>Result: " + result + "</h2>");
    }
}