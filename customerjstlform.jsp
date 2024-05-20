<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
#pro
{
   text-align: center;
	background-color: red;
	display: flex;
	justify-content: center;
	width: 200px;
	border: 1px solid black;
	border-radius: 10px;
}
#cus
{
  display: flex;
  justify-content: center;
}
#one
{
  display: flex;
	justify-content: center;

}
#two
{
   background-color: limepink;
	display: flex;
	flex-direction: column;
	gap: 10px;
	padding: 30px;
	border: 1px solid black;
	border-radius: 10px;

}



</style>
</head>
<body>

<form:form action="savecustomer"   modelAttribute="customerobj">

             <div id="cus"> <h1 id="pro">CUSTOMER DETAILS</h1></div>
             
 <div id="one">
 <div id="two">
                Enter Name:<div><form:input path="name"/></div>
                Enter MobileNumber:<div><form:input path="mobilenumber"/></div>
                Enter Email:<div><form:input path="email"/></div>
                Enter Password:<div><form:input path="password"/></div>
        
         
                <div><input type="submit"></div>
 </div>
 </div>

 
</form:form>


</body>
</html>