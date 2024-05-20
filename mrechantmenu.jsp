 <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

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
  background-image: url("https://img.freepik.com/premium-photo/shopping-cart-hd-8k-wallpaper-stock-photographic-image_890746-31208.jpg");
  background-size: cover;
  background-position: center;
}
#class {
  /* background-color: rgba(255, 255, 255, 0.8); /* Semi-transparent white background */ */
  display:flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  width: 200px;
  padding: 20px 5px;
  border-radius: 10px;
}
#btn1 button, #btn2 button {
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
#btn1 button a, #btn2 button a {
  color: black;
  text-decoration: none;
}
#btn1 button {
  background-color: red;
}
#btn2 button {
  background-color: yellow;
}
</style>
</head>
<body>
  <div id="class">
    <div id="btn1">
      <button><a href="addmerchant">Register</a></button>
    </div>
    <div id="btn2">
      <button><a href="merchantloginform.jsp">Loginform</a></button>
    </div>
  </div>
</body>
</html>
 