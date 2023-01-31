<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ page import = "java.io.PrintWriter" %>
<%@ page import = "java.util.List" %>
<%@ page import = "com.company.home.test.product.ProductDAO" %>
<%@ page import = "com.company.home.test.product.ProductDTO" %>
<%@ page import = "com.company.home.test.product.option.ProductOptionDAO" %>
<html>
<head>
<meta charset="UTF-8">
<title>web-inf-pro-list</title>
</head>
<body>
	<h1>product list page</h1>
	<a href = "home">back-home</a>
	
	<%-- <%
	ProductDAO productDAO = new ProductDAO();
	ProductOptionDAO productOptionDAO = new ProductOptionDAO();
	
	try {
		List<ProductDTO> listDTO = productDAO.getProduct();
		
		PrintWriter pw = response.getWriter();
		for(ProductDTO productDTO : listDTO) {
			pw.println("<h1>" + productDTO.getPro_name() + "<h1>");
		}
		
		pw.close();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	%> --%>
</body>
</html>