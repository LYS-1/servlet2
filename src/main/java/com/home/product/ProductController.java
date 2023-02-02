package com.home.product;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.home.test.product.ProductDAO;
import com.company.home.test.product.ProductDTO;
import com.company.home.test.product.ProductService;
import com.company.home.test.product.option.ProductOptionDAO;
import com.company.home.test.product.option.ProductOptionDTO;

/**
 * Servlet implementation class ProductController
 */
@WebServlet("/ProductController")
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductDAO productDAO; 
	private ProductService productService;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductController() {
        super();
        // TODO Auto-generated constructor stub
        productDAO = new ProductDAO();
        productService = new ProductService();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("product page");
		
		
		String str = request.getRequestURI();
		int idx = str.lastIndexOf("/");
		str = str.substring(idx + 1);
		
		RequestDispatcher view;
		
		switch(str) {
		case "list.do":
			try {
				List<ProductDTO> ar = productService.getProductList();
				request.setAttribute("list", ar);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			view = request.getRequestDispatcher("/WEB-INF/views/product/productList.jsp");
			view.forward(request, response);
			break;
		case "add.do":
			view = request.getRequestDispatcher("/WEB-INF/views/product/productAdd.jsp");
			view.forward(request, response);
			break;
			
			
		case "detail.do":
			ProductDTO productDTO = new ProductDTO();
			String productNumber = request.getParameter("productNum");
			System.out.println(productNumber);
			int proNum = Integer.parseInt(productNumber);
			try {
				productDTO.setPro_num(proNum);
				productDTO = productService.getProductDetail(productDTO);
				request.setAttribute("detail", productDTO);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			view = request.getRequestDispatcher("/WEB-INF/views/product/productDetail.jsp");
			view.forward(request, response);
			break;
			
			
		case "update.do":
			view = request.getRequestDispatcher("/WEB-INF/views/product/productUpdate.jsp");
			view.forward(request, response);
			break;
		case "delete.do":
			view = request.getRequestDispatcher("/WEB-INF/views/product/productDelete.jsp");
			view.forward(request, response);
			break;
		default :
			break;
		}

		
		
		
//		try {
//			List<ProductDTO> listDTO = productDAO.getProduct();
//			
//			PrintWriter out = response.getWriter();
//			for(ProductDTO productDTO : listDTO) {
//				out.println("<h1>" + productDTO.getPro_name() + "<h1>");
//			}
//			
//			out.close();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
// 		-----------------------------------------------------
//		String name = request.getParameter("name");
//		System.out.println("name : " + name);
//		
//		String price = request.getParameter("price");
//		if(price != null) {
//			int p = Integer.parseInt(price);
//			System.out.println("price : " + p);
//		}
//		
//		String detail = request.getParameter("detail");
//		
//		ProductDTO productDTO = new ProductDTO();
//		productDTO.setPro_name(name);
//		productDTO.setPro_introduce(detail);
//		
//		try {
//			int result = productService.setAddProduct(productDTO, new ArrayList<ProductOptionDTO>());
//			System.out.println(result);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
