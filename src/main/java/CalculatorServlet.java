import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/calculate")
public class CalculatorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		try {
			double num1 = Double.parseDouble(req.getParameter("num1"));
			double num2 = Double.parseDouble(req.getParameter("num2"));
			String operation1 = req.getParameter("operation");

			double result = 0;
			switch (operation1) {
			case "add":
				result = num1 + num2;
				break;
			case "subtract":
				result = num1 - num2;
				break;

			case "multiply":
				result = num1 * num2;
				break;
			case "divide":
				if (num2 != 0) {
					result = num1 / num2;
				} else {
					out.println("Error : Cant division by zero");
					return;
				}
				break;
			default:
				out.println("Error :  Invalid Operation");
				return;
			}

			out.println("<html><body>");
			out.println("<h2>Result: " + result + "</h2>");
			out.println("<a href='index.html'>Go Back</a>");
			out.println("</body></html>");
		} catch (NumberFormatException e) {
			out.println("<html><body>");
			out.println("<h2>Error: Invalid number format</h2>");
			out.println("<a href='index.html'>Go Back</a>");
			out.println("</body></html>");
		}

	}

}
