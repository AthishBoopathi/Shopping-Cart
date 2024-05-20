<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
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
  background-image: url("https://th.bing.com/th/id/R.7245daa997d11d202942413b1952a25b?rik=NVriz1jCdN9FpA&riu=http%3a%2f%2fxoopah.com%2fwp-content%2fuploads%2f2022%2f08%2fdata-driven-customer-service.jpg&ehk=HD3ILmpxynTRhGX3aIik%2bjXwYRGTOyuGyQvAonyVAVI%3d&risl=&pid=ImgRaw&r=0");
  background-size: cover;
  background-position: center;
}	
#main
{
/*  background-color: rgba(255, 255, 255, 0.8); /* Semi-transparent white background */ */
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  width: 200px;
  padding: 20px 5px;
  border-radius: 10px;
}
#one button,#two button
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
/* #one button,#two button
{
 text-decoration: none;
 color: black;
} */
a
{
color: white;
text-decoration: none;

}

</style>
</head>
<body>
	${msg}
	<div id="main">
		<div id="one" >
			<button id="btn1">
				<a href="addcustomer">Register</a>
			</button>
		</div>
		<br> <br>
		<div id="two">
			<button id="btn2">
				<a href="logincustomer.jsp">Login</a>
			</button>
		</div>
	</div>

</body>
</html>