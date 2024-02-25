package com.customer;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeleteCustomerServlet
 */
@WebServlet("/DeleteCustomerServlet")
public class DeleteCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("cusid");
		
		boolean isTrue;
		
		isTrue = CustomerDBUtil.DeleteCustomer(id);
		
		if(isTrue == true) {
			RequestDispatcher dis1 = request.getRequestDispatcher("insertdata.jsp");
			dis1.forward(request, response);
		} else {
			
			List<Customer> cusDetails = CustomerDBUtil.GetcustomerDetails(id);
			
			request.setAttribute("cusDetails", cusDetails);
			
			RequestDispatcher dis2 = request.getRequestDispatcher("useraccount.jsp");
			dis2.forward(request, response);
		}
		
	}

}
