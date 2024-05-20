<%@page import="com.jsp.ShoppingCart_Application.dto.Items"%>
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
	List<Items> listitems = (List<Items>) request.getAttribute("itemslistobj");
	double totalprice = (double) request.getAttribute("totalprice");
	%>

	<table border="2px" cellpadding="20px">
		<th>brand</th>
		<th>category</th>
		<th>price</th>
		<th>add</th>
		<tbody>
			<%
			for (Items i : listitems) {
			%>
			<tr style="text-align:center">
				<td><%=i.getBrand()%></td>
				<td><%=i.getCategory()%></td>
				<td><%=i.getPrice()%></td>
				<td><%=i.getQuantity()%></td>

			</tr>
			<%
			}
			%>
			<tr style="text-align: center">
				<!-- <td colspan="3"><a>Buy Now</a></td> -->
				<td colspan="2">TotalPrice:<%=totalprice%></td>
			</tr>
		</tbody>



	</table>

</body>
</html>