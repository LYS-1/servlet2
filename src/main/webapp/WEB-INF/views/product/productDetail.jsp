<%@page import="com.home.spring.product.ProductDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		ProductDTO productDTO = (ProductDTO)request.getAttribute("detail");
	%>
	<h1>productDetail</h1>
	<h3>product_number : <%= productDTO.getPro_num() %></h3><br>
	<h3>product_name : <%= productDTO.getPro_name() %></h3><br>
	<h3>product_rating : <%= productDTO.getRating() %></h3><br>
	<h3>product_tag : <%= productDTO.getTag() %></h3><br>
	<h3>product_introduce : <%= productDTO.getPro_introduce() %></h3><br>
	
</body>
</html>