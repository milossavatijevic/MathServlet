package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/math")
public class MathServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MathServlet() {
        super();
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int a=0;
		int b=0;
		int c=0;
		boolean signal = true;
		if(validate(request, "a")) {
			a=Integer.parseInt(request.getParameter("a"));
		} else {
			signal = false;
		}
		if(validate(request, "b")) {
			b=Integer.parseInt(request.getParameter("b"));
		} else {
			signal = false;
		}
		request.setAttribute("c", c);
		doOperation(request, signal, a, b);
		RequestDispatcher rd = request.getRequestDispatcher("input.jsp");
		rd.forward(request, response);
	}
	
	private void doOperation(HttpServletRequest request, boolean signal, int firstOperand, int seconOperand) {
		if(signal) {
			if("Plus".equals(request.getParameter("operation")))
				request.setAttribute("c", plus(firstOperand, seconOperand));
			else
				request.setAttribute("c", minus(firstOperand, seconOperand));
			}
	}

	private boolean validate(HttpServletRequest request, String sign) {
		boolean validator = true;
		String number = request.getParameter(sign);
		try {
			if(number.isEmpty() || !checkNumber(number))
				throw new Exception("Insert number...");
		} catch (Exception e) {
			validator = false;
			request.setAttribute("error"+sign.toUpperCase(), sign.toUpperCase()+" is not number");
		}
		request.setAttribute("parametar"+sign.toUpperCase(), number);
		return validator;
	}

	private boolean checkNumber(String parameter) {
		try {
			Integer.parseInt(parameter);
		} catch(Exception e){
			return false;
		}
		return true;
	}

	private int plus(int a, int b) {
		return a+b;
	}
	
	private int minus(int a, int b) {
		return a-b;
	}

}
