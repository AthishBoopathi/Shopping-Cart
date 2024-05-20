<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
#one {
	background-color: aqua;
	display: flex;
	flex-direction: column;
	gap: 10px;
	padding: 30px;
	border: 1px solid black;
	border-radius: 10px;
}

#abc {
	display: flex;
	justify-content: center;
}

#two {
	text-align: center;
	background-color: red;
	display: flex;
	justify-content: center;
	width: 200px;
	border: 1px solid black;
	border-radius: 10px;
}

#def {
	display: flex;
	justify-content: center;
}
</style>
</head>
<body>
	<form:form action="saveproduct" modelAttribute="productobj">
		<div id="def">
			<h1 id="two">PRODUCTS</h1>
		</div>

		<div id="abc">

			<div id="one">

				Enter brand:<div><form:input path="brand" /></div>
				Enter category:<div><form:input path="category" /></div>
				Enter price:<div><form:input path="price" /></div>
				Enter stock:<div><form:input path="stock" /></div>


				    <div>
					       <input type="submit">
				    </div>
			</div>
		</div>


	</form:form>


</body>
</html>