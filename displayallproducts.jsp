<%@page import="com.jsp.ShoppingCart_Application.dto.Product"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
${msg}
	<%
	List<Product> listproduct = (List<Product>) request.getAttribute("fetchallproducts");
	%>
	<h1><a href="fetchallitemscart">View Cart</a></h1>

	<table border="2px" cellpadding="20px">
		<th>brand</th>
		<th>category</th>
		<th>price</th>
		<th>add</th>
		<tbody>
			<%
			for (Product p : listproduct) {
			%>
			<tr>
				<td><%=p.getBrand()%></td>
				<td><%=p.getCategory()%></td>
				<td><%=p.getPrice()%></td>
				<td><a href="additemtocart?id=<%=p.getId()%>">Add to Cart</a></td>

			</tr>
			<%
			}
			%>

		</tbody>



	</table>


</body>
</html>