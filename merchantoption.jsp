<%@page import="com.jsp.ShoppingCart_Application.dto.Merchant"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
/* <link href="merchantoptioncssstyles.css"></link> */
#one {
	background-color: red;
	font-size: 20px;
	text-align: center;
}

#two {
	background-color: yellow;
	font-size: 20px;
}
#abc button
{
  outline: none;
  border:none;
}
#def button

{
    outline: none;
  border:none;
}
#class
{
  background-color: aqua;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  width: 200px;
  padding: 20px 5px;
  border: 1px solid;
  border-radius: 50px 0 50px 0;
  
}
body{
	display: flex;
	justify-content: center;
	align-items: center;
	height: 90vh;
}

#abc #one a
{
  text-decoration: none;
}
#def #two a
{
    text-decoration: none;
}
</style>
</head>
<body>
	${msg}
	<%
       Merchant m =(Merchant) session.getAttribute("merchantinfo");
	if(m!=null){
	%>
	<div id="class">
		<div id="abc">
			<button id="one">
				<a href="addproduct">AddProduct </a>
			</button>
		</div>
		<br> <br>
		<div id="def">
			<button id="two">
				<a href="viewallproducts">ViewAllProducts</a>

			</button>
		</div>
	</div>
	<%
	}else{
		%>
		<a href="merchantloginform.jsp">Login First</a>
	<%
	}
	%>

</body>
</html>