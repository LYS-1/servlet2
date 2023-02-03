<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ page import = "java.util.List" %>
<%@ page import = "com.home.spring.product.ProductDAO" %>
<%@ page import = "com.home.spring.product.ProductDTO" %>
<%@ page import = "com.home.spring.product.option.ProductOptionDAO" %>
<html>
<head>
<meta charset="UTF-8">
<title>web-inf-pro-list</title>
</head>
<body>
	<h1>product list page</h1>
	<a href = "add.do">ProductAdd</a>
	<a href = "update.do">ProductUpdate</a>
	<br>
	
	<%
		List<ProductDTO> ar = (List<ProductDTO>)request.getAttribute("list");
		for (ProductDTO productDTO : ar){		
	%>
			<h3><%= productDTO.getPro_num() %></h3>
			<h3><a href = "detail.do?productNum=<%= productDTO.getPro_num() %>"><%= productDTO.getPro_name() %></a></h3>

	<%} %>
	
	
	
	
	
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