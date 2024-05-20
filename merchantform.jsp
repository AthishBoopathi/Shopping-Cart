<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>

body {
  margin: 0;
  padding: 0;
  height: 100vh;
  display: flex;
  justify-content: center;
  align-items: center;
  background-image: url("https://atgscorp.com/images/thumbnails/customers.png");
  background-size: cover;
  background-position: center;
}
#one{
 background-color: rgba(255, 255, 255, 0.8); /* Semi-transparent white background */
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  width: 200px;
  padding: 20px 5px;
  border-radius: 10px;
}
#submit
{
   display: flex;
   flex-direction: column;
  justify-content: center;
    align-items: center;
   gap:10px;
}


</style>
</head>
<body>
<form:form action="savemerchant" modelAttribute="merchantobj">
 <div id="one">
         Enter name:<div id="name"><form:input path="name"/></div>
         Enter email:<div id="email"><form:input path="email"/></div>
         Enter password:<div id="password"><form:input path="password"/></div>
      <div id="submit"><input type="submit"></div>
 </div>

        
</form:form>



</body>
</html>