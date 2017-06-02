<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
			<div>
          	<form action="template/login.jsp" method="post"> 
          		<label for="login">Login </label>     
                <input type="text" name="login">
                
                <br>
                
                <label for="senha">Senha </label> 
                <input type="text" name="senha">
                
                <br>
                
                <input type="submit" value="Entrar">
             </form>   
          </div>
          ${msg}
</body>
</html>