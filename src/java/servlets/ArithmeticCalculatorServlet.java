package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 710429
 */
public class ArithmeticCalculatorServlet extends HttpServlet {
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/arithmeticcalculator.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String operation = request.getParameter("submit");
        String first = request.getParameter("first");
        String second = request.getParameter("second");
        
        request.setAttribute("first", first);
        request.setAttribute("second", second);
        request.setAttribute("artMessage", "Result--");
        if(first == null || first.equals("") || (second == null) || second.equals("")) {
            request.setAttribute("artMessage", "invalid");
            getServletContext().getRequestDispatcher("/WEB-INF/arithmeticcalculator.jsp").forward(request, response);
        }
        
        int numFirst = Integer.parseInt(first);
        int numSecond = Integer.parseInt(second);
        
        //int calculate = numFirst operation  numSecond;
        request.setAttribute("artMessage", "Result: " + operation);
        getServletContext().getRequestDispatcher("/WEB-INF/arithmeticcalculator.jsp").forward(request, response);
        
    }

}
