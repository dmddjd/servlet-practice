package com.kh.menu;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/menuOrder.do")
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public OrderServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String burger = request.getParameter("burger");
		int totalPrice = 0;
		switch(burger){
		case "한우버거": totalPrice += 5000; break;
		case "밥버거": totalPrice += 4500; break;
		case "치즈버거": totalPrice += 4000; break;
		}

		String side = request.getParameter("side");
		switch(side){
		case "감자튀김": totalPrice += 1500; break;
		case "어니언링": totalPrice += 1700; break;
		}

		String drink = request.getParameter("drink"); 
		switch(drink){
		case "콜라": totalPrice += 1000; break;
		case "사이다": totalPrice += 1000; break;
		case "커피": totalPrice += 1500; break;
		case "밀크쉐이크": totalPrice += 2500; break;
		}
		
		request.setAttribute("totalPrice", totalPrice);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/order.jsp");
		dispatcher.forward(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
}