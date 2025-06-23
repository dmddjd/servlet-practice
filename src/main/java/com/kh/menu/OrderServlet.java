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
		int burgerPrice = 0;
		switch(burger){
		case "한우버거": burgerPrice = 5000; break;
		case "밥버거": burgerPrice = 4500; break;
		case "치즈버거": burgerPrice = 4000; break;
		}

		String side = request.getParameter("side");
		int sidePrice = 0;
		switch(side){
		case "감자튀김": sidePrice = 1500; break;
		case "어니언링": sidePrice = 1700; break;
		}

		String drink = request.getParameter("drink"); 
		int drinkPrice = 0;
		switch(drink){
		case "콜라": drinkPrice = 1000; break;
		case "사이다": drinkPrice = 1000; break;
		case "커피": drinkPrice = 1500; break;
		case "밀크쉐이크": drinkPrice = 2500; break;
		}
		
		int totalPrice = burgerPrice + sidePrice + drinkPrice;
		
		request.setAttribute("totalPrice", totalPrice);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/order.jsp");
		dispatcher.forward(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
}