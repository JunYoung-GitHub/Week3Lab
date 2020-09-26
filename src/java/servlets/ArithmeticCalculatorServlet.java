package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
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
        request.setAttribute("artMessage", "Result: ---");
        getServletContext().getRequestDispatcher("/WEB-INF/arithmeticcalculator.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int result = 0;
        String first = request.getParameter("first");
        String second = request.getParameter("second");

        request.setAttribute("first", first);
        request.setAttribute("second", second);

        if ((first == null || first.equals("")) || ((second == null) || second.equals(""))) {
            request.setAttribute("artMessage", "invalid");
            getServletContext().getRequestDispatcher("/WEB-INF/arithmeticcalculator.jsp").forward(request, response);
        }

        try {
            int numFirst = Integer.parseInt(first);
            int numSecond = Integer.parseInt(second);
            String operation = request.getParameter("submit");

            if (null != operation) {
                switch (operation) {
                    case "+":
                        result = numFirst + numSecond;
                        break;
                    case "-":
                        result = numFirst - numSecond;
                        break;
                    case "*":
                        result = numFirst * numSecond;
                        break;
                    case "%":
                        result = numFirst % numSecond;
                        break;
                    default:
                        break;
                }
            }

            request.setAttribute("artMessage", "Result: " + result);
            getServletContext().getRequestDispatcher("/WEB-INF/arithmeticcalculator.jsp").forward(request, response);
        } catch (NumberFormatException e) {
            request.setAttribute("artMessage", "invalid");
            getServletContext().getRequestDispatcher("/WEB-INF/arithmeticcalculator.jsp").forward(request, response);
        }

    }
}
