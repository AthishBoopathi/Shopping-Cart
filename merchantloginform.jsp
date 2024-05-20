<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
#one
{
 background-color: rgba(255, 255, 255, 0.8); /* Semi-transparent white background */
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  width: 200px;
  padding: 20px 5px;
  border-radius: 10px;
}
#body
{
margin: 0;
  padding: 0;
  height: 100vh;
  display: flex;
  justify-content: center;
  align-items: center;
  background-image: url("");
  background-size: cover;
  background-position: center;
  background-color:limeblue;
	font-size: 20px;
	text-align: center;

}
#email
{
text-decoration: none;
  background: none;
  border: none;
  font-size: 20px;
  text-align: center;
  cursor: pointer;
  margin: 10px 0;
  padding: 10px 20px;
  border-radius: 5px;
}
#password
{
text-decoration: none;
  background: none;
  border: none;
  font-size: 20px;
  text-align: center;
  cursor: pointer;
  margin: 10px 0;
  padding: 10px 20px;
  border-radius: 5px;

}

</style>
</head>
<body>
${msg }
<div id="one">
<form action="validatemerchant">


 Enter email:<div id="email"><input type="email" name="email"></div>
 Enter password:<div id="password"><input type="password" name="password"></div>
 
 <input type="submit">

</div>

</form>
</body>
</html>