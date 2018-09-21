package com.mahesh;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CalculatorServlet
 */
public class CalculatorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Serving Request---");
		Calculator cal=new Calculator();
		response.setContentType("text/html");
		PrintWriter out =response.getWriter();
		int num1=0;
		int num2=0;
		int op=0 ;
		try {
		num1=Integer.parseInt(request.getParameter("n1"));
		num2=Integer.parseInt(request.getParameter("n2"));
		op = Integer.parseInt(request.getParameter("op"));
		}catch(NumberFormatException e) {
			out.print("Please check the input values.");
			return;
		}
		int result;
	
		switch(op) {
		case 1:
			result=cal.addFunction(num1, num2);
			out.print(result);
			break;
		case 2:
			result=cal.substractFunction(num1, num2);
			out.print(result);
			break;
		case 3:
			result=cal.multiplyFunction(num1, num2);
			out.print(result);
			break;
		case 4:
			result=cal.divideFunction(num1, num2);
			out.print(result);
			break;
			default:
				result=0;
				out.print(result);
		}
	}
}
