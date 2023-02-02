package com.home;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.home.test.product.ProductDAO;

/**
 * Servlet implementation class HomeController
 */
@WebServlet("/HomeController")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    
	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeController() {
        super();
        // TODO Auto-generated constructor stub
        
        
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("H W");
//		String str = request.getMethod();
//		System.out.println("method :" +  str);
//		StringBuffer sb = request.getRequestURL();
//		System.out.println("url : " + sb);
//		str = request.getRequestURI();
//		System.out.println("uri : " + str);
//		Cookie[] cookie= request.getCookies();
//		for(Cookie c : cookie) {
//			System.out.println("cookie : " + c.getName());
//			System.out.println("value : " + c.getValue());
//		}
//		str = request.getContextPath();
//		System.out.println("contextpath : " + str);
//		str = request.getParameter("name");
//		System.out.println("param_NAME : " + str);
//		str = request.getParameter("age");
//		
//		if(str != null) {
//			int age = Integer.parseInt(str);
//			System.out.println("param_AGE : " + age);
//		}
//		String[] sList = request.getParameterValues("money");
//		
//		for(String strL : sList) {
//			System.out.println("money : " + strL);
//		}
		
//		PrintWriter out = response.getWriter();
//		out.println("<h1>lsy page</h1>");
//		out.println("<h1>gda</h1>");
//		
//		out.close();
		
		Soldier soldier = new Soldier();
		Gun gun = new Gun();
		Bullet bullet = new Bullet();
		gun.setB(bullet);
		soldier.setGun(gun);
		
		soldier.useGun();
		
		
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/home.jsp");
		view.forward(request, response);
		
		
		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
