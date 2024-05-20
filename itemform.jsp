<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form:form action="saveitemtocart" modelAttribute="itemobj">
<form:hidden path="id"/>
Enter Brand:<form:input path="brand" readonly="true"/>
Enter Category:<form:input path="category" readonly="true"/>
Enter Price:<form:input path="price" readonly="true"/>
Enter Quantity:<form:input path="quantity" />

 <input type="submit">
 
</form:form>

</body>
</html>