<%@page import="com.jsp.ShoppingCart_Application.dto.Product"%>
<%@page import="java.util.List"%>
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
List <Product> products = (List<Product>)request.getAttribute("allproduct");
%>

<table border="2px" cellpadding="20px">
<thead>
			<tr>
		         <td>Id</td>
		         <td>Brand</td>
		         <td>Category</td>
		         <td>Price</td>
		         <td>Stock</td>
		         <td>Update</td>
		         <td>Delete</td>
			</tr>
		</thead>
		
		<tbody>
		 <% for(Product p: products){ %>
		 
		 <tr>
		      <td><%= p.getId() %></td>
		      <td><%= p.getBrand()%></td>
		      <td><%= p.getCategory()%></td>
		      <td><%= p.getPrice()%></td>
		      <td><%= p.getStock()%></td>
		      <td><a href="updateproduct?id=<%=p.getId()%>">Update</a></td>
		      <td><a href="deleteproduct?id=<%=p.getId()%>">Delete</a></td>
		 
		 </tr>
		<% }%> 
	
		 </tbody>



</table>


</body>
</html>